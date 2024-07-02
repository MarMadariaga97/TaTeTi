package juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class FrameJuego {

	private JFrame frame;
	private JButton[][] botones;
	private JLabel lblNombreGanador;
	private JLabel lblGanador;
	private JButton btnVolverAJugar;
	private JLabel lblfondo;
	private JLabel lblAclaracion;
	private JLabel lblAclaracion2;
	private JPanel panel;
	private JPanel panelPrincipal;


	public FrameJuego(Juego juego) {
		frame = new JFrame();
		frame.setBounds(100, 100, 551, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Border borde = BorderFactory.createLineBorder(new Color(169, 107, 225), 2);

		botones = new JButton[3][3];

		lblfondo = new JLabel();
		lblfondo.setBounds(0, 0, 536, 433);

		panel = new JPanel();
		panel.setBackground(new Color(18, 17, 17));
		panel.setBounds(0, 0, 537, 433);
		panel.setLayout(null);
		panel.add(lblfondo);
		frame.getContentPane().add(panel);
		
		lblAclaracion = new JLabel("El jugador que comienza es: " + juego.sortear());
		lblAclaracion.setForeground(new Color(169, 107, 255));
		lblAclaracion.setFont(new Font("Arial", Font.PLAIN, 10));
		lblAclaracion.setBounds(54, 285, 400, 30);
		lblAclaracion.setVisible(true);
		
		lblAclaracion2 = new JLabel(juego.getPrimerTurno() + ": X, " + juego.getSegundoTurno() + ": O.");
		lblAclaracion2.setForeground(new Color(169, 107, 255));
		lblAclaracion2.setFont(new Font("Arial", Font.PLAIN, 10));
		lblAclaracion2.setBounds(54, 310, 400, 30);
		lblAclaracion2.setVisible(true);
		
		
		lblNombreGanador = new JLabel("");
		lblNombreGanador.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreGanador.setVerticalAlignment(SwingConstants.CENTER);
		lblNombreGanador.setForeground(new Color(169, 107, 255));
		lblNombreGanador.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNombreGanador.setBounds(159, 330, 210, 43);
		lblNombreGanador.setVisible(false);

		lblGanador = new JLabel("Ganador/a:");
		lblGanador.setForeground(new Color(169, 107, 255));
		lblGanador.setFont(new Font("Arial", Font.PLAIN, 20));
		lblGanador.setBounds(54, 320, 105, 52);
		lblGanador.setVisible(false);

		panelPrincipal = new JPanel(new GridLayout(3, 3));
		panelPrincipal.setBounds(46, 15, 438, 264);
		panelPrincipal.setVisible(true);
		panelPrincipal.setOpaque(false);

		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones.length; j++) {
				JButton boton = new JButton();
				botones[i][j] = boton;
				boton.setFont(boton.getFont().deriveFont(Font.BOLD, 30f)); // Creo una fuente de tamaño 24
				boton.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto
				boton.setBorder(borde);
				boton.setFocusPainted(false);
				boton.setContentAreaFilled(false); // para evitar que se muestre cuando pulso
				panelPrincipal.add(boton);
			}

		}

		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones[0].length; j++) {
				final int fila = i;
				final int col = j;
				botones[i][j].addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						if (botones[fila][col].getText().equals("")) {
							botones[fila][col].setText(juego.getSimbolo());
							juego.setTabla(fila, col, botones[fila][col].getText());

							if (botones[fila][col].getText().equals("X"))

								botones[fila][col].setForeground(new Color(255, 22, 255));

							else
								botones[fila][col].setForeground(new Color(21, 169, 178));
						}

						if (juego.hayGanador(botones[fila][col].getText())) {
							inhabilitarBotones();
							lblGanador.setVisible(true);

							if (botones[fila][col].getText().equals("X")) {

								if (juego.getJugador1().equals(""))
									lblNombreGanador.setText("Jugador 1");

								else
									lblNombreGanador.setText(juego.getPrimerTurno());
							}

							else {
								if (juego.getJugador2().equals(""))
									lblNombreGanador.setText("Jugador 2");

								else
									lblNombreGanador.setText(juego.getSegundoTurno());
							}

							lblNombreGanador.setVisible(true);
							btnVolverAJugar.setVisible(true);

						}

						else {
							if (juego.tableroLleno()) {
								lblNombreGanador.setText("EMPATE");
								lblNombreGanador.setVisible(true);
								btnVolverAJugar.setVisible(true);
							}

						}

					}
				});
			}
		}

		btnVolverAJugar = new JButton("Volver a jugar");
		btnVolverAJugar.setFont(new Font("Arial", Font.BOLD, 12));
		btnVolverAJugar.setBackground(new Color(18, 17, 17));
		btnVolverAJugar.setForeground(new Color(169, 107, 255));
		btnVolverAJugar.setVisible(false);
		btnVolverAJugar.setFocusPainted(false);
		btnVolverAJugar.setOpaque(false);
		btnVolverAJugar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				lblAclaracion2.setText(juego.getPrimerTurno() + ": X, "  + juego.getSegundoTurno() + ": O.");
				juego.limpiarTabla();
				reiniciar(juego);

			}
		});
		btnVolverAJugar.setBounds(197, 385, 138, 42);

		lblfondo.add(panelPrincipal);
		lblfondo.add(lblNombreGanador);
		lblfondo.add(lblGanador);
		lblfondo.add(btnVolverAJugar);
		lblfondo.add(lblAclaracion);
		lblfondo.add(lblAclaracion2);
	}

	public void reiniciar(Juego juego) {
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones.length; j++) {
				
				botones[i][j].setText("");
				botones[i][j].setEnabled(true);
			}

		}
		this.lblGanador.setVisible(false);
		this.lblNombreGanador.setVisible(false);
		btnVolverAJugar.setVisible(false);
		lblAclaracion.setText("El jugador que comienza es: " + juego.sortear());
		lblAclaracion2.setText(juego.getPrimerTurno() + ": X, " + juego.getSegundoTurno() + ": O.");

	}

	public void inhabilitarBotones() {
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones.length; j++) {
				if (botones[i][j].getText().equals(""))
					botones[i][j].setEnabled(false);
			}

		}
	}

	
	
	public JFrame getFrame() {
		return this.frame;
	}
	
	
}
