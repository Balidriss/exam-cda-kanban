package fr.hb.kanban.Idriss.business;

import java.time.LocalDateTime;

public class Tache {
	private static long compteur;

	private Long id;

	private String intitule;
	private TypeTache typeTache;
	private Developpeur developpeur;
	private Colonne colonne;
	private Float nbHeuresEstime;
	private LocalDateTime dateHeureCreation;

	public Tache() {
		super();
		this.id = compteur++;
		this.dateHeureCreation = LocalDateTime.now();
	}

	public Tache(String intitule) {
		this();
		this.intitule = intitule;

	}

	public Tache(String intitule, TypeTache typeTache) {
		this(intitule);
		this.typeTache = typeTache;

	}

	public Tache(String intitule, TypeTache typeTache, Developpeur developpeur) {
		this(intitule, typeTache);
		this.developpeur = developpeur;

	}

	public Tache(String intitule, TypeTache typeTache, Developpeur developpeur, Colonne colonne) {
		this(intitule, typeTache, developpeur);
		this.colonne = colonne;
		colonne.getTaches().add(this);

	}

	public Tache(String intitule, TypeTache typeTache, Developpeur developpeur, Colonne colonne, Float nbHeuresEstime) {
		this(intitule, typeTache, developpeur, colonne);
		this.nbHeuresEstime = nbHeuresEstime;

	}

	public Tache(String intitule, TypeTache typeTache, Developpeur developpeur, Colonne colonne, Float nbHeuresEstime,
			LocalDateTime dateHeureCreation) {
		this(intitule, typeTache, developpeur, colonne, nbHeuresEstime);
		this.dateHeureCreation = dateHeureCreation;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public TypeTache getTypeTache() {
		return typeTache;
	}

	public void setTypeTache(TypeTache typeTache) {
		this.typeTache = typeTache;
	}

	public Developpeur getDeveloppeur() {
		return developpeur;
	}

	public void setDeveloppeur(Developpeur developpeur) {
		this.developpeur = developpeur;
	}

	public Colonne getColonne() {
		return colonne;
	}

	public void setColonne(Colonne colonne) {
		this.colonne = colonne;
	}

	public Float getNbHeuresEstime() {
		return nbHeuresEstime;
	}

	public void setNbHeuresEstime(Float nbHeuresEstime) {
		this.nbHeuresEstime = nbHeuresEstime;
	}

	public LocalDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}

	public void setDateHeureCreation(LocalDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Tache [id=" + id + ", intitule=" + intitule + ", colonne=" + colonne.getNom() + ", nbHeuresEstime="
				+ nbHeuresEstime + ", dateHeureCreation=" + dateHeureCreation + "]";
	}

}
