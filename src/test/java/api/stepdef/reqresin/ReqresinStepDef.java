package api.stepdef.reqresin;

import api.service.reqresin.ReqresinAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ReqresinStepDef {

    ReqresinAPI reqresinAPI = new ReqresinAPI();

    @And("user send PUT Update request to reqresin")
    public void putUpdate() {
        reqresinAPI.putUpdate();
    }

    @And("user send POST login request to reqresin")
    public void postlogin() {
        reqresinAPI.postLogin();
    }

    @And("user send GET Users request to reqresin")
    public void getUsers() {
        reqresinAPI.getListUser();
    }

    @And("user send POST Register request to reqresin")
    public void postRegister() {
        reqresinAPI.postRegister();
    }

    @And("user send POST unsuccess login request to reqresin")
    public void postunsuccesslogin() {
        reqresinAPI.postUnsuccessLogin();
    }


    @Then("response status code should be {int}")
    public void statusCodeValidation(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    @Then("response path {string} should contain Int value {string}")
    public void responseDataValidationInt(String path, String value) {
        restAssuredThat(response -> response.body(path, equalTo(Integer.parseInt(value))));
    }

    @Then("response path {string} should contain String value {string}")
    public void responseDataValidationString(String path, String value) {
        restAssuredThat(response -> response.body(path, equalTo(value)));
    }

    @Then("response structure should match json schema {string}")
    public void validateJsonSchema(String schema) {
        String path = String.format("schema/%s", schema);
        restAssuredThat(response -> response.assertThat().body(matchesJsonSchemaInClasspath(path)));
    }

}
