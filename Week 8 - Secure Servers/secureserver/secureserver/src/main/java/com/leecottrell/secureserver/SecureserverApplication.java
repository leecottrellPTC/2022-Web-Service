package com.leecottrell.secureserver;

//import java.util.*;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class SecureserverApplication {

@RequestMapping(value="/", method=RequestMethod.GET)
public ResponseEntity<String> login(@RequestHeader("Authorization") String auth){


	String userPass = auth.substring(6);
	byte[] decryptArray = Base64.decodeBase64(userPass);
	String decString = new String(decryptArray);
	int colon = decString.indexOf(":");
	String userName = decString.substring(0, colon);
	String password = decString.substring(colon+1);

	if(userName.equalsIgnoreCase("Lee") && password.equals("hello")){
		//do your logic here
		return new ResponseEntity<String>("Welcome " + userName, 
			HttpStatus.OK);
	}
	else{
		return new ResponseEntity<String>("Not Authenticated", 
			HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
	}
}

	public static void main(String[] args) {
		SpringApplication.run(SecureserverApplication.class, args);
	}

}
