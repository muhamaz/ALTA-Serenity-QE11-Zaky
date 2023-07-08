package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class GetListResourceSteps {

    @Steps
    ReqresAPI reqresAPI;
    @Given("GET list Resource with valid parameter page {int}")
    public void getListResourceWithValidParameterPage(int numPage) {
        reqresAPI.getListResource(numPage);
    }

    @When("Send request GET list Resource")
    public void sendRequestGETListResource() {
        SerenityRest.when()
                .get(ReqresAPI.GET_LIST_RESOURCE);
    }
}
