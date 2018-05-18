package kasvisto.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kasvi.model.Kasvi;

public class KasviDAO extends DataAccessObject {
	// voidaan hakea kavitaulun kaikki kasvit tarvittaessas
	public ArrayList<Kasvi> findAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Kasvi> kasvit = new ArrayList<Kasvi>();
		Kasvi kasvi = null;

		try {
			conn = getConnection(); // Luodaan yhteys
			// Luodaan komento: haetaan kaikki rivit person-taulusta
			String sqlSelect = "SELECT id, nimi, kuvaus, kastelu, valo, henkiloId FROM kasvi;";
			// Valmistellaan komento:
			stmt = conn.prepareStatement(sqlSelect);
			// L‰hetet‰‰n komento:
			rs = stmt.executeQuery();
			// K‰yd‰‰n tulostaulun rivit l‰pi
			while (rs.next()) {
				kasvi = readKasvi(rs);
				kasvit.add(kasvi); // lis‰t‰‰n kasvi listaan
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs, stmt, conn); // Suljetaan
		}
		return kasvit; // palautetaan Kasvi-lista(ArrayList)
	}

	private Kasvi readKasvi(ResultSet rs) {
		try {
			// Haetaan yhden kasvin tiedot kyselyn tulostaulun
			// (ResultSettyyppinenrs-olion) aktiiviselta tietorivilt‰

			Kasvi kasvi = new Kasvi();

			kasvi.setId(rs.getInt("id"));
			kasvi.setNimi(rs.getString("nimi"));
			kasvi.setKuvaus(rs.getString("kuvaus"));
			kasvi.setKastelu(rs.getString("kastelu"));
			kasvi.setValo(rs.getString("valo"));
			kasvi.setHenkiloId(rs.getInt("henkiloId"));
			/*
			 * int id = rs.getInt("id"); String nimi = rs.getString("nimi");
			 * String kuvaus = rs.getString("kuvaus"); String kastelu =
			 * rs.getString("kastelu"); String valo = rs.getString("valo");
			 */

			// Luodaan ja palautetaan uusi kasvi
			return kasvi;/* new Kasvi(id, nimi, kuvaus, kastelu, valo); */
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	public void addKasvi(Kasvi kasvi) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtInsert = null;

		try {
			// Luodaan yhteys
			connection = getConnection();
			// Luodaan uusi kasvi tietokantaan:
			String sqlInsert = "INSERT INTO kasvi(id, nimi, kuvaus, kastelu, valo, henkiloId) VALUES (?, ?, ?, ?, ?,?)";
			stmtInsert = connection.prepareStatement(sqlInsert);
			stmtInsert.setInt(1, kasvi.getId());
			stmtInsert.setString(2, kasvi.getNimi());
			stmtInsert.setString(3, kasvi.getKuvaus());
			stmtInsert.setString(4, kasvi.getKastelu());
			stmtInsert.setString(5, kasvi.getValo());
			stmtInsert.setInt(6, kasvi.getHenkiloId());
			stmtInsert.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtInsert, connection); // Suljetaan statement ja yhteys
		}
	}

	// poistetaan kasvi kasviId numeron perusteella
	public void removeKasvi(int kasviId) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtDelete = null;

		try {
			// Luodaan yhteys
			connection = getConnection();
			// Poistetaan kasvi tietokantasta:
			String sqlInsert = "DELETE FROM kasvi WHERE id = ?";
			stmtDelete = connection.prepareStatement(sqlInsert);
			stmtDelete.setInt(1, kasviId);
			stmtDelete.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtDelete, connection); // Suljetaan statement ja yhteys
		}
	}

	// poistetaan kasvit joiden viiteavaimena on parametrina saatu henkiloId
	public void removeKasviByHenkiloId(int henkiloId) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtDelete = null;

		try {
			// Luodaan yhteys
			connection = getConnection();
			// Poistetaan kasvi tietokantasta:
			String sqlInsert = "DELETE FROM kasvi WHERE henkiloId = ?";
			stmtDelete = connection.prepareStatement(sqlInsert);
			stmtDelete.setInt(1, henkiloId);
			stmtDelete.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtDelete, connection); // Suljetaan statement ja yhteys
		}
	}

	// haetaan kaikki kasvit tietokannan taulusta, joiden viiteavain on
	// parametrina saatu hankiloId
	public List<Kasvi> findKasvitByHenkiloId(int henkiloId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// int henkiloId = 0; testi toimii
		List<Kasvi> kasvit = new ArrayList<Kasvi>();
		Kasvi kasvi = null;
		try {
			// Luodaan yhteys
			conn = getConnection();

			// Luodaan komento: haetaan kaikki rivit kasvitaulusta
			String sqlSelect = "SELECT id, nimi, kuvaus, kastelu, valo, henkiloId FROM kasvi WHERE henkiloId = ?";

			// Valmistellaan komento:
			stmt = conn.prepareStatement(sqlSelect);
			stmt.setInt(1, henkiloId);

			// L‰hetet‰‰n komento:
			rs = stmt.executeQuery();

			// K‰yd‰‰n tulostaulun rivit l‰pi ja luetaan read()-metodilla:
			while (rs.next()) {
				kasvi = readKasvi(rs);
				// lis‰t‰‰n kasvi listaan
				kasvit.add(kasvi);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs, stmt, conn); // Suljetaan
		}

		return kasvit; // palautetaan lista kasveista joiden viiteavain on
						// parametrina saatu henkiloId
	}

	// haetaan yksi kasvi tietokannasta henkiloId-arvon perusteella
	public Kasvi findByhenkiloId(int henkiloId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Kasvi kasvi = null;
		try {
			// Luodaan yhteys
			conn = getConnection();

			// Luodaan komento: haetaan kaikki rivit kurssitaulusta
			String sqlSelect = "SELECT id, nimi, kuvaus, kastelu, valo, henkiloId FROM kasvi WHERE henkiloId = ?";

			// Valmistellaan komento:
			stmt = conn.prepareStatement(sqlSelect);
			stmt.setInt(1, henkiloId);

			// L‰hetet‰‰n komento:
			rs = stmt.executeQuery();

			// K‰yd‰‰n tulostaulun rivit l‰pi ja luetaan read()-metodilla:
			if (rs.next()) {
				kasvi = readKasvi(rs);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs, stmt, conn); // Suljetaan
		}

		return kasvi;
	}

	// haetaan yksi kasvi tietokannasta kasvin Id-arvon perusteella 
	public Kasvi findByKasviId(int KasviId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Kasvi kasvi = null;
		try {
			// Luodaan yhteys
			conn = getConnection();

			// Luodaan komento: haetaan kaikki rivit kurssitaulusta
			String sqlSelect = "SELECT id, nimi, kuvaus, kastelu, valo, henkiloId FROM kasvi WHERE id = ?";

			// Valmistellaan komento:
			stmt = conn.prepareStatement(sqlSelect);
			stmt.setInt(1, KasviId);

			// L‰hetet‰‰n komento:
			rs = stmt.executeQuery();

			// K‰yd‰‰n tulostaulun rivit l‰pi ja luetaan read()-metodilla:
			if (rs.next()) {
				kasvi = readKasvi(rs);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs, stmt, conn); // Suljetaan
		}

		return kasvi;
	}

	// haetaan yksi kasvi tietokannasta kasvin Id-arvon perusteella ja
	// p‰ivitet‰‰n tiedot
	public void updateByKasviId(Kasvi kasvi) {
		Connection connection = null;
		PreparedStatement stmtInsert = null;

		try {
			// Luodaan yhteys
			connection = getConnection();

			// Luodaan komento: haetaan kaikki rivit kurssitaulusta
			String sqlInsert = "UPDATE kasvi SET nimi=?, kuvaus=?, kastelu=?, valo=?, henkiloId=? WHERE id=?";

			// Valmistellaan komento:

			stmtInsert = connection.prepareStatement(sqlInsert);

			stmtInsert.setString(1, kasvi.getNimi());
			stmtInsert.setString(2, kasvi.getKuvaus());
			stmtInsert.setString(3, kasvi.getKastelu());
			stmtInsert.setString(4, kasvi.getValo());
			stmtInsert.setInt(5, kasvi.getHenkiloId());
			stmtInsert.setInt(6, kasvi.getId());

			// L‰hetet‰‰n komento:
			stmtInsert.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtInsert, connection); // Suljetaan statement ja yhteys
		}
	}

}
