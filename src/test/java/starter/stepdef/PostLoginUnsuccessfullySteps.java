package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostLoginUnsuccessfullySteps {

    @Steps
    ReqresAPI reqresAPI;

    /**
     *
     *POST LOGIN INVALID USER
     */
    @Given("POST Login with invalid JSON {string}")
    public void postLoginInWithValidJSON(String jsonName) {
        File json = new File(Constants.REQ_BODY+"/"+jsonName+"");
        reqresAPI.postLoginUser(json);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);

    }

    @And("Response body should be display error {string}")
    public void responseBodyShouldBeDisplayError(String errorMsg) {
        SerenityRest.and()
                .body(ReqresResponses.ERROR_MESSAGE, equalTo(errorMsg));
    }

}
