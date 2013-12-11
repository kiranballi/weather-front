package expedia.weatherfront.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

public class ZipValidatorTest {

    private ZipValidator validator;
        
    @Before
    public void setup() {
        validator = new ZipValidator();
    }
    
    @Test
    public void getWeatherValid() {
        String errorMsg = validator.validate("94117");
        assertNull(errorMsg);
    }        

    @Test
    public void getWeatherInvalid() {
        String errorMsg = validator.validate("");
        assertEquals("Please fill in ZIP code.", errorMsg);
    }    

    @Test
    public void getWeatherInvalidFormat() {
        String errorMsg = validator.validate("865");
        assertEquals("Please enter valid ZIP code.", errorMsg);
    }    
    
    
}
