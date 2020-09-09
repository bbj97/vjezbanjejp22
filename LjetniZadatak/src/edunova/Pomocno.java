package edunova;

import java.awt.Desktop;
import java.net.URI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Pomocno {
	private static Scanner scanner = new Scanner(System.in);

	public static int akcija() {

		int brojAkcije;

		while (true) {

			try {

				System.out.print("Odaberite akciju: ");
				brojAkcije = scanner.nextInt();
				scanner.nextLine();

				if (brojAkcije <= 7 && brojAkcije >= 1) {
					return brojAkcije;
				}

			} catch (Exception e) {

				System.out.println("---Krivi unos---");
				scanner.nextLine();
			}
		}
	}
	


	// Metoda za kreiranje djela

	public static void unosDjela() {
		String pieceName, author, museum, description;

		pieceName = unosImeSlike("Unesite ime slike: ");
		author = unosAuthor("Unesite autora djela: ");
		museum = unosMuseum("Unesite muzej u kojem je djelo: ");
		description = unosDescription("Unesite opis djela: ");

		CrudMet.unosDjelaUBazu(pieceName, author, museum, description);

		System.out.println("---Djelo je usješno kreirano---");
	}

	// Metoda za promjenu podataka djela

	public static void promjenaDjela() {

		CrudMet.ispisDjelaIzBaze();

		int sifra = unosRedniBroj("Unesite redni broj klijenta za promjenu: ");

		if (sifra == 0) {
			return;

		}

		String pieceName, author, museum, description;

		pieceName = unosImeSlike("Unesite ime djela za promjenu: ");
		author = unosAuthor("Unesite autora djela za promjenu: ");
		museum = unosMuseum("Unesite muzej djela za promjenu: ");
		description = unosDescription("Unesite opis djela za promjenu: ");

		CrudMet.promjenaDjelaUBazi(sifra, pieceName, author, museum, description);

		System.out.println("---Promjena djela je izvršena---");

	}

	public static void brisanjeDjela() {
		CrudMet.ispisDjelaIzBaze();

		int sifra = unosRedniBroj("Unesite redni broj djela za brisanje: ");

		if (sifra == 0) {
			return;
		}

		CrudMet.brisanjeDjelaUBazi(sifra);

		System.out.println("---Djelo je uspješno obrisano---");

	}

	private static int unosRedniBroj(String string) {

		int redniBroj;
		Integer sifra;
		String akcija = "";

		search: while (true) {

			try {

				System.out.print(string);
				redniBroj = scanner.nextInt();
				scanner.nextLine();

				sifra = findSifru(redniBroj);

				if (sifra.equals(0)) {

					while (true) {
						System.out.println("Želite li nastaviti željenu akciju? Da ili Ne?");
						akcija = scanner.nextLine();

						if (akcija.toLowerCase().equals("ne")) {
							return 0;
						} else if (akcija.toLowerCase().equals("da")) {
							continue search;
						}

					}

				}

				return sifra;

			} catch (Exception e) {
				System.out.println("---Krivi unos---");
				scanner.nextLine();
			}
		}

	}

	private static Integer findSifru(Integer sifra) {
		try {

			PreparedStatement query = Baza.otvoriVezu().prepareStatement("SELECT sifra FROM artpiece");

			ResultSet rs = query.executeQuery();

			while (rs.next()) {
				if (sifra.equals(rs.getRow())) {
					return rs.getInt("sifra");

				}
			}
			System.out.println("---Djelo pod rednim brojem " + sifra + " ne postoji---");

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;

	}



	private static String unosImeSlike(String string) {

		String s;

		while (true) {

			System.out.println(string);
			s = scanner.nextLine();

			if (!s.isEmpty() && s.matches(".*[a-zA-Z]+.*")) {

				return s;

			}

		}

	}
	private static String unosAuthor(String string) {

		String s;

		while (true) {

			System.out.println(string);
			s = scanner.nextLine();

			if (!s.isEmpty() && s.matches(".*[a-zA-Z]+.*")) {

				return s;

			}

		}

	}
	
	private static String unosMuseum(String string) {

		String s;

		while (true) {

			System.out.println(string);
			s = scanner.nextLine();

			if (!s.isEmpty() && s.matches(".*[a-zA-Z]+.*")) {

				return s;

			}

		}

	}
	private static String unosDescription(String string) {

		String s;

		while (true) {

			System.out.println(string);
			s = scanner.nextLine();

			if (!s.isEmpty() && s.matches(".*[a-zA-Z]+.*")) {

				return s;

			}

		}

	}

	public static void goToAddress(String url) {

		try {
			Desktop desktop = java.awt.Desktop.getDesktop();
			URI goTo = new URI(url);
			desktop.browse(goTo);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
