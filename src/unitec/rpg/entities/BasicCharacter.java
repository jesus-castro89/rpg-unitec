package unitec.rpg.entities;

import unitec.rpg.entities.enums.Stats;

import java.io.Serializable;
import java.util.HashMap;

public abstract class BasicCharacter implements Serializable {

    protected String name;
    protected HashMap<Stats, Integer> stats;

    public BasicCharacter(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        this.stats.put(Stats.HP, 100);
        this.stats.put(Stats.MAX_HP, 100);
        this.stats.put(Stats.MP, 50);
        this.stats.put(Stats.MAX_MP, 50);
        this.stats.put(Stats.ATTACK, 10);
        this.stats.put(Stats.DEFENSE, 5);
        this.stats.put(Stats.SPEED, 5);
        this.stats.put(Stats.LUCK, 5);
        this.stats.put(Stats.ACCURACY, 5);
        this.stats.put(Stats.EVASION, 5);
        this.stats.put(Stats.CRITICAL_HIT_CHANCE, 95);
        this.stats.put(Stats.CRITICAL_HIT_DAMAGE, 150);
    }

    public BasicCharacter() {
        this("John Doe");
    }

    private void setStats(Stats stat, int value) {
        this.stats.put(stat, value);
    }

    public void increaseStat(Stats stat, int value) {
        this.stats.put(stat, this.stats.get(stat) + value);
    }

    public void decreaseStat(Stats stat, int value) {
        this.stats.put(stat, this.stats.get(stat) - value);
    }

    public void heal(int amount) {
        int hp = this.stats.get(Stats.HP) + amount;
        if (hp > this.stats.get(Stats.MAX_HP)) {
            hp = this.stats.get(Stats.MAX_HP);
        }
        this.stats.put(Stats.HP, hp);
    }

    public void restore(int amount) {
        int mp = this.stats.get(Stats.MP) + amount;
        if (mp > this.stats.get(Stats.MAX_MP)) {
            mp = this.stats.get(Stats.MAX_MP);
        }
        this.stats.put(Stats.MP, mp);
    }

    public void recover() {
        this.stats.put(Stats.HP, this.stats.get(Stats.MAX_HP));
        this.stats.put(Stats.MP, this.stats.get(Stats.MAX_MP));
    }

    private boolean isCriticalHit() {

        return Math.random() < this.getStatus(Stats.CRITICAL_HIT_CHANCE) / 100.0;
    }

    private boolean isHit(BasicCharacter character) {

        return Math.random() < this.getStatus(Stats.ACCURACY) - character.getStatus(Stats.EVASION) / 100.0;
    }

    private boolean isEvaded(BasicCharacter character) {

        return Math.random() > this.getStatus(Stats.EVASION) - character.getStatus(Stats.ACCURACY) / 100.0;
    }

    public String attack(BasicCharacter character) {

        String message = "";
        int damage = this.getStatus(Stats.ATTACK);
        if (!isHit(character)) {
            message += String.format("%s ataca a %s pero falla.\n", this.getName(), character.getName());
            damage = 0;
        }
        if (isEvaded(character)) {
            message += String.format("%s ataca a %s pero esquivan el ataque.\n", this.getName(), character.getName());
            damage = 0;
        }
        if (damage > 0) {
            if (isCriticalHit()) {
                message += String.format("%s realiza un golpe crítico.\n", this.getName());
                damage = (int) (damage * (this.getStatus(Stats.CRITICAL_HIT_DAMAGE) / 100.0));
            }
            message += String.format("%s ataca a %s y le hace %d puntos de daño.\n", this.getName(), character.getName(),
                    damage);
            message += character.takeDamage(damage);
        } else if (!isEvaded(character) && isHit(character) && damage == 0) {
            message += String.format("%s ataca a %s pero no le hace daño.\n", this.getName(), character.getName());
        }
        return message;
    }

    public void defend(BasicCharacter character) {

        int damage = character.getStatus(Stats.ATTACK) - getStatus(Stats.DEFENSE);
        this.takeDamage(damage);
    }

    public String takeDamage(int damage) {

        String message;
        int hp = this.stats.get(Stats.HP) - damage;
        message = String.format("%s recibe %d puntos de daño.\n", this.getName(), damage);
        stats.put(Stats.HP, hp);
        if (hp <= 0) {

            message += String.format("%s ha muerto.\n", this.getName());
        }
        return message;
    }

    public boolean isAlive() {

        return stats.get(Stats.HP) > 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus(Stats stat) {
        return this.stats.get(stat);
    }
}