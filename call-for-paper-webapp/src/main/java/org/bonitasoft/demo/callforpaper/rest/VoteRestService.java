package org.bonitasoft.demo.callforpaper.rest;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.bonitasoft.demo.callforpaper.model.Vote;
import org.bonitasoft.demo.callforpaper.service.VoteService;

@Path("/vote")
public class VoteRestService {

	@Inject
	private VoteService voteService;

	@Context
	private UriInfo uriInfo;

	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response createVote(Vote vote) {
		voteService.createVote(vote);
		URI uri = uriInfo.getAbsolutePathBuilder().path(vote.getId().toString()).build();
		return Response.created(uri).build();
	}
}
