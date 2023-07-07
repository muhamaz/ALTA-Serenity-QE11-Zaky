package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class DeleteUserSteps {

    @Steps
    ReqresAPI reqresAPI;

    @Given("DELETE User with id {int}")
    public void deleteUserWithId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send request DELETE User")
    public void sendRequestDELETEUser() {
        SerenityRest.when()
                .delete(ReqresAPI.DELETE_USER);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);
    }
}
