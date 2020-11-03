package gestionDeCommande;

public class Personne {
	private String nom;
	private int id ;
	private String prenom;

	public Personne(String nom, int id, String prenom) {
		this.nom = nom;
		this.id = id;
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
