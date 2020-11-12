package databaseconnection;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class MyConnnectionDataBase {
	private static Connection connection=null;
	private MyConnnectionDataBase(){
		
	}
//	public static Connection cnx=null;
//	static PreparedStatement stmt=null;
//	
//		public static void  createConnection() throws ClassNotFoundException,SQLException{
//			if (cnx == null) {
//				Class.forName("com.mysql.jdbc.Driver");
//				String url ="jdbc:mysql://localhost:3306/BuildStore";
//				cnx=DriverManager.getConnection(url,"root","123456");				
//			}
		
//		}
//		public static int executerRequeteMiseAJour(String requete) throws SQLException, ClassNotFoundException {
//			createConnection();
//			return stmt.executeUpdate(requete);
//		}
		
		public static Connection getConnection() throws SQLException, ClassNotFoundException {
			 if(connection==null) {
				 Class.forName("com.mysql.jdbc.Driver");
					String url ="jdbc:mysql://localhost:3306/BuildStore";
					connection=DriverManager.getConnection(url,"root","123456");
			 }
			 return  connection;
		 }
}

