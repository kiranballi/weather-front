package expedia.weatherfront.controller;

import expedia.weatherfront.bean.Temperature;
import expedia.weatherfront.service.bean.Weather;
import expedia.weatherfront.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WeatherFrontController {

    @Autowired
    WeatherService service;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String queryForm(Model model) {
        return "query";
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public @ResponseBody
    Temperature querySubmit(@RequestParam String zip) {
        Weather weather = service.getWeather(zip);
        Temperature temperature = new Temperature(weather);
        return temperature;
    }
}
