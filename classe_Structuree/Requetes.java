package classe_Structuree;

import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

public class Requetes {
	
	//Requetes locales :
	public final static String prologue1 = "PREFIX p: <http://www.ex.fr/p#>" ;
	public final static String prologue2 ="PREFIX rdf: <"+RDF.getURI()+">";
	public final static String prologue3 = "PREFIX rdfs: <"+RDFS.getURI()+">";
	
	//Requetes Endpoint :
	public final static String prolog1 = "PREFIX bd: <http://www.bigdata.com/rdf#>";
	public final static String prolog2 = "PREFIX wikibase: <http://wikiba.se/ontology#>";
	public final static String prolog3 = "PREFIX wd: <http://www.wikidata.org/entity/>";
	public final static String prolog4 = "PREFIX wdt: <http://www.wikidata.org/prop/direct/>";
	public final static String prolog5 = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>";
	public final static String prolog6 = "PREFIX p: <http://www.wikidata.org/prop/>";
	public final static String prolog7 = "PREFIX ps: <http://www.wikidata.org/prop/statement/>";
	public final static String prolog8 = "PREFIX pq: <http://www.wikidata.org/prop/qualifier/>";
	public final static String prolog9 = "PREFIX rdfs: <" + RDFS.getURI() + ">";
	public final static String prolog10 = "PREFIX schema: <http://schema.org/>";
	
	private String corps;

	public Requetes (String corps) {this.corps = corps;}

	public String getCorps() {
		return corps;
	}

	public void setCorps(String corps) {
		this.corps = corps;
	}
	
	@Override
	public String toString() {
		return "la requete est : [  "+corps+"  ]";
	}



}
