package gestionDeCommande;

import java.util.ArrayList;

public class Facture {
	private int ID;
	private ArrayList<LigneDeFacture> tabLigne = new ArrayList<LigneDeFacture>();
	public Facture(int ID, ArrayList<LigneDeFacture> tabLigne) {
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
	public ArrayList<LigneDeFacture> getTabLigne() {
		return tabLigne;
	}
	public void setTabLigne(ArrayList<LigneDeFacture> tabLigne) {
		this.tabLigne = tabLigne;
	}
	public void addProduct(int quantity, Produits p) {
		this.tabLigne.add(new LigneDeFacture(quantity, p));
	}
// In an array to generate a good to string your should iterate through the array and generate the toString of each object of the array
	public String toString() {
		String s = "Facture: "
				+ "\n ID = " + this.ID
				+ "\n Liste des produits: ";
		for (LigneDeFacture f: this.tabLigne) {
			s += f;
		}
		return s;

	}

	public void deleteLigneDeFacture(int id) {
		this.tabLigne.remove(id);
	}


	public double sommeTotal( ) {
		double somme = 0;
		for (LigneDeFacture f: this.tabLigne) {
			somme += f.getSum();
		}
		return somme;
	}
}
