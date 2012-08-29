package org.bonitasoft.demo.callforpaper.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.bonitasoft.demo.callforpaper.model.Cfp;

@Stateless
public class CfpService implements Serializable {

	private static final long serialVersionUID = -526852528138167511L;

	private static final String QUERY_ALL = "Cfp.all";

	@Inject
	private EntityManager em;

	public Cfp createCfp(Cfp cfp) {
		cfp.setCreationDate(new Date());
		em.persist(cfp);
		return cfp;
	}

	public Cfp getCfp(Long id) {
		return em.find(Cfp.class, id);
	}

	public List<Cfp> getAllCfp() {
		TypedQuery<Cfp> q = em.createNamedQuery(QUERY_ALL, Cfp.class);
		return q.getResultList();
	}

	public void removeCfp(Long id) {
		em.remove(em.find(Cfp.class, id));
	}

	public void removeCfp(Cfp cfp) {
		em.remove(em.merge(cfp));
	}

}
