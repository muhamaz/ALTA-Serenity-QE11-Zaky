package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostRegisterSuccessfullySteps {

    @Steps
    ReqresAPI reqresAPI;

    /**
     *
     * REGISTER VALID USER
     */

    @Given("POST Register user with valid JSON {string}")
    public void postRegisterUserWithValidJSON(String jsonName) {
        File json = new File(Constants.REQ_BODY + "/"+jsonName+"");
        reqresAPI.postRegisterUser(json);
    }

    @When("Send request POST Register user")
    public void sendRequestPOSTRegisterUser() {
        SerenityRest.when()
                .post(ReqresAPI.POST_REGISTER_USER);
    }

    @And("Response body id was {int} and token was {string}")
    public void responseBodyIdWasAndTokenWas(int id, String token) {
        SerenityRest.and()
                .body(ReqresResponses.ID, equalTo(id))
                .body(ReqresResponses.TOKEN, equalTo(token));
    }

    /**
     *
     * REGISTER INVALID USER
     */

    @Given("POST Register user with invalid JSON {string}")
    public void postRegisterUserWithInvalidJSON(String jsonName) {
        File json = new File(Constants.REQ_BODY + "/"+jsonName+"");
        reqresAPI.postRegisterUser(json);
    }
}
