package unitec.rpg.items.weapons.bows;

import unitec.rpg.entities.enums.Stats;
import unitec.rpg.items.weapons.AbstractWeapon;

public class BasicBow extends AbstractWeapon {

    public BasicBow(String name, String description, int price) {
        super(name, description, price);
    }

    @Override
    protected void initStats() {

        switch (rarity) {
            case COMMON -> {
                stats.put(Stats.ATTACK, 5);
                stats.put(Stats.ACCURACY, 5);
                stats.put(Stats.CRITICAL_HIT_CHANCE, 5);
                stats.put(Stats.CRITICAL_HIT_DAMAGE, 20);
            }
            case RARE -> {
                stats.put(Stats.ATTACK, 10);
                stats.put(Stats.ACCURACY, 10);
                stats.put(Stats.CRITICAL_HIT_CHANCE, 10);
                stats.put(Stats.CRITICAL_HIT_DAMAGE, 30);
            }
            case EPIC -> {
                stats.put(Stats.ATTACK, 15);
                stats.put(Stats.ACCURACY, 15);
                stats.put(Stats.CRITICAL_HIT_CHANCE, 15);
                stats.put(Stats.CRITICAL_HIT_DAMAGE, 40);
            }
            case LEGENDARY -> {
                stats.put(Stats.ATTACK, 20);
                stats.put(Stats.ACCURACY, 20);
                stats.put(Stats.CRITICAL_HIT_CHANCE, 20);
                stats.put(Stats.CRITICAL_HIT_DAMAGE, 50);
            }
        }
    }
}
