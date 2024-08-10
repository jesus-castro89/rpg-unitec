package unitec.rpg.ui.buttons.events;

import unitec.rpg.entities.Player;
import unitec.rpg.ui.buttons.AbstractButton;
import unitec.rpg.ui.buttons.LoadGameButton;
import unitec.rpg.ui.buttons.NewGameButton;
import unitec.rpg.ui.windows.MainWindow;
import unitec.rpg.ui.windows.NewGameWindow;
import unitec.rpg.ui.windows.StartWindow;
import unitec.rpg.util.FileManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class FileListener implements ActionListener {

	private final int slot;
	private final AbstractButton button;
	private final StartWindow startWindow;
	private final NewGameWindow newGameWindow;

	public FileListener(AbstractButton button, int slot,
						StartWindow startWindow, NewGameWindow newGameWindow) {


		this.slot = slot;
		this.button = button;
		this.startWindow = startWindow;
		this.newGameWindow = newGameWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Este método se encarga de gestionar las acciones de los botones de la ventana de inicio
		switch (button) {
			case NewGameButton _ -> {
				startWindow.dispose();
				// Si el botón es de nueva partida, se abre la ventana de nueva partida
				newGameWindow.setVisible(true);
			}
			case LoadGameButton _ -> {
				// Si el botón es de cargar partida, se carga la partida del slot correspondiente
				try {
					// Se carga la partida y se abre la ventana de juego
					Player player = FileManager.loadGame(slot);
					startWindow.dispose();
					new MainWindow(player, slot);
				} catch (FileNotFoundException fileNotFoundException) {
					// Si no se encuentra la partida, se muestra un mensaje de error
					JOptionPane.showMessageDialog(null, "No hay partida guardada en este slot",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			default -> throw new IllegalStateException("Unexpected value: " + button);
		}
	}
}
