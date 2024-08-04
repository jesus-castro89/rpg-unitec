package unitec.rpg.items.weapons.swords;

import unitec.rpg.entities.enums.Stats;
import unitec.rpg.items.weapons.AbstractWeapon;

public class WoodenSword extends AbstractWeapon {

    public WoodenSword(String name, String description, int price) {
        super(name, description, price);
    }

    @Override
    protected void initStats() {

        switch (rarity) {
            case COMMON -> {
                stats.put(Stats.ATTACK, 5);
                stats.put(Stats.HP, 5);
                stats.put(Stats.CRITICAL_HIT_CHANCE, 5);
                stats.put(Stats.CRITICAL_HIT_DAMAGE, 20);
            }
            case RARE -> {
                stats.put(Stats.ATTACK, 10);
                stats.put(Stats.HP, 10);
                stats.put(Stats.CRITICAL_HIT_CHANCE, 10);
                stats.put(Stats.CRITICAL_HIT_DAMAGE, 30);
            }
            case EPIC -> {
                stats.put(Stats.ATTACK, 15);
                stats.put(Stats.HP, 15);
                stats.put(Stats.CRITICAL_HIT_CHANCE, 15);
                stats.put(Stats.CRITICAL_HIT_DAMAGE, 40);
            }
            case LEGENDARY -> {
                stats.put(Stats.ATTACK, 20);
                stats.put(Stats.HP, 20);
                stats.put(Stats.CRITICAL_HIT_CHANCE, 20);
                stats.put(Stats.CRITICAL_HIT_DAMAGE, 50);
            }
        }
    }
}
