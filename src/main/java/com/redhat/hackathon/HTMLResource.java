package com.redhat.hackathon;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@io.smallrye.common.annotation.Blocking
@Path("/html")
public class HTMLResource {
    @Inject
    MiscUtils miscUtils;
    @Inject
    DummyJSONResource dummy;

    @Inject
    Template stacks;

    @Inject
    JSONResource json;
    
    @GET
    @Path("stacks/{associate}/{quarter}")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance quarterly(String associate, String quarter) {
        List<String> quarterly = json.quarterly(associate, quarter);
        miscUtils.println(quarterly);
        List<String> rewardzone = json.rewardzone(associate, quarter);
        miscUtils.println(rewardzone);
        List<String> anniversary = json.anniversary(associate, quarter);
        miscUtils.println(anniversary);
        return stacks.data("dto", new StacksDTO(
            quarterly,
            rewardzone,
            anniversary
        ));
    }

    @GET
    @Path("dummy/{associate}/{quarter}")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance dummy(String associate, String quarter) {
        return stacks.data("dto", new StacksDTO(
            dummy.quarterly(associate, quarter),
            dummy.rewardzone(associate, quarter),
            dummy.anniversary(associate, quarter)
        ));
    }
}
