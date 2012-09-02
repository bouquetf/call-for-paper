package org.bonitasoft.demo.callforpaper.db;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.bonitasoft.demo.callforpaper.model.Paper;
import org.bonitasoft.demo.callforpaper.service.PaperService;

@Singleton
@Startup
public class DatabasePopulator {

	private Paper aPaper;
	private Paper anotherPaper;

	@Inject
	private PaperService paperService;

	@PostConstruct
	private void populateDB() {
		// A Paper
		aPaper = new Paper();
		aPaper.setCreationDate(new Date());
		aPaper.setSubmitterEmail("sebastien.prunier(at)gmail(dot)com");
		aPaper.setSessionType("Quickie");
		aPaper.setSessionTitle("How Javascript will save the world !");
		aPaper.setSessionSummary("15 minutes to explain how Javascript will save the world.");
		aPaper.setSpeakers("Sebastien Prunier");
		aPaper.setSpeakersBios("Software engineer @MosicaFR. Follow @sebprunier on Twitter !");

		// Another Paper
		anotherPaper = new Paper();
		anotherPaper.setCreationDate(new Date());
		anotherPaper.setSubmitterEmail("frederic.bouquet(at)bonitasoft(dot)com");
		anotherPaper.setSessionType("Conference");
		anotherPaper.setSessionTitle("Add BPM to your Business Applications");
		anotherPaper.setSessionSummary("Demo-oriented conference to show the power of Bonita Open Solution !");
		anotherPaper.setSpeakers("Frederic Bouquet");
		anotherPaper.setSpeakersBios("Bonita evangelist. Follow @bouquetf on Twitter !");

		// Save them !
		paperService.createPaper(aPaper);
		paperService.createPaper(anotherPaper);
	}

	@PreDestroy
	private void clearDB() {
		paperService.removePaper(aPaper);
		paperService.removePaper(anotherPaper);
	}
}
