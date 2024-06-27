package juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class FrameJuego {

	private JFrame frame;
	private Juego tateti;
	private JButton[][] botones;
	JLabel lblNombreGanador;
	JLabel lblGanador;
	JButton btnVolverAJugar;
	private JLabel lblfondo;

	public FrameJuego(Juego juego) {
		frame = new JFrame();
		frame.setBounds(100, 100, 551, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		tateti = new Juego();

		Border borde = BorderFactory.createEtchedBorder();

		botones = new JButton[3][3];

		lblfondo = new JLabel(new ImageIcon("src/imagenes/fondoJuego.png"));
		lblfondo.setBounds(0, 0, 536, 433);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 537, 433);
		panel.setLayout(null);
		panel.add(lblfondo);
		frame.getContentPane().add(panel);

		lblNombreGanador = new JLabel("");
		lblNombreGanador.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNombreGanador.setBounds(212, 307, 215, 52);
		lblNombreGanador.setVisible(false);

		lblGanador = new JLabel("Ganador/a:");
		lblGanador.setFont(new Font("Arial", Font.PLAIN, 20));
		lblGanador.setBounds(95, 307, 105, 52);
		lblGanador.setVisible(false);

		JPanel panelPrincipal = new JPanel(new GridLayout(3, 3));
		panelPrincipal.setBounds(46, 33, 438, 264);
		panelPrincipal.setVisible(true);

		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones.length; j++) {
				String nombreBoton = "b" + String.valueOf(i) + String.valueOf(j);
				JButton boton = new JButton();
				boton.setName(nombreBoton);
				botones[i][j] = boton;
				boton.setFont(boton.getFont().deriveFont(Font.BOLD, 24f)); // Creo una fuente de tamaño 24
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
							botones[fila][col].setText(tateti.getSimbolo());
							tateti.setTabla(fila, col, botones[fila][col].getText());

							if (botones[fila][col].getText().equals("X"))

								botones[fila][col].setForeground(Color.blue);

							else
								botones[fila][col].setForeground(Color.red);
						}

						if (tateti.hayGanador(botones[fila][col].getText())) {
							inhabilitarBotones();
							lblGanador.setVisible(true);

							if (botones[fila][col].getText().equals("X")) {
							
								if(juego.getJugador1().equals(""))
									lblNombreGanador.setText("Jugador 1");
								
								else
									lblNombreGanador.setText(juego.getJugador1());
							}
							
							
							else {
								if(juego.getJugador2().equals(""))
									lblNombreGanador.setText("Jugador 2");
								
								else
									lblNombreGanador.setText(juego.getJugador2());
							}
								
							lblNombreGanador.setVisible(true);
							btnVolverAJugar.setVisible(true);

						}
					}
				});
			}
		}

		btnVolverAJugar = new JButton("Volver a jugar");
		btnVolverAJugar.setFont(new Font("Arial", Font.BOLD, 12));
		btnVolverAJugar.setVisible(false);
		btnVolverAJugar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				reiniciar();

			}
		});
		btnVolverAJugar.setBounds(192, 369, 138, 42);

		lblfondo.add(panelPrincipal);
		lblfondo.add(lblGanador);
		lblfondo.add(lblNombreGanador);
		lblfondo.add(btnVolverAJugar);

	
	}

		

	public void reiniciar() {
		this.tateti = new Juego();
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j < botones.length; j++) {
				botones[i][j].setText("");
				botones[i][j].setEnabled(true);
			}

		}
		this.lblGanador.setVisible(false);
		this.lblNombreGanador.setVisible(false);
		btnVolverAJugar.setVisible(false);

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
