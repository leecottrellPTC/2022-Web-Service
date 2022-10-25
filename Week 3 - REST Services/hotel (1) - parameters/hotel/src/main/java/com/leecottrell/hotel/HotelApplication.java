package com.leecottrell.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class HotelApplication {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String getRespond(){
		return "<h1>It works</h1>";
	}



	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}

}
