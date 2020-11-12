package metiers;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	static void addbook() throws ClassNotFoundException, SQLException {
		Scanner sc =new Scanner(System.in);
		System.out.println("enter title : \n");
		String title =sc.nextLine();
		System.out.println("enter author : \n");
		String author =sc.nextLine();
		System.out.println("enter price : \n");
		double price =sc.nextDouble();
		System.out.println("enter release date : \n");
		String releasedate =sc.next();
		Date date = Date.valueOf(releasedate);
		System.out.println("enter quantity : \n");
		int quantity = sc.nextInt();
		Books book1=new Books(0,price,quantity,title,author,date);
		Books.addbooks(book1);
		
	}
	static void adduser() throws Exception {
		Scanner sc =new Scanner(System.in);
		System.out.println("enter name : \n");
		String name =sc.nextLine();
		System.out.println("enter surname : \n");
		String surname =sc.nextLine();
		System.out.println("enter adress : \n");
		String adress =sc.nextLine();
		Utilisateur user1=new Utilisateur(0,name,surname,adress);
		Utilisateur.addClient(user1);
	}
	static void updatebook() throws ClassNotFoundException, SQLException {
		Scanner sc =new Scanner(System.in);
		System.out.println("enter title : \n");
		String title =sc.nextLine();
		System.out.println("enter author : \n");
		String author =sc.nextLine();
		System.out.println("enter price : \n");
		double price =sc.nextDouble();
		System.out.println("enter release date : \n");
		String releasedate =sc.next();
		Date date = Date.valueOf(releasedate);
		System.out.println("enter quantity : \n");
		int quantity = sc.nextInt();
		Books book2=new Books(0,price,quantity,title,author,date);
		Books.updatebooks(book2);
	}
	static void deletebook() throws ClassNotFoundException, SQLException {
		Scanner sc =new Scanner(System.in);
		System.out.println("enter id : \n");
		int id = sc.nextInt();
		Books.deletebooks(id);
		
	}
	static void addFacture(int idUser) throws ClassNotFoundException, SQLException {
		System.out.println("Ceci est pour tester l'ajout d'une facture");
		ArrayList<FactureLine> fl = new ArrayList<FactureLine>();
		fl.add(new FactureLine(5,Books.getallbooks().get(0),2));
		fl.add(new FactureLine(5,Books.getallbooks().get(1),2));
		Facture f = new Facture(0, fl);
		Facture.addfacture(f, idUser );
	}
	public static void main(String args[]) throws Exception {
		while (true) {
			System.out.println("*** Menu Administrateur *** \n");
			System.out.println(" Bonjour Mr  this is your Menu \n");
			System.out.println("1. Create User \n");
			System.out.println("2. Display Users \n");
			System.out.println("3. Display Books \n");
			System.out.println("4. Update Book \n");
			System.out.println("5. Create Book \n");
			System.out.println("6. Delete Book \n");
			System.out.println("7. Create facture \n");
			System.out.println("8. Display factures \n");
			System.out.println("9. quit  \n");
			System.out.println("***************** \n");
			Scanner sc =new Scanner(System.in);
			System.out.println("select your choice please : \n");
			int choice = sc.nextInt();
			switch(choice) {
			case 1 :
				adduser();
				break;
			case 2 :
				for(Utilisateur user : Utilisateur.getallUsers()) {
					System.out.println(user);
				}
				break;
			case 3 :
				for(Books b : Books.getallbooks()) {
					System.out.println(b);
				}
				break;
			case 4 :
				updatebook();
				break;
			case 5 :			
				addbook();
				break;
			case 6 :
				Test.deletebook();
				break;
			case 7:
				addFacture(Utilisateur.getallUsers().get(0).getId());
				break;
			case 8 :
				for(Facture f : Facture.getFacture()) {
					System.out.println(f);
				}
				break;
			case 9 :
				System.exit(1);
			}
		}
	}
}