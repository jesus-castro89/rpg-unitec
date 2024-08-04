package unitec.rpg.items.weapons;

import unitec.rpg.entities.enums.Stats;
import unitec.rpg.items.Item;
import unitec.rpg.items.ItemType;
import unitec.rpg.items.Rarity;

import java.util.HashMap;

public abstract class AbstractWeapon extends Item {

    protected HashMap<Stats, Integer> stats;
    protected Rarity rarity;

    public AbstractWeapon(String name, String description, int price) {

        super(name, description, price);
        type = ItemType.WEAPON;
        rarity = switch (Math.random() < 0.1 ? 0 : Math.random() < 0.3 ? 1 : 2) {
            case 0 -> Rarity.RARE;
            case 1 -> Rarity.EPIC;
            case 2 -> Rarity.LEGENDARY;
            default -> Rarity.COMMON;
        };
        initStats();
    }

    protected abstract void initStats();
}
