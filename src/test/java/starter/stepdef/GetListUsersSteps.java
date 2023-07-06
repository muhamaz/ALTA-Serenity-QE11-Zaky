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

public class GetListUsersSteps {

    @Steps
    ReqresAPI reqresAPI;

    /**
     * GET List User
     */
    @Given("GET list users with valid parameter page {int}")
    public void getListUsersWithValidParameterPage(int numPage) {
        reqresAPI.getListUsers(numPage);
    }

    @When("Send request GET list users")
    public void sendRequestGETListUsers() {
        SerenityRest.when()
                .get(ReqresAPI.GET_LIST_USERS);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);
    }

    @And("Response body page value should be {int}")
    public void responseBodyPageValueShouldBe(int numPage) {
        SerenityRest.and()
                .body(ReqresResponses.PAGE, equalTo(numPage));
    }

}
