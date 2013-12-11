package expedia.weatherfront.service;

import expedia.weatherfront.service.bean.Weather;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class WeatherServiceTest {
    
    private WeatherService weatherService;
        
    @Before
    public void setup() {
        weatherService = new WeatherService();
    }
    
    @Test
    public void getWeatherValid() {
        Weather weather = weatherService.getWeather("94117");
        assertEquals("San Francisco", weather.current_observation.display_location.city);
        assertEquals("California", weather.current_observation.display_location.state_name);
        assertNotNull(weather.current_observation.temp_f);
    }        

    @Test
    public void getWeatherInvalid() {
        Weather weather = weatherService.getWeather("33333");
        assertNull(weather.current_observation);
        assertEquals("querynotfound", weather.response.error.type);
        assertEquals("No cities match your search query", weather.response.error.description);
    }    

    @Test
    public void getWeatherInvalidFormat() {
        Weather weather = weatherService.getWeather("865");
        assertNull(weather.current_observation);
        assertEquals("querynotfound", weather.response.error.type);
        assertEquals("No cities match your search query", weather.response.error.description);
    }    
}
