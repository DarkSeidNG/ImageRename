package image_rename;

import image_rename.controllers.MainController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HttpRequestTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MainController mainController;

    @Test
    public void mainControllerLoads() throws Exception {
        assertThat(mainController).isNotNull();
    }

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/api/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("hello alien!")));
    }
}
