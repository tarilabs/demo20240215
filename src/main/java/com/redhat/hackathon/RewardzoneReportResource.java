package com.redhat.hackathon;

import java.nio.file.Files;
import java.nio.file.Paths;

import jakarta.enterprise.context.ApplicationScoped;

import dev.langchain4j.agent.tool.Tool;

@ApplicationScoped
public class RewardzoneReportResource {
    @Tool("rewardzone report")
    public String rewardzone_report(String employeeID, String quarter) {
        try {
            return Files
                    .readString(Paths.get(getClass().getClassLoader().getResource("/catalog/" + employeeID + "/rewardzone/" + quarter + ".md").toURI()));
        } catch (Exception e) {
            throw new RuntimeException("It was not possible to locate the database report of " + quarter + " for the employee "
                    + employeeID + ".");
        }
    }
}
