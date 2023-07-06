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

public class PostLoginSuccessfullySteps {

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


}
