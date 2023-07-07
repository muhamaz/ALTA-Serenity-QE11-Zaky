package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class PutUpdateUserSteps {

    @Steps
    ReqresAPI reqresAPI;

    @Given("PUT Update User with id {int} and json {string}")
    public void putUpdateUserWithIdAndJson(int id, String jsonName) {
        File json = new File(Constants.REQ_BODY + "/"+jsonName+"");
        reqresAPI.putUpdateUser(id, json);
    }

    @When("Send request PUT Update User")
    public void sendRequestPUTUpdateUser() {
        SerenityRest.when()
                .put(ReqresAPI.PUT_UPDATE_USER);
    }
}
