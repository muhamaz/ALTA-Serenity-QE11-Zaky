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

public class PostLoginUserSteps {

    @Steps
    ReqresAPI reqresAPI;

    /**
     * POST LOGIN VALID USER
     */

    @Given("POST Login with valid JSON {string}")
    public void postLoginWithValidJSON(String jsonName) {
        File json = new File(Constants.REQ_BODY+"/"+jsonName+"");
        reqresAPI.postLoginUser(json);
    }

    @When("Send request POST Login")
    public void sendRequestPOSTLogin() {
        SerenityRest.when()
                .post(ReqresAPI.POST_LOGIN_USER);
    }

    @And("Response body should be display token {string}")
    public void responseBodyShouldBeDisplayToken(String token) {
        SerenityRest.and()
                .body(ReqresResponses.TOKEN, equalTo(token));
    }


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
