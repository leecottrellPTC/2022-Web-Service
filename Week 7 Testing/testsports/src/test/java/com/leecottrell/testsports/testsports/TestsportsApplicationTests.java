package com.leecottrell.testsports.testsports;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class TestsportsApplicationTests {

	private static int port=8080;
	private static URL base;
	private TestRestTemplate template;


	@BeforeAll
	public static void setup() throws MalformedURLException {
		base = new URL("http://localhost:" + port + "/sports");
	}

	@Test
	public void testSoccerTeam() throws Exception{
		template = new TestRestTemplate();
		base = new URL(base.toString() + "?sportName=soccer");

		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
		String body = response.getBody();

		ObjectMapper mapper = new ObjectMapper();
		Sport sportJson = mapper.readValue(body, Sport.class);

		assertEquals(sportJson.getTeamName(), "Riverhounds", 
			"Soccer team name fails");
	}

	public void testSoccerStadium() throws Exception{
		template = new TestRestTemplate();
		base = new URL(base.toString() + "?sportName=soccer");

		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
		String body = response.getBody();

		ObjectMapper mapper = new ObjectMapper();
		Sport sportJson = mapper.readValue(body, Sport.class);

		assertEquals(sportJson.getStadium(), "Highmark Stadium", 
			"Soccer team name fails");
	}

}
