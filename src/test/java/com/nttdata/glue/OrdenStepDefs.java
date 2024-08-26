package com.nttdata.glue;

import com.nttdata.steps.OrdenStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class OrdenStepDefs {

    @Steps
    OrdenStep orden;

    @Given("la url {string} del servicio")
    public void laUrlDelServicio(String url) {
        orden.definirurl(url);

    }

    @When("crear el orden con id {int}, petId {int}, quantity {int}")
    public void crearElOrdenConIdPetIdQuantity(int id, int petId, int quantity) {
        orden.crearOrden(id, petId, quantity);
    }

    @Then("el código de respuesta es {int}")
    public void elCódigoDeRespuestaEs(int statusCode) {
        orden.validarCodigoRespuesta(statusCode);
    }

    @When("consultar el orden con id {string}")
    public void consultarElOrdenConId(String idOrden) {
        System.out.println("STEPDeF");
        orden.consultarOrden(idOrden);
    }

    @And("imprimir orden")
    public void imprimirOrden() {
        orden.imprimirOrden();
    }

    @And("el atributo de respuesta complete es {string}")
    public void elAtributoCompleteEs(String complete){
        Assert.assertEquals(complete, orden.estadoComplete());
    }

    @And("validar los datos ingresados id {int}, petId {int}, quantity {int} se registraron correctamente")
    public void validarLosDatosIngresadosIdPetIdQuantity(int id, int petId, int quantity) {
        orden.validarAtributosIngresados(id, petId, quantity);
    }

}