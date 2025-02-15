package juego;

import java.util.Random;

public class Juego {
	private String[][] tabla;
	private String jugador1="";
	private String jugador2="";
	private int turno;
	private String primerTurno;
	private String SegundoTurno;


	public Juego() {
		this.tabla = new String[3][3];
		this.tabla[0][0] = "";
		this.tabla[0][1] = "";
		this.tabla[0][2] = "";
		this.tabla[1][0] = "";
		this.tabla[1][1] = "";
		this.tabla[1][2] = "";
		this.tabla[2][0] = "";
		this.tabla[2][1] = "";
		this.tabla[2][2] = "";
		this.turno = 0;
	}

	public String getJugador1() {
		return this.jugador1;
	}

	public void setJugador1(String s1) {
		this.jugador1 = s1;
	}

	public String getJugador2() {
		return this.jugador2;
	}

	public void setJugador2(String s2) {
		this.jugador2 = s2;
	}

	public String[][] getTabla() {
		return this.tabla;
	}

	public void setTabla(int i, int j, String s) {
		this.tabla[i][j] = s;
	}

	public String getSimbolo() {
		if (turno % 2 == 0) {
			turno = turno + 1;
			return "X";
		}

		else {
			turno = turno + 1;
			return "O";
		}

	}
	
	public String sortear() {

        Random random = new Random();
        int numAleatorio = random.nextInt(10)+1;
        
        
        if(numAleatorio<6) {
        	this.primerTurno=this.jugador1;
        	this.SegundoTurno=this.jugador2;
        	
        	
        }
        else {
        	this.primerTurno=this.jugador2;
        	this.SegundoTurno=this.jugador1;
         }
        
        return this.primerTurno;
	}
	
	public String getPrimerTurno() {
		return this.primerTurno;
	}
	
	public String getSegundoTurno() {
		return this.SegundoTurno;
	}

	private boolean alineacionHorizontal(String s) {
		if (tabla[0][0].equals(s) && tabla[0][1].equals(s) && tabla[0][2].equals(s)) {
			return true;
		} else if (tabla[1][0].equals(s) && tabla[1][1].equals(s) && tabla[1][2].equals(s)) {
			return true;
		} else if (tabla[2][0].equals(s) && tabla[2][1].equals(s) && tabla[2][2].equals(s)) {
			return true;
		}

		return false;

	}

	private boolean alineacionVertical(String s) {
		if (tabla[0][0].equals(s) && tabla[1][0].equals(s) && tabla[2][0].equals(s)) {
			return true;
		} else if (tabla[0][1].equals(s) && tabla[1][1].equals(s) && tabla[2][1].equals(s)) {
			return true;
		} else if (tabla[0][2].equals(s) && tabla[1][2].equals(s) && tabla[2][2].equals(s)) {
			return true;
		}

		return false;
	}

	public boolean alineacionHorizontalIzqDer(String s) {
		if (tabla[0][0].equals(s)) {
			if (tabla[1][1].equals(s) && tabla[2][2].equals(s)) {
				return true;
			}
			return false;
		}

		else
			return false;
	}

	private boolean alineacionHorizontalDerIzq(String s) {
		if (tabla[0][2].equals(s)) {
			if (tabla[1][1].equals(s) && tabla[2][0].equals(s)) {
				return true;
			}
			return false;
		}

		else
			return false;
	}

	public boolean hayGanador(String s) {
		if (alineacionHorizontal(s) || alineacionVertical(s) || alineacionHorizontalIzqDer(s)
				|| alineacionHorizontalDerIzq(s)) {
			return true;
		}
		return false;
	}

	public boolean tableroLleno() {

		for (String[] s : this.tabla) {
			for (String elem : s) {
				if (elem.equals(""))
					return false;
			}
		}

		return true;
	}

	public void limpiarTabla() {

		for (String[] s : this.tabla) {
			for (int i = 0; i < s.length; i++) {
				s[i]="";
				
			}
		}

	}
}
