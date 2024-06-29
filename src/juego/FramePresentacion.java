package juego;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FramePresentacion {

	private JFrame frame;
	private JPanel panel;
	private JLabel lblfondo;
	private JLabel J1;
	private JLabel J2;
	private JTextField textFieldJ1;
	private JTextField textFieldJ2;

	public FramePresentacion(Juego j) {
		frame = new JFrame();
		frame.setBounds(100, 100, 534, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblfondo = new JLabel(new ImageIcon("src/imagenes/fondoTateti.png"));
		lblfondo.setBounds(0, 0, 520, 400);

		panel = new JPanel();
		panel.setBackground(new Color(18, 17, 17));
		panel.setBounds(0, 0, 520, 400);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.add(lblfondo);

		J1 = new JLabel("Nombre de jugador 1");
		J1.setHorizontalAlignment(SwingConstants.CENTER);
		J1.setForeground(new Color(148, 123, 166));
		J1.setFont(new Font("Arial", Font.BOLD, 15));
		J1.setBounds(46, 292, 155, 27);

		J2 = new JLabel("Nombre de jugador 2");
		J2.setHorizontalAlignment(SwingConstants.CENTER);
		J2.setForeground(new Color(148, 123, 166));
		J2.setFont(new Font("Arial", Font.BOLD, 15));
		J2.setBounds(311, 292, 166, 27);

		textFieldJ1 = new JTextField();
		textFieldJ1.setFont(new Font("Candara", Font.PLAIN, 14));
		textFieldJ1.setForeground(new Color(148, 123, 166));
		textFieldJ1.setBounds(75, 323, 96, 19);
		textFieldJ1.setColumns(10);

		textFieldJ2 = new JTextField();
		textFieldJ2.setFont(new Font("Candara", Font.PLAIN, 14));
		textFieldJ2.setForeground(new Color(148, 123, 166));
		textFieldJ2.setColumns(10);
		textFieldJ2.setBounds(336, 323, 96, 19);

		JButton btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				j.setJugador1(textFieldJ1.getText());
				j.setJugador2(textFieldJ2.getText());
				FrameJuego f = new FrameJuego(j);
				cambiarFrame(f.getFrame());
			}
		});
		btnJugar.setForeground(new Color(148, 123, 166));
		btnJugar.setBackground(new Color(18, 17, 17));
		btnJugar.setFont(new Font("Arial", Font.BOLD, 12));
		btnJugar.setBounds(220, 369, 85, 21);
		btnJugar.setFocusPainted(false);
		btnJugar.setOpaque(false);

		lblfondo.add(J1);
		lblfondo.add(J2);
		lblfondo.add(textFieldJ1);
		lblfondo.add(textFieldJ2);
		lblfondo.add(btnJugar);
	}

	public void cambiarFrame(JFrame otro) {
		this.frame.setVisible(false);
		otro.setVisible(true);
	}

	public JFrame getFrame() {
		return this.frame;
	}
}
