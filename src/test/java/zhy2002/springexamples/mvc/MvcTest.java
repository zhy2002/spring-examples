package zhy2002.springexamples.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Test a controller.
 */
@WebAppConfiguration
@ContextConfiguration("classpath:mvctest/springMvcConfig.xml")
public class MvcTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeMethod
    public void beforeMethod(){

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getActionShouldWork() throws Exception{

        //action
        ResultActions resultActions = mockMvc.perform(get("/hello/{name}", "Jane"));

        //assertion
        resultActions.andExpect(status().isOk());
        resultActions.andExpect(model().attribute("name", "Jane"));

    }

    @Test
    public void postActionShouldWork() throws Exception{

        //action
        ResultActions resultActions = mockMvc.perform(post("/accessSecret").param("username", "Ned").param("password", "Stark"));

        //assertion
        resultActions.andExpect(status().isOk());
        resultActions.andExpect(model().attribute("secret", "Revealed"));
    }
}
