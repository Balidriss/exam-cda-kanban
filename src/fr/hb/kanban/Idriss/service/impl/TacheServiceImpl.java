package fr.hb.kanban.Idriss.service.impl;

import java.util.ArrayList;
import java.util.List;

import fr.hb.kanban.Idriss.business.Developpeur;
import fr.hb.kanban.Idriss.business.Tache;
import fr.hb.kanban.Idriss.business.TypeTache;
import fr.hb.kanban.Idriss.service.ColonneService;
import fr.hb.kanban.Idriss.service.TacheService;

public class TacheServiceImpl implements TacheService {

	List<Tache> taches = new ArrayList<Tache>();

	@Override
	public Tache createTache(String intitule, TypeTache typeTache, Developpeur dev, Float heuresEstime,
			ColonneService colonneService) {
		// TODO Auto-generated method stub
		Tache tache = new Tache(intitule, typeTache, dev, colonneService.getDefaultColonne(), heuresEstime);
		taches.add(tache);
		return tache;
	}

	@Override
	public List<Tache> getTaches() {

		return taches;
	}

}
