package fr.hb.kanban.Idriss.service;

import fr.hb.kanban.Idriss.business.TypeTache;

public interface TypeTacheService {

	TypeTache getSpike();

	TypeTache getAmelioration();

	TypeTache getBug();

	TypeTache getFonctionalite();

}
