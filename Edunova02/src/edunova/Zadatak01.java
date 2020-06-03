package edunova;

import javax.swing.JOptionPane;

public class Zadatak01 {
	public static void main(String[] args) {
		int broj = Integer.parseInt(JOptionPane.showInputDialog("Unesi broj:"));
		int broj1 = Integer.parseInt(JOptionPane.showInputDialog("Unesi broj:"));
		int broj2 = Integer.parseInt(JOptionPane.showInputDialog("Unesi broj:"));

		if(broj1<broj & broj2<broj) {
			System.out.println(broj);
		}else if(broj1>broj & broj1>broj2) {
			System.out.println(broj1);
		}else {
			System.out.println(broj2);
		}
	}
}
