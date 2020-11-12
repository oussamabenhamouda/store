package metiers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import databaseconnection.MyConnnectionDataBase;

public class Facture {
	private int ID;
	private ArrayList<FactureLine> tabLigne = new ArrayList<FactureLine>();
	public Facture(int ID, ArrayList<FactureLine> tabLigne) {
		this.ID=ID;
		this.tabLigne=tabLigne;
	}
	public Facture() {
	}

	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public ArrayList<FactureLine> getTabLigne() {
		return tabLigne;
	}
	public void setTabLigne(ArrayList<FactureLine> tabLigne) {
		this.tabLigne = tabLigne;
	}
	public void addProduct(int quantity, Books p) {
		this.tabLigne.add(new FactureLine(quantity, p, ID));
	}
// In an array to generate a good to string your should iterate through the array and generate the toString of each object of the array
	public String toString() {
		String s = "Facture: "
				+ "\n ID = " + this.ID
				+ "\n Liste des livres : ";
		for (FactureLine f: this.tabLigne) {
			s += f;
		}
		return s;

	}

	public void deleteLigneDeFacture(int id) {
		this.tabLigne.remove(id);
	}


	public double sommeTotal( ) {
		double somme = 0;
		for (FactureLine f: this.tabLigne) {
			somme += f.getSum();
		}
		return somme;
	}
		
		public static void addfacture(Facture f,int idUser) throws ClassNotFoundException, SQLException {
			String request="insert into facture(user) values(?)";
			PreparedStatement stmt =MyConnnectionDataBase.getConnection().prepareStatement(request);
			stmt.setInt(1, idUser);
			stmt.executeUpdate();
			for(FactureLine fL : f.getTabLigne() ) {
				FactureLine.addlignedefacture(f.getID(), fL);
			}
		}
	public static ArrayList<Facture> getFacture() throws ClassNotFoundException, SQLException{
		String request="select* from Facture";
		PreparedStatement stmt=MyConnnectionDataBase.getConnection().prepareStatement(request);
		ResultSet rs=stmt.executeQuery();
		ArrayList<Facture>fl = new ArrayList<Facture>();
		while(rs.next()) {
			fl.add(new Facture(rs.getInt(1),FactureLine.getFactureLine(rs.getInt(1))));
		}
		
		
		return fl;
		
	}
}
