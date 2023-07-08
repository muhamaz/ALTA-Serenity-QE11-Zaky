package starter.reqres;


import io.restassured.http.ContentType;
import jnr.posix.windows.SystemTime;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ReqresAPI {
    public static String GET_LIST_USERS = Constants.BASE_URL + "/api/users?page={numPage}";
    public static String GET_LIST_RESOURCE = Constants.BASE_URL + "/api/unknown?page={numPage}";
    public static String GET_DELAYED_RESPONSE = Constants.BASE_URL + "/api/users?delay={time}";
    public static String POST_CREATE_USER = Constants.BASE_URL + "/api/users";
    public static String GET_SINGLE_USER = Constants.BASE_URL + "/api/users/{id}";
    public static String POST_LOGIN_USER = Constants.BASE_URL + "/api/login";
    public static String PUT_UPDATE_USER = Constants.BASE_URL + "/api/users/{id}";
    public static String DELETE_USER = Constants.BASE_URL + "/api/users/{id}";
    public static String POST_REGISTER_USER = Constants.BASE_URL + "/api/register";

    @Step("GET list users")
    public void getListUsers(int numPage){
        SerenityRest.given()
                .pathParam("numPage", numPage);
    }

    @Step("")
    public void getListResource(int numpage){
        SerenityRest.given()
                .pathParam("numPage", numpage);
    }

    @Step("GET Single User")
    public void getSingleUser(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step
    public void getDelayedResponse(int delay){
        SerenityRest.given()
                .pathParam("time", delay);
    }

    @Step("POST Create new user")
    public void postCreateNewUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON).body(json);
    }

    @Step("POST Register User")
    public void postRegisterUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON).body(json);
    }

    @Step("POST Login User")
    public void postLoginUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON).body(json);
    }

    @Step("PUT Update User")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("DELETE User")
    public void deleteUser(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }


}
