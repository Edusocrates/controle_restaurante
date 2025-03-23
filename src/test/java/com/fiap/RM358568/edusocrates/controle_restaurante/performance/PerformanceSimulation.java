package com.fiap.RM358568.edusocrates.controle_restaurante.performance;

import io.gatling.javaapi.core.ActionBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class PerformanceSimulation extends Simulation {

    private final HttpProtocolBuilder httpProtocol =
            http.baseUrl("http://localhost:8080")
                    .header("Content-Type", "application/json");

    ActionBuilder listar_restaurantes = http("controle de Restaurantes")
            .get("/restaurantes")
            .check(status().is(200));

    ScenarioBuilder listarRestaurantes = scenario("controle de Restaurantes")
            .exec(listar_restaurantes);

    {
        setUp(
                listarRestaurantes.injectOpen(rampUsersPerSec(1)
                        .to(10)
                        .during(Duration.ofSeconds(10)),
                        constantUsersPerSec(10)
                        .during(Duration.ofSeconds(20)),

                        rampUsersPerSec(10)
                                .to(1)
                                .during(Duration.ofSeconds(10)),
                        constantUsersPerSec(10)
                                .during(Duration.ofSeconds(20))

                )
        )
                .protocols(httpProtocol)
                .assertions(
                        global().responseTime().max().lt(2000)
                );
    }
}
