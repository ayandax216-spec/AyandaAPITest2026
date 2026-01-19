package PayloadBuilder;


import org.json.simple.JSONObject;

public class WeatherStationPayloadBuilder {


    public static JSONObject registerWeatherStationPayload(String external_id, String name, double latitude, double longitude, Integer altitude){
        JSONObject registerWeatherStation = new JSONObject();
        registerWeatherStation.put("external_id",external_id);
        registerWeatherStation.put("name",name);
        registerWeatherStation.put("latitude",latitude);
        registerWeatherStation.put("longitude",longitude);
        registerWeatherStation.put("altitude",altitude);

        return registerWeatherStation;
    }


}
