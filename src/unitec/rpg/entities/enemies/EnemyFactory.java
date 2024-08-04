package unitec.rpg.entities.enemies;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import unitec.rpg.entities.Player;
import unitec.rpg.entities.enemies.annotations.BossEnemy;
import unitec.rpg.entities.enemies.annotations.RegularEnemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Clase que genera enemigos aleatorios
 */
public class EnemyFactory {

    private static final Random random = new Random();

    /**
     * Genera un enemigo regular aleatorio
     *
     * @return un enemigo regular
     */
    public static Enemy generateRegularEnemy(Player player) {

        // Reflections es una librería que permite obtener información sobre las clases de un paquete
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forJavaClassPath())
                .setScanners(new SubTypesScanner(), new TypeAnnotationsScanner()));
        // Obtiene todas las clases que tienen la anotación RegularEnemy
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(RegularEnemy.class);
        // Convierte el conjunto de clases a una lista
        List<Class<?>> classList = classes.stream()
                .filter(clazz -> !clazz.isAnnotationPresent(BossEnemy.class))
                .toList();
        if (classList.isEmpty()) {
            throw new IllegalStateException("No regular enemies available");
        }
        // Obtiene una clase aleatoria de la lista
        Class<?> claseEnemyRegular = classList.get(random.nextInt(classList.size()));
        // Intenta crear una instancia de la clase obtenida
        try {

            Enemy enemy = (Enemy) claseEnemyRegular.getDeclaredConstructor(Player.class).newInstance(player);
            //DialogPanel.getInstance().addText("¡Un " + enemy.getName() + " aparece frente a ti!\n");
            return enemy;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    /**
     * Genera un enemigo jefe aleatorio
     *
     * @return un enemigo jefe
     */
    public static Enemy generateBossEnemy(Player player) {

        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forJavaClassPath())
                .setScanners(new SubTypesScanner(), new TypeAnnotationsScanner()));

        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(BossEnemy.class);
        List<Class<?>> classList = new ArrayList<>(classes);

        Class<?> claseJefe = classList.get(random.nextInt(classList.size()));

        try {
            return (Enemy) claseJefe.getDeclaredConstructor(Player.class).newInstance(player);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}