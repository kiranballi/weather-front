package expedia.weatherfront.service.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather implements Serializable{
    public Response response;
    public Observation current_observation;       
}
