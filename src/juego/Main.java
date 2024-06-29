package juego;

import java.awt.EventQueue;

public class Main {

	private Juego tateti = new Juego();
	private FramePresentacion frame = new FramePresentacion(tateti);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
