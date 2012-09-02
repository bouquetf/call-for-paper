package org.bonitasoft.demo.callforpaper.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.bonitasoft.demo.callforpaper.model.Paper;

@Stateless
public class PaperService implements Serializable {

	private static final long serialVersionUID = -526852528138167511L;

	private static final String QUERY_ALL = "Paper.all";

	@Inject
	private EntityManager em;

	public Paper createCfp(Paper cfp) {
		cfp.setCreationDate(new Date());
		em.persist(cfp);
		return cfp;
	}

	public Paper getCfp(Long id) {
		return em.find(Paper.class, id);
	}

	public List<Paper> getAllCfp() {
		TypedQuery<Paper> q = em.createNamedQuery(QUERY_ALL, Paper.class);
		return q.getResultList();
	}

	public void removeCfp(Long id) {
		em.remove(em.find(Paper.class, id));
	}

	public void removeCfp(Paper cfp) {
		em.remove(em.merge(cfp));
	}

}
