package org.bonitasoft.demo.callforpaper.service;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.bonitasoft.demo.callforpaper.model.Paper;
import org.bonitasoft.demo.callforpaper.model.Vote;

@Stateless
public class VoteService implements Serializable {

	private static final long serialVersionUID = 932490007081177825L;

	@Inject
	private EntityManager em;

	public Vote createVote(Vote vote) {
		vote.setPaper(em.find(Paper.class, vote.getPaper().getId()));
		em.persist(vote);
		return vote;
	}
}
