package Tests;


import RequestBuilder.WeatherStationRequestBuilder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static RequestBuilder.WeatherStationRequestBuilder.stationID;
import static org.hamcrest.Matchers.equalTo;

public class APITests {


    @Test
    public void registerWeatherStationTests() {
        WeatherStationRequestBuilder.registerWeatherStationResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(201);
    }

    @Test(priority = 1)
    public void retrieveWeatherStationInfoTest() {
        WeatherStationRequestBuilder.retrieveWeatherStationInfoResponse(String.valueOf(stationID))
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }

    @Test(priority = 2)
    public void updateWeatherStationInfoTest() {
        WeatherStationRequestBuilder.updateWeatherStationInfoResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200);
    }

    @Test(priority = 3)
    public void removeWeatherStationTest(){
        WeatherStationRequestBuilder.removeWeatherStationResponse()
                .then()
                .log().all()
                .assertThat()
                .statusCode(204);
    }

    @Test(priority = 4)
    public void registerWeatherStationWithoutExternalIdTests() {
        WeatherStationRequestBuilder.registerWeatherStationWithoutExternalId()
                .then()
                .log().all()
                .assertThat()
                .statusCode(400);
    }

        @Test(priority= 5)
        public void registerWeatherStationWithoutNameTests() {
            WeatherStationRequestBuilder.registerWeatherStationWithoutName()
                    .then()
                    .log().all()
                    .assertThat()
                    .statusCode(400);
        }
}
