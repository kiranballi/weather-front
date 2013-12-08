package expedia.weatherfront.controller;

import expedia.weatherfront.bean.Temperature;
import expedia.weatherfront.service.bean.Weather;
import expedia.weatherfront.service.WeatherService;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WeatherFrontController {

    @Autowired
    WeatherService service;
    @Autowired
    ZipValidator validator;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String showQueryForm(Model model) {
        return "query";
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public @ResponseBody Object processQuery(@RequestParam String zip, HttpServletResponse response) {

        String errorMsg = validator.validate(zip);
        if (StringUtils.isEmpty(errorMsg)) {
            Weather weather = service.getWeather(zip);
            if (weather.response.error == null) {
                return new Temperature(weather);
            } else {
                return getErrorMsg(response, weather.response.error.description);
            }
        } else {
            return getErrorMsg(response, errorMsg);
        }
    }
    
    private String getErrorMsg(HttpServletResponse response, String errorMsg) {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return errorMsg;
    }
}

