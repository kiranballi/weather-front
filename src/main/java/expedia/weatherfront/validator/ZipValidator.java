package expedia.weatherfront.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ZipValidator {

    public String validate(String zip) {
        String msg = null;
        if(StringUtils.isEmpty(zip)) {
            msg = "Please fill in ZIP code.";
        } else if (zip.length() != 5){
            msg = "Please enter valid ZIP code.";
        }        
        return msg;
    }
}
