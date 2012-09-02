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

	public Paper createPaper(Paper paper) {
		paper.setCreationDate(new Date());
		em.persist(paper);
		return paper;
	}

	public Paper getPaper(Long id) {
		return em.find(Paper.class, id);
	}

	public List<Paper> getAllPapers() {
		TypedQuery<Paper> q = em.createNamedQuery(QUERY_ALL, Paper.class);
		return q.getResultList();
	}

	public void removePaper(Long id) {
		em.remove(em.find(Paper.class, id));
	}

	public void removePaper(Paper paper) {
		em.remove(em.merge(paper));
	}

}
