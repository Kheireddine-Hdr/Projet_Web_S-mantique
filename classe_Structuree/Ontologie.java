package classe_Structuree;

import org.apache.jena.ontology.DatatypeProperty;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntProperty;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.shared.PrefixMapping;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;
import org.apache.jena.vocabulary.XSD;

public class Ontologie {
	
	OntModel model = ModelFactory.createOntologyModel();

	public static final String peinture_mus = "http://www.ex.fr/p#";

	public Musee musee;
	public Lister<Oeuvre> listerOeuvre;
	public Lister<Artiste> listerArtiste;
	public Lister<ParcoursThematique> listerPT;

	public Ontologie() {}

	public Ontologie(Lister<Oeuvre> listerOeuvre, Lister<Artiste> listerArtiste,Lister<ParcoursThematique> listerPT,
			Musee musee) {
		
		this.listerArtiste = listerArtiste;
		this.listerOeuvre = listerOeuvre;
		this.listerPT = listerPT;
		this.musee = musee;
		setPrefixModel();
	}
	
	public OntModel getM() {
		return model;
	}

	public void setPrefixModel() {
		model.setNsPrefix("p", peinture_mus);
		model.setNsPrefixes(PrefixMapping.Standard);
	}
	
	ObjectProperty Créa = model.createObjectProperty(peinture_mus + "Créa");
	ObjectProperty peint = model.createObjectProperty(peinture_mus + "peint");
	ObjectProperty est_peint_par = model.createObjectProperty(peinture_mus + "est_peint_par");
	ObjectProperty est_Créé_par = model.createObjectProperty(peinture_mus + "est_Crée_par");
	ObjectProperty regroupe = model.createObjectProperty(peinture_mus + "regroupe");
	ObjectProperty est_regroupé = model.createObjectProperty(peinture_mus + "est_regroupé");
	ObjectProperty expose = model.createObjectProperty(peinture_mus + "expose");
	ObjectProperty est_expose = model.createObjectProperty(peinture_mus + "est_exposé");
	
	/*------------------------- méthode d'ajout de musée a l'Ontologie -------------------------------------------------------*/
	
	public void addMuseeOntologie(Musee mus) {

		OntClass mu = model.createClass(peinture_mus + "Musee");
		est_expose.addInverseOf(expose);
		est_expose.setRange(mu);
		
		Individual musee_F = model.createIndividual(peinture_mus + mus.getNom(), mu);
		
		DatatypeProperty adresse = model.createDatatypeProperty(peinture_mus + "Adresse");
		DatatypeProperty dateCreation = model.createDatatypeProperty(peinture_mus + "date_ouverture");
		DatatypeProperty surface = model.createDatatypeProperty(peinture_mus + "surface");

		musee_F.addProperty(adresse, model.createLiteral(mus.getAdresse(), "fr"));
		musee_F.addProperty(dateCreation, model.createLiteral(mus.getDateCreation()));
		musee_F.addProperty(surface, model.createTypedLiteral(mus.getSurface(), "int"));
	}
	
/*------------------- méthode d'ajout des parcours thématiques à l'Ontologie -------------------------------------------------------------------*/
	
	public void addThematOntologie(Musee mus) {

		OntClass parcours_thematique = model.createClass(peinture_mus + "Parcours_Thematique");
		OntClass musee = model.getOntClass("");
		est_regroupé.addInverseOf(regroupe);
		est_regroupé.setDomain(parcours_thematique);
		est_expose.setDomain(parcours_thematique);
		
		DatatypeProperty Nom_thematique = model.createDatatypeProperty(peinture_mus + "Nom_thematique");
		
		for(ParcoursThematique s: listerPT.listeElement) {
			Individual a = model.createIndividual(peinture_mus + s.getNom(), parcours_thematique);
			Individual mus_F = model.createIndividual(peinture_mus + mus.getNom(), musee);
			a.addProperty(RDF.type, parcours_thematique);
			a.addProperty(RDFS.label, s.getNom());
			a.addProperty(Nom_thematique, model.createLiteral(s.getNom(), "fr"));
			model.add(a, est_expose, mus_F);
			
		}
	}
	
	/*--------------- méthode d'ajout de ressources Oeuvres et Artistes à l'Ontologie ------------------------------------------------------*/
	
	public <x extends IntOeuvre, y extends IntArtiste> void addOntClass(Lister<x> s, Lister<y> p) {
		
		OntClass OeuvresMusee = model.createClass(peinture_mus + "Oeuvre");
		OntClass ArtistesMusee = model.createClass(peinture_mus + "Artiste");
		est_regroupé.setDomain(OeuvresMusee);
	
			OntClass sculpture = model.createClass(peinture_mus + "Sculpture");
			sculpture.addSuperClass(OeuvresMusee);
			sculpture.addEquivalentClass(OeuvresMusee);
			Créa.setRange(sculpture);	
				
			OntClass sculptur = model.createClass(peinture_mus + "Sculpture");
			OntClass peinture = model.createClass(peinture_mus + "Peinture");
			peinture.addSuperClass(OeuvresMusee);
			peinture.addDisjointWith(sculptur);
			peinture.addEquivalentClass(OeuvresMusee);
			peint.setRange(peinture);
			
			OntClass sculpteur = model.createClass(peinture_mus + "Sculpteur");
			sculpteur.addSuperClass(ArtistesMusee);
			sculpteur.addEquivalentClass(ArtistesMusee);
			Créa.addInverseOf(est_Créé_par);
			Créa.setDomain(sculpteur);	
			
			OntClass sculp = model.createClass(peinture_mus + "Sculpteur");
			OntClass peintre = model.createClass(peinture_mus + "Peintre");
			peintre.addSuperClass(ArtistesMusee);
			peintre.addEquivalentClass(ArtistesMusee);
			peint.addInverseOf(est_peint_par);
			peint.setDomain(peintre);
			peintre.addDisjointWith(sculp);
				
		}
		
	/*------------ méthode d'ajout des propriétés d'Artistes à l'Ontologie ( Peintres et Sculpteurs ) --------------------------------------------------------*/
	
	public <x extends IntArtiste, y extends IntOeuvre> void addArtisteOntologie(Lister<x> s, Lister<y> p,
			String element1, String element2, String element3, String element4) {
	
		DatatypeProperty id = model.createDatatypeProperty(peinture_mus + "id");
		DatatypeProperty nom = model.createDatatypeProperty(peinture_mus + "nom");
		DatatypeProperty prenom = model.createDatatypeProperty(peinture_mus + "prenom");
		DatatypeProperty date_naissance = model.createDatatypeProperty(peinture_mus + "date_naissance");
		DatatypeProperty pays_naissance = model.createDatatypeProperty(peinture_mus + "pays_naissance");
		DatatypeProperty date_deces = model.createDatatypeProperty(peinture_mus + "date_deces");
		
		for( x e: s.listeElement) {
			Individual a;
		
			if(e.getId().length()>7) {
				OntClass sculpteur = model.getOntClass(element1);
				a = model.createIndividual(peinture_mus + e.getNom()+"_"+e.getPrenom(), sculpteur); 
				a.addProperty(RDF.type, element1);
			}
			else {
				OntClass peintre = model.getOntClass(element2);
				a = model.createIndividual(peinture_mus + e.getNom()+"_"+e.getPrenom(), peintre);	
				a.addProperty(RDF.type, element2);
			}
			
			a.addProperty(id, model.createTypedLiteral(e.getId(), XSD.getURI() + "string"));
			a.addProperty(nom, model.createTypedLiteral(e.getNom(), XSD.getURI() + "string"));
			a.addProperty(prenom, model.createTypedLiteral(e.getPrenom(), XSD.getURI() + "string"));
			a.addProperty(date_naissance, model.createTypedLiteral(e.getDateNaissance(), XSD.getURI() + "string"));
			a.addProperty(pays_naissance, model.createTypedLiteral(e.getLieuNaissance(), XSD.getURI() + "string"));
			a.addProperty(date_deces, model.createTypedLiteral(e.getDateDeces(), XSD.getURI() + "string"));
			
			for(y d: p.listeElement) {
				if(e.getId().length()>7 && d.getId().length()>7) {
					if(e.getId().equals(d.getId())){
					OntClass sculpture = model.getOntClass(element3);
					Individual q = model.createIndividual(peinture_mus + d.getTitre(), sculpture);	
				model.add(a, Créa, q);}}
				
				if(e.getId().length()<=7 && d.getId().length()<=7) {
					if(e.getId().equals(d.getId())) {
					OntClass peinture = model.getOntClass(element4);
					Individual q = model.createIndividual(peinture_mus + d.getTitre(), peinture);	
				model.add(a, peint, q);	
				}}	
		}}}
			
	/*------------- méthode d'ajout des propriétés d'Oeuvres à l'Ontologie ( Peintures et Sculptures ) ----------------------------------------------------------------*/
							
	public <x extends IntOeuvre, y extends IntParcoursThematique > void addOeuvreOntologie(Lister<x> s, Lister<y> p,
				String element1, String element2) {
		
		DatatypeProperty id = model.createDatatypeProperty(peinture_mus + "id");
		DatatypeProperty titre = model.createDatatypeProperty(peinture_mus + "titre");
		DatatypeProperty domaine = model.createDatatypeProperty(peinture_mus + "domaine");
		DatatypeProperty matiere_et_technique = model.createDatatypeProperty(peinture_mus + "matiere");
		DatatypeProperty annee_creation = model.createDatatypeProperty(peinture_mus + "annee_creation");
		DatatypeProperty num_inventaire = model.createDatatypeProperty(peinture_mus + "num_inventaire");
		
		for(x e: s.listeElement) {
			Individual a;
			OntClass sculpture = model.getOntClass(element1);
			OntClass peinture = model.getOntClass(element2);
			
			if(e.getId().length()>7) {
				 a = model.createIndividual(peinture_mus + " " + e.getTitre(), sculpture);
				 a.addProperty(RDF.type, element1);
			}
			else {
				a = model.createIndividual(peinture_mus + " " + e.getTitre(), peinture);
				a.addProperty(RDF.type, element2);	
			}
			
			a.addProperty(id, model.createTypedLiteral(e.getId(), XSD.getURI() + "string"));
			a.addProperty(titre, model.createLiteral(e.getTitre(), "fr"));
			a.addProperty(domaine, model.createLiteral(e.getDomaine(), "fr"));
			a.addProperty(matiere_et_technique, model.createLiteral(e.getMatiereTechnique(), "fr"));
			a.addProperty(annee_creation, model.createTypedLiteral(e.getAnneeCreation(), XSD.getURI() + "int"));
			a.addProperty(num_inventaire, model.createTypedLiteral(e.getNumInventaire(), XSD.getURI() + "string"));
			
			for(y q: p.listeElement) {	
				if(e.getThematique().equals(q.getNom())) {
					OntClass w = model.getOntClass("parcours_thematique");
					Individual m = model.createIndividual(peinture_mus + q.getNom(), w);
					model.add(a, est_regroupé, m);
				}
				
		}}}
		
}
