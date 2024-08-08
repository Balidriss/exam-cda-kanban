package fr.hb.kanban.Idriss.service.impl;

import java.util.ArrayList;
import java.util.List;

import fr.hb.kanban.Idriss.business.Colonne;
import fr.hb.kanban.Idriss.service.ColonneService;

public class ColonneServiceImpl implements ColonneService {

	// differente approche que type tache

	final private static int DEFAULT = 0;

	private List<Colonne> colonnes;

	@Override
	public Colonne getDefaultColonne() {

		return colonnes.get(DEFAULT);
	}

	@Override
	public void createColonnes() {

		colonnes = new ArrayList<Colonne>();
		colonnes.add(new Colonne("A faire"));
		colonnes.add(new Colonne("En cours"));
		colonnes.add(new Colonne("Terminé"));

	}

	@Override
	public List<Colonne> getColonnes() {
		return colonnes;
	}

}
