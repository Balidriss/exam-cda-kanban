package fr.hb.kanban.Idriss.service;

import java.util.List;

import fr.hb.kanban.Idriss.business.Developpeur;
import fr.hb.kanban.Idriss.business.Tache;
import fr.hb.kanban.Idriss.business.TypeTache;

public interface TacheService {

	Tache createTache(String intitule, TypeTache typeTache, Developpeur dev, Float heureEstime,
			ColonneService colonneService);

	List<Tache> getTaches();

}
