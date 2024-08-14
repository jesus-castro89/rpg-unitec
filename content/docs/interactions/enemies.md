---
weight: 701
title: "Actualizando los Enemigos"
description: ""
icon: "article"
date: "2024-08-03T23:38:40-06:00"
lastmod: "2024-08-03T23:38:40-06:00"
draft: false
toc: true
---

## Enemy

{{< prism lang="java" line-numbers="true" >}}

    package unitec.rpg.entities.enemies;
    
    import unitec.rpg.entities.BasicCharacter;
    import unitec.rpg.entities.Player;
    import unitec.rpg.entities.enums.Stats;
    
    import javax.swing.*;
    
    public abstract class Enemy
    extends BasicCharacter {
    
        protected int experience;
        protected int gold;
        protected int maxLevel;
        protected final double adjustLevel = 1.15;
        protected final Player player;
    
        public abstract ImageIcon getImage();
    
        public Enemy(Player player) {
    
            this.player = player;
            initStats();
        }
    
        protected abstract void initStats();
    
        protected void setStats(Player player) {
    
            stats.put(Stats.HP, getAdjustedStat(Stats.HP, player));
            stats.put(Stats.MAX_HP, getStatus(Stats.HP));
            stats.put(Stats.ATTACK, getAdjustedStat(Stats.ATTACK, player));
            stats.put(Stats.DEFENSE, getAdjustedStat(Stats.DEFENSE, player));
            stats.put(Stats.SPEED, getAdjustedStat(Stats.SPEED, player));
            stats.put(Stats.EVASION, getAdjustedStat(Stats.EVASION, player));
            stats.put(Stats.ACCURACY, getAdjustedStat(Stats.ACCURACY, player));
            experience = (int) (experience * (player.getLevel() * adjustLevel));
        }
    
        public abstract String attack(Player player);
    
        protected int getAdjustedStat(Stats stat, Player player) {
    
            return (int) (stats.get(stat) * (player.getLevel() * adjustLevel));
        }
    
        public String dropLoot(Player player) {
    
            return gainExperience(player) + "\n" + gainGold(player) + "\n";
        }
    
        public String gainExperience(Player player) {
    
            return player.gainExperience(this.experience);
        }
    
        public String gainGold(Player player) {
    
            player.gainGold(this.gold);
            return String.format("%s gana %d monedas de oro.", player.getName(), this.gold);
        }
    
        public int getExperience() {
            return experience;
        }
    
        public void setExperience(int experience) {
            this.experience = experience;
        }
    
        public int getGold() {
            return gold;
        }
    
        public void setGold(int gold) {
            this.gold = gold;
        }
    
        public boolean isBoss() {
    
            return this.getClass().isAnnotationPresent(unitec.rpg.entities.enemies.annotations.BossEnemy.class);
        }
    }

{{< /prism >}}

## Goblin

{{< prism lang="java" line-numbers="true" >}}

    package unitec.rpg.entities.enemies.goblins;
    
    import unitec.rpg.entities.enemies.Enemy;
    import unitec.rpg.entities.Player;
    import unitec.rpg.entities.enemies.annotations.RegularEnemy;
    import unitec.rpg.entities.enums.Stats;
    import unitec.rpg.ui.cache.ImageCache;
    
    import javax.swing.*;
    
    @RegularEnemy
    public class RookieGoblin extends Enemy {
    
        public RookieGoblin(Player player) {
    
            super(player);
        }
    
        protected void initStats() {
    
            this.name = "Goblin Novato";
            this.experience = 9;
            this.gold = 4;
            this.maxLevel = 10;
            this.stats.put(Stats.HP, 10);
            this.stats.put(Stats.ATTACK, 5);
            this.stats.put(Stats.DEFENSE, 5);
            this.stats.put(Stats.SPEED, 5);
            this.stats.put(Stats.EVASION, 5);
            this.stats.put(Stats.ACCURACY, 5);
            setStats(player);
        }
    
        /**
         * Función que permitirá al enemigo atacar al jugador utilizando de forma aleatoria los métodos de ataque del enemigo
         *
         * @param player el jugador al que se atacará
         * @return un mensaje que indica el ataque realizado
         */
        @Override
        public String attack(Player player) {
    
            String message;
            // Probabilidades de ataque
            double plainAttackChance = 0.30;
            double throwRockChance = 0.30;
            double fleeChance = 0.30;
            double random = Math.random();
            if (random < plainAttackChance) {
    
                message = plainAttack(player);
            } else if (random < plainAttackChance + throwRockChance) {
    
                message = throwRock(player);
            } else if (random < plainAttackChance + throwRockChance + fleeChance) {
    
                message = flee(player);
            } else {
                message = stealGold(player);
            }
            return message;
        }
    
        protected String plainAttack(Player player) {
    
            int damage = stats.get(Stats.ATTACK) - player.getStatus(Stats.DEFENSE);
            player.takeDamage(damage);
            return String.format("%s ataca a %s por %d puntos de daño.\n", name, player.getName(), damage);
        }
    
        protected String throwRock(Player player) {
    
            int damage = (int) ((stats.get(Stats.ATTACK) * 1.15) - player.getStatus(Stats.DEFENSE));
            player.takeDamage(damage);
            return String.format("%s lanza una roca a %s por %d puntos de daño.\n", name, player.getName(), damage);
        }
    
        protected String flee(Player player) {
    
            stats.put(Stats.HP, 0);
            return String.format("%s huye.\n", name);
        }
    
        protected String stealGold(Player player) {
    
            int goldStolen = Math.max((player.getGold() - 5), 0);
            player.setGold(player.getGold() - goldStolen);
            gold += goldStolen;
            return goldStolen == 0 ? String.format("%s intenta robar a %s, pero no tiene oro.\n", name, player.getName()) :
                    String.format("%s roba %d monedas de oro a %s.\n", name, goldStolen, player.getName());
        }
    
        /**
         * Devuelve la imagen del enemigo.
         *
         * @return la imagen del enemigo
         */
        @Override
        public ImageIcon getImage() {
    
            ImageCache.addImage("RookieGoblin", "img/enemies/goblins/rookie_goblin.png");
            return ImageCache.getImageIcon("RookieGoblin");
        }
    }

{{< /prism >}}

## Slime

{{< prism lang="java" line-numbers="true" >}}

    package unitec.rpg.entities.enemies.slimes;
    
    import unitec.rpg.entities.Player;
    import unitec.rpg.entities.enemies.Enemy;
    import unitec.rpg.entities.enemies.annotations.RegularEnemy;
    import unitec.rpg.entities.enums.Stats;
    import unitec.rpg.ui.cache.ImageCache;
    
    import javax.swing.*;
    
    @RegularEnemy
    public class SimpleSlime extends Enemy {
    
        public SimpleSlime(Player player) {
    
            super(player);
        }
    
        @Override
        protected void initStats() {
    
            this.name = "Slime";
            this.experience = 10;
            this.gold = 5;
            this.maxLevel = 11;
            this.stats.put(Stats.HP, 11);
            this.stats.put(Stats.ATTACK, 6);
            this.stats.put(Stats.DEFENSE, 5);
            this.stats.put(Stats.SPEED, 5);
            this.stats.put(Stats.EVASION, 5);
            this.stats.put(Stats.ACCURACY, 5);
            setStats(player);
        }
    
        @Override
        public ImageIcon getImage() {
    
            ImageCache.addImage("slime", "img/enemies/slimes/basic_slime.png");
            return new ImageIcon("img/enemies/slimes/basic_slime.png");
        }
    
        @Override
        public String attack(Player player) {
    
            double decision = Math.random();
            double splashProbability = 0.3;
            double healProbability = 0.1;
            double runProbability = 0.1;
    
            if (decision < splashProbability) {
                return splashAttack(player);
            } else if (decision < splashProbability + healProbability) {
                return heal();
            } else if (decision < splashProbability + healProbability + runProbability) {
                return run();
            } else {
                return plainAttack(player);
            }
        }
    
        protected String splashAttack(Player player) {
    
            player.takeDamage((int) (getStatus(Stats.ATTACK) * 1.15 - player.getStatus(Stats.DEFENSE)));
            return String.format("%s ataca a %s con un ataque de salpicadura.\n", this.getName(), player.getName());
        }
    
        protected String plainAttack(Player player) {
    
            player.takeDamage(getStatus(Stats.ATTACK) - player.getStatus(Stats.DEFENSE));
            return String.format("%s ataca a %s, con %d de daño.\n", this.getName(), player.getName(),
                    getStatus(Stats.ATTACK) - player.getStatus(Stats.DEFENSE));
        }
    
        protected String heal() {
    
            increaseStat(Stats.HP, 2);
            return String.format("%s se cura.\n", this.getName());
        }
    
        protected String run() {
    
            stats.put(Stats.HP, 0);
            return String.format("%s huye.\n", this.getName());
        }
    }

{{< /prism >}}

## Player

{{< prism lang="java" line-numbers="true" >}}

    package unitec.rpg.entities;
    
    import unitec.rpg.entities.enums.Stats;
    import unitec.rpg.items.Inventory;
    
    import java.io.Serializable;
    
    public class Player extends BasicCharacter implements Serializable {
    
        private int experience;
        private int level;
        private int gold;
        private final Inventory inventory;
    
        public Player(String name) {
    
            super(name);
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
            this.stats.put(Stats.CRITICAL_HIT_CHANCE, 5);
            this.stats.put(Stats.CRITICAL_HIT_DAMAGE, 150);
            this.gold = 0;
            this.experience = 0;
            this.level = 1;
            this.inventory = new Inventory();
        }
    
        public Player() {
            this("John Doe");
        }
    
        public int getExperienceToNextLevel() {
            return 100 * this.level;
        }
    
        public String tryToFlee() {
    
            return Math.random() < 0.5 ? "Has huido con éxito.\n" : "No has podido huir.\n";
        }
    
        public String levelUp() {
    
            this.level++;
            this.increaseStat(Stats.MAX_HP, 10);
            this.increaseStat(Stats.MAX_MP, 5);
            this.increaseStat(Stats.ATTACK, 2);
            this.increaseStat(Stats.DEFENSE, 1);
            this.increaseStat(Stats.SPEED, 1);
            this.increaseStat(Stats.LUCK, 1);
            this.increaseStat(Stats.ACCURACY, 1);
            this.increaseStat(Stats.EVASION, 1);
            this.increaseStat(Stats.CRITICAL_HIT_CHANCE, 1);
            this.experience = 0;
            recover();
            return String.format("\n%s ha subido al nivel %d.", this.name, this.level);
        }
    
        public String gainExperience(int exp) {
    
            String message = String.format("%s gana %d puntos de experiencia.", this.name, exp);
            this.experience += exp;
            if (this.experience >= 100 * this.level) {
                message += levelUp();
            }
            return message;
        }
    
        public void gainGold(int gold) {
            this.gold += gold;
        }
    
        public int getExperience() {
            return experience;
        }
    
        public void setExperience(int experience) {
            this.experience = experience;
        }
    
        public int getLevel() {
            return level;
        }
    
        public void setLevel(int level) {
            this.level = level;
        }
    
        public int getGold() {
            return gold;
        }
    
        public void setGold(int gold) {
            this.gold = gold;
        }
    
        public Inventory getInventory() {
            return inventory;
        }
    }

{{< /prism >}}


Además de esto puedes basarte del código fuente ubicado en BB.