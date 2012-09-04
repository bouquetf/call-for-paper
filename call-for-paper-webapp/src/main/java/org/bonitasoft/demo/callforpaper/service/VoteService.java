package org.bonitasoft.demo.callforpaper.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.bonitasoft.demo.callforpaper.model.Paper;
import org.bonitasoft.demo.callforpaper.model.Vote;

@Stateless
public class VoteService implements Serializable {

	private static final long serialVersionUID = 932490007081177825L;

	private static final String QUERY_ALL = "Vote.all";

	private static final String QUERY_BY_PAPER = "Vote.bypaper";

	@Inject
	private EntityManager em;

	public Vote createVote(Vote vote) {
		vote.setPaper(em.find(Paper.class, vote.getPaper().getId()));
		em.persist(vote);
		return vote;
	}

	public List<Vote> getAllVotes() {
		TypedQuery<Vote> q = em.createNamedQuery(QUERY_ALL, Vote.class);
		return q.getResultList();
	}

	public List<Vote> getVotesByPaper(Long paperId) {
		TypedQuery<Vote> q = em.createNamedQuery(QUERY_BY_PAPER, Vote.class);
		q.setParameter("paperid", paperId);
		return q.getResultList();
	}

	public Vote getVote(Long id) {
		return em.find(Vote.class, id);
	}
}
