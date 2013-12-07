package expedia.weatherfront.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    public Response response;
    public Observation current_observation;       
}
