package kasvisto.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kasvi.model.Henkilo;

public class HenkiloDAO extends DataAccessObject {

	public ArrayList<Henkilo> findAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Henkilo> henkilot = new ArrayList<Henkilo>();
		Henkilo henkilo = null;

		try {
			conn = getConnection(); // Luodaan yhteys
			// Luodaan komento: haetaan kaikki rivit person-taulusta
			String sqlSelect = "SELECT id, kayttajaTunnus, etuNimi, sukuNimi FROM henkilo;";
			// Valmistellaan komento:
			stmt = conn.prepareStatement(sqlSelect);
			// L‰hetet‰‰n komento:
			rs = stmt.executeQuery();
			// K‰yd‰‰n tulostaulun rivit l‰pi
			while (rs.next()) {
				henkilo = readHenkilo(rs);
				henkilot.add(henkilo); // lis‰t‰‰n henkilˆ listaan
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs, stmt, conn); // Suljetaan
		}
		return henkilot; // palautetaan henkilo-lista(ArrayList)
	}

	// haetaan yksi henkilo tietokannasta henkiloId-arvon perusteella
	public Henkilo findByhenkiloId(int henkiloId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Henkilo henkilo = null;
		try {
			// Luodaan yhteys
			conn = getConnection();

			// Luodaan komento: haetaan kaikki rivit kurssitaulusta
			String sqlSelect = "SELECT id, kayttajaTunnus, etuNimi, sukuNimi FROM henkilo WHERE id = ?";

			// Valmistellaan komento:
			stmt = conn.prepareStatement(sqlSelect);
			stmt.setInt(1, henkiloId);

			// L‰hetet‰‰n komento:
			rs = stmt.executeQuery();

			// K‰yd‰‰n tulostaulun rivit l‰pi ja luetaan read()-metodilla:
			if (rs.next()) {
				henkilo = readHenkilo(rs);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(rs, stmt, conn); // Suljetaan
		}

		return henkilo;
	}
	
	// haetaan yksi henkilo tietokannasta  Id-arvon perusteella ja
		// p‰ivitet‰‰n tiedot
		public void updateById(Henkilo henkilo) {
			Connection connection = null;
			PreparedStatement stmtInsert = null;

			try {
				// Luodaan yhteys
				connection = getConnection();

				// Luodaan komento: haetaan kaikki rivit kurssitaulusta
				String sqlInsert = "UPDATE henkilo SET kayttajaTunnus=?, etuNimi=?, sukuNimi=?  WHERE id=?";

				// Valmistellaan komento:

				stmtInsert = connection.prepareStatement(sqlInsert);

				stmtInsert.setString(1, henkilo.getKayttajaTunnus());
				stmtInsert.setString(2, henkilo.getEtuNimi());
				stmtInsert.setString(3, henkilo.getSukuNimi());
				stmtInsert.setInt(4, henkilo.getId());

				// L‰hetet‰‰n komento:
				stmtInsert.executeUpdate();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				close(stmtInsert, connection); // Suljetaan statement ja yhteys
			}
		}

	private Henkilo readHenkilo(ResultSet rs) {
		try {
			// Haetaan yhden henkilˆn tiedot kyselyn tulostaulun
			// (ResultSettyyppinenrs-olion) aktiiviselta tietorivilt‰
			// luodaan uusi henkilo olio
			Henkilo henkilo = new Henkilo();

			henkilo.setId(rs.getInt("id"));
			henkilo.setKayttajaTunnus(rs.getString("kayttajaTunnus"));
			henkilo.setEtuNimi(rs.getString("etuNimi"));
			henkilo.setSukuNimi(rs.getString("sukuNimi"));

			/*
			 * int id = rs.getInt("id"); String kayttajaTunnus =
			 * rs.getString("kayttajaTunnus"); String etuNimi =
			 * rs.getString("etuNimi"); String sukuNimi =
			 * rs.getString("sukuNimi");
			 * 
			 * 
			 * // luodaan uusi kurssiryhm‰-olio CourseGroup group = new
			 * CourseGroup(); group.setId(rs.getString("id"));
			 * group.setName(rs.getString("name"));
			 * 
			 * // palautetaan uusi kurssiryhm‰ return group;
			 */

			// Luodaan ja palautetaan uusi henkilo
			return henkilo;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * lis‰‰ henkilon tiedot tietokantaan
	 * 
	 * @param henkilo
	 *            henkilo-luokan olio
	 * @throws SQLException
	 */
	public void addHenkilo(Henkilo henkilo) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtInsert = null;

		try {
			// Luodaan yhteys
			connection = getConnection();
			// Luodaan uusi kasvi tietokantaan:
			String sqlInsert = "INSERT INTO henkilo(id, kayttajaTunnus, etuNimi, sukuNimi) VALUES (?, ?, ?, ?)";
			stmtInsert = connection.prepareStatement(sqlInsert);
			stmtInsert.setInt(1, henkilo.getId());
			stmtInsert.setString(2, henkilo.getKayttajaTunnus());
			stmtInsert.setString(3, henkilo.getEtuNimi());
			stmtInsert.setString(4, henkilo.getSukuNimi());

			stmtInsert.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtInsert, connection); // Suljetaan statement ja yhteys
		}
	}

	public void removeHenkilo(int henkiloId) throws SQLException {
		Connection connection = null;
		PreparedStatement stmtDelete = null;

		try {
			// Luodaan yhteys
			connection = getConnection();
			// Poistetaan kasvi tietokantasta:
			String sqlInsert = "DELETE FROM henkilo WHERE id = ?";
			stmtDelete = connection.prepareStatement(sqlInsert);
			stmtDelete.setInt(1, henkiloId);
			stmtDelete.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(stmtDelete, connection); // Suljetaan statement ja yhteys
		}
	}
}
