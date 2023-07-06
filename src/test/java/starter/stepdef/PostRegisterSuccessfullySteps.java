package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class PostRegisterSuccessfullySteps {
    @Given("POST Register user with valid JSON {string}")
    public void postRegisterUserWithValidJSON(String arg0) {
    }

    @When("Send request POST Register user")
    public void sendRequestPOSTRegisterUser() {
    }

    @And("Response body id was {string} and token was {string}")
    public void responseBodyIdWasAndTokenWas(String arg0, String arg1) {
    }
}
