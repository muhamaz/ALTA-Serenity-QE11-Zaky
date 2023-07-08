package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import starter.reqres.ReqresAPI;

public class GetDelayedResponseSteps {

    @Steps
    ReqresAPI reqresAPI;
    @Given("GET list user with parameter delay {int}")
    public void getListUserWithParameterDelay(int time) {
        reqresAPI.getDelayedResponse(3);
    }

    @When("Send request GET delayed response")
    public void sendRequestGETDelayedResponse() {
        SerenityRest.when()
                .get(ReqresAPI.GET_DELAYED_RESPONSE);
    }

    @And("Response time is {long} milliseconds")
    public void responseTimeIsMilliSeconds(long time) {
        SerenityRest.and()
                .assertThat()
                .time(Matchers.lessThan(time));
    }

}
