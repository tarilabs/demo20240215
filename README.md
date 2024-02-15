# GE's AI Combinator Hackathon

In organizations with flat structures, the significant demands placed on managers to support their team members can be overwhelming. This proposal introduces an **AI tool** designed to enhance the effectiveness of quarterly conversations and the overall performance management process. Utilizing advanced **Large Language Models (LLMs)**, this tool aggregates and analyzes data from various sources throughout the quarter—including workday events, peer feedback, peer rewards, and one-on-one meeting notes. It then synthesizes this information to generate a concise list of discussion topics for managers. Managers have the flexibility to review, modify, or augment these topics as needed. Subsequently, the tool crafts a structured conversation guide **based on the "Crucial Conversations" framework**, ensuring discussions are both impactful and efficiently managed.

The tool is designed to empower managers by:
- Streamlining preparation for quarterly conversations, allowing managers to concentrate on delivering constructive feedback and formulating action plans rather than compiling data.
- Mitigating biases, such as recency and confirmation biases, by consistently capturing and integrating key signals from multiple sources throughout the quarter.
- Enhancing fairness by uniformly collecting data for all team members, contributing to an equitable review process.
- Providing timely and relevant information to facilitate meaningful conversations.
- Encouraging the adoption of best practices in communication, as documented in professional guidelines.
- Ensuring team members receive consistent, valuable, and actionable feedback, fostering their growth and development.

This tool not only aims to optimize managerial efficiency but also to elevate the quality of interactions between managers and their teams, promoting a more supportive and effective organizational culture.

## Dev Notes

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/demo20240215-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides


## Provided Code

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
