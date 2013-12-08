package expedia.weatherfront.bean;

import expedia.weatherfront.service.bean.Weather;
import java.io.Serializable;

public final class Temperature implements Serializable{
    
    private final String city;
    private final String state;
    private final String temperature;

    public Temperature(Weather weather) {
        city = weather.current_observation.display_location.city;
        state = weather.current_observation.display_location.state_name;
        temperature = weather.current_observation.temp_f;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getTemperature() {
        return temperature;
    }
}
