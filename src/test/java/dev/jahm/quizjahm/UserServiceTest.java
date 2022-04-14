package dev.jahm.quizjahm;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.jahm.quizjahm.controller.UserController;
import dev.jahm.quizjahm.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
public class UserServiceTest {

    private MockRestServiceServer mockServer;
    private ObjectMapper mapper = new ObjectMapper();

    @LocalServerPort
    private int port;

    @Autowired
    UserController userController;

    @Autowired
    UserService userService;

    @Autowired
    private TestRestTemplate offlineRestTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @BeforeEach
    public void init() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    void contextLoads() throws Exception {
        assertThat(userController).isNotNull();
    }

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.offlineRestTemplate.getForObject("http://localhost:" + port + "/users/hello",
                String.class)).contains("Hello, World");
    }

    @Test
    public void getAllReturnsUserList() throws Exception {
        Assertions.assertEquals(this.offlineRestTemplate.getForEntity("http://localhost:" + port + "/users",
                String.class).getStatusCode(), HttpStatus.OK);
    }
}
