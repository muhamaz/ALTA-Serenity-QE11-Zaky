package starter.stepdef;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class PostRegisterUnsuccessfullySteps {

    @Steps
    ReqresAPI reqresAPI;

    @Given("POST Register user with invalid JSON {string}")
    public void postRegisterUserWithInvalidJSON(String jsonName) {
        File json = new File(Constants.REQ_BODY + "/"+jsonName+"");
        reqresAPI.postRegisterUser(json);
    }
}
