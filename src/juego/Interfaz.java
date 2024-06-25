package juego;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.JLabel;

public class Interfaz {

	private JFrame frame;
	private Juego tateti;
	private JButton[][] botones;
	JLabel lblNombreGanador;
	JLabel lblGanador;
	JButton btnVolverAJugar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 534, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		tateti = new Juego();
		
		Border borde = BorderFactory.createEtchedBorder();
		
		botones=new JButton[3][3];

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(38, 21, 432, 227);
		panelPrincipal.setLayout(new GridLayout(3, 3, 1, 1));
		panelPrincipal.setVisible(true);
		
		lblGanador = new JLabel("Ganador/a:");
		lblGanador.setFont(new Font("Arial", Font.PLAIN, 20));
		lblGanador.setBounds(96, 258, 105, 52);
		lblGanador.setVisible(false);
		frame.getContentPane().add(lblGanador);
		
		lblNombreGanador = new JLabel("");
		lblNombreGanador.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNombreGanador.setBounds(207, 258, 215, 52);
		lblNombreGanador.setVisible(false);
		frame.getContentPane().add(lblNombreGanador);
		
		btnVolverAJugar = new JButton("Volver a Jugar");
		btnVolverAJugar.setVisible(false);
		btnVolverAJugar.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				reiniciar();
				
			}
		});
		btnVolverAJugar.setBounds(186, 335, 138, 42);
		frame.getContentPane().add(btnVolverAJugar);

		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j <  botones.length; j++) {
				String nombreBoton = "b" + String.valueOf(i) + String.valueOf(j);
				JButton boton = new JButton();
				boton.setName(nombreBoton);
				botones[i][j]=boton;
				boton.setFont(boton.getFont().deriveFont(Font.BOLD, 24f)); // Creo una fuente de tamaño 24
				boton.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto
				boton.setBorder(borde);
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
	                    	botones[fila][col].setText(tateti.getSimbolo());
	                    	tateti.setTabla(fila, col, botones[fila][col].getText());
	                    	
	                    	botones[fila][col].setEnabled(false);
	                    	
	                    	if(tateti.hayGanador(botones[fila][col].getText())) {
	                    		lblGanador.setVisible(true);
	                    		
	                    		if(botones[fila][col].getText().equals("X")) 
	                    			lblNombreGanador.setText("Jugador 1");
	                    			
	                    		else 
	                    			lblNombreGanador.setText("Jugador 2");
	                    		
	                    		
	                    		lblNombreGanador.setVisible(true);
	                    		btnVolverAJugar.setVisible(true);
	                    			
	                    	}
	                    }
	                });
	            }
	        }

		frame.getContentPane().add(panelPrincipal);
		
	
	}
	
	public void reiniciar() {
		this.tateti=new Juego();
		for (int i = 0; i < botones.length; i++) {
			for (int j = 0; j <  botones.length; j++) {
				botones[i][j].setText("");
				botones[i][j].setEnabled(true);
			}

		}
		this.lblGanador.setVisible(false);
		this.lblNombreGanador.setVisible(false);
		btnVolverAJugar.setVisible(false);
	}
}
