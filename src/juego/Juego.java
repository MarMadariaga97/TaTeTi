package juego;

public class Juego {
	private String[][] tabla;
	private int turno;

	public Juego() {
		this.tabla = new String[3][3];
		this.tabla[0][0]="";
		this.tabla[0][1]="";
		this.tabla[0][2]="";
		this.tabla[1][0]="";
		this.tabla[1][1]="";
		this.tabla[1][2]="";
		this.tabla[2][0]="";
		this.tabla[2][1]="";
		this.tabla[2][2]="";
		this.turno=0;
	}

	public String[][] getTabla() {
		return this.tabla;
	}
	
	public void setTabla(int i, int j, String s) {
		this.tabla[i][j]=s;
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
		if (tabla[2][2].equals(s)) {
			if (tabla[1][1].equals(s) && tabla[0][0].equals(s)) {
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

}
