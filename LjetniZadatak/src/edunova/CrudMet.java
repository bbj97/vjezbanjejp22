package edunova;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudMet {

	public static void unosDjelaUBazu(String pieceName, String author, String museum, String description) {

		try {
			PreparedStatement query = Baza.otvoriVezu().prepareStatement(
					"INSERT INTO artpiece (pieceName,description,author,museum)" + " VALUES (?,?,?,?)");

			query.setString(1, pieceName);
			query.setString(2, author);
			query.setString(3, museum);
			query.setString(4, description);


			query.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// Read metoda

	public static void ispisDjelaIzBaze() {
		int redniBroj = 1;

		try {

			PreparedStatement query = Baza.otvoriVezu().prepareStatement("SELECT * FROM artpiece;");

			ResultSet rs = query.executeQuery();

			while (rs.next()) {
				System.out.println((redniBroj++) + ". " + rs.getString("pieceName") + ", " + rs.getString("author") + " Muzej: "
						+ rs.getString("museum") + "Opis: " + rs.getString("description"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Update metoda

	public static void promjenaDjelaUBazi(int redniBroj, String pieceName, String author, String museum, String description) {

		try {

			PreparedStatement query = Baza.otvoriVezu().prepareStatement(
					"UPDATE artpiece SET pieceName=?, author=?, museum=?, description=? WHERE sifra = ?");

			query.setString(1, pieceName);
			query.setString(2, author);
			query.setString(3, museum);
			query.setString(4, description);
			query.setInt(5, redniBroj);

			query.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Delete metoda

	public static void brisanjeDjelaUBazi(int redniBroj) {

		try {

			PreparedStatement query = Baza.otvoriVezu().prepareStatement("DELETE FROM artpiece WHERE sifra=?");

			query.setInt(1, redniBroj);

			query.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
