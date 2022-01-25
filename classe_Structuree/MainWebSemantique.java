package classe_Structuree;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.ReasonerRegistry;
import org.apache.jena.reasoner.ValidityReport;

public class MainWebSemantique {

	public static void main(String[] args) {
		
//--------------------------- Instantiation de Musée  -------------------------------------------------------------------------------/	
			
			Lister<Artiste> listeArtiste = new Lister<>();
			Lister<Oeuvre> listeOeuvre = new Lister<>();
			Lister<ParcoursThematique> listePT = new Lister<>();
			ArrayList<String> listeReqLocal = new ArrayList<>();
			ArrayList<String> listeConstDesc = new ArrayList<>();
			ArrayList<String> listeReqEnd = new ArrayList<>();
		
//--------------------------- Instantiation de Musée  -------------------------------------------------------------------------------/
		
			Musee Mus = new Musee("musee_Fabre", "39 Boulevard Bonne Nouvelle, 34000 Montpellier", "3 Decembre 1828", 9200);
			
//--------------------------- Instantiation des Peintres  ---------------------------------------------------------------------------/
			
			Peintre Fabre = new Peintre("FRX_Fab", "Fabre", "Francois Xavier", "1 avril 1766", "Montpellier", "16 mars 1837");
			Peintre HILLEMACHER = new Peintre("EUG_Hil","HILLEMACHER","Eugene Ernest","13 octobre 1818","France","3 mars 1887");
			Peintre SUBLEYRAS = new Peintre("PHU_Sub", "SUBLEYRAS","Pierre Hubert","25 novembre 1699","France","28 mai 1749");
			Peintre PIAZZETTA = new Peintre("GBA_Pia", "PIAZZETTA","Giovanni Battista","13 feverier 1682","Italie","28 avril 1754");
			Peintre NEGRETTI = new Peintre("JPA_Neg", "NEGRETTI","Jacopo Palma le Jeune","1550","Italie","17 octobre 1628");
			Peintre RIMINI = new Peintre("PDA_Rim", "RIMINI","Pietro da","1280","Italie","1350");
			Peintre PRUDHON = new Peintre("PPA_Pru", "PRUDHON","Pierre Paul","29 mars 1807","France","14 feverier 1823");
			Peintre CARDI= new Peintre("LIC_Car", "CARDI","Lodovico il Cigoli","22 septembre 1559 ","Italie","18 juin 1613");
			Peintre VOUET = new Peintre("SIM_Vou", "VOUET","Simon","9 janvier 1590","Italie","30 juin 1649");
			Peintre COPPOLA = new Peintre("GAN_Cop", "COPPOLA","Giovanni Andrea","1592","Italie","1659");
			Peintre AZURBARAN = new Peintre("FDE_Zur", "ZURBARAN","Francisco de","7 novembre 1598","Espagne","27 aout 1664");
			Peintre DIAZ_DE_LA_PENA = new Peintre("NVI_Ddp", "DIAZ DE LA PENA","Narcisse_Virgile","20 aout 1807","France","18 novembre 1876");
			Peintre LEHMANN = new Peintre("HEI_Leh", "LEHMANN","Heinrich","11 decembre 1911","Allemagne","18 avril 1986");
			Peintre LOUDRY = new Peintre("JCA_Lou", "LOUDRY","Jacques Charles","1720","France","1778");
			Peintre SILVESTRE = new Peintre("LDE_Sil", "SILVESTRE","Louis de","23 juin 1675","France","11 avril  1760");
			Peintre HONDIUS = new Peintre("ABR_Hon","HONDIUS","Abraham","1631","Pays_Bas","17 septembre 1691");
			Peintre BERRE = new Peintre("JBA_Ber", "BERRE","Jean Baptiste","11 fevrier 1777 ","Belgique","5 juillet 1838");
			Peintre POTTER = new Peintre("PAU_Pot", "POTTER","Paulus","20 novembre 1625","Pays Bas","20 novembre 1678");
			Peintre BRASCASSAT = new Peintre ("JRA_Bra", "BRASCASSAT","Jacques_Raymond","30 aout 1804","France","28 fevrier 1867");
			Peintre HONDECOETER = new Peintre("MEL_Hon", "HONDECOETER","Melchior","1636","Irlande","28 decemebre 1656");
			Peintre LA_HYRE = new Peintre("LAD_Lhy", "LA_HYRE","Laurent de","27 feverier 1606","France","20 novembre 1678");
			Peintre MARSEUS_VAN_SCHRIECK = new Peintre("VSC_Mar", "MARSEUS VAN SCHRIECK","Otto","1619","Irlande","22 juin 1678");
			Peintre TROYON = new Peintre("CON_Tro", "TROYON","Constant","28 aout 1810","France","21 feverier 1865");
			Peintre DIDIER = new Peintre("JUL/Did", "DIDIER","Jules","Septembre 1626","France","20 novembre 1678");
			Peintre LAURENS = new Peintre("JJO/Lau", "LAURENS","Jules Joseph Augustin","27 juillet 1825","France","5 mai 1901");
			Peintre CASTELNAU = new Peintre("AEU/Cas", "CASTELNAU","Alexandre Eugene","29 decembre 1827","France","2 novembre 1894");
			Peintre ALLEMAND = new Peintre("LHE/All", "ALLEMAND","Louis Hector","5 aout 1809","France","13 septembre 1886");
			
			Peintre COURBET = new Peintre("GUS?Cou", "COURBET","Gustave","10 mars 1819","France","31 decembre 1877");
			Peintre MORISOT = new Peintre("BMP?Mor", "MORISOT","Berthe Marie Pauline","2 mars 1895","France","21 feverier 1865");
			Peintre MONNOYER = new Peintre("JBL?Mno", "MONNOYER","Jean Baptiste l'Aine","12 janvier 1636","France","20 fevrier 1699");
			Peintre BAZILLE = new Peintre("FRR?Baz", "BAZILLE","Frederic","6 decembre 1841","France","28 novembre 1870");
			Peintre GAUFFIER = new Peintre("LSO?Gau", "GAUFFIER","Louis","10 juin 1762","France","20 octobre 1801");
			Peintre DELORME = new Peintre("PRR?Del", "DELORME","Pierre Claude Francois","1783","France","1859");
			Peintre SCHUPPEN = new Peintre("JVA?Shc", "SCHUPPEN","Jacob van","26 janvier 1670","France","29 janvier 1751");
			Peintre STELLA = new Peintre("JAC?Ste", "STELLA","Jacques","29 septembre 1596","France","29 avril 1657");
			Peintre COUSIN = new Peintre("JLP?Cou","COUSIN","Jean le Pere","1490","France","1589");
			Peintre WOLF = new Peintre("CAS?Wol", "WOLF","Caspar","1735","suisse","6 octobre 1783");
			Peintre BERCHEM = new Peintre("NIC?Ber", "BERCHEM","Nicolaes","1620","Pays-Bas","18 fevrier 1683");
			Peintre MATISSE = new Peintre("HEN?Mai", "MATISSE","Henri","15 decembre 1807","France","3 novembre 1954");
			Peintre TROY = new Peintre("JFD?Tro", "TROY","Jean-Francois de","26 janvier 1752","France","26 janvier 1752");
			Peintre RYCKHALS  = new Peintre("FRM?Ryc", "RYCKHALS","Francois Marius","17 decembre 1775","France","1679");
			Peintre HELMONT = new Peintre("MAV?Hel", "HELMONT","Mattheus van","1623","Belgique","29 avril 1657");
			Peintre VOLLON = new Peintre("ALX!Vol", "VOLLON","Alexis "," 23 avril 1833 ","France"," 27 août 1900 ");
			Peintre ZAMPIERI = new Peintre("DOM!Zam", "ZAMPIERI","Domenico","21 octobre 1581","Italie", "6 avril 1641");
			Peintre PIERRE = new Peintre("JBI!Pie", "PIERRE","Jean Baptiste Marie ","6 mars 1714","France", "15 mai 1789");
			Peintre LAGRENEE = new Peintre("LJFA!La", "LAGRENEE","Louis Jean François l'Aîné "," 30 décembre 1724","France", "19 juin 1805");
			
			Sculpteur HOUDON = new Sculpteur("JAN/Houd", "HOUDON","Jean Antoine","25 mars 1741","France","15 juillet 1828");
			Sculpteur BARYE = new Sculpteur("LHE/Bary", "BARYE","Louis Hector","24 septembre 1795","France","25 juin 1875");
			Sculpteur CLEVE = new Sculpteur("COR/Clev", "CLEVE","Corneille van","10 juin 1645","France","30 décembre 1732");
			Sculpteur MENGUE = new Sculpteur("JMA/Meng", "MENGUE","Jean Marie","30 decembre 1855","France","24 septembre 1939");
			Sculpteur BOSIO = new Sculpteur("FJO/Bosi", "BOSIO","Francois Joseph","16 septembre 1902","France","1768");
			
			//ajouter les peintres à la liste :
			
			listeArtiste.entrer(Fabre);
			listeArtiste.entrer(HILLEMACHER);
			listeArtiste.entrer(SUBLEYRAS);
			listeArtiste.entrer(PIAZZETTA);
			listeArtiste.entrer(NEGRETTI);
			listeArtiste.entrer(RIMINI);
			listeArtiste.entrer(PRUDHON);
			listeArtiste.entrer(CARDI);
			listeArtiste.entrer(VOUET);
			listeArtiste.entrer(COPPOLA);
			listeArtiste.entrer(AZURBARAN);
			listeArtiste.entrer(DIAZ_DE_LA_PENA);
			listeArtiste.entrer(LEHMANN);
			listeArtiste.entrer(LOUDRY);
			listeArtiste.entrer(SILVESTRE);
			listeArtiste.entrer(HONDIUS);
			listeArtiste.entrer(BERRE);
			listeArtiste.entrer(POTTER);
			listeArtiste.entrer(BRASCASSAT);
			listeArtiste.entrer(HONDECOETER);
			listeArtiste.entrer(LA_HYRE);
			listeArtiste.entrer(MARSEUS_VAN_SCHRIECK);
			listeArtiste.entrer(TROYON);
			listeArtiste.entrer(DIDIER);
			listeArtiste.entrer(LAURENS);
			listeArtiste.entrer(CASTELNAU);
			listeArtiste.entrer(ALLEMAND);
			listeArtiste.entrer(COURBET);
			listeArtiste.entrer(MORISOT);
			listeArtiste.entrer(MONNOYER);
			listeArtiste.entrer(BAZILLE);
			listeArtiste.entrer(GAUFFIER);
			listeArtiste.entrer(DELORME);
			listeArtiste.entrer(SCHUPPEN);
			listeArtiste.entrer(STELLA);
			listeArtiste.entrer(COUSIN);
			listeArtiste.entrer(WOLF);
			listeArtiste.entrer(BERCHEM);
			listeArtiste.entrer(MATISSE);
			listeArtiste.entrer(TROY);
			listeArtiste.entrer(RYCKHALS);
			listeArtiste.entrer(HELMONT);
			listeArtiste.entrer(VOLLON);
			listeArtiste.entrer(ZAMPIERI);
			listeArtiste.entrer(PIERRE);
			listeArtiste.entrer(LAGRENEE);
			
			listeArtiste.entrer(HOUDON);
			listeArtiste.entrer(BARYE);
			listeArtiste.entrer(CLEVE);
			listeArtiste.entrer(MENGUE);
			listeArtiste.entrer(BOSIO);
			
		
			
//----------------------------  Instantiation des Peintures  ----------------------------------------------------------------------------------------/
			
			Peinture FABRE_1 = new Peinture("FRX_Fab", "Le retour d'Ulysse", "Peinture_francaise_18e_siecle", "2006.4.1",
					"Huile_sur_toile", 1779, "TH_les_heros");	
			
			Peinture HILLEMACHER_1  = new Peinture("EUG_Hil", "Clotilde de Surville", "Peinture_francaise_19e_siecle", "2005.4.1", 
					"Huile_sur_toile", 1853, "TH_ecrivains_lecteurs");

			Peinture SUBLEYRAS_1  = new Peinture("PHU_Sub", "la venerable Baptistine Vernazza", "Peinture francaise 18e siecle", " 61.3.1", 
					"Huile_sur_toile", 1739, "TH_ecrivains_lecteurs");

			Peinture PIAZZETTA_1  = new Peinture("GBA_Pia", "Le chanteur", "Peinture francaise 18e siecle", "73.2.1", 
					"Huile_sur_toile", 1720, "TH_ecrivains_lecteurs");

			Peinture NEGRETTI_1  = new Peinture("JPA_Neg", "Le Martyre de saint Donatienet ses ompagnons à Carthage", "Peinture francaise 16e siecle", "2012.19.22", 
					"Huile_sur_toile", 1593, "TH_anges");

			Peinture RIMINI_1  = new Peinture("PDA_Rim", "La Dormition de la Vierge", "Peinture francaise 14e siecle", "825.1.122", 
					"Tempera_a_l'oeuf_et_feuille_d'or_sur_bois",1320, "TH_anges");

			Peinture ANONYME_1  = new Peinture("ANO_Nym", "Le Martyre de sainte Cecile", "Peinture francaise 17e siecle", "825.1.166", 
					"Huile_sur_toile",1625, "TH_anges");

			Peinture PRUDHON_1  = new Peinture("PPA_Pru", "Les Arts, la Richesse, les Plaisirs, la Philosophie (esquisse)", "Peinture francaise 18e siecle", "836.4.48", 
					"Huile_sur_toile_marouflee_sur_bois",1801, "TH_anges");

			Peinture CARDI_1  = new Peinture("LIC_Car", "La Fuite en Egypte", "Peinture francaise 17e siecle", "837.1.25", 
					"Huile_sur_cuivre", 1612, "TH_anges");

			Peinture VOUET_1  = new Peinture("SIM_Vou", "Allegorie de la Prudence", "Peinture francaise 17e siecle", "837.1.98", 
					"Huile_sur_toile",1645, "TH_anges");
			Peinture COPPOLA_1  = new Peinture("GAN_Cop", "Adoration des bergers", "Peinture francaise 17e siecle", "825.1.166", 
					"Huile_sur_toile",1640, "TH_anges");

			Peinture AZURBARAN_1  = new Peinture("FDE_Zur", "L'Ange Gabriel", "Peinture francaise 17e siecle", "852.1.2", 
					"Huile_sur_toile",1632 , "TH_anges");

			Peinture DIAZ_DE_LA_PENA_1  = new Peinture("NVI_Ddp", "Les rendez-vous d'amour", "Peinture francaise 19e siecle", "868.1.30", 
					"Huile_sur_papier_maroufle_sur_toile",1849 , "TH_anges");

			Peinture LEHMANN_1  = new Peinture("HEI_Leh", "Sainte Catherine d'Alexandrie portee au tombeau", "Peinture francaise 19e siecle", "892.4.8", 
					"Huile_sur_toile",1839 , "TH_anges");
			Peinture LOUDRY_1  = new Peinture("JCA_Lou", "Gibier, chien, fleurs et fruits", "Peinture francaise 18e siecle", "2012.19.21", 
					"Huile_sur_toile",1748 , "TH_les_animaux");

			Peinture SILVESTRE_1  = new Peinture("LDE_Sil", "La Formation De L'Homme par Promethee aide du secours de Minerve", "Peinture francaise 18e siecle", "2012.19.29", 
					"Huile_sur_toile", 1702, "TH_les_animaux");

			Peinture HONDIUS_1  = new Peinture("ABR_Hon", "Chasse au sanglier", "Peinture francaise 17e siecle", "835.2.1", 
					"Huile_sur_toile", 1675, "TH_les_animaux");

			Peinture BERRE_1  = new Peinture("JBA_Ber", "Paysage avec animaux", "Peinture francaise 18e siecle", "836.4.4", 
					"Huile_sur_bois", 1821, "TH_les_animaux");

			Peinture POTTER_1  = new Peinture("PAU_Pot", "Trois vaches au paturage", "Peinture francaise 17e siecle", "836.4.15", 
					"Huile_sur_bois", 1648, "TH_les_animaux");

			Peinture BRASCASSAT_1  = new Peinture("JRA_Bra", "Paysage avec animaux","Peinture francaise 19e siecle", "825.1.166", 
					"Huile_sur_toile", 1835, "TH_les_animaux");

			Peinture HONDECOETER_1  = new Peinture("MEL_Hon", "La poule blanche", "Peinture francaise 17e siecle", "837.1.39", 
					"Huile_sur_toile", 1660, "TH_les_animaux");

			Peinture LA_HYRE_1  = new Peinture("LAD_Lhy", "Paysage au patre jouant de la flute", "Peinture francaise 17e siecle", "837.1.50", 
					"Huile_sur_toile", 1647, "TH_les_animaux");

			Peinture MARSEUS_VAN_SCHRIECK_1  = new Peinture("VSC_Mar", "Une tige de chardons", "Peinture francaise 17e siecle", "837.1.55", 
					"Huile_sur_toile", 1667, "TH_les_animaux");

			Peinture TROYON_1  = new Peinture("CON_Tro", "L'Abreuvoir", "Peinture francaise 19e siecle", "868.1.93", 
					"Huile_sur_toile", 1850, "TH_les_animaux");

			Peinture DIDIER_1  = new Peinture("JUL/Did", "Une foret de pins a Castel Fusano", "Peinture francaise 19e siecle", "876.3.31", 
					"Huile_sur_toile", 1869, "TH_les_animaux");

			Peinture LAURENS_1  = new Peinture("JJO/Lau", "Le_Chemin des Sables a Fontainebleau", "Peinture francaise 19e siecle", "876.3.54", 
					"Huile_sur_toile", 1869, "TH_les_animaux");

			Peinture CASTELNAU_1  = new Peinture("AEU/Cas", "Les garrigues du pic Saint-Loup", "Peinture francaise 19e siecle", "895.1.2", 
					"Huile_sur_toile", 1859, "TH_les_animaux");

			Peinture ALLEMAND_1  = new Peinture("LHE/All", "Le paturage", "Peinture francaise 19e siecle", "897.1.2", 
					"Huile_sur_toile", 1867, "TH_les_animaux");
		
			Peinture COURBET_1  = new Peinture("GUS?Cou", "Les Baigneuses", "Peinture francaise 19e siecle", "868.1.19", 
					"Huile_sur_toile", 1853, "TH_le_Nu");

			Peinture MORISOT_1  = new Peinture("BMP?Mor", "Jeune femme assise devant la fenetre, dit l'Ete", "Peinture francaise 19e siecle", "07.5.1", 
					"Huile_sur_toile", 1879, "TH_les_fleurs");

			Peinture BAZILLE_1  = new Peinture("FRR?Baz", "Etude de nu, dit Nu couche", "Peinture francaise 19e siecle", "18.1.1", 
					"Huile_sur_toile", 1864, "TH_les_fleurs");

			Peinture MONNOYER_1  = new Peinture("JBL?Mno", "Fleurs, fruits objets d'art", "Peinture francaise 17e siecle", "2012.19.19", 
					"Huile_sur_toile", 1665, "TH_vie_artiste");

			Peinture GAUFFIER_1  = new Peinture("LSO?Gau", "Portrait du peintre Van Wyck Coklers", "Peinture francaise 18 siecle", "825.1.112", 
					"Huile_sur_toile", 1797, "TH_vie_artiste");

			Peinture DELORME_1  = new Peinture("PRR?Del", "Eve tentee par le serpent", "Peinture francaise 19e siecle", "860.2.2", 
					"Huile_sur_toile", 1791, "TH_Les_monstres");

			Peinture SCHUPPEN_1  = new Peinture("JVA?Shc", "Meleagre tue le sanglier de Calydon", "Peinture francaise 18e siecle", "2012.19.28", 
					"Huile_sur_toile", 1704, "TH_Les_monstres");

			Peinture STELLA_1  = new Peinture("JAC?Ste", "Sainte Famille avec saint Jean-Baptiste", "Peinture francaise 17e siecle", "2001.6.1", 
					"Huile_sur_ardoise", 1633, "TH_les_enfants");
			
			Peinture COUSIN_1  = new Peinture("JLP?Cou", "Allegorie de la Charite", "Peinture francaise 16e siecle", "884.3.1", 
					"Huile sur bois", 1546, "TH_les_enfants");
			
			Peinture WOLF_1  = new Peinture("CAS?Wol", "Baigneuses pres d'une cascade en montagne", "Peinture suisse 18e siecle", "2012.19.34", 
					"Huile_sur_toile", 1770, "TH_eau");

			Peinture BERCHEM_1  = new Peinture("NIC?Ber", "Les fagots", "Peinture hollandaise 17e siecle", "836.4.3", 
					"1670 - 1680", 1704, "TH_eau");

			Peinture MATISSE_1  = new Peinture("HEN?Mai", "Nature morte aux couteaux noirs", "Peinture francaise 20e siecle", "D05.2.3", 
					"Huile sur toile sur bois", 1896, "TH_le_vin");

			Peinture TROY_1  = new Peinture("JFD?Tro", "Ariane dans l'ile de Naxos", "Peinture francaise 18e siecle", "806.11", 
					"Huile_sur_toile", 1725, "TH_le_vin");

			Peinture RYCKHALS_1  = new Peinture("FRM?Ryc", "Interieur rustique", "Peinture francaise 17e siecle", "832.1.2", 
					"Huile_sur_bois", 1640, "TH_peinture_interieurs");
			
			Peinture MORISOT_2  = new Peinture("BMP?Mor", "Jeune femme assise devant la fenetre, dit l'Ete", "Peinture francaise 19e siecle", "07.5.1", 
					"Huile_sur_toile", 1879, "TH_peinture_interieurs");

			Peinture HELMONT_1  = new Peinture("MAV?Hel", "L'alchimiste", "Peinture Belgue 17e siecle", "895.7.54", 
					"Huile sur bois", 1668, "TH_peinture_interieurs");
			
			Peinture MONNOYER_2  = new Peinture("JBL!Mwo", "Fleurs, fruits et objets d'art", "Peinture francaise 17e siecle", "2012.19.19", 
					"Huile_sur_toile", 1704, "TH_fruits");

			Peinture VOLLON_1  = new Peinture("ALX!Vol", "Nature morte", "Peinture francaise 19e siecle", "33.5.14", 
					"Huile sur toile ", 1933, "TH_fruits");

			Peinture ZAMPIERI_1  = new Peinture("DOM!Zam", "Portrait du cardinal Jean de Bonsy (1554-1621), évêque de Beziers", "Peinture Italienne 17e siecle", "00.7.2", 
					"Huile_sur_toile", 1900, "TH_ Etoffes_et_tissus");

			Peinture PIERRE_1  = new Peinture("JBI!Pie", "Diomède roi de Thrace, tué par Hercule et dévoré par ses propres chevaux", "Peinture Italienne 18e siecle", "2012.19.23", 
					"Huile_sur_toile", 1742, "TH_Heros");

			Peinture LAGRENEE_1  = new Peinture("LJFA!La", "Alexandre consulte l'oracle d'Apollon", "Peinture francaise 18e siecle", "2012.19.15", 
					"Huile sur bois", 1789, "TH_Heros");
			
//------------------------ Instantiation des SCULPTURES ------------------------------------------------------------------------------------------/

			Sculpture HOUDON_1  = new Sculpture("JAN/Houd", "L'Hiver", "Sculpture francaise 18e siecle", "828.5.1", 
					"Marbre", 1867, "TH_le_Nu");

			Sculpture BARYE_1  = new Sculpture("LHE/Bary", "Hercule portant le sanglier d'Erymanthe", "Sculpture française 19e siècle", "08.2.3", 
					"Bronze", 1825, "TH_les_heros");

			Sculpture BARYE_2  = new Sculpture("LHE/Bary", "Thesee combattant le Minotaure", "Sculpture francaise 19e siecle", "876.3.72", 
					"Bronze", 1874, "TH_Les_monstres");
			
			Sculpture BARYE_3  = new Sculpture("LHE/Bary", "Thesee combattant le centaure_Bienor", "Sculpture française 19e siècle", "876.3.73", 
					"Bronze", 1874, "TH_Les_monstres");

			Sculpture HOUDON_2  = new Sculpture("JAN/Houd", "Cheval surpris par un lion", "Sculpture francaise 19e siecle", "876.3.7", 
					"Bronze", 1874, "TH_les_animaux");

			Sculpture HOUDON_3 = new Sculpture("JAN/Houd", "Leone con serpente", "Sculpture francaise 19e siecle", "876.3.80", 
					"Bronze", 1872, "TH_les_animaux");

			Sculpture CLEVE_1  = new Sculpture("COR/Clev", "Polypheme", "Sculpture française 17e siècle", "877.1.3", 
					"Terre cuite patinee", 1681, "TH_les_heros");
			
			Sculpture MENGUE_1  = new Sculpture("JMA/Meng", "Icare", "Sculpture francaise 19e siecle", "D889.2.1", 
					"Marbre", 1887, "TH_les_heros");
			
			Sculpture BOSIO_1  = new Sculpture("FJO/Bosi", "Henri IV enfant", "Sculpture française 19e siècle", "68.2.437", 
					"Bronze argente", 1946, "TH_les_enfants");

		//ajouter les peintures à la liste :
			
			listeOeuvre.entrer(FABRE_1);
			listeOeuvre.entrer(HILLEMACHER_1);
			listeOeuvre.entrer(SUBLEYRAS_1);
			listeOeuvre.entrer(PIAZZETTA_1);
			listeOeuvre.entrer(NEGRETTI_1);
			listeOeuvre.entrer(RIMINI_1);
			listeOeuvre.entrer(ANONYME_1);
			listeOeuvre.entrer(PRUDHON_1);
			listeOeuvre.entrer(CARDI_1);
			listeOeuvre.entrer(VOUET_1);
			listeOeuvre.entrer(COPPOLA_1);
			listeOeuvre.entrer(AZURBARAN_1);
			listeOeuvre.entrer(DIAZ_DE_LA_PENA_1);
			listeOeuvre.entrer(LEHMANN_1);
			listeOeuvre.entrer(LOUDRY_1);
			listeOeuvre.entrer(SILVESTRE_1);
			listeOeuvre.entrer(HONDIUS_1);
			listeOeuvre.entrer(BERRE_1);
			listeOeuvre.entrer(POTTER_1);
			listeOeuvre.entrer(BRASCASSAT_1);
			listeOeuvre.entrer(HONDECOETER_1);
			listeOeuvre.entrer(LA_HYRE_1);
			listeOeuvre.entrer(MARSEUS_VAN_SCHRIECK_1);
			listeOeuvre.entrer(TROYON_1);
			listeOeuvre.entrer(DIDIER_1);
			listeOeuvre.entrer(LAURENS_1);
			listeOeuvre.entrer(CASTELNAU_1);
			listeOeuvre.entrer(ALLEMAND_1);
			
			listeOeuvre.entrer(COURBET_1);
			listeOeuvre.entrer(MORISOT_1);
			listeOeuvre.entrer(BAZILLE_1);
			listeOeuvre.entrer(MONNOYER_1);
			listeOeuvre.entrer(GAUFFIER_1);
			listeOeuvre.entrer(DELORME_1);
			listeOeuvre.entrer(SCHUPPEN_1);
			listeOeuvre.entrer(STELLA_1);
			listeOeuvre.entrer(COUSIN_1);
			listeOeuvre.entrer(WOLF_1);
			listeOeuvre.entrer(BERCHEM_1);
			listeOeuvre.entrer(MATISSE_1);
			listeOeuvre.entrer(TROY_1);
			listeOeuvre.entrer(RYCKHALS_1);
			listeOeuvre.entrer(HELMONT_1);
			listeOeuvre.entrer(MONNOYER_2);
			listeOeuvre.entrer(VOLLON_1);
			listeOeuvre.entrer(ZAMPIERI_1);
			listeOeuvre.entrer(PIERRE_1);
			listeOeuvre.entrer(LAGRENEE_1);
			listeOeuvre.entrer(MORISOT_2);
			
			listeOeuvre.entrer(HOUDON_1);
			listeOeuvre.entrer(HOUDON_2);
			listeOeuvre.entrer(HOUDON_3);
			listeOeuvre.entrer(BARYE_1);
			listeOeuvre.entrer(BARYE_2);
			listeOeuvre.entrer(BARYE_3);
			listeOeuvre.entrer(CLEVE_1);
			listeOeuvre.entrer(MENGUE_1);
			listeOeuvre.entrer(BOSIO_1);
		
//--------------------------- Instantiation des parcours thématiques  --------------------------------------------------------/
			
			ParcoursThematique pt1 = new ParcoursThematique("TH_les_heros");
			ParcoursThematique pt2 = new ParcoursThematique("TH_peinture_interieurs");
			ParcoursThematique pt3 = new ParcoursThematique("TH_ecrivains_lecteurs");
			ParcoursThematique pt4 = new ParcoursThematique("TH_les_enfants");
			ParcoursThematique pt5 = new ParcoursThematique("TH_anges");
			ParcoursThematique pt6 = new ParcoursThematique("TH_les_animaux");
			ParcoursThematique pt7 = new ParcoursThematique("TH_Les_monstres");
			ParcoursThematique pt8 = new ParcoursThematique("TH_le_Nu");
			ParcoursThematique pt9 = new ParcoursThematique("TH_les_fleurs");
			ParcoursThematique pt10 = new ParcoursThematique("TH_vie_artiste");
			ParcoursThematique pt11= new ParcoursThematique("TH_eau");
			ParcoursThematique pt12= new ParcoursThematique("TH_le_vin");
			ParcoursThematique pt13= new ParcoursThematique("TH_ Etoffes_et_tissus");
			ParcoursThematique pt14= new ParcoursThematique("TH_fruits");
			// ajouter les parcours thématiques à la liste :
			
			listePT.entrer(pt1);
			listePT.entrer(pt2);
			listePT.entrer(pt3);
			listePT.entrer(pt4);
			listePT.entrer(pt5);
			listePT.entrer(pt6);
			listePT.entrer(pt7);
			listePT.entrer(pt8);
			listePT.entrer(pt9);
			listePT.entrer(pt10);
			listePT.entrer(pt11);
			listePT.entrer(pt12);
			listePT.entrer(pt13);
			listePT.entrer(pt14);
			
			//pt2.AjoutOeuvre(listeOeuvre);
			//System.out.println(pt2.toString());
			
						
//--------------------------------------- AFFichage Modèle: -----------------------------------------------------------------------/
			
			Modele modele = new Modele(listeOeuvre, listeArtiste, listePT, Mus);
			
			modele.ajoutMuseeModel();
			modele.addClassModel("Oeuvre", "Artiste", "Sculpture", "Peinture", "Sculpteur", "Peintre"); 
			modele.addArtisteModel(listeArtiste, listeOeuvre, "Sculpteur", "Peintre");
			modele.addOeuvreModel(listeOeuvre,listePT, "Sculpture", "Peinture");
			modele.addThematiqueModel(Mus);
			
			try { FileOutputStream outStream = new FileOutputStream("ProModel.n3"); 
			modele.getM().write(System.out, "N3");
			//modele.getM().write(outStream, "N3");
			outStream.close(); } 
	
			catch (FileNotFoundException e)
			{System.out.println("File not found");} 
			catch (IOException e)
			{System.out.println("IO problem");}
			catch (Exception e) {
				System.out.println("failure" + e);
			}
			
	//------------------------------------- Affichage OWL: -------------------------------------------------------------------------/
			
			Ontologie onto = new Ontologie(listeOeuvre, listeArtiste, listePT, Mus);
			
			onto.addMuseeOntologie(Mus);
			onto.addOntClass(listeOeuvre, listeArtiste); 
			onto.addArtisteOntologie(listeArtiste, listeOeuvre, "Sculpteur", "Peintre", "Sculpture", "Peinture");
			onto.addOeuvreOntologie(listeOeuvre,listePT, "Sculpture", "Peinture");
			onto.addThematOntologie(Mus);
			
			onto.getM().write(System.out, "N3");
			String fic = "Projet.n3";
			OntModel om =
			ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM_RDFS_INF);
			try {
			om.read(fic);
			Reasoner reasoner = ReasonerRegistry.getOWLReasoner();
			reasoner = reasoner.bindSchema(om);
			InfModel infmodel = ModelFactory.createInfModel(reasoner, om);
			ValidityReport validity = infmodel.validate();
			if(validity.isValid())System.out.println("OK");
			else{System.out.println("Conflicts");
			for(Iterator i = validity.getReports(); i.hasNext(); )
			{ValidityReport.Report report =(ValidityReport.Report)i.next();
			System.out.println(" "+ report);}}
			}
			finally {om.close();}
			
	//------------------------------------- Requètes Locales : -------------------------------------------------------------------------/
	
			Model m = ModelFactory.createDefaultModel();
			m.read("Projet.n3");
	
			Requetes req = new Requetes("SELECT ?peintre ?date_naissance WHERE { ?peintre rdf:type p:Peintre . " +
					" OPTIONAL { ?s p:date_naissance ?date_naissance } } LIMIT 20");
			
			Requetes req1 = new Requetes("SELECT ?peintre ?pays_naissance WHERE { ?peintre rdf:type p:Peintre ;"
					+ " p:pays_naissance ?pays_naissance . "
					+ " FILTER (lang(?pays_naissance) = 'it') } LIMIT 20");
			
			Requetes req2 = new Requetes("SELECT ?peintre ?date_deces WHERE { ?peintre rdf:type p:Peintre ; " +
					" p:date_deces ?date_deces .} LIMIT 20 " );
			
			Requetes req3 = new Requetes("SELECT ?s ?label WHERE { ?s rdf:type p:Peinture ."
					+ "?s rdfs:label ?label . " 
					+  " FILTER REGEX(?label, \"^[C|M]\") }" );
			
			Requetes req4 = new Requetes("SELECT ?s ?label WHERE { ?s rdf:type p:Peinture ; "
					+ " rdfs:label ?label . " 
					+ " FILTER REGEX(?label, \"e$\") } LIMIT 10 ");
			
			Requetes req5 = new Requetes("SELECT ?peinture ?annee_creation WHERE { ?peinture rdf:type p:Peinture ; "
					+	" p:annee_creation ?annee_creation . " 
					+  " FILTER (bound(?annee_creation)) } LIMIT 20 " );
			
			Requetes req6 = new Requetes ("SELECT ?peinture ?annee_creation WHERE { ?peinture rdf:type p:Peinture . "
					+  " ?peinture p:annee_creation ?annee_creation . " 
					+  " FILTER (?annee_creation > 1600 && ?annee_creation < 1700) }");
			
			Requetes req7 = new Requetes ("SELECT ?peintre ?date_naissance WHERE { ?peintre p:date_naissance ?date_naissance . " 
					+  " FILTER  NOT EXISTS { ?peintre p:date_deces ?date_deces  } }");
			
			Requetes req8 = new Requetes ("SELECT ?sculpteur ?nom WHERE { ?sculpteur rdf:type p:Sculpteur . " +
					" OPTIONAL { ?sculpteur p:nom ?nom } } LIMIT 6" );
			
			Requetes req9 = new Requetes ("SELECT ?peinture ?domaine WHERE { ?peinture rdf:type p:Peinture . "
					+ "?peinture p:domaine ?domaine . "
					+ " OPTIONAL {?peinture p:annee_creation ?annee_creation .} " 
					+ " FILTER ( !bound(?annee_creation) && lang(?domaine) = 'fr') } ");
			
			Requetes req10 = new Requetes ("SELECT ?s ?label WHERE { ?s rdfs:label ?label ."
					+ " {?s rdf:type p:Sculpture . } "
					+ " UNION "
					+ " {?s rdf:type p:Peinture . } "
					+ "} LIMIT 20");
			
			Requetes req11 = new Requetes ("SELECT ?sculpture WHERE { ?sculpture rdf:type p:Sculpture}");
			
			Requetes req12 = new Requetes (" SELECT ?class  (count(?individu) as ?nbreIndividus) WHERE {  " 
					+  " ?individu rdf:type ?class . } group by ?class ");
			
			Requetes req13 = new Requetes (" SELECT ?class  (count(?individu) as ?nbreParClasse) WHERE {  " 
					+  " ?individu rdf:type ?class .} group by ?class  having (count(?individu) >1) ");
			
			Requetes req14 = new Requetes (" SELECT ?cl  ?individu ?label WHERE {  bind(p:Parcours_Thematique as ?cl) " 
					+  " ?individu rdf:type ?cl ;  rdfs:label ?label    }");
		
			Requetes req15 = new Requetes ("SELECT ?s  ?o WHERE { ?s rdf:type ?o} LIMIT 20 ");
			
			
			Requetes req16 = new Requetes("CONSTRUCT WHERE { ?i rdf:type p:Sculpture ." +
					" ?i rdfs:label ?label . ?i p:annee_creation ?annee_creation .}");
			
			Requetes req17 = new Requetes("DESCRIBE ?Portrait_F1 WHERE { ?Portrait_F1 rdf:type p:Peinture ." 
					+ " ?Portrait_F1 rdfs:label \"Le retour d'Ulysse\" .}");
	//------------------------------------------------------------------------------------------------------------------/
			
			RequeteSPRQL sprqSelect = new RequeteSPRQL();
			
			sprqSelect.ajouterRequete(req);
			sprqSelect.ajouterRequete(req1);
			sprqSelect.ajouterRequete(req2);
			sprqSelect.ajouterRequete(req3);
			sprqSelect.ajouterRequete(req4);
			sprqSelect.ajouterRequete(req5);
			sprqSelect.ajouterRequete(req6);
			sprqSelect.ajouterRequete(req7);
			sprqSelect.ajouterRequete(req8);
			sprqSelect.ajouterRequete(req9);
			sprqSelect.ajouterRequete(req10);
			sprqSelect.ajouterRequete(req11);
			sprqSelect.ajouterRequete(req12);
			sprqSelect.ajouterRequete(req13);
			sprqSelect.ajouterRequete(req14);
			sprqSelect.ajouterRequete(req15);
			
			
			listeReqLocal = sprqSelect.constructionRDQ(sprqSelect.listeRequete);
			
			for (String chaine : listeReqLocal) {
				System.out.println("\n***************************************** REQUETE SUIVANTE : *************************************************************************\n");
				sprqSelect.interrogationSelect(chaine, m);
			}			
			
		System.out.println("\n------------------------------------- CONSTRUCT : -------------------------------------------------------------\n");
			
			RequeteSPRQL sprqConstruct = new RequeteSPRQL();
			sprqConstruct.ajouterRequete(req16);
			
			listeConstDesc = sprqConstruct.constructionRDQ(sprqConstruct.listeRequete);
			sprqConstruct.interrogationConstruct(listeConstDesc.get(0), m);
			
		System.out.println("\n-------------------------------------- DESCRIBE : ------------------------------------------------------------\n");
			
			RequeteSPRQL sprqDiscribe = new RequeteSPRQL();
			sprqDiscribe.ajouterRequete(req17);
		
			listeConstDesc = sprqDiscribe.constructionRDQ(sprqDiscribe.listeRequete);
			sprqDiscribe.interrogationDescribe(listeConstDesc.get(0), m);
		
	System.out.println("\n**************************************** Requetes Endpoint ******************************************************************************\n");
	
	System.out.println("tableau 01 : tout les peintres qui ont des oeuvres au musée FABRE"
			+ " et les informations les concernant :");
	
	Requetes req18 = new Requetes(" select ?Peintre ?PeintreLabel (year(?date_naissance) as ?birthyear)"
				+ " ?lieu_naissanceLabel (year(?date_decès) as ?deathyear)"
				+ " WHERE { ?item wdt:P195 wd:Q1519002 ;" 
				+ " wdt:P170 ?Peintre ."
				+ " ?Peintre wdt:P569 ?date_naissance ;"
				+ " wdt:P19 ?lieu_naissance ;"
				+ " wdt:P570 ?date_decès ."
				+ " SERVICE wikibase:label { bd:serviceParam wikibase:language 'fr, en' .}} ");
	//-------------------------------------------------------------------------------------------------------------------------------------------------/
	System.out.println("tableau 02 : musée FABRE, année_creation, nature de musée :");
	
	Requetes req19 = new Requetes(" SELECT ?s ?label ?o ?label_s (year(?year_creation) as ?annee_creation ) WHERE { bind(wd:Q1519002 as ?s) "
				+ " ?s rdfs:label ?label ;  wdt:P31 ?o . "
				+ " ?s wdt:P571 ?year_creation . " 
				+ " ?o rdfs:label ?label_s filter(lang(?label) ='fr' && lang(?label_s) ='fr') }");
	//-------------------------------------------------------------------------------------------------------------------------------------------------/
	
	System.out.println("tableau 03 : Peintures de Bazille FREDERIC :");
	
	Requetes req20 = new Requetes(" select ?item  ?itemLabel  where { ?item wdt:P31/wdt:P279* wd:Q3305213 . "
				+  " ?item wdt:P170 wd:Q207298 . "
				+  " SERVICE wikibase:label { bd:serviceParam wikibase:language 'fr, en' .}}");
	//-------------------------------------------------------------------------------------------------------------------------------------------------/
	
	System.out.println("tableau 04 :toutes les sculptures de la collection musée FABRE ");
	
	Requetes req21 = new Requetes(" SELECT ?item ?itemLabel WHERE { ?item wdt:P195 wd:Q1519002 ."
			+ " ?item wdt:P31 wd:Q860861 ."			
			+ " SERVICE wikibase:label { bd:serviceParam wikibase:language 'fr, en' .}}");
	//-------------------------------------------------------------------------------------------------------------------------------------------------/
	
	System.out.println("tableau 05 :les peintures de FREDERIC Bazille éxposées au musée FABRE "
			+ " ainsi que leurs date de creation :");
	
	Requetes req22 = new Requetes(" select ?item ?itemLabel (year(?year_creation) as ?annee_creation ) where { ?item wdt:P195 wd:Q1519002 . "
			+ " ?item wdt:P31/wdt:P279* wd:Q3305213 ."
			+ " ?item wdt:P170 wd:Q207298 . "
			+ " ?item wdt:P571 ?year_creation . "
			+ " SERVICE wikibase:label { bd:serviceParam wikibase:language 'fr','en' .}}");
	//-------------------------------------------------------------------------------------------------------------------------------------------------/
	
	System.out.println("tableau 06: les peintures de la collection musée FABRE exposées entre 1700 et 1850 :");
	
	Requetes req23 = new Requetes(" SELECT ?peinture ?peintureLabel (year(?year_creation) as ?annee_creation ) WHERE{ ?peinture wdt:P195 wd:Q1519002 ."
			+ " ?peinture wdt:P31/wdt:P279* wd:Q3305213 ."
			+ " ?peinture wdt:P571 ?year_creation ."
			+ "  FILTER(YEAR(?year_creation)>= 1700 && YEAR(?year_creation)<= 1850)."
			+ " SERVICE wikibase:label { bd:serviceParam wikibase:language 'fr', 'en'.}} ");
	//-------------------------------------------------------------------------------------------------------------------------------------------------/
	
	System.out.println("tableau 07: les peintures de la collection musée FABRE qui commencent par la lettre 'C',"
			+ " ainsi que leur numéro d'inventaire :");
	
	Requetes req24 = new Requetes(" SELECT ?peinture ?peintureLabel ?num_inventaire WHERE{ ?peinture wdt:P195 wd:Q1519002 ."
			+ " ?peinture wdt:P31/wdt:P279* wd:Q3305213 ;"
			+		" wdt:P217 ?num_inventaire ; "
			+ 		" rdfs:label ?peintureLabel . " 	
			+  " FILTER(LANG(?peintureLabel) = 'fr'&& 'en' ). "
			+  " FILTER(STRSTARTS(?peintureLabel, 'C')) . }");
	//-------------------------------------------------------------------------------------------------------------------------------------------------/
	
	System.out.println("tableau 08: les oeuvres de peintre Gustave COURBET qui terminent par la lettre 't', exposées"
			+ "au musée FABRE ainsi que leurs numéro d'inventaire :");
	
	Requetes req25 = new Requetes(" SELECT ?peinture ?peintureLabel ?num_inventaire WHERE{ ?peinture wdt:P195 wd:Q1519002 ."
			+ " ?peinture wdt:P31/wdt:P279* wd:Q3305213 ."
			+ " ?peinture wdt:P170 wd:Q34618 ;"
			+ 	" wdt:P217 ?num_inventaire ; " 
			+ 	" rdfs:label ?peintureLabel . " 	
			+ " FILTER(LANG(?peintureLabel) = 'fr'&& 'en' ). "
			+ " FILTER(STRENDS(?peintureLabel, 't')) . }"); 
	//-------------------------------------------------------------------------------------------------------------------------------------------------/
	
	System.out.println("\ntableau 09: toutes les peintures de la collection musée FABRE, leurs createur, leur année_creation"
			+ " leurs num_inventaire et la matière avac quoi elles sont peintent :\n");
	
	Requetes req26 = new Requetes(" select ?Peinture ?PeintureLabel ?creatorLabel (year(?year_creation) as ?annee_creation ) "
			+ " ?num_inventaire ?matiereLabel WHERE { ?Peinture wdt:P195 wd:Q1519002 ;"
			+ "  wdt:P31 wd:Q3305213 ;"
			+ "  wdt:P170 ?creator ; "
			+ "  wdt:P571 ?year_creation ; "
			+ "  wdt:P217 ?num_inventaire ; "
			+ "  wdt:P186 ?matiere ; "
			+ " SERVICE wikibase:label { bd:serviceParam wikibase:language 'fr, en' .}} ");
	//-------------------------------------------------------------------------------------------------------------------------------------------------/
	
			requeteEndpoint ENDPSelect = new requeteEndpoint();
			
			ENDPSelect.ajouterRequete(req18);
			ENDPSelect.ajouterRequete(req19);
			ENDPSelect.ajouterRequete(req20);
			ENDPSelect.ajouterRequete(req21);
			ENDPSelect.ajouterRequete(req22);
			ENDPSelect.ajouterRequete(req23);
			ENDPSelect.ajouterRequete(req24);
			ENDPSelect.ajouterRequete(req25);
			ENDPSelect.ajouterRequete(req26);
			
			listeReqEnd = ENDPSelect.constructionRDQ(ENDPSelect.listeRequete);
			
			ENDPSelect.interrogationSelect(listeReqEnd.get(8));
			
			int tab = 01;
				while(tab!=9){
					System.out.println("\n******************************************* tableau :" + tab + " " + "*********************************************************************************\n");
					ENDPSelect.interrogationSelect(listeReqEnd.get(tab-1));
				tab++;
			}
			
		//------------------------------------- injecter des données: -------------------------------------------------------------------/ 
		
	// 1- à commenter tout ce qui est avant et décommenter la 1ére ligne pour créer l'objet rqE;
	// 2- ensuite décommenter la dernière ligne (methode endpoint2()) pour pouvoir injecter 
	// sur un fichier vièrge en local toutes les informations que le service à distance peut nous 
	// renvoyer sur muséé FABRE (artistes, oeuvres et les informations sur le mussée) ;
	// 3- et enfin commenter la dernière ligne et décommenter la ligne de milieu ( la méthode endpoint1(...)) 
	// pour pouvoir injecter la geolocalisation et la nature de musée dans la ressource musee_Fabre. 	
			
			//requeteEndpoint rqE = new requeteEndpoint("Projet.n3");
			//rqE.endpoint1("musee_Fabre");
			//rqE.endpoint2();	
		}
	}


