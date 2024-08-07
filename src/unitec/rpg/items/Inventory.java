package unitec.rpg.items;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Inventory extends ArrayList<Item> implements Serializable {

    private int maxCapacity;

    public Inventory() {

        super();
        maxCapacity = 10;
    }

    public void increaseMaxCapacity(int amount) {

        maxCapacity += amount;
    }

    public void addItem(Item item) {

        if (size() < maxCapacity) {
            add(item);
        } else {
            JOptionPane.showMessageDialog(null, "¡Inventario Lleno!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void removeItem(Item item) {

        remove(item);
    }

    public void removeItem(int index) {

        remove(index);
    }

    public void removeItem(String name) {

        for (Item item : this) {

            if (item.getName().equals(name)) {

                remove(item);
                break;
            }
        }
    }

    public Item getItem(String name) {

        for (Item item : this) {

            if (item.getName().equals(name)) {

                return item;
            }
        }
        return null;
    }

    public Item getItem(int index) {

        return get(index);
    }

    public int getItemIndex(String name) {

        for (int i = 0; i < size(); i++) {

            if (get(i).getName().equals(name)) {

                return i;
            }
        }
        return -1;
    }

    public int getItemIndex(Item item) {

        return indexOf(item);
    }

    public boolean containsItem(String name) {

        for (Item item : this) {

            if (item.getName().equals(name)) {

                return true;
            }
        }
        return false;
    }

    public boolean containsItem(Item item) {

        return contains(item);
    }

    public int getInventorySize() {

        return size();
    }

    public boolean isInventoryEmpty() {

        return isEmpty();
    }

    public void clearInventory() {

        clear();
    }

    public void setMaxCapacity(int maxCapacity) {

        this.maxCapacity = maxCapacity;
    }
}
