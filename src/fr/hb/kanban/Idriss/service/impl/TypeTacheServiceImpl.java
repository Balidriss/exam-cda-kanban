package fr.hb.kanban.Idriss.service.impl;

import fr.hb.kanban.Idriss.business.TypeTache;
import fr.hb.kanban.Idriss.service.TypeTacheService;

public class TypeTacheServiceImpl implements TypeTacheService {

	private TypeTache spike = new TypeTache("Spike", "Magenta");
	private TypeTache bug = new TypeTache("Bug", "Rouge");
	private TypeTache amelioration = new TypeTache("Amélioration", "Vert");
	private TypeTache fonctionnalite = new TypeTache("Fonctionnalité", "Bleu");

	@Override
	public TypeTache getSpike() {

		return spike;
	}

	@Override
	public TypeTache getAmelioration() {

		return amelioration;
	}

	@Override
	public TypeTache getBug() {
		// TODO Auto-generated method stub
		return bug;
	}

	@Override
	public TypeTache getFonctionalite() {
		return fonctionnalite;
	}

}
