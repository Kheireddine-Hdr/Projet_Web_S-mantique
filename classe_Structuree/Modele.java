package classe_Structuree;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;
import org.apache.jena.vocabulary.XSD;

public class Modele {

	Model m =  ModelFactory.createDefaultModel();

	public static final String peinture_mus = "http://www.ex.fr/p#";

	public Musee musee;
	public Lister<Oeuvre> listerOeuvre;
	public Lister<Artiste> listerArtiste;
	public Lister<ParcoursThematique> listerPT;

	public Modele() {}

	public Modele(Lister<Oeuvre> listerOeuvre, Lister<Artiste> listerArtiste,Lister<ParcoursThematique> listerPT,
			Musee musee) {
		
		this.listerArtiste = listerArtiste;
		this.listerOeuvre = listerOeuvre;
		this.listerPT = listerPT;
		this.musee = musee;
		setPrefixModel();
	}
	
	public Model getM() {
		return m;
	}

	public void setPrefixModel() {

		m.setNsPrefix("p", peinture_mus);
		m.setNsPrefix("rdf", RDF.getURI());
		m.setNsPrefix("rdfs", RDFS.getURI());
		m.setNsPrefix("xsd", XSD.getURI());
	}
	
	/*------------------------- méthode d'ajout de musée au modèle -------------------------------------------------------*/
	
	public void ajoutMuseeModel() {

		Resource musee = m.createResource(peinture_mus + "Musee");
		m.add(musee, RDFS.subClassOf, RDFS.Class);

		Resource musee_F = m.createResource(peinture_mus + this.musee.getNom());
		musee_F.addProperty(RDF.type, musee);

		Property adresse = m.createProperty(peinture_mus + "Adresse");
		Property dateCreation = m.createProperty(peinture_mus + "date_ouverture");
		Property surface = m.createProperty(peinture_mus + "surface");

		musee_F.addProperty(adresse, m.createLiteral(this.musee.getAdresse(), "fr"));
		musee_F.addProperty(dateCreation, m.createLiteral(this.musee.getDateCreation()));
		musee_F.addProperty(surface, m.createTypedLiteral(this.musee.getSurface(), "int"));
	}
	
/*------------------- méthode d'ajout des parcours thématiques au modèle -------------------------------------------------------------------*/
	
	public void addThematiqueModel(Musee mus) {

		Resource parcours_thematique = m.createResource(peinture_mus + "Parcours_Thematique");
		m.add(parcours_thematique, RDFS.subClassOf, RDFS.Class);

		Property Nom_thematique = m.createProperty(peinture_mus + "Nom_thematique");
		Property est_expose = m.createProperty(peinture_mus + "est_exposé");

		for(ParcoursThematique pt: listerPT.listeElement) {
			Resource b = m.getResource(mus.getNom());
			Resource a = m.createResource(peinture_mus + pt.getNom());
			a.addProperty(RDF.type, parcours_thematique);
			a.addProperty(RDFS.label, pt.getNom());
			a.addProperty(Nom_thematique, m.createLiteral(pt.getNom(), "fr"));
			m.add(a, est_expose, b);
	}}
	
	/*--------------- méthode d'ajout de ressources Oeuvres et Artistes au modèle ------------------------------------------------------*/
	
	public void addClassModel( String element, String element1, String element2, String element3, String element4, String element5 ) {
		
		Resource ContenuMusee = m.createResource(peinture_mus + element);
		m.add(ContenuMusee, RDFS.subClassOf, RDFS.Class);
		
		Resource OeuvreMusee = m.createResource(peinture_mus + element1); 
		m.add(OeuvreMusee, RDFS.subClassOf, RDFS.Class);
		
		Resource sculpture = m.createResource(peinture_mus + element2);
		m.add(sculpture, RDFS.subClassOf, ContenuMusee);
				
		Resource peinture = m.createResource(peinture_mus + element3);
		m.add(peinture, RDFS.subClassOf, ContenuMusee);	
		
		Resource sculpteur = m.createResource(peinture_mus + element4);
		m.add(sculpteur, RDFS.subClassOf, OeuvreMusee);	
			
		Resource peintre = m.createResource(peinture_mus + element5);
		m.add(peintre, RDFS.subClassOf, OeuvreMusee);	
	}
	
	/*------------ méthode d'ajout des propriétés d'Artistes au modèle ( Peintres et Sculpteurs ) --------------------------------------------------------*/
	
	public <x extends IntArtiste, y extends IntOeuvre> void addArtisteModel(Lister<x> s, Lister<y> p, String element1, String element2) {
		Property id = m.createProperty(peinture_mus + "id");
		Property nom = m.createProperty(peinture_mus + "nom");
		Property prenom = m.createProperty(peinture_mus + "prenom");
		Property date_naissance = m.createProperty(peinture_mus + "date_naissance");
		Property pays_naissance = m.createProperty(peinture_mus + "pays_naissance");
		Property date_deces = m.createProperty(peinture_mus + "date_deces");
		Property peint = m.createProperty(peinture_mus + "peint");
		Property Créa = m.createProperty(peinture_mus + "Créa");
		
		for( x e: s.listeElement) {
			Resource a;
			if(e.getId().length()>7) {
				a = m.createResource(peinture_mus + e.getNom() + "_" + e.getPrenom()); 
				a.addProperty(RDF.type, element1);	
			}
			else {
				a = m.createResource(peinture_mus + e.getNom() + "_" + e.getPrenom());
				a.addProperty(RDF.type, element2);	
			}		
			a.addProperty(id, m.createTypedLiteral(e.getId(), XSD.getURI() + "string"));
			a.addProperty(nom, m.createTypedLiteral(e.getNom(), XSD.getURI() + "string"));
			a.addProperty(prenom, m.createTypedLiteral(e.getPrenom(), XSD.getURI() + "string"));
			a.addProperty(date_naissance, m.createTypedLiteral(e.getDateNaissance(), XSD.getURI() + "string"));
			a.addProperty(pays_naissance, m.createTypedLiteral(e.getLieuNaissance(), XSD.getURI() + "string"));
			a.addProperty(date_deces, m.createTypedLiteral(e.getDateDeces(), XSD.getURI() + "string"));
			
			for(y d: p.listeElement) {
				if(e.getId().length()>7 && d.getId().length()>7) {
					if(e.getId().equals(d.getId())) {
					Resource q = m.getResource(d.getTitre());
				m.add(a, Créa, q);}}
				if(e.getId().length()<=7 && d.getId().length()<=7) {
					if(e.getId().equals(d.getId())) {
					Resource q = m.getResource(d.getTitre());
				m.add(a, peint, q);	
				}}	
			}}}
	
	/*------------- méthode d'ajout des propriétés d'Oeuvres au modèle ( Peintures et Sculptures ) ----------------------------------------------------------------*/
	
	public <x extends IntOeuvre, y extends IntParcoursThematique > void addOeuvreModel(Lister<x> s, Lister<y> p, String element1, String element2) {
		Property id = m.createProperty(peinture_mus + "id");
		Property titre = m.createProperty(peinture_mus + "titre");
		Property domaine = m.createProperty(peinture_mus + "domaine");
		Property matiere_et_technique = m.createProperty(peinture_mus + "matiere");
		Property annee_creation = m.createProperty(peinture_mus + "annee_creation");
		Property num_inventaire = m.createProperty(peinture_mus + "num_inventaire");
		Property est_regroupé = m.createProperty(peinture_mus + "est_regroupé");
	
		for(x e: s.listeElement) {
			Resource a;
			if(e.getId().length()>7) { 
				 a = m.createResource(peinture_mus + e.getTitre()); 
				 a.addProperty(RDF.type, element1);	
			}
			else {
				a = m.createResource(peinture_mus + e.getTitre());
				a.addProperty(RDF.type, element2);	
			}
			
			a.addProperty(id, m.createTypedLiteral(e.getId(), XSD.getURI() + "string"));
			a.addProperty(titre, m.createLiteral(e.getTitre(), "fr"));
			a.addProperty(domaine, m.createLiteral(e.getDomaine(), "fr"));
			a.addProperty(matiere_et_technique, m.createLiteral(e.getMatiereTechnique(), "fr"));
			a.addProperty(annee_creation, m.createTypedLiteral(e.getAnneeCreation(), XSD.getURI() + "int"));
			a.addProperty(num_inventaire, m.createTypedLiteral(e.getNumInventaire(), XSD.getURI() + "string"));
			
				for(y q: p.listeElement) {
					if(e.getThematique().equals(q.getNom())) {
						Resource w = m.getResource(q.getNom());
					m.add(a, est_regroupé, w);
					}		
		}}}		
	
}
