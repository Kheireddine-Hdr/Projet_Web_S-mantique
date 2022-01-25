package classe_Structuree;

import java.util.ArrayList;

public class ParcoursThematique implements IntParcoursThematique {

	private String nom;
	public ArrayList<Oeuvre> OeuvresThematique = new ArrayList<>();
	
	public ParcoursThematique() {

	}

	public ParcoursThematique(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "nom de la thematique est :"+ nom + ": " + "les oeuvres de cette thematique sont : " + OeuvresThematique +"\n";
	}
		
	public void AjoutOeuvre(Lister<Oeuvre> f) {
		for(Oeuvre e : f.listeElement) {
			if(e.getThematique().equals(this.getNom())) {
				OeuvresThematique.add(e);		
			}			
		}
			
	}
}
