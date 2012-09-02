package org.bonitasoft.demo.callforpaper.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Vote {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String juryMember;

	@Column(nullable = false)
	private Boolean vote;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "paper_fk", nullable = false, insertable = false, updatable = false)
	private Paper cfp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJuryMember() {
		return juryMember;
	}

	public void setJuryMember(String juryMember) {
		this.juryMember = juryMember;
	}

	public Boolean getVote() {
		return vote;
	}

	public void setVote(Boolean vote) {
		this.vote = vote;
	}

	public Paper getCfp() {
		return cfp;
	}

	public void setCfp(Paper cfp) {
		this.cfp = cfp;
	}

}
