package metiers;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import databaseconnection.MyConnnectionDataBase;

public class Books {
	private int id;
	private double prixUnitaire;
	private int quantity;
	private String title;
	private String author;
	public Date releaseDate;
	
	public Books() {
	}
	
	public Books(int id, double prixUnitaire, int quantity, String title, String author, Date releaseDate) {
		
		this.id = id;
		this.prixUnitaire = prixUnitaire;
		this.quantity = quantity;
		this.title = title;
		this.author = author;
		this.releaseDate = releaseDate;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String toString() {
		return "id :"+this.id+ " prixUnitaire: "+this.prixUnitaire+" quantite : "+this.quantity+" title : "+this.title+" author :"+this.author+" release date :"+this.getReleaseDate();
	}
	public String getAuthor() {;
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	private static int getMaxId() throws ClassNotFoundException, SQLException {
		int id = 0;
		String request = "SELECT MAX(id_book) FROM book";
		PreparedStatement stmt =MyConnnectionDataBase.getConnection().prepareStatement(request);
		ResultSet result = stmt.executeQuery();
		while (result.next()) {
			id = result.getInt(1);
		}
		return id +1;
		
	}
	public static void addbooks(Books b) throws ClassNotFoundException, SQLException {
		String request1="insert into book values(?,?,?,?,?,?)";
		PreparedStatement stmt =MyConnnectionDataBase.getConnection().prepareStatement(request1);
		stmt.setInt(1, getMaxId());
		stmt.setString(2, b.getTitle());
		stmt.setString(3, b.getAuthor());
		stmt.setDouble(4, b.getPrixUnitaire());
		stmt.setDate(5, b.getReleaseDate());
		stmt.setInt(6, b.getQuantity());
		stmt.executeUpdate();
	}
	public static void deletebooks(int idBook) throws ClassNotFoundException, SQLException {
		String request2="delete from book where id_book = ?";
		PreparedStatement stmt=MyConnnectionDataBase.getConnection().prepareStatement(request2);
		stmt.setInt(1, idBook);
		stmt.executeUpdate();
		
	}
	public static void updatebooks(Books book) throws ClassNotFoundException, SQLException {
		String request3="update book  set title_book=?,author_book=?,price_book=?,releasedate_book= ?,quantity=?  where id_book = ?;";
		PreparedStatement stmt = MyConnnectionDataBase.getConnection().prepareStatement(request3);
		stmt.setString(1, book.getTitle());
		stmt.setString(2, book.getAuthor());
		stmt.setDouble(3, book.getPrixUnitaire());
		stmt.setDate(4, book.getReleaseDate());
		stmt.setInt(5, book.getQuantity());
		stmt.setInt(6,book.getId());
		stmt.executeUpdate();
	}
	public static ArrayList<Books>getallbooks() throws ClassNotFoundException, SQLException{
		String request ="select * from book ";
		PreparedStatement stmt =MyConnnectionDataBase.getConnection().prepareStatement(request);
		ResultSet rs = stmt.executeQuery();
		ArrayList<Books>b=new ArrayList<Books>();
		while(rs.next()) {
			b.add(new Books(rs.getInt(1),rs.getDouble(4),rs.getInt(6),rs.getString(2),rs.getString(3),rs.getDate(5)));
		}
		
		return b;
		
	}
}

