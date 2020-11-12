package metiers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import databaseconnection.MyConnnectionDataBase;

public class FactureLine {
	private int id;
	private int quantite ;
	private Books book;
	public FactureLine( int quantite, Books p, int id) {	
		this.id=id;
		this.book=p;
		this.quantite=quantite;
	}
	
	public FactureLine() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Books getProduct() {
		return book;
	}
	public void setProduct(Books p) {
		this.book = p;
	}
	
	public String toString() {
		return " Produit : "+this.book+" quantite : "+this.quantite +"\n";
	}
	public double getSum() {
		return this.quantite * this.book.getPrixUnitaire();
	}
	
	private static int getFactureLineId() throws ClassNotFoundException, SQLException {
		int id = 0;
		String request = "SELECT MAX(id) FROM ligne_de_facture";
		PreparedStatement stmt =MyConnnectionDataBase.getConnection().prepareStatement(request);
		ResultSet result = stmt.executeQuery();
		while (result.next()) {
			id = result.getInt(1);
		}
		return id +1;	
	}
	public static void addlignedefacture(int idFacture,FactureLine factureline) throws ClassNotFoundException, SQLException {
		String request1="insert into ligne_de_facture values(?,(select id_book from book where id_book = ?),(select id_facture from facture where id_facture = ?),?)";
		PreparedStatement stmt=MyConnnectionDataBase.getConnection().prepareStatement(request1);
		stmt.setInt(1, FactureLine.getFactureLineId());
		stmt.setInt(2, factureline.getProduct().getId());
		stmt.setInt(3, idFacture);
		stmt.setInt(4, factureline.getQuantite());
		stmt.executeUpdate();
	}
	public static ArrayList<FactureLine>getFactureLine(int idFacture) throws ClassNotFoundException, SQLException {
		String request="select* from ligne_de_facture, book where id = ? AND ligne_de_facture.book=book.id_book";
		PreparedStatement stmt =MyConnnectionDataBase.getConnection().prepareStatement(request);
		stmt.setInt(1, idFacture);
		ResultSet rs=stmt.executeQuery();
		ArrayList<FactureLine>rrrr= new ArrayList<FactureLine>();
		while(rs.next()) {
		 rrrr.add(new FactureLine(rs.getInt(1),new Books(rs.getInt(5),rs.getDouble(8),rs.getInt(10),rs.getString(6),rs.getString(7),rs.getDate(9)),rs.getInt(3)));
		}
		return rrrr;
		
	}
}
