package RequestBuilder;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static Common.Base.base;
import static PayloadBuilder.WeatherStationPayloadBuilder.registerWeatherStationPayload;
import static io.restassured.RestAssured.put;
import static org.apache.http.client.methods.RequestBuilder.post;

public class WeatherStationRequestBuilder {

    public static String apikey = "b99b1476794c2ba7182c8da3370d9686";
     public static String stationID;



    public static Response registerWeatherStationResponse(){

        Response response = RestAssured.given()
                .baseUri(base)
                .basePath("/data/3.0/stations")
                .queryParam( "appid", apikey)
                .contentType(ContentType.JSON)
                .log().all()
                .body(registerWeatherStationPayload("SK_Test110","AyandaSK Weather Station",38.78,-123.44,151))
                .post()
                .then()
                .extract().response();
        stationID= response.jsonPath().getString("ID");

        return response;

    }


    public static Response retrieveWeatherStationInfoResponse(String stationID){

        return RestAssured.given()
                .baseUri(base)
                .basePath("/data/3.0/stations/"+stationID)
                .queryParam("appid",apikey)
                .contentType(ContentType.JSON)
                .log().all()
                .get()
                .then()
                .extract().response();
    }


    public static Response updateWeatherStationInfoResponse(){

        return RestAssured.given()
                .baseUri(base)
                .basePath("/data/3.0/stations/"+stationID )
                .queryParam("appid", apikey)
                .contentType(ContentType.JSON)
                .log().all()
                .body(registerWeatherStationPayload("SK_Test110","AyandaSK Weather Station",37.78,-122.47,142))
                .put()
                .then()
                .extract().response();
    }

    public static Response removeWeatherStationResponse(){

        return RestAssured.given()
                .baseUri(base)
                .basePath("/data/3.0/stations/"+stationID)
                .queryParam( "appid", apikey)
                .contentType(ContentType.JSON)
                .log().all()
                .delete()
                .then()
                .extract().response();
    }

    public static Response registerWeatherStationWithoutExternalId(){

        Response response = RestAssured.given()
                .baseUri(base)
                .basePath("/data/3.0/stations")
                .queryParam( "appid", apikey)
                .contentType(ContentType.JSON)
                .log().all()
                .body(registerWeatherStationPayload("","AyandaSK Weather Station",38.78,-123.44,151))
                .post()
                .then()
                .extract().response();

        stationID = response.jsonPath().getString("ID");
        return response;
    }

    public static Response registerWeatherStationWithoutName() {

        Response response = RestAssured.given()
                .baseUri(base)
                .basePath("/data/3.0/stations")
                .queryParam("appid", apikey)
                .contentType(ContentType.JSON)
                .log().all()
                .body(registerWeatherStationPayload("SK_Test110", "", 38.78, -123.44, 151))
                .post()
                .then()
                .extract().response();
        stationID= response.jsonPath().getString("ID");
        return response;
    }
}
