package fr.hb.kanban.Idriss;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import fr.hb.kanban.Idriss.business.Colonne;
import fr.hb.kanban.Idriss.business.Developpeur;
import fr.hb.kanban.Idriss.business.Tache;
import fr.hb.kanban.Idriss.business.TypeTache;
import fr.hb.kanban.Idriss.service.ColonneService;
import fr.hb.kanban.Idriss.service.DeveloppeurService;
import fr.hb.kanban.Idriss.service.TacheService;
import fr.hb.kanban.Idriss.service.TypeTacheService;
import fr.hb.kanban.Idriss.service.impl.ColonneServiceImpl;
import fr.hb.kanban.Idriss.service.impl.DeveloppeurServiceImpl;
import fr.hb.kanban.Idriss.service.impl.TacheServiceImpl;
import fr.hb.kanban.Idriss.service.impl.TypeTacheServiceImpl;
import fr.hb.kanban.Idriss.util.TacheCompare;

public class App {

	final static String PATH = "developpeurs.csv";

	public static DeveloppeurService developpeurService = new DeveloppeurServiceImpl();
	public static TacheService tacheService = new TacheServiceImpl();
	public static ColonneService colonneService = new ColonneServiceImpl();
	public static TypeTacheService typeTacheService = new TypeTacheServiceImpl();
	public static Scanner sc = new Scanner(System.in);
	public static List<Developpeur> devs = loadCSV(PATH);

	public static void main(String[] args) {
		String menuChoice = "";
		s("Bienvenue sur Kanban !");
		colonneService.createColonnes();
		System.out.println(colonneService.getDefaultColonne());
		do {
			s("MENU PRINCIPAL");
			s("1 : ajouter une tâche");
			s("2 : voir le tableau");
			s("3 : voir toutes les tâches triées sur le nombre d’heure estimé");
			s("4 : quitter");
			menuChoice = sc.nextLine();
			switch (menuChoice) {
			case "1": {
				addTache();
				break;
			}
			case "2": {
				displayTableau();
				break;
			}
			case "3": {
				displayTachesHeureEstimeAsc();
				break;
			}
			case "4": {
				break;
			}
			default: {
				s("Choisissez en écrivant le chiffre.");
			}
			}
		} while (!(menuChoice.equals("4")));

		s("A bientôt sur Kanban !");
		// importCSV();

	}

	private static void displayTachesHeureEstimeAsc() {
		List<Tache> taches = tacheService.getTaches();
		List<Tache> sortedTaches = sortAsc(taches);
		s("Voice les tache rangé de du plus court au plus long : ");
		sortedTaches.forEach(System.out::println);

	}

	private static List<Tache> sortAsc(List<Tache> taches) {

		Collections.sort(taches, new TacheCompare());
		return taches;
	}

	private static void displayTableau() {
		List<Colonne> colonnes = colonneService.getColonnes();
		s("Voici les colonnes et ses taches : ");
		for (Colonne colonne : colonnes) {
			System.out.println(colonne.getNom());
			colonne.getTaches().forEach(System.out::println);
		}

	}

	private static void addTache() {

		String intitule = askIntitule();
		TypeTache typeTache = askTypeTache();
		Developpeur dev = askDev();
		Float heureEstime = askHeure();
		Tache tache = tacheService.createTache(intitule, typeTache, dev, heureEstime, colonneService);

		recapAddTache(tache);

	}

	private static Float askHeure() {
		Float heure;
		s("Entrez le nombre d’heures estimé :");
		s("");
		// TODO: Validator
		heure = sc.nextFloat();
		sc.nextLine();
		return heure;
	}

	private static Developpeur askDev() {
		String menuChoice = "";
		boolean goodInput = false;
		Developpeur dev = null;
		do {
			s("Choisissez le développeur : ");
			s("");
			int i = 0;
			for (Developpeur developpeur : devs) {
				i++;
				System.out.println(i + ". " + developpeur.getPrenom() + " " + developpeur.getNom());
			}

			menuChoice = sc.nextLine();
			// TODO: Faire dynamique
			switch (menuChoice) {
			case "1": {
				dev = devs.get(0);
				goodInput = true;
				break;
			}
			case "2": {
				dev = devs.get(1);
				goodInput = true;
				break;
			}
			default: {
				s("Choisissez en écrivant le chiffre.");
			}
			}
		} while (!goodInput);
		return dev;
	}

	private static String askIntitule() {
		s("Entrez l’intitulé de la tâche :");
		return sc.nextLine();
	}

	private static TypeTache askTypeTache() {
		String menuChoice;
		boolean goodInput = false;
		TypeTache typeTache = null;
		do {
			s("Choisissez le type de tâche :");
			s("1. Fonctionnalité");
			s("2. Bug");
			s("3. Amélioration");
			s("4. Spike");
			menuChoice = sc.nextLine();
			switch (menuChoice) {
			case "1": {
				typeTache = typeTacheService.getFonctionalite();
				goodInput = true;
				break;
			}
			case "2": {
				typeTache = typeTacheService.getBug();
				goodInput = true;
				break;
			}
			case "3": {
				typeTache = typeTacheService.getAmelioration();
				goodInput = true;
				break;
			}
			case "4": {
				typeTache = typeTacheService.getSpike();
				goodInput = true;
				break;
			}
			default: {
				s("Choisissez en écrivant le chiffre.");
			}
			}
		} while (!goodInput);
		return typeTache;
	}

	public static void s(String string) {
		System.out.println(string);
	}

	public static void recapAddTache(Tache tache) {
		System.out.println("La tâche « " + tache.getIntitule() + " » a bien été ajouté dans la colonne "
				+ tache.getColonne().getNom() + ", elle porte l’id " + tache.getId() + ". Il s’agit d’une "
				+ tache.getTypeTache().getNom() + ". Une estimation de " + tache.getNbHeuresEstime()
				+ " heures a été renseignée. Cette tâche a été confiée à " + tache.getDeveloppeur().getNom() + " "
				+ tache.getDeveloppeur().getPrenom() + ".");
	}

	public static List<Developpeur> loadCSV(String path) {
		List<Developpeur> devs = new ArrayList<>();
		String csvSplitBy = ",";

		try (Scanner scanner = new Scanner(new File(path))) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] values = line.split(csvSplitBy);

				String prenom = values[0];
				String nom = values[1];
				String mail = values[2];

				Developpeur verbe = new Developpeur(nom, prenom, mail);
				devs.add(verbe);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return devs;
	}

}
