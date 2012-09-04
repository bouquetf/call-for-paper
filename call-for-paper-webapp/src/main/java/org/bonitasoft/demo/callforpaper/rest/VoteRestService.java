package org.bonitasoft.demo.callforpaper.rest;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.bonitasoft.demo.callforpaper.model.Vote;
import org.bonitasoft.demo.callforpaper.service.VoteService;

@Path("/vote")
public class VoteRestService {

	@Inject
	private VoteService voteService;

	@Context
	private UriInfo uriInfo;

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getAllVotes(@QueryParam(value = "paperid") String paperid) {
		Vote[] votes;
		if (paperid == null || "".equals(paperid)) {
			votes = voteService.getAllVotes().toArray(new Vote[] {});
		} else {
			votes = voteService.getVotesByPaper(Long.valueOf(paperid)).toArray(new Vote[] {});
		}
		return Response.ok(votes).build();
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getVote(@PathParam("id") String id) {
		Vote vote = voteService.getVote(Long.valueOf(id));
		if (vote == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(vote).build();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response createVote(Vote vote) {
		voteService.createVote(vote);
		URI uri = uriInfo.getAbsolutePathBuilder().path(vote.getId().toString()).build();
		return Response.created(uri).build();
	}
}
