package com.redhat.hackathon;

import java.util.List;
import java.util.Random;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/json")
public class JSONResource {
    @Inject
    MiscUtils miscUtils;

    @Inject
    ChatService chat;

    @Inject
    QuarterlyReportResource qr;
    @Inject
    RewardzoneReportResource rzr;

    @GET
    @Path("topics/{associate}/{quarter}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> topics(String associate, String quarter) {
        Log.infof("invoked topics with: %s, %s", associate, quarter);
        StringBuilder sb = new StringBuilder("Summarize ")
        .append(associate)
        .append("'s in the ")
        .append(quarter)
        .append(" quarter accordingly to the following report: \n")
        .append(qr.quarterly_report(associate, quarter))
        .append("\n and the following peer feedback: \n")
        .append(rzr.rewardzone_report(associate, quarter))
        .append("\n and considering the associate next work anniversary is 2024-02-21.");
        String message = sb.toString();
        Log.infof("message is: %s", message);
        List<String> result = chat.chat(new Random().nextInt(), message);
        miscUtils.println(result);
        List<String> purgedList = MiscUtils.purgeIff(result);
        return purgedList.subList(1, purgedList.size()); //hackathon avoid 1st line hardcoded likely is the "here is the list you asked" etc.
    }

    @GET
    @Path("quarterly/{associate}/{quarter}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> quarterly(String associate, String quarter) {
        Log.infof("invoked quarterly with: %s, %s", associate, quarter);
        List<String> result = chat.chat(new Random().nextInt(), "Summarize "+associate+"'s achievement in the "+quarter+" quarter accordingly to the following report: "+qr.quarterly_report(associate, quarter));
        miscUtils.println(result);
        return MiscUtils.purgeIff(result);
    }

    @GET
    @Path("rewardzone/{associate}/{quarter}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> rewardzone(String associate, String quarter) {
        Log.infof("invoked rewardzone with: %s, %s", associate, quarter);
        List<String> result = chat.chat(new Random().nextInt(), "Summarize the rewards given to "+associate+"'s and the feedback received in the "+quarter+" quarter, using data from the following report: "+rzr.rewardzone_report(associate, quarter));
        miscUtils.println(result);
        return MiscUtils.purgeIff(result);
    }

    @GET
    @Path("anniversary/{associate}/{quarter}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> anniversary(String associate, String quarter) {
        Log.infof("invoked anniversary with: %s, %s", associate, quarter);
        // we hardcode for poc/hackathon scope
        List<String> result = chat.chat(new Random().nextInt(), "Generate a one, SINGLE and only one bulletpoint item to celebrate the "+associate+"/s work anniversary is 2024-02-21 which falls in the quarter. Answer using only one paragraph.");
        miscUtils.println(result);
        return MiscUtils.purgeIff(result);
    }
}
