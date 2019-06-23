package apis;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ZipCodeApi {

    private static final String ENDPOINT = "http://api.zippopotam.us/us/";

    private String zipCode;
    private Response response;

    public ZipCodeApi(String zipCode){
        setZipCode(zipCode);
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Response get(){
        response = given().get(ENDPOINT + zipCode);
        return response;
    }

    public int getStatusCode(){
        return response == null ? null : response.getStatusCode();
    }

    public String getBody(){
        return response == null ? null : response.body().prettyPrint();
    }

    public String getHeaders(){
        return response == null ? null : response.headers().toString();
    }

    public String getFullResponse(){
        return getFullResponse(false);
    }

    public String getFullResponse(boolean maskDynamicContent){
        String response = getHeaders() + "\n\n" + getBody();

        if(maskDynamicContent){
            response = response.replaceAll("Date=.*", "#####DATE");
            response = response.replaceAll("Set-Cookie=.*", "#####COOKIE");
            response = response.replaceAll("CF-RAY=.*", "#####CF-RAY");
        }

        return response;
    }
}
