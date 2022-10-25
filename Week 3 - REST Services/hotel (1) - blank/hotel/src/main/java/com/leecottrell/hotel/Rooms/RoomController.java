package com.leecottrell.hotel.Rooms;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class RoomController {
    static Map<Integer, Room> reservations = new HashMap();
    public RoomController(){
        Room res = new Room();
        res.setRoomNum(603);
        res.setGuest("Lee Cottrell");
        reservations.put(603, res);

        Room res2 = new Room();
        res2.setRoomNum(602);
        res2.setGuest("Frank Schurter");
        reservations.put(602, res2);
    }    

    @RequestMapping(value="/rooms", method=RequestMethod.GET)
    public ResponseEntity<List<Room>> getReservations(){
        Collection<Room> results = reservations.values();
        List response = new ArrayList<>(results);

        return new ResponseEntity<List<Room>>(response, HttpStatus.OK);
    }

    @RequestMapping(value="/rooms", method=RequestMethod.POST)
    public ResponseEntity<Room> postReservation(){
        Room response = new Room(0, "empty");

        return new ResponseEntity<Room>(response, HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(value="/rooms", method=RequestMethod.PUT)
    public ResponseEntity<Room> putReservation(){
        Room response = new Room(0, "empty");

        return new ResponseEntity<Room>(response, HttpStatus.NOT_IMPLEMENTED);
    }

    @RequestMapping(value="/rooms", method=RequestMethod.DELETE)
    public ResponseEntity<Room> deleteReservation(){
        Room response = new Room(0, "empty");

        return new ResponseEntity<Room>(response, HttpStatus.NOT_IMPLEMENTED);
    }
}
