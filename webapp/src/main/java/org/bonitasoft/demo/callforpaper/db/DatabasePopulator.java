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
@DataSourceDefinition(className = "org.apache.derby.jdbc.EmbeddedDataSource",
		name = "java:global/jdbc/applicationCfpDS",
		user = "app",
		password = "app",
		databaseName = "applicationCfpDB",
		properties = { "connectionAttributes=;create=true" })
public class DatabasePopulator {

	private Cfp myCfp;

	@Inject
	private CfpService cfpService;

	@PostConstruct
	private void populateDB() {
		myCfp = new Cfp();
		myCfp.setCreationDate(new Date());
		myCfp.setSubmitterEmail("spr@pebprunier.com");
		myCfp.setSessionType("Conference");
		myCfp.setSessionTitle("Title");
		myCfp.setSessionSummary("Description");
		myCfp.setSpeakers("sebprunier");
		myCfp.setSpeakersBios("here i am !");

		cfpService.createCfp(myCfp);
	}

	@PreDestroy
	private void clearDB() {
		cfpService.removeCfp(myCfp);
	}
}
