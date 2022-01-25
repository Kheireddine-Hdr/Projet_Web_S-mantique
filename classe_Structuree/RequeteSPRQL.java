package classe_Structuree;

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.apache.jena.atlas.io.IndentedWriter;
import org.apache.jena.query.Query;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;

public class RequeteSPRQL {
	
	public static final String NL = System.getProperty("line.separator");

	public ArrayList<Requetes> listeRequete = new ArrayList<>();

	public RequeteSPRQL() {}
	
	//-----------------------------------------------------------------------------------------------------------/

	public void ajouterRequete(Requetes requete) {
		this.listeRequete.add(requete);
	}
	
	//------------------------------------------------------------------------------------------------------------/

	public ArrayList<String> constructionRDQ(ArrayList<Requetes> listeRequete) {
		ArrayList<String> listeReqConstruite = new ArrayList<String>();
		String construction="";
		for (Requetes requete: listeRequete) {
			construction += Requetes.prologue1 +NL+ Requetes.prologue2 +NL+ Requetes.prologue3 +NL+ requete.getCorps();
			listeReqConstruite.add(construction);
			construction = "";
		}  
		return listeReqConstruite;
	}
	
	//-------------------------------------------------------------------------------------------------------------/

	public void interrogationSelect(String rdq, Model m) {
		Query query = QueryFactory.create(rdq);
		QueryExecution qexec = QueryExecutionFactory.create(query,m);
		query.serialize(new IndentedWriter(System.out,true)) ;
		System.out.println("_");
		try {
			ResultSet rs = qexec.execSelect() ;
			ResultSetFormatter.out(System.out, rs, query);
		}
		finally {qexec.close();}
	}
	
	//---------------------------------------------------------------------------------------------------------------/

	public void interrogationDescribe(String rdq, Model m) {
		Query query = QueryFactory.create(rdq);
		QueryExecution qexec = QueryExecutionFactory.create(query, m);
		query.serialize(new IndentedWriter(System.out,true)) ;
		System.out.println("_");

		Model results = qexec.execDescribe();
		results.write(System.out, "N3");
		try {
			FileOutputStream ost = new FileOutputStream("F1Describe.n3");
			results.write(ost, "N3" ); 
		}
		catch (FileNotFoundException e) {
			System.out.println("pb de fichier");
		}
		finally {qexec.close();}
	}
	
	//----------------------------------------------------------------------------------------------------------------/

	public void interrogationConstruct(String rdq, Model m) {
		Query query = QueryFactory.create(rdq);
		QueryExecution qexec = QueryExecutionFactory.create(query, m);
		query.serialize(new IndentedWriter(System.out,true)) ;
		System.out.println();
		Model results = qexec.execConstruct();
		results.write(System.out, "N3");
		try {
			FileOutputStream ost = new FileOutputStream("SculptureCons.n3");
			results.write(ost, "N3"); 
		}
		catch (FileNotFoundException e) {
			System.out.println("pb de fichier");
		}
		finally {qexec.close();}
	}

}
