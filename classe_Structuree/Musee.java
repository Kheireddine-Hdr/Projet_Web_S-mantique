package classe_Structuree;

public class Musee {
	
	private String nom, adresse, dateCreation;
	private int surface;
	
	
	public Musee(String nom, String adresse, String dateCreation, int surface) {
		this.nom = nom;
		this.adresse = adresse;
		this.dateCreation = dateCreation;
		this.surface = surface;
	}
	
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	public int getSurface() {
		return surface;
	}


	public void setSurface(int surface) {
		this.surface = surface;
	}
	
	

}
