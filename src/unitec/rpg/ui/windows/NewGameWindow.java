package unitec.rpg.ui.windows;

import unitec.rpg.ui.buttons.ExitButton;
import unitec.rpg.ui.buttons.StartButton;
import unitec.rpg.ui.cache.FontCache;
import unitec.rpg.ui.cache.ImageCache;
import unitec.rpg.ui.labels.PlayerLabel;

import javax.swing.*;
import java.awt.*;

public class NewGameWindow extends JFrame {

	private final int slot;
	private JPanel backgroundPanel;
	private JButton exitButton;
	private JButton startButton;
	private JTextArea welcomeText;
	private JTextField playerName;
	private JLabel playerLabel;
	private JLabel portraitLabel;


	public NewGameWindow(int slot) {

		this.slot = slot;
		setTitle("New Game");
		add(backgroundPanel);
		pack();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		//setVisible(true);
		welcomeText.append("¡Bienvenido al mundo de JavaRPG!\n");
		welcomeText.append("¿Estás listo para comenzar tu aventura?\n");
		welcomeText.append("¡Elige tu nombre de jugador y comencemos!");
		welcomeText.setOpaque(false);
		welcomeText.setEditable(false);
		//welcomeText.setFont(FontCache.getFont("Standard"));
		welcomeText.setForeground(Color.WHITE);
		//playerName.setFont(FontCache.getFont("Standard"));
		playerName.setForeground(Color.WHITE);
		//playerLabel.setFont(FontCache.getFont("Standard"));
		playerLabel.setForeground(Color.WHITE);
		((StartButton) startButton).setSlot(slot);
	}

	private void createUIComponents() {

		backgroundPanel = new JPanel() {

			@Override
			public void paintComponent(Graphics g) {

				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2d.drawImage(ImageCache.getImage("skillPanel"), 0, 0, null);
			}
		};
		portraitLabel = new PlayerLabel();
		startButton = new StartButton(this, slot);
		exitButton = new ExitButton();
	}

	public String getPlayerName() {

		return playerName.getText();
	}
}
