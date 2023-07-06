package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;

import static org.hamcrest.Matchers.equalTo;

public class GetSingleUserSteps {

    @Steps
    ReqresAPI reqresAPI;


    /**
     * GET Single User with valid user id
     */
    @Given("GET Single user with user id {int}")
    public void getSingleUserWithValidUserId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @When("Send request GET Single user")
    public void sendRequestGETSingleUser() {
        SerenityRest.when()
                .get(ReqresAPI.GET_SINGLE_USER);
    }

    @And("Response body user id should be {int}")
    public void responseBodyUserIdShouldBe(int id) {
        SerenityRest.and()
                .body(ReqresResponses.USER_ID, equalTo(id));
    }

    /**
     * GET Single user with invalid user id
     */
    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);
    }

}
