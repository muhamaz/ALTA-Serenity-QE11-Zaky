package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class GetSingleResourceSteps {

    @Steps
    ReqresAPI reqresAPI;
    @Given("GET Single Resource with valid parameter id {int}")
    public void getSingleResourceWithValidParameterId(int id) {
        reqresAPI.getSingleResource(id);
    }

    @When("Send request GET Single Resource")
    public void sendRequestGETSingleResource() {
        SerenityRest.when()
                .get(ReqresAPI.GET_SINGLE_RESOURCE);
    }
}
