package classe_Structuree;

public class Artiste implements IntArtiste {
	
	private String id;
	private String nom; 
	private String prenom;
	private String dateNaissance;
	private String LieuNaissance;
	private String dateDeces;
	
	public Artiste() {
		
	}

	public Artiste(String id, String nom, String prenom, String dateNaissance, String lieuNaissance, String dateDeces) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.LieuNaissance = lieuNaissance;
		this.dateDeces = dateDeces;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getLieuNaissance() {
		return LieuNaissance;
	}

	public void setLieuNaissance(String lieuNaissance) {
		LieuNaissance = lieuNaissance;
	}

	public String getDateDeces() {
		return dateDeces;
	}

	public void setDateDeces(String dateDeces) {
		this.dateDeces = dateDeces;
	}

	@Override
	public String toString() {
		return "id=" + id + "nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", LieuNaissance="
				+ LieuNaissance + ", dateDeces=" + dateDeces + "\n";
	}
	 
}
