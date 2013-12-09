package expedia.weatherfront.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:/application-context.xml")
public class WeatherFrontControllerTest {
 

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void showQueryForm() throws Exception {
        mockMvc.perform(get("/query").accept(MediaType.TEXT_HTML))
          .andExpect(status().isOk());
    }

    @Test
    public void processValidQuery() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/query");
        request.param("zip", "94117");
        mockMvc.perform(request.accept(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void processInvalidQuery() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/query");
        request.param("zip", "111");
        mockMvc.perform(request.accept(MediaType.APPLICATION_JSON))
          .andExpect(status().isBadRequest())
          .andExpect(content().contentType("application/json;charset=UTF-8"));
    }
}