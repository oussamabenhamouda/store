package gestionDeCommande;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Utilisateur user1=new Utilisateur("ahmed",5,"masaad","rue marsana");
		Administrateur admin=new Administrateur("khaled",6,"majdoub");
		ArrayList<Personne>users=new ArrayList<Personne>();
		users.add(user1);
		users.add(admin);
		Produits product1= new Produits(11,6.0,7,"apple");
		Produits product2=new Produits (2,12,6,"samsung");
		ArrayList<Produits>product = new ArrayList<Produits>();
		product.add(product1);
		product.add(product2);
		Facture f=new Facture();
		f.addProduct(5, product1);
		f.addProduct(12, product2);
		Produits product3=new Produits(5,6,3,"adidas");
		f.addProduct(5, product3);
		System.out.println("the amount money you have to pay is "+f.sommeTotal());
		f.deleteLigneDeFacture(0);		
		System.out.println(f.sommeTotal());
		
		// test
	}

}