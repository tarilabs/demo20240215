package com.redhat.hackathon;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/dummy")
public class DummyJSONResource {

    @GET
    @Path("quarterly/{associate}/{quarter}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> quarterly(String associate, String quarter) {
        return List.of("quarterly topic 1", "quarterly topic 2", "quarterly topic 3");
    }

    @GET
    @Path("rewardzone/{associate}/{quarter}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> rewardzone(String associate, String quarter) {
        return List.of("reward zone topic 1", "reward zone topic 2", "reward zone topic 3");
    }

    @GET
    @Path("anniversary/{associate}/{quarter}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> anniversary(String associate, String quarter) {
        return List.of("anniversary topic A", "anniversary topic B");
    }
}
