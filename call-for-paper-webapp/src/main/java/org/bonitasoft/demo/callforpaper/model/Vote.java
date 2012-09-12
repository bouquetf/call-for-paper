package org.bonitasoft.demo.callforpaper.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Vote.all", query = "select v from Vote v"),
	@NamedQuery(name = "Vote.bypaper", query = "select v from Vote v where v.paper.id = :paperid") })
public class Vote {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String juryMember;

	@Column(nullable = false)
	private Boolean choice;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "paper_fk", nullable = false)
	private Paper paper;

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

	public Boolean getChoice() {
		return choice;
	}

	public void setChoice(Boolean choice) {
		this.choice = choice;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

}
