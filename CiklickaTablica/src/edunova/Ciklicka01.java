package edunova;

import javax.swing.JOptionPane;

public class Ciklicka01 {

	public static void main(String[] args) {
	
		int red, stup;

		do {
			red = Integer.parseInt(JOptionPane.showInputDialog("Broj redova: "));
			stup = Integer.parseInt(JOptionPane.showInputDialog("Broj stupaca: "));

		} while ((red == 0 | red< 0) | (stup == 0 | stup < 0));

		final int matrica[][] = new int[red][stup];
		int prviStup = 0, zadnjiStup = stup - 1;
		int prviRed = 0, zadnjiRed = red - 1;
		int polje = 1;

		
		while (polje <= red * stup) {
			for (int i = zadnjiStup; i >= prviStup; i--) {
				matrica[zadnjiRed][i] = polje++;
			}
			for (int j = zadnjiRed - 1; j >= prviRed; j--) {
				matrica[j][prviStup] = polje++;
			}
			for (int i = prviStup + 1; i <= zadnjiStup; i++) {
				matrica[prviRed][i] = polje++;
			}

			for (int j = prviRed + 1; j < zadnjiRed; j++) {
				matrica[j][zadnjiStup] = polje++;
			}

			prviStup++;
			zadnjiStup--;
			prviRed++;
			zadnjiRed--;
		}
		
		
		System.out.println("Ciklicka matrica:" + "\n");
		for (int i = 0; i < red; i++) {
			for (int j = 0; j < stup; j++) {
				System.out.print(matrica[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
