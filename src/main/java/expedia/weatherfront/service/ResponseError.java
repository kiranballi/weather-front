package expedia.weatherfront.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseError {
    public String type;
    public String description;
}
