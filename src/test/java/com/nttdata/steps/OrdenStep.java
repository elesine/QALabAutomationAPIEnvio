package com.nttdata.steps;
import java.time.LocalDateTime;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static io.restassured.RestAssured.given;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class OrdenStep {
    private static String URLBase = null; //"https://petstore.swagger.io/v2/store/order";

    public void definirurl(String url) {
        URLBase = url;
    }
    public void crearOrden(int id, int petId, int quantity) {
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": \"" + id + "\",\n" +
                        "  \"petId\": \"" + petId + "\",\n" +
                        "  \"quantity\": \"" + quantity + "\",\n" +
                        "  \"shipDate\": \"" +  LocalDateTime.now() + "\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": \"true\"\n" +
                        "}")
                .log().all()
                .post(URLBase)
                .then()
                .log().all()
        ;
    }
    public void validarCodigoRespuesta(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    public void consultarOrden(String idOrden) {
        SerenityRest.given()
                .contentType("application/json")
                .log().all()
                .get(URLBase+"/"+idOrden)
                .then()
                .log().all()
        ;
    }

    public void imprimirOrden() {
        System.out.println("IMPRIMO ORDEN JSONPATH \n"+lastResponse().jsonPath().prettify());
    }

    public String estadoComplete() {
        String complete = SerenityRest.lastResponse().body().path("'complete'").toString();
        System.out.println("valor complete: "+ complete);
        return complete;

        //Otra forma de validacion
        // restAssuredThat(response -> response.body("'complete'", equalTo(true)));
    }

    public void validarAtributosIngresados(int id, int petId, int quantity) {
        restAssuredThat(response -> response.body("'id'", equalTo(id)));
        restAssuredThat(response -> response.body("'petId'", equalTo(petId)));
        restAssuredThat(response -> response.body("'quantity'", equalTo(quantity)));
    }
}
