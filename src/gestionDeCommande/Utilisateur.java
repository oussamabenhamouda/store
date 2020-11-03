package gestionDeCommande;

import java.util.ArrayList;

public class Utilisateur extends Personne {
	public Utilisateur(String nom, int id, String prenom, String adresse) {
		super(nom, id, prenom);
		this.adresse = adresse;
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
}


