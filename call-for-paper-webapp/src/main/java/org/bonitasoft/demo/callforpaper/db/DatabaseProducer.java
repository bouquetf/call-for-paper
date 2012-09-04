package org.bonitasoft.demo.callforpaper.db;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DatabaseProducer {

	@Produces
	@PersistenceContext(unitName = "cfpPU")
	private EntityManager em;

}
