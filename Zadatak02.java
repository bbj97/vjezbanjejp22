package edunova;

import javax.swing.JOptionPane;

public class Zadatak02 {

	public static void main(String[] args) {
	
		int broj = Integer.parseInt(JOptionPane.showInputDialog("Unesi broj od 1 do 5:"));
		
		if (broj<1 || broj>5) {
			System.out.println("Broj nije dobar");
		}else {
			switch(broj) {
			case 1: 
				System.out.println("nedovoljan");
				break;
			case 2:
				System.out.println("dovoljan");
				break;
			case 3:
				System.out.println("dobar");
				break;
			case 4:
				System.out.println("vrlo dobar");
				break;
			case 5: 
				System.out.println("odlican");
				break;
			}
		}
		
	}
}
