package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostCreateUserSteps {

    @Steps
    ReqresAPI reqresAPI;


    /**
     * POST Create New User
     */
    @Given("POST Create user with JSON {string}")
    public void postCreateUserWithJSON(String jsonName) {
        File json = new File(Constants.REQ_BODY + "/"+jsonName+"");
        reqresAPI.postCreateNewUser(json);
    }

    @When("Send request POST create user")
    public void sendRequestPOSTCreateUser() {
        SerenityRest.when()
                .post(ReqresAPI.POST_CREATE_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);
    }

    @And("Response body name was {string} and job was {string}")
    public void responseBodyNameWasAndJobWas(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job));
    }

}
