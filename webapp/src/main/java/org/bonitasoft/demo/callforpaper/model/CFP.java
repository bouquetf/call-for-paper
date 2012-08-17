package org.bonitasoft.demo.callforpaper.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Cfp.all", query = "select c from Cfp c") })
public class Cfp {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Version
	private Long version;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@Column(nullable = false)
	private String sessionType;

	@Column(nullable = false)
	private String submitterEmail;

	@Column(nullable = false)
	private String sessionTitle;

	@Column(nullable = false)
	private String sessionSummary;

	@Column(nullable = false)
	private String speakers;

	@Column(nullable = false)
	private String speakersBios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getSessionType() {
		return sessionType;
	}

	public void setSessionType(String sessionType) {
		this.sessionType = sessionType;
	}

	public String getSubmitterEmail() {
		return submitterEmail;
	}

	public void setSubmitterEmail(String submitterEmail) {
		this.submitterEmail = submitterEmail;
	}

	public String getSessionTitle() {
		return sessionTitle;
	}

	public void setSessionTitle(String sessionTitle) {
		this.sessionTitle = sessionTitle;
	}

	public String getSessionSummary() {
		return sessionSummary;
	}

	public void setSessionSummary(String sessionSummary) {
		this.sessionSummary = sessionSummary;
	}

	public String getSpeakers() {
		return speakers;
	}

	public void setSpeakers(String speakers) {
		this.speakers = speakers;
	}

	public String getSpeakersBios() {
		return speakersBios;
	}

	public void setSpeakersBios(String speakersBios) {
		this.speakersBios = speakersBios;
	}

}
