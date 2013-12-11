package expedia.weatherfront.validator;

import java.util.ResourceBundle;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ZipValidator {

    private ResourceBundle messages = ResourceBundle.getBundle("messages");
    
    public String validate(String zip) {
        String msg = null;
        if(StringUtils.isEmpty(zip)) {
            msg = messages.getString("zip.empty");
        } else if (zip.length() != 5){
            msg = messages.getString("zip.invalid_format");
        }        
        return msg;
    }
}
