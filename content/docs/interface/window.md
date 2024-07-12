---
weight: 401
title: "La primera ventana"
description: "Primera ventana de la aplicación"
icon: "preview"
date: "2024-06-13T14:25:08-06:00"
lastmod: "2024-06-13T14:25:08-06:00"
draft: false
toc: true
---

## La primera ventana

Para nuestra primera ventana, vamos a crear una ventana de bienvenida. Esta ventana será la primera que vea el usuario
al
abrir la aplicación.

### Crear la ventana

Para crear la ventana, vamos a hacer lo siguiente:

1. Crearemos el paquete `windows` en el directorio `ui`.
2. Dentro del paquete `windows`, crearemos un nuevo formulario de Swing llamado `WelcomeWindow` que heredara
   de `JFrame`.
3. Agregaremos un `JTextArea` dentro de un `JScrollPane` con la información de la aplicación.
4. Nombraremos al `JTextArea` como `textArea`, al `JScrollPane` como `scrollPane` y al panel principal como `mainPanel`.
5. Crearemos un método `initTextArea()` que inicialice el component `JTextArea` con la información de bienvenida.
6. Crearemos un método `createDesktop()` que cree un `JDesktopPane` y lo agregue al panel principal.
7. Crearemos un método `addTextToDesktop()` que agregue la información de la batalla entre el jugador y un enemigo al
   `JTextArea`.
8. Crearemos una instancia de `Player` y `Enemy` y los enfrentaremos en la batalla.
9. Mostraremos la ventana, la centraremos en la pantalla y haremos que no se pueda redimensionar.

### Código de ejemplo

{{< prism lang="java" line-numbers="true" >}}

      package unitec.rpg.ui.windows;

      import unitec.rpg.entities.Enemy;
      import unitec.rpg.entities.Player;
      
      import javax.swing.*;
      import java.awt.*;
      
      public class WelcomeWindow extends JFrame {
      
          private JPanel mainPanel;
          private JTextArea textArea;
          private JScrollPane scrollPane;
      
          public WelcomeWindow() {
      
              super("Welcome to the RPG");
              initTextArea();
              createDesktop();
              add(mainPanel);
              pack();
              setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              setResizable(false);
              setVisible(true);
              setLocationRelativeTo(null);
          }
      
          private void initTextArea() {
      
              textArea.setText("""
                      Bienvenido al RPG
                      Este es un juego de rol en el que podrás crear tu propio personaje y vivir aventuras en un mundo de fantasía.
                      ¡Que te diviertas!
                      """);
              addTextToDesktop();
              textArea.setFont(new Font("Arial", Font.BOLD, 16));
              textArea.setEditable(false);
              textArea.setLineWrap(true);
              textArea.setWrapStyleWord(true);
              textArea.setOpaque(false);
              textArea.setAutoscrolls(true);
              scrollPane.setAutoscrolls(true);
              scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
              scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
              scrollPane.setOpaque(false);
          }
      
          private void createDesktop() {
      
              JDesktopPane desktopPane = new JDesktopPane();
              desktopPane.setPreferredSize(new Dimension(1280, 680));
              desktopPane.setSize(desktopPane.getPreferredSize());
              mainPanel.setPreferredSize(desktopPane.getPreferredSize());
              desktopPane.add(mainPanel, JLayeredPane.DEFAULT_LAYER);
              desktopPane.setVisible(true);
          }
      
          private void addTextToDesktop() {
      
              Player player = new Player();
              String message;
              player.setName("Player");
              Enemy enemy = new Enemy();
              enemy.setName("Enemy");
              textArea.append(player.getName() + " vs " + enemy.getName() + "\n");
              while (player.isAlive() && enemy.isAlive()) {
                  message = String.format("++++++++++++++++++++++++++\n%s HP: %d vs %s HP: %d\n++++++++++++++++++++++++++\n",
                          player.getName(), player.getHP(), enemy.getName(), enemy.getHP());
                  textArea.append(message);
                  if (player.isAlive()) {
                      message = player.attack(enemy);
                      textArea.append(message);
                  } else {
                      message = String.format("%s ha muerto.\n", player.getName());
                      textArea.append(message);
                      break;
                  }
                  if (enemy.isAlive()) {
                      message = enemy.attack(player);
                      textArea.append(message);
                  } else {
                      message = String.format("%s ha muerto.\n", enemy.getName());
                      textArea.append(message);
                      message = enemy.dropLoot(player);
                      textArea.append(message);
                      break;
                  }
              }
          }
      }

{{< /prism >}}

### Ejecutar la aplicación

Para ejecutar la aplicación, vamos a hacer lo siguiente:

1. Crearemos una clase `Main` en el paquete `unitec.rpg` que contenga el método `main`.
2. Dentro del método `main`, crearemos una instancia de `WelcomeWindow`.
3. Ejecutaremos la aplicación.

### Código de ejemplo

{{< prism lang="java" line-numbers="true" >}}

      package unitec.rpg;
      
      import unitec.rpg.ui.windows.WelcomeWindow;
      
      public class Main {
      
          public static void main(String[] args) {
      
              new WelcomeWindow();
          }
      }

{{< /prism >}}

### Resultado

Al ejecutar la aplicación, deberíamos ver una ventana de bienvenida con la información de la aplicación y una batalla
entre el jugador y un enemigo.

## Conclusiones

En este capítulo, hemos creado nuestra primera ventana de bienvenida. En el siguiente capítulo, crearemos una ventana
mediante las clases `JDesktopPane`, `JTextArea` y `JScrollPane` para mostrar información de la batalla entre el jugador
y un enemigo.

Ahora que hemos creado nuestra primera ventana, podemos continuar con la creación de la ventana de batalla.