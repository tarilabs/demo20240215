package com.redhat.hackathon;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/freeform")
public class Freeform {
    @Inject
    MiscUtils miscUtils;

    @Inject
    ChatService chat;

    @POST
    @Path("convHelper")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @RequestBody(content=@Content(mediaType = MediaType.TEXT_PLAIN,
        example = """
        You are a manager conducting your quarterly performance review with your associates. Create a conversation plan with a list of talking points based on the associate data. Consolidate the topics and create a single plan with the talking points following the "Crucial Conversations" framework. Keep the talking points succinct and avoid giving conversation examples. Include in the plan a couple suggestions of possible areas for development of the associate. Avoid repeated topics. 
        Here is the data collected for your associate Mason Morgan:
        
        - The associate contributed to other conversations on GitHub, created issues and pull requests for the Model Registry repository, and participated in other threads reporting.
        - The associate received positive feedback from team members regarding their communication skills, leadership abilities, and technical knowledge.
        - The associate was commended for their contributions to the UX review meetings, particularly their ability to break down complex technical concepts into simple terms.
        - The associate's work on the integration of GH issues and JIRA was praised as "wonderful" and "inspiring," showcasing their willingness to try new things and master them.
        - The associate demonstrated strong communication skills and the ability to set up the team for success, as noted by their colleagues.
        - The associate's leadership and technical skills have grown significantly over time, according to their team members.
        - The associate was recognized for their contributions to the Model Registry team's success, particularly during the UX review meetings.
        - The associate's work on the Model Registry project was praised for its ability to evolve with changing requirements and deliver an initial version despite complexity and tight timelines.
        - The associate prioritized team success and put forth a positive attitude, as noted by their colleagues.
        - The associate received reward points as a token of appreciation for their support during a difficult period.
        """))
    public String convHelper(String message) {
        Log.infof("invoked convHelper with: %s", message);
        String result = chat.convHelper(message);
        miscUtils.println(result);
        return result;
    }
}
