package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DbConnection;
import model.Personne;

public class PersonneDao implements Dao<Personne> {
	// variables
	Connection connection = null;
	Statement statement = null;
	String requet = null;
	Personne personne = null;

	public PersonneDao() {
		try {
			connection = DbConnection.getInstance().getConnection();
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Personne> getAll() {

		return null;
	}

	@Override
	public Personne getById(int id) {
		requet = "SELECT * FROM PERSONNE WHERE nni =" + id + " ;";
		System.out.println(requet);
		try {
			ResultSet resultSet = statement.executeQuery(requet);
			resultSet.next();
			int nni = resultSet.getInt("nni");
			String nom = resultSet.getString("nom");
			personne = new Personne(nni, nom);
			System.out.println(personne.toString());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return personne;
	}

	@Override
	public void save(Personne t) {
		requet = "insert into personne values(" + t.getNni() + ",'" + t.getNom() + "');";
		System.out.println(requet);

		try {
			int resultat = statement.executeUpdate(requet);
			if (resultat != 0) {
				System.out.println("Insertion effectuée");
			} else {
				System.out.println("Erreur d'insertion");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Personne t, int[] params) {

	}

	@Override
	public void delete(Personne t) {

	}

	/**
	 * @param args
	 * @author Benany
	 */
	public static void main(String[] args){
		//new PersonneDao().getById(1234223233);
		new PersonneDao().save(new Personne(121231232, "Baba"));
	}
}
