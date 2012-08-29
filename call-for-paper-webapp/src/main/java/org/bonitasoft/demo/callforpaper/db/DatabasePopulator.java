package org.bonitasoft.demo.callforpaper.db;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.bonitasoft.demo.callforpaper.model.Cfp;
import org.bonitasoft.demo.callforpaper.service.CfpService;

@Singleton
@Startup
public class DatabasePopulator {

	private Cfp aCfp;
	private Cfp anotherCfp;

	@Inject
	private CfpService cfpService;

	@PostConstruct
	private void populateDB() {
		// A CFP
		aCfp = new Cfp();
		aCfp.setCreationDate(new Date());
		aCfp.setSubmitterEmail("sebastien.prunier(at)gmail(dot)com");
		aCfp.setSessionType("Quickie");
		aCfp.setSessionTitle("How Javascript will save the world !");
		aCfp.setSessionSummary("15 minutes to explain how Javascript will save the world.");
		aCfp.setSpeakers("Sebastien Prunier");
		aCfp.setSpeakersBios("Software engineer @MosicaFR. Follow @sebprunier on Twitter !");

		// Another CFP
		anotherCfp = new Cfp();
		anotherCfp.setCreationDate(new Date());
		anotherCfp.setSubmitterEmail("frederic.bouquet(at)bonitasoft(dot)com");
		anotherCfp.setSessionType("Conference");
		anotherCfp.setSessionTitle("Add BPM to your Business Applications");
		anotherCfp.setSessionSummary("Demo-oriented conference to show the power of Bonita Open Solution !");
		anotherCfp.setSpeakers("Frederic Bouquet");
		anotherCfp.setSpeakersBios("Bonita evangelist. Follow @bouquetf on Twitter !");

		// Save them !
		cfpService.createCfp(aCfp);
		cfpService.createCfp(anotherCfp);
	}

	@PreDestroy
	private void clearDB() {
		cfpService.removeCfp(aCfp);
		cfpService.removeCfp(anotherCfp);
	}
}
