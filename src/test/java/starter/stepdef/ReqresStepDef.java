package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;


public class ReqresStepDef {

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
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body page value should be {int}")
    public void responseBodyPageValueShouldBe(int numPage) {
        SerenityRest.and().body(ReqresResponses.PAGE, equalTo(numPage));
    }

    /**
     * GET Single User with valid user id
     */
    @Given("GET Single user with valid user id {int}")
    public void getSingleUserWithValidUserId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @When("Send request GET Single user")
    public void sendRequestGETSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
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
        SerenityRest.then().statusCode(statusCode);
    }

    /**
     * POST Create New User
     */
    @Given("POST Create user with valid JSON")
    public void postCreateUserWithValidJSON() {
        File json = new File(Constants.REQ_BODY + "/User.json");
        reqresAPI.postCreateNewUser(json);
    }

    @When("Send request POST create user")
    public void sendRequestPOSTCreateUser() {
        SerenityRest.when()
                .post(ReqresAPI.POST_CREATE_USER);
    }

    @Then("Response status code should be {int} created")
    public void responseStatusCodeShouldBeCreated(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body name was {string} and job was {string}")
    public void responseBodyNameWasAndJobWas(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job));
    }

    /**
     * POST LOGIN USER
     */

    @Given("POST Login with valid JSON")
    public void postLoginWithValidJSON() {
        File json = new File(Constants.REQ_BODY+"/ValidLogin.json");
        reqresAPI.postLoginValidUser(json);
    }

    @When("Send request POST Login")
    public void sendRequestPOSTLogin() {
        SerenityRest.when()
                .post(ReqresAPI.POST_LOGIN_USER);
    }

    @And("Response body should be display token {string}")
    public void responseBodyShouldBeDisplayToken(String token) {
        SerenityRest.and()
                .body(ReqresResponses.TOKEN, equalTo(token));
    }

    @Given("POST Login with invalid email {string} and password {string}")
    public void postLoginWithInvalidEmailAndPassword(String email, String password) {
        reqresAPI.postLoginInvalidUser(email, password);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int statusCode) {
        SerenityRest.then().statusCode(statusCode);

    }

    @And("Response body should be display error {string}")
    public void responseBodyShouldBeDisplayError(String errorMsg) {
        SerenityRest.and()
                .body(ReqresResponses.ERROR_MESSAGE, equalTo(errorMsg));
    }

}