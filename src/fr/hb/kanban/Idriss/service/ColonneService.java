package fr.hb.kanban.Idriss.service;

import java.util.List;

import fr.hb.kanban.Idriss.business.Colonne;

public interface ColonneService {

	Colonne getDefaultColonne();

	void createColonnes();

	List<Colonne> getColonnes();

}
