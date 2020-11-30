package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import klinika.Betegek;
import klinika.Idopont;
import klinika.Kezelok;
import klinika.Orvosok;
import klinika.Szakrendeles;
import klinika.Vizit;

public class Repository {

	private final String DB_URL = "jdbc:mysql://localhost:3306/klinika_demo";
	private final String DB_PASS = "";
	private final String DB_USER = "root";

	private Connection conn;

	public Repository() {
		initDatabase();
	}

	private void initDatabase() {
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		} catch (SQLException ex) {
			System.err.println("Hiba az adatbázis kapcsolat létrehozásában " + ex);
		}
	}

	public Integer ujOrvos(Orvosok orvos) {
		String query = "INSERT INTO Orvosok" + "(szakr_id,nev)" + "values(?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, orvos.getSzakr_id());
			pstmt.setString(2, orvos.getNev());
			pstmt.execute();
			ResultSet tableKeys = pstmt.getGeneratedKeys();
			tableKeys.next();
			return tableKeys.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer ujBeteg(Betegek beteg) {
		String query = "INSERT INTO betegek(nev, cim, tel, email, ht_nev, ht_cim, ht_tel, ht_email) VALUES (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, beteg.getNev());
			pstmt.setString(2, beteg.getCim());
			pstmt.setInt(3, beteg.getTel());
			pstmt.setString(4, beteg.getEmail());
			pstmt.setString(5, beteg.getHt_nev());
			pstmt.setString(6, beteg.getHt_cim());
			pstmt.setInt(7, beteg.getTel());
			pstmt.setString(8, beteg.getHt_email());
			pstmt.execute();
			ResultSet tableKeys = pstmt.getGeneratedKeys();
			return tableKeys.getInt(1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public Integer ujDatum(String datum) {
		String query = "INSERT INTO datum (datum) VALUES (?)";

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.M.d.", Locale.ENGLISH);
		LocalDate date = LocalDate.parse(datum, formatter);
		String dateEnd = date.toString();

		try {
			PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, dateEnd);
			pstmt.execute();
			ResultSet tableKeys = pstmt.getGeneratedKeys();
			return tableKeys.getInt(1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public Integer betegVizit(Vizit vizit) {
		String query = "INSERT INTO vizit(szakrendeles_id, orvosok_id, kezelok_id, datum_id, idopont_id, betegek_id) VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, vizit.getSzakrendeles_id());
			pstmt.setInt(2, vizit.getOrvosok_id());
			pstmt.setInt(3, vizit.getKezelok_id());
			pstmt.setInt(4, vizit.getDatum_id());
			pstmt.setInt(5, vizit.getIdopont_id());
			pstmt.setInt(6, vizit.getBetegek_id());
			pstmt.execute();
			ResultSet tableKeys = pstmt.getGeneratedKeys();
			return tableKeys.getInt(1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public List<Szakrendeles> szakrendelesekLekerdezes() {

		String query = "SELECT * FROM szakrendeles";
		List<Szakrendeles> resultList = new ArrayList<>();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(query);
			stmt.executeQuery();
			ResultSet rs = stmt.getResultSet();
			while (rs.next()) {
				Szakrendeles szr = new Szakrendeles();
				szr.setId(rs.getInt("szakrendeles_id"));
				szr.setNev(rs.getString("nev"));
				resultList.add(szr);
			}
		} catch (Exception e) {

		}
		for (Szakrendeles szakrendeles : resultList) {
			System.out.println(szakrendeles);
		}
		return resultList;
	}

	public Integer datumIdLekerdezes(String datum) {
		Integer result = 0;
		String query = "SELECT datum_id FROM datum WHERE datum = ?";

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.M.d.", Locale.ENGLISH);
		LocalDate date = LocalDate.parse(datum, formatter);
		String dateEnd = date.toString();

		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(query);
			stmt.setString(1, dateEnd);
			stmt.executeQuery();
			ResultSet rs = stmt.getResultSet();
			if (rs.next()) {
				result = rs.getInt("datum_id");
			}
//			if (result == 0) {
//				
//			}
		} catch (Exception e) {

		}

		return result;
	}

	public Integer idopontVizsgalat(Integer szakrendelesId, Integer datumId, Integer idopontId) {
		Integer kezelokOsszes = 0;
		Integer orvosokOsszes = 0;
		Integer kezelokSzakrendelesSzerint = 0;
		Integer orvosokSzakrendelesSzerint = 0;
		Integer eredmenyKezelok = null;
		Integer eredmenyOrvosok = null;
		
		String query = "SELECT COUNT(*) AS szam FROM kezelok WHERE `id` NOT IN (SELECT DISTINCT (`kezelok_id`) FROM vizit WHERE ? AND ? AND idopont_id=?)";

		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, szakrendelesId);
			stmt.setInt(2, datumId);
			stmt.setInt(3, idopontId);
			stmt.executeQuery();
			ResultSet rs = stmt.getResultSet();
			if (rs.next()) {
				kezelokOsszes = rs.getInt("szam");
			}
		} catch (Exception e) {

		}
		//System.out.println("Kezelok osszes: " + kezelokOsszes);
		query = "SELECT COUNT(*) AS szam FROM kezelok WHERE szakr_id != ?";

		try {
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, szakrendelesId);
			stmt.executeQuery();
			ResultSet rs = stmt.getResultSet();
			if (rs.next()) {
				kezelokSzakrendelesSzerint = rs.getInt("szam");
			}
			eredmenyKezelok = kezelokOsszes - kezelokSzakrendelesSzerint;
		} catch (Exception e) {
		}
		System.out.println("Eredmény kezelõk: " + eredmenyKezelok);
		query = "SELECT COUNT(*) AS szam FROM orvosok WHERE `id` NOT IN (SELECT DISTINCT(`orvosok_id`) FROM vizit WHERE ? AND ? AND idopont_id=?)";

		try {
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, szakrendelesId);
			stmt.setInt(2, datumId);
			stmt.setInt(3, idopontId);
			stmt.executeQuery();
			ResultSet rs = stmt.getResultSet();
			if (rs.next()) {
				orvosokOsszes = rs.getInt("szam");
			}
		} catch (Exception e) {

		}
		//System.out.println("Orvosok osszes: " + orvosokOsszes);
		query = "SELECT COUNT(*) AS szam FROM orvosok WHERE szakr_id != ?";

		try {
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, szakrendelesId);
			stmt.executeQuery();
			ResultSet rs = stmt.getResultSet();
			if (rs.next()) {
				orvosokSzakrendelesSzerint = rs.getInt("szam");
			}
			eredmenyOrvosok = orvosokOsszes - orvosokSzakrendelesSzerint;
		} catch (Exception e) {
		}
		System.out.println("Eredmény orvosok: " + eredmenyOrvosok);
		if (eredmenyKezelok == 0 || eredmenyOrvosok == 0) {
			return 0;
		}
		return 1;
	}

	public void idopontTablaMegjelenitBeallit(List<Integer> idopontBeGyujt) {
		for (int i = 1; i < 10; i++) {
			String query = "UPDATE idopont SET megjelenit=? WHERE idopont_id= ?";
			PreparedStatement stmt;
			try {
				stmt = conn.prepareStatement(query);
				if (idopontBeGyujt.get(i) < 1) {
					stmt.setBoolean(1, false);
					stmt.setInt(2, i);
					stmt.execute();
				} else {
					stmt.setBoolean(1, true);
					stmt.setInt(2, i);
					stmt.execute();
				}
			} catch (Exception e) {

			}
		}
	}

	public void idopontTablaMegjelenitAlapertelmezett() {
		for (int i = 1; i < 10; i++) {
			String query = "UPDATE idopont SET megjelenit=? WHERE idopont_id= ?";
			PreparedStatement stmt;
			try {
				stmt = conn.prepareStatement(query);
				stmt.setBoolean(1, true);
				stmt.setInt(2, i);
				stmt.execute();
			} catch (Exception e) {

			}
		}
	}

	public List<Idopont> idopontTablaLekerdezes() {

		String query = "SELECT * FROM `idopont` WHERE megjelenit != 0";
		List<Idopont> eredmenyLista = new ArrayList<>();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(query);
			stmt.executeQuery();
			ResultSet rs = stmt.getResultSet();
			while (rs.next()) {
				Idopont idopont = new Idopont();
				idopont.setId(rs.getInt("idopont_id"));
				idopont.setIdopont(rs.getString("idopont"));
				eredmenyLista.add(idopont);
			}
		} catch (Exception e) {

		}
		for (Idopont idopont : eredmenyLista) {
			System.out.println(idopont.toString());
		}
		return eredmenyLista;
	}

	// ---------------
//	public List<Szakrendeles> szakrendelesekLekerdezes() {
//
//		String query = "SELECT * FROM szakrendeles";
//		List<Szakrendeles> resultList = new ArrayList<>();
//		PreparedStatement stmt;
//		try {
//			stmt = conn.prepareStatement(query);
//			stmt.executeQuery();
//			ResultSet rs = stmt.getResultSet();
//			while (rs.next()) {
//				Szakrendeles szr = new Szakrendeles();
//				szr.setId(rs.getInt("szakrendeles_id"));
//				szr.setNev(rs.getString("nev"));
//				resultList.add(szr);
//			}
//		} catch (Exception e) {
//
//		}
//		return resultList;
//	}

	public List<Kezelok> kezelokLekerdezes(Integer szakrendelesId, Integer datumId, Integer idopontId) {
		String query = "SELECT * FROM kezelok WHERE `id` NOT IN (SELECT DISTINCT(`kezelok_id`) FROM vizit WHERE ? AND ? AND idopont_id=?)";
		List<Kezelok> eredmenyLista = new ArrayList<>();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, szakrendelesId);
			stmt.setInt(2, datumId);
			stmt.setInt(3, idopontId);
			stmt.executeQuery();
			ResultSet rs = stmt.getResultSet();
			while (rs.next()) {
				if (rs.getInt("szakr_id") == szakrendelesId) {
					Kezelok kezelok = new Kezelok();
					kezelok.setId(rs.getInt("id"));
					kezelok.setSzakr_id(rs.getInt("szakr_id"));
					kezelok.setRendelo(rs.getString("rendelo"));
					eredmenyLista.add(kezelok);
				}
			}
		} catch (Exception e) {

		}
		for (Kezelok kezelok : eredmenyLista) {
			System.out.println(kezelok.toString());
		}
		return eredmenyLista;
	}

	public List<Orvosok> orvosokLekerdezes(Integer szakrendelesId, Integer datumId, Integer idopontId) {
		String query = "SELECT * FROM orvosok WHERE `id` NOT IN (SELECT DISTINCT(`orvosok_id`) FROM vizit WHERE ? AND ? AND idopont_id=?)";
		List<Orvosok> eredmenyLista = new ArrayList<>();
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, szakrendelesId);
			stmt.setInt(2, datumId);
			stmt.setInt(3, idopontId);
			stmt.executeQuery();
			ResultSet rs = stmt.getResultSet();
			while (rs.next()) {
				if (rs.getInt("szakr_id") == szakrendelesId) {
					Orvosok orvosok = new Orvosok();
					orvosok.setId(rs.getInt("id"));
					orvosok.setSzakr_id(rs.getInt("szakr_id"));
					orvosok.setNev(rs.getString("nev"));
					eredmenyLista.add(orvosok);
				}
			}
		} catch (Exception e) {

		}
		for (Orvosok orvosok : eredmenyLista) {
			System.out.println(orvosok.toString());
		}
		return eredmenyLista;
	}

	public void closeConnection() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException ex) {
			System.err.println("Hiba a kapcsolat lezárásában " + ex);
		}
	}

	public boolean ellenorzes(String tabla, String oszlop, String mezo) {

		String query = "SELECT COUNT(*) AS DARAB FROM " + tabla + " WHERE " + oszlop + " = '" + mezo + "'";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				int total = rs.getInt("DARAB");
				// System.out.println(total);
				if (total != 0) {
					return true;
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

	public Integer betegLekerdezes(String betegNeve) {
		Integer eredmeny = 0;
		String query = "SELECT betegek_id FROM betegek WHERE nev = ?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, betegNeve);
			pstmt.executeQuery();
			ResultSet rs = pstmt.getResultSet();
			if (rs.next()) {
				eredmeny = rs.getInt("betegek_id");
			}
		} catch (Exception e) {

		}
		return eredmeny;
	}
}
