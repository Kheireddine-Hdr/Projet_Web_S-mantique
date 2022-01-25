	package classe_Structuree;
	
	import java.io.FileOutputStream;
	import java.util.ArrayList;
	import org.apache.jena.query.Query;
	import org.apache.jena.query.QueryExecutionFactory;
	import org.apache.jena.query.QueryFactory;
	import org.apache.jena.query.QuerySolution;
	import org.apache.jena.query.ResultSet;
	import org.apache.jena.query.ResultSetFormatter;
	import org.apache.jena.query.QueryExecution;
	import org.apache.jena.rdf.model.Literal;
	import org.apache.jena.rdf.model.Model;
	import org.apache.jena.rdf.model.ModelFactory;
	import org.apache.jena.rdf.model.Property;
	import org.apache.jena.rdf.model.Resource;
	import org.apache.jena.vocabulary.RDF;
	import org.apache.jena.vocabulary.RDFS;
	import org.apache.jena.vocabulary.XSD;
	
	
	
	
	public class requeteEndpoint {
		
		public ArrayList<Requetes> listeRequete = new ArrayList<>();
		
		public final static String sparqlService = "https://query.wikidata.org/sparql";
		public static final String NL = System.getProperty("line.separator");
	
		private String fil_mus;
		
		// constructeur
	
		public requeteEndpoint() {}
		
	
		public requeteEndpoint(String fil_mus) {
			this.fil_mus = fil_mus;
		}
		
		// Accesseur
		
		public String getFil_mus() {
			return fil_mus;
		}
	
	
		public void setFil_mus(String fil_mus) {
			this.fil_mus = fil_mus;
		}
	
	
	//méthodes:
	
	/*----------------------------------------------------------------------------------------------*/
	
		public void ajouterRequete(Requetes requete) {
			this.listeRequete.add(requete);
		}
	/*----------------------------------------------------------------------------------------------*/
	
		public ArrayList<String> constructionRDQ(ArrayList<Requetes> listeRequete) {
			ArrayList<String> listeReqConstruite = new ArrayList<String>();
			String construction="";
			for (Requetes requete: listeRequete) {
				construction += Requetes.prolog1 +NL+ Requetes.prolog2 +NL+ Requetes.prolog3 +NL+ 
						Requetes.prolog4 +NL + Requetes.prolog5 +NL + Requetes.prolog6 +NL +
						Requetes.prolog7 +NL + Requetes.prolog8 +NL +
						Requetes.prolog9 + Requetes.prolog10 + NL + requete.getCorps();
				listeReqConstruite.add(construction);
				construction = "";
			}  
			return listeReqConstruite;
		}
		
	/*----------------------------------------------------------------------------------------------*/
		public void interrogationSelect(String rdq) {
			Query query = QueryFactory.create(rdq);
			QueryExecution qexec = QueryExecutionFactory.sparqlService(sparqlService, query);
			try {
	
				ResultSet rs = qexec.execSelect();
				ResultSetFormatter.out(System.out, rs, query);
			} finally {
				qexec.close();
			}
		}
		
	/*----------------------------------------------------------------------------------------------*/	
		
		public void endpoint1(String element) {
			
				try {
					Model m = ModelFactory.createDefaultModel();
					m.read(fil_mus);
					String peinture_mus = "http://www.ex.fr/p#";
						
					Resource res = m.getResource(peinture_mus + element);
					Property geolocation = m.createProperty(peinture_mus + "geolocation"); 
					Property nature = m.createProperty(peinture_mus + "nature"); 
					
					String rdq1 = Requetes.prolog9 + NL + Requetes.prolog10 + NL + Requetes.prolog3
							+ NL + Requetes.prolog4 + NL
							+ "SELECT ?s ?label ?o ?label_s "
							+ " ?geolocation WHERE { bind(wd:Q1519002 as ?s) "
							+ " ?s rdfs:label ?label ;  wdt:P31 ?o . "
							+ " ?s wdt:P625 ?geolocation . "
							+ " ?o rdfs:label ?label_s filter(lang(?label) ='fr' && lang(?label_s) ='fr') }";
							
			System.out.println(" la geolocalisation de musée FABRE et sa nature :\n");
		
			Query query1 = QueryFactory.create(rdq1);
			QueryExecution qexec1 = QueryExecutionFactory.sparqlService(sparqlService, query1);
		
				ResultSet rs = qexec1.execSelect();
				for(; rs.hasNext();) {
					QuerySolution sol = rs.next();
					Literal geoloc = (Literal) sol.get("?geolocation");
					Literal mus_art = (Literal) sol.get("?label_s");
					m.add(res, nature, mus_art);
					m.add(res, geolocation, geoloc);	
				} 
			qexec1.close();
			FileOutputStream outStream = new FileOutputStream(this.fil_mus);
			m.write(outStream, "N3");
			outStream.close(); 
			} catch (Exception e) {
				System.out.println("failure" + e);
			} finally {
		}
	}
	
	/*----------------------------------------------------------------------------------------------*/
		
	public void endpoint2() {	
		try {
			Model m = ModelFactory.createDefaultModel();
			String peinture_mus = "http://www.ex.fr/p#";
			
			m.setNsPrefix("p", peinture_mus);
			m.setNsPrefix("rdf", RDF.getURI());
			m.setNsPrefix("rdfs", RDFS.getURI());
			m.setNsPrefix("xsd", XSD.getURI());
			m.setNsPrefix("wd", "http://www.wikidata.org/entity/");
			m.setNsPrefix("wdt", "http://www.wikidata.org/prop/direct/");
			
			Resource musee_fabre = m.createResource(peinture_mus + "musee_Fabre");
			Resource musee = m.createResource(peinture_mus + "Musee");
			m.add(musee, RDFS.subClassOf, RDFS.Class);
			Property est_cree= m.createProperty(peinture_mus + "est_crée");
			
			//musée fabre est un musée d'art ainsi que sa date de creation:
			String rdq1 = Requetes.prolog9 + NL + Requetes.prolog10 + NL + Requetes.prolog3 + NL + Requetes.prolog4 + NL
					+ "SELECT ?s ?label ?annee_creation WHERE { bind(wd:Q1519002 as ?s) "
					+ " ?s rdfs:label ?label. "
					+ " ?s wdt:P571 ?annee_creation . "
					+ " filter(lang(?label) ='fr') }";
			
			Query query = QueryFactory.create(rdq1);
			QueryExecution qexec = QueryExecutionFactory.sparqlService(sparqlService, query);
			ResultSet results = qexec.execSelect();
			for (; results.hasNext();) {
				QuerySolution sol = results.next();
				
				Literal label = (Literal) sol.get("?label");
				Literal annee_creation = (Literal) sol.get("?annee_creation");
				m.add(musee_fabre, RDF.type, musee);
				m.add(musee_fabre, RDFS.label, label);
				m.add(musee_fabre, est_cree, annee_creation);	
			}
			Resource peintre = m.createResource(peinture_mus + "Peintre");
			m.add(peintre, RDFS.subClassOf,RDFS.Class);
			Property Lieu_naissance = m.createProperty(peinture_mus + "Lieu_naissance");
			
			// tous les peintres qui on des collections au musée FABRE:
			String rdq2 = Requetes.prolog1 + NL + Requetes.prolog2 + NL + Requetes.prolog3 + NL + Requetes.prolog4 + NL
					+ " SELECT ?Peintre ?PeintreLabel ?lieu_naissanceLabel WHERE { ?item wdt:P195 wd:Q1519002 ;"
					+ " wdt:P170 ?Peintre ."
					+ " ?Peintre wdt:P19 ?lieu_naissance ;"
					+ " SERVICE wikibase:label { bd:serviceParam wikibase:language 'fr, en' .}} LIMIT 200 ";
	
			Query query2 = QueryFactory.create(rdq2);
			QueryExecution qexec2 = QueryExecutionFactory.sparqlService(sparqlService, query2);
			ResultSet results2 = qexec2.execSelect();
			for (; results2.hasNext();) {
				QuerySolution sol1 = results2.next();
				Resource wdPeinture = (Resource) sol1.get("?Peintre");
				Literal label1 = (Literal) sol1.get("?PeintreLabel");
				Literal lieu = (Literal) sol1.get("?lieu_naissanceLabel");
				m.add(wdPeinture, RDF.type,peintre);
				m.add(wdPeinture, RDFS.label, label1);
				m.add(wdPeinture, Lieu_naissance, lieu);		
			}
			
			Resource peinture = m.createResource(peinture_mus + "Peinture");
			m.add(peinture, RDFS.subClassOf,RDFS.Class);
			Property annee_creation = m.createProperty(peinture_mus + "Annee_creation");
			Property num_inventaire = m.createProperty(peinture_mus + "Num_inventaire");
			Property matiere = m.createProperty(peinture_mus + "Matiere");
			
			// tous les peintures de la collections musée FABRE:
			String rdq3 = Requetes.prolog1 + NL + Requetes.prolog2 + NL + Requetes.prolog3 + NL + Requetes.prolog4 + NL
					+ " select ?item ?itemLabel ?num_inventaire ?matiereLabel ?year_creation WHERE { ?item wdt:P195 wd:Q1519002 ." 
					+	" ?item wdt:P31 wd:Q3305213 ;"
					+ 	" wdt:P571 ?year_creation ; "
					+ 	" wdt:P217 ?num_inventaire ;"
					+ 	" wdt:P186 ?matiere . "
					+ " SERVICE wikibase:label { bd:serviceParam wikibase:language 'fr, en' .}} ";
	
			Query query3 = QueryFactory.create(rdq3);
			QueryExecution qexec3 = QueryExecutionFactory.sparqlService(sparqlService, query3);
			ResultSet results3 = qexec3.execSelect();
			for (; results3.hasNext();) {
				QuerySolution sol1 = results3.next();
				Resource wdPeinture = (Resource) sol1.get("?item");
				Literal label1 = (Literal) sol1.get("?itemLabel");
				Literal anCrea = (Literal) sol1.get("?year_creation");
				Literal numInv = (Literal) sol1.get("?num_inventaire");
				Literal mat = (Literal) sol1.get("?matiereLabel");
				
				m.add(wdPeinture, RDF.type,peinture);
				m.add(wdPeinture, RDFS.label, label1);
				m.add(wdPeinture, annee_creation, anCrea);
				m.add(wdPeinture, num_inventaire, numInv);
				m.add(wdPeinture, matiere, mat);
			}
		
			qexec2.close();
			m.write(System.out, "N3");
			FileOutputStream outStream = new FileOutputStream(this.getFil_mus()); 
			m.write(outStream, "N3");
			outStream.close();
		} catch (Exception e) {
			System.out.println("failure" + e);
		} finally {
		}	
	}	
}
			
	
