package com.redhat.hackathon;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

import jakarta.ws.rs.core.Application;

@OpenAPIDefinition(
    info = @Info(
        title="GE's AI Combinator Hackathon API",
        description = "the dream team: Roberto Emanuel, Matteo Mortari, Edson Tirelli, Daniele Zonca",
        version = "1.0.0-SNAPSHOT",
        contact = @Contact(
            name = "Roberto Emanuel, Matteo Mortari, Edson Tirelli, Daniele Zonca"),
        license = @License(
            name = "Apache 2.0",
            url = "https://www.apache.org/licenses/LICENSE-2.0.html")
    )
)
public class ExampleApiApplication extends Application {
}