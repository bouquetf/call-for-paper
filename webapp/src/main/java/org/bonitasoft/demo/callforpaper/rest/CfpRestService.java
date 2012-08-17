package org.bonitasoft.demo.callforpaper.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bonitasoft.demo.callforpaper.model.Cfp;
import org.bonitasoft.demo.callforpaper.service.CfpService;

@Path("/cfp")
public class CfpRestService {

	@Inject
	private CfpService cfpService;

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Cfp[] getAllCfp() {
		return cfpService.getAllCfp().toArray(new Cfp[] {});
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Cfp getCfp(@PathParam("id") String id) {
		return cfpService.getCfp(Long.valueOf(id));
	}

	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public void createCFP(Cfp cfp) {
		cfpService.createCfp(cfp);
	}
}
