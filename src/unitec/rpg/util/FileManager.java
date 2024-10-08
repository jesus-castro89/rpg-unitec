package unitec.rpg.util;


import unitec.rpg.entities.Player;

import java.io.*;

public class FileManager {

    public static Player loadGame(int slot) throws FileNotFoundException {

        Player player;
        String fileName = "files/player_" + slot + ".dat";
        try {
            player = (Player) new ObjectInputStream(new FileInputStream(fileName)).readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new FileNotFoundException("No se encontró el archivo");
        }
        return player;
    }

    public static void saveGame(Player player, int slot) {

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("files/player_" + slot + ".dat"));
            oos.writeObject(player);
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

