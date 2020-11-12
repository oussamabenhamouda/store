package metiers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import databaseconnection.MyConnnectionDataBase;

public class Utilisateur extends Personne {
	public Utilisateur( int id, String nom, String prenom, String adresse) {
		super(nom, id, prenom);
		this.adresse = adresse;
	}
	
	public Utilisateur() {
		
	}

	private String adresse;
	private ArrayList<Facture> order=new ArrayList<Facture>();
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public ArrayList<Facture> getOrder() {
		return order;
	}

	public void setOrder(ArrayList<Facture> order) {
		this.order = order;
	}
	public String toString() {
		return " nom : "+this.getNom()+" id : "+this.getId()+" prenom : "+this.getPrenom()+" adresse : "+this.adresse;
	}
	public void addOrdre(Facture f) {
		this.order.add(f);
	}
	public void deleteOrdre(int id ) {
		for (Facture f: this.order) {
			if (f.getID() == id) {
				this.order.remove(f);
			}
		}
	}
	private static int getUtilisateurId() throws ClassNotFoundException, SQLException {
		int id = 0;
		String request = "SELECT MAX(id_user) FROM user";
		PreparedStatement stmt =MyConnnectionDataBase.getConnection().prepareStatement(request);
		ResultSet result = stmt.executeQuery();
		while (result.next()) {
			id = result.getInt(1);
		}
		return id +1;
	}
	public static void addClient(Utilisateur user) throws Exception {
		String req="insert into user "+"VALUES (?,?,?,?)";
		PreparedStatement stmt=MyConnnectionDataBase.getConnection().prepareStatement(req);
		stmt.setInt(1, getUtilisateurId());
		stmt.setString(2,user.getNom());
		stmt.setString(3, user.getPrenom());
		stmt.setString(4, user.getAdresse());
		stmt.executeUpdate();
//		
	}
	public static void deleteClient(Utilisateur user) throws ClassNotFoundException, SQLException {
		String req1="delete from user where id_user = ? ";
		PreparedStatement stmt = MyConnnectionDataBase.getConnection().prepareStatement(req1);
		stmt.setInt(1, user.getId());
		stmt.executeUpdate();
	}
	public static ArrayList<Utilisateur>getallUsers() throws ClassNotFoundException, SQLException{
		String request ="select * from user ";
		PreparedStatement stmt =MyConnnectionDataBase.getConnection().prepareStatement(request);
		ResultSet rs =stmt.executeQuery();
		ArrayList<Utilisateur>user =new ArrayList<Utilisateur>();
		while(rs.next()) {
			user.add(new Utilisateur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			
		}
		return user;
		
	}
}



