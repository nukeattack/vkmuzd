package com.cryptobat.vkmuzd.services.web;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cryptobat.vkmuzd.entities.application.Track;

@Path("csv")
public class TrackResource {
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Track> getTrackList(){
		List<Track> result = new LinkedList<>();
		for(int i = 0; i < 100; i++){
			result.add(new Track());
		}
		return result;
	}
}
