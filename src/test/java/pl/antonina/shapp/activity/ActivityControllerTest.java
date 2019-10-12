package pl.antonina.shapp.activity;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class ActivityControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    @Test
    public void test1() {
        given()
                .when()
                .get("/api/activities/")
                .then()
                .log().ifValidationFails()
                .statusCode(OK.value());
    }

    @Test
    public void test2() {
        given()
                .contentType(ContentType.JSON)
                .body("{ \"usersId\" : [] }")
                .when()
                .post("/api/activities/")
                .then()
                .log().ifValidationFails()
                .statusCode(OK.value());
    }
}