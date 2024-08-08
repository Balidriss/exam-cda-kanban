package fr.hb.kanban.Idriss.business;

public class Developpeur {
	private static long compteur;

	private Long id;

	private String nom;
	private String prenom;
	private String email;

	public Developpeur() {
		super();
		this.id = compteur++;
	}

	public Developpeur(String nom) {
		this();
		this.nom = nom;
	}

	public Developpeur(String nom, String prenom) {
		this(nom);
		this.prenom = prenom;
	}

	public Developpeur(String nom, String prenom, String email) {
		this(nom, prenom);
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Developpeur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
	}

}
