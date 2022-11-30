package com.leecottrell.testsports.testsports.sports;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
public class SportController {
    @RequestMapping(value="/sports", method = RequestMethod.GET)
    public ResponseEntity<Sport> sportIngo(@RequestParam String sportName){
        Sport aSport = new Sport();

        //aSport.setTeamName("Riverhounds");

        switch(sportName){
            case "soccer":
                aSport.setSportName(sportName);
                aSport.setTeamName("Riverhounds");
                aSport.setStadium("Highmark Stadium");
                break;
            case "football":
                aSport.setSportName(sportName);
                aSport.setTeamName("Steelers");
                aSport.setStadium("Acrisure Stadium");
                break;
            default:
                aSport.setSportName(sportName);
                aSport.setStadium("");
                aSport.setTeamName("");
                return new ResponseEntity<Sport>(aSport, HttpStatus.NOT_FOUND);
                //break;
        }

        return new ResponseEntity<Sport>(aSport, HttpStatus.OK);
    }
}
