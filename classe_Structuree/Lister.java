package classe_Structuree;

import java.util.ArrayList;

public class Lister<T> {
	
	public ArrayList<T> listeElement = new ArrayList<>();
	
	public Lister() {}
	
	public void entrer(T element) {
		if(this.listeElement.contains(element))
			System.out.println("l'element existe deja !");
		else {
			listeElement.add(element);	
		}	
	}
	
	public String afficher() {
		System.out.println("-----------");
		String resultat = "";
		for (T t : this.listeElement) {
			resultat += t +"\n";
		}
		return resultat;
	}
	
	
}
