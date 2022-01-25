package classe_Structuree;

public class Oeuvre implements IntOeuvre {
	
	private String id, titre, domaine, numInventaire, matiereTechnique, thematique;
	private int anneeCreation;
	
	public Oeuvre() {}
	
	public Oeuvre(String id, String titre, String domaine, String numInventaire, 
			String matiereTechnique, int anneeCreation , String thematique) {
		
		this.id = id;
		this.titre = titre;
		this.domaine = domaine;
		this.numInventaire = numInventaire;
		this.matiereTechnique = matiereTechnique;
		this.anneeCreation = anneeCreation;
		this.thematique = thematique;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDomaine() {
		return domaine;
	}
	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
	public String getNumInventaire() {
		return numInventaire;
	}
	public void setNumInventaire(String numInventaire) {
		this.numInventaire = numInventaire;
	}
	public String getMatiereTechnique() {
		return matiereTechnique;
	}
	public void setMatiereTechnique(String matiereTechnique) {
		this.matiereTechnique = matiereTechnique;
	}
	public int getAnneeCreation() {
		return anneeCreation;
	}
	public void setAnneeCreation(int anneeCreation) {
		this.anneeCreation = anneeCreation;
	}
	
	public String getThematique() {
		return thematique;
	}
	public void setThematique(String thematique) {
		this.thematique = thematique;
	}
	
	@Override
	public String toString() {
		return "titre : " + titre + ", domaine : " + domaine + ", numInventaire : " + numInventaire
				+ ", matiereTechnique : " + matiereTechnique + ", anneeCreation : " + anneeCreation + ", thematique : " + thematique + "\n" ;
	}
	

}
