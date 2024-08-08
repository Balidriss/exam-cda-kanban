package fr.hb.kanban.Idriss.util;

import java.util.Comparator;

import fr.hb.kanban.Idriss.business.Tache;

public class TacheCompare implements Comparator<Tache> {

	@Override
	public int compare(Tache t1, Tache t2) {

		return t1.getNbHeuresEstime().compareTo(t2.getNbHeuresEstime());
	}
}