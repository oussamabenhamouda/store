package gestionDeCommande;


public class LigneDeFacture {
	private int quantite ;
	private Produits product;
	public LigneDeFacture( int quantite, Produits p) {	
		this.product=p;
		this.quantite=quantite;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Produits getProduct() {
		return product;
	}
	public void setProduct(Produits p) {
		this.product = p;
	}
	
	public String toString() {
		return " Produit : "+this.product+" quantite : "+this.quantite +"\n";
	}
	public double getSum() {
		return this.quantite * this.product.getPrixUnitaire();
	}
}
