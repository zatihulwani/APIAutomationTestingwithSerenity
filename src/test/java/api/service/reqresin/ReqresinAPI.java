package api.service.reqresin;


import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;


public class ReqresinAPI {

    private static final String REQRESIN_BASEURL = "https://reqres.in";


//    public void getListUser() {
//        Response response = SerenityRest.get(REQRESIN_BASEURL + "/api/users?page=2");
//
//        Assert.assertEquals(response.statusCode(), 200);
//    }

//    public void getListUser() {
//        Response response = SerenityRest.get(REQRESIN_BASEURL + "/api/users?page=2");
//        System.out.println(response.statusCode());
//        System.out.println(response.body().prettyPrint());
//    }

    public void getListUser() {
        SerenityRest.get(REQRESIN_BASEURL + "/api/users?page=2");
    }

    public void postLogin() {
        JSONObject bodyJSON = new JSONObject();
        bodyJSON.put("email", "eve.holt@reqres.in");
        bodyJSON.put("password", "cityslicka");

        SerenityRest.given()
                .header("Content-type", "application/json")
                .body(bodyJSON.toString())
                .post(REQRESIN_BASEURL + "/api/login");
    }

    public void postRegister() {
        JSONObject bodyJSON = new JSONObject();
        bodyJSON.put("email", "eve.holt@reqres.in");
        bodyJSON.put("password", "pistol");

        SerenityRest.given()
                .header("Content-type", "application/json")
                .body(bodyJSON.toString())
                .post(REQRESIN_BASEURL + "/api/register");
    }

    public void putUpdate() {
        JSONObject bodyJSON = new JSONObject();
        bodyJSON.put("name", "morpheus");
        bodyJSON.put("job", "zion resident");

        SerenityRest.given()
                .header("Content-type", "application/json")
                .body(bodyJSON.toString())
                .put(REQRESIN_BASEURL + "/api/users/2");
    }


    public void postUnsuccessLogin() {
        JSONObject bodyJSON = new JSONObject();
        bodyJSON.put("email", "peter@klaven");

        SerenityRest.given()
                .header("Content-type", "application/json")
                .body(bodyJSON.toString())
                .post(REQRESIN_BASEURL + "/api/login");
    }

    public void postUnsuccessRegister() {
        JSONObject bodyJSON = new JSONObject();
        bodyJSON.put("email", "sydney@fife");

        SerenityRest.given()
                .header("Content-type", "application/json")
                .body(bodyJSON.toString())
                .post(REQRESIN_BASEURL + "/api/register");
    }

    public void getUserNotFound() {
        SerenityRest.get(REQRESIN_BASEURL + "/api/users/23");
    }

    public void deleteUser() {
        SerenityRest.delete(REQRESIN_BASEURL + "/api/users/2");
    }


}
