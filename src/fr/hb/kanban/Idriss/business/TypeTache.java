package fr.hb.kanban.Idriss.business;

public class TypeTache {

	private static long compteur;

	private Long id;

	private String nom;
	private String couleurRGB;

	public TypeTache() {
		super();
		this.id = compteur++;
	}

	public TypeTache(String nom) {
		this();
		this.nom = nom;

	}

	public TypeTache(String nom, String couleurRGB) {
		this(nom);
		this.couleurRGB = couleurRGB;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCouleurRGB() {
		return couleurRGB;
	}

	public void setCouleurRGB(String couleurRGB) {
		this.couleurRGB = couleurRGB;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "TypeTache [id=" + id + ", nom=" + nom + ", couleurRGB=" + couleurRGB + "]";
	}

}
