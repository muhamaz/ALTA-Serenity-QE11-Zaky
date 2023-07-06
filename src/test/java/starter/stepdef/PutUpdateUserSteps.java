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

    @Given("PUT Update User with valid id {int} and json")
    public void putUpdateUserWithValidIdAndJson(int id) {
        File json = new File(Constants.REQ_BODY + "/Updateuser.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @When("Send request PUT Update User")
    public void sendRequestPUTUpdateUser() {
        SerenityRest.when()
                .put(ReqresAPI.PUT_UPDATE_USER);
    }
}
