package expedia.weatherfront.service;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    
    private static final String KEY = "ed044d75b91fb500";
    
    Weather getWeather(String zipCode) {
        RestTemplate template = new RestTemplate();
        template.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        
        Weather weather = template.getForObject("http://api.wunderground.com/api/"+KEY+
                "/conditions/q/"+zipCode+".json", 
                Weather.class);        
        return weather;
    }    
}
