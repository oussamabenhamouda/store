package gestionDeCommande;

public class Produits {
	private int ref;
	private double prixUnitaire;
	private int quantite;
	private String description;
	
	public Produits() {
	}
	public Produits(int ref, double prixUnitaire, int quantite, String description) {
		this.ref = ref;
		this.prixUnitaire = prixUnitaire;
		this.quantite = quantite;
		this.description = description;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public double getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String toString() {
		return " prixUnitaire: "+this.prixUnitaire+" quantite : "+this.quantite+" reference : "+this.ref+" description : "+this.description;
	}
	

}
