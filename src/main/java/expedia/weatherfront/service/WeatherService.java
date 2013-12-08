package expedia.weatherfront.service;

import expedia.weatherfront.service.bean.Weather;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    
    private static final String KEY = "ed044d75b91fb500";
    
    public Weather getWeather(String zip) {
        RestTemplate template = new RestTemplate();
        template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        
        Weather weather = template.getForObject("http://api.wunderground.com/api/"+KEY+
                "/conditions/q/"+zip+".json", 
                Weather.class);        
        return weather;
    }    
}
