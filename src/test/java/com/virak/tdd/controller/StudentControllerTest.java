package com.virak.tdd.controller;

import com.virak.tdd.TddApplication;
import com.virak.tdd.domain.Course;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = TddApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentControllerTest {
    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testRetrieveStudentCourse() throws JSONException {

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/students/Student1/courses/Course1"),
                HttpMethod.GET, entity, String.class);

        String expected = "{id:Course1,name:Spring,description:10Steps}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void addCourse() {

        Course course = new Course("Course1", "Spring", "10Steps",
                Arrays.asList("Learn Maven", "Import Project", "First Example",
                        "Second Example"));

        HttpEntity<Course> entity = new HttpEntity<Course>(course, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/students/Student1/courses"),
                HttpMethod.POST, entity, String.class);

        String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

        assertTrue(actual.contains("/students/Student1/courses/"));

    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}