package fr.hb.kanban.Idriss.business;

import java.util.ArrayList;
import java.util.List;

public class Colonne {

	private static long compteur;

	private Long id;

	private String nom;

	List<Tache> taches;

	public Colonne() {
		super();
		this.id = compteur++;
		taches = new ArrayList<Tache>();
	}

	public Colonne(String nom) {
		this();
		this.nom = nom;
	}

	public Colonne(String nom, List<Tache> taches) {
		this(nom);
		this.taches = taches;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Tache> getTaches() {
		return taches;
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Colonne [id=" + id + ", nom=" + nom + ", taches=" + taches + "]";
	}

}
