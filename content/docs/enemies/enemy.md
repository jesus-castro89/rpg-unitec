---
weight: 602
title: "Enemy"
description: ""
icon: "article"
date: "2024-08-03T23:38:40-06:00"
lastmod: "2024-08-03T23:38:40-06:00"
draft: false
toc: true
---

## Actualización de los enemigos en el juego

En esta sección se presentan los enemigos que se pueden encontrar en el juego. Estos son personajes que se pueden
enfrentar durante la exploración del mundo y que representan un desafío para el jugador. Cada enemigo tiene sus propias
características y habilidades, por lo que es importante conocer sus fortalezas y debilidades para poder derrotarlos.

## Stats

{{< prism lang="java" line-numbers="true" >}}

    package unitec.rpg.entities.enums;
    
    public enum Stats {
    
        HP, MAX_HP, MP, MAX_MP, ATTACK, DEFENSE, SPEED, LUCK, ACCURACY, EVASION,
        CRITICAL_HIT_CHANCE, CRITICAL_HIT_DAMAGE;
    }

{{< /prism >}}

## BasicCharacter

{{< prism lang="java" line-numbers="true" >}}

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

{{< /prism >}}

### Enemy

Lo primero que deberemos hacer es actualizar la clase `Enemy` para que pueda ser utilizada en el juego. Esta clase
representa a un enemigo en el juego y contiene información sobre sus características, habilidades y comportamiento.

{{< prism lang="java" line-numbers="true" >}}

    package unitec.rpg.entities.enemies;
    
    import unitec.rpg.entities.BasicCharacter;
    import unitec.rpg.entities.Player;
    import unitec.rpg.entities.enums.Stats;
    
    import javax.swing.*;
    
    public abstract class Enemy extends BasicCharacter {
    
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
            stats.put(Stats.ATTACK, getAdjustedStat(Stats.ATTACK, player));
            stats.put(Stats.DEFENSE, getAdjustedStat(Stats.DEFENSE, player));
            stats.put(Stats.SPEED, getAdjustedStat(Stats.SPEED, player));
            stats.put(Stats.EVASION, getAdjustedStat(Stats.EVASION, player));
            stats.put(Stats.ACCURACY, getAdjustedStat(Stats.ACCURACY, player));
        }
    
        public abstract String attack(Player player);
    
        protected int getAdjustedStat(Stats stat, Player player) {
    
            return (int) (stats.get(stat) * (player.getLevel() * adjustLevel));
        }
    
        public String dropLoot(Player player) {
    
            return gainExperience(player) + "\n" + gainGold(player);
        }
    
        public String gainExperience(Player player) {
    
            return String.format("%s gana %d puntos de experiencia.", player.getName(), this.experience);
        }
    
        public String gainGold(Player player) {
    
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

En esta actualización, se han añadido los métodos `dropLoot`, `gainExperience` y `gainGold` para que los enemigos puedan
dejar caer objetos y recompensas al ser derrotados. Además, se ha añadido el método `isBoss` para determinar si un
enemigo es un jefe final.

### Goblin

El primer enemigo que se ha añadido al juego es él `Goblin`. Este enemigo es débil, pero rápido, por lo que puede ser un
desafío para los jugadores principiantes. A continuación se muestra la clase `Goblin`:

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
            return String.format("%s ataca a %s por %d puntos de daño.", name, player.getName(), damage);
        }
    
        protected String throwRock(Player player) {
    
            int damage = (int) ((stats.get(Stats.ATTACK) * 1.15) - player.getStatus(Stats.DEFENSE));
            player.takeDamage(damage);
            return String.format("%s lanza una roca a %s por %d puntos de daño.", name, player.getName(), damage);
        }
    
        protected String flee(Player player) {
    
            return String.format("%s huye.", name);
        }
    
        protected String stealGold(Player player) {
    
            int goldStolen = Math.max((player.getGold() - 5), 0);
            player.setGold(player.getGold() - goldStolen);
            gold += goldStolen;
            return goldStolen == 0 ? String.format("%s intenta robar a %s, pero no tiene oro.", name, player.getName()) :
                    String.format("%s roba %d monedas de oro a %s.", name, goldStolen, player.getName());
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

En esta clase, se ha definido el método `attack` que permite al `Goblin` atacar al jugador utilizando diferentes
habilidades. Estas habilidades se eligen de forma aleatoria, lo que hace que el combate sea impredecible y emocionante.

### GeneralGoblin

El segundo enemigo que se ha añadido al juego es el `GeneralGoblin`. Este enemigo es más fuerte que el `Goblin` novato y
puede representar un desafío mayor para los jugadores. A continuación se muestra la clase `GeneralGoblin`:

{{< prism lang="java" line-numbers="true" >}}

    package unitec.rpg.entities.enemies.goblins;
    
    import unitec.rpg.entities.Player;
    import unitec.rpg.entities.enemies.annotations.BossEnemy;
    import unitec.rpg.entities.enums.Stats;
    import unitec.rpg.ui.cache.ImageCache;
    
    import javax.swing.*;
    
    @BossEnemy
    public class GeneralGoblin extends RookieGoblin {
    
        public GeneralGoblin(Player player) {
    
            super(player);
        }
    
        protected void initStats() {
    
            this.name = "Goblin General";
            this.experience = 50;
            this.gold = 30;
            this.maxLevel = 20;
            this.stats.put(Stats.HP, 50);
            this.stats.put(Stats.ATTACK, 20);
            this.stats.put(Stats.DEFENSE, 20);
            this.stats.put(Stats.SPEED, 20);
            this.stats.put(Stats.EVASION, 20);
            this.stats.put(Stats.ACCURACY, 20);
            setStats(player);
        }
    
        @Override
        public String attack(Player player) {
    
            String message;
            double plainAttackChance = 0.30;
            double throwClubChance = 0.30;
            double random = Math.random();
            if (random < plainAttackChance) {
    
                message = plainAttack(player);
            } else if (random < plainAttackChance + throwClubChance) {
    
                message = throwClub(player);
            } else {
    
                message = flee(player);
            }
            return message;
        }
    
        protected String plainAttack(Player player) {
    
            int damage = (int) ((stats.get(Stats.ATTACK) * 1.25) - player.getStatus(Stats.DEFENSE));
            player.takeDamage(damage);
            return String.format("%s ataca a %s por %d puntos de daño.", name, player.getName(), damage);
        }
    
        private String throwClub(Player player) {
    
            int damage = (int) ((stats.get(Stats.ATTACK) * 1.5) - player.getStatus(Stats.DEFENSE));
            player.takeDamage(damage);
            return String.format("%s lanza un garrote a %s por %d puntos de daño.", name, player.getName(), damage);
        }
    
        @Override
        public ImageIcon getImage() {
    
            ImageCache.addImage("GeneralGoblin", "img/enemies/goblins/general_goblin.png");
            return ImageCache.getImageIcon("GeneralGoblin");
        }
    }

{{< /prism >}}

En esta clase, se ha definido el método `attack` que permite al `GeneralGoblin` atacar al jugador utilizando diferentes
habilidades. Este enemigo es más fuerte que el `Goblin` novato y puede representar un desafío mayor para los jugadores.

### SimpleSlime

El tercer enemigo que se ha añadido al juego es el `Slime` simple. Este enemigo es débil, pero puede dividirse en
múltiples enemigos más pequeños si no se derrota rápidamente. A continuación se muestra la clase `SimpleSlime`:

{{< prism lang="java" line-numbers="true" >}}

    package unitec.rpg.entities.enemies.slimes;
    
    import annotations.RegularEnemy;
    import unitec.rpg.entities.Player;
    import unitec.rpg.entities.enemies.Enemy;
    import unitec.rpg.entities.enums.Stats;
    import unitec.rpg.ui.cache.ImageCache;
    
    import javax.swing.*;
    
    @RegularEnemy
    public class SimpleSlime extends Enemy {
    
        public SimpleSlime(Player player) {
    
            super(player);
        }
    
        protected void initStats() {
    
            this.name = "Slime";
            this.experience = 10;
            this.gold = 5;
            this.maxLevel = 10;
            this.stats.put(Stats.HP, 10);
            this.stats.put(Stats.ATTACK, 5);
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
            return String.format("%s ataca a %s con un ataque de salpicadura.", this.getName(), player.getName());
        }
    
        protected String plainAttack(Player player) {
    
            player.takeDamage(getStatus(Stats.ATTACK) - player.getStatus(Stats.DEFENSE));
            return String.format("%s ataca a %s.", this.getName(), player.getName());
        }
    
        protected String heal() {
    
            increaseStat(Stats.HP, 2);
            return String.format("%s se cura.", this.getName());
        }
    
        protected String run() {
    
            stats.put(Stats.HP, 0);
            return String.format("%s huye.", this.getName());
        }
    }

{{< /prism >}}

### KingSlime

El cuarto enemigo que se ha añadido al juego es él `KingSlime`. Este enemigo es más fuerte que el `Slime` simple y puede
atacar de diversas maneras.

{{< prism lang="java" line-numbers="true" >}}

    package unitec.rpg.entities.enemies.slimes;
    
    import unitec.rpg.entities.Player;
    import unitec.rpg.entities.enemies.annotations.BossEnemy;
    import unitec.rpg.entities.enums.Stats;
    import unitec.rpg.ui.cache.ImageCache;
    
    import javax.swing.*;
    
    @BossEnemy
    public class KingSlime extends SimpleSlime {
    
        public KingSlime(Player player) {
    
            super(player);
        }
        
        protected void initStats() {
    
            this.name = "King Slime";
            this.experience = 55;
            this.gold = 35;
            this.maxLevel = 25;
            this.stats.put(Stats.HP, 55);
            this.stats.put(Stats.ATTACK, 25);
            this.stats.put(Stats.DEFENSE, 20);
            this.stats.put(Stats.SPEED, 20);
            this.stats.put(Stats.EVASION, 20);
            this.stats.put(Stats.ACCURACY, 20);
            setStats(player);
        }
    
        @Override
        public String attack(Player player) {
            String message;
            double plainAttackChance = 0.60;
            double throwThunder = 0.20;
            double throwFireball = 0.20;
            double random = Math.random();
            if (random < plainAttackChance) {
                message = plainAttack(player);
            } else if (random < plainAttackChance + throwThunder) {
                message = throwThunder(player);
            } else {
                message = throwFireball(player);
            }
            return message;
        }
    
        protected String throwThunder(Player player) {
    
            int damage = (int) ((stats.get(Stats.ATTACK) * 2.00) - player.getStatus(Stats.DEFENSE));
            player.takeDamage(damage);
            return String.format("%s lanza un rayo a %s por %d puntos de daño.", name, player.getName(), damage);
        }
    
        protected String throwFireball(Player player) {
    
            int damage = (int) ((stats.get(Stats.ATTACK) * 2.50) - player.getStatus(Stats.DEFENSE));
            player.takeDamage(damage);
            return String.format("%s lanza una bola de fuego a %s por %d puntos de daño.", name, player.getName(), damage);
        }
    
        @Override
        public ImageIcon getImage() {
    
            ImageCache.addImage("KingSlime", "img/enemies/slimes/king_slime.png");
            return ImageCache.getImageIcon("KingSlime");
        }
    }

{{< /prism >}}