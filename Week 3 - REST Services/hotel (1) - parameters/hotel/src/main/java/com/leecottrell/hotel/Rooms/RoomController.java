package com.leecottrell.hotel.Rooms;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;

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
    public ResponseEntity<List<Room>> 
        getReservations(@RequestParam(value="roomnum", defaultValue="0")int roomnum){
       // Collection<Room> results = reservations.values();
        List<Room> response = new ArrayList<>();

        switch(roomnum){
            case 0://all reservations in the liswt
                response = new ArrayList<>(reservations.values());
                break;
            default://some room number passed in
                Room found = reservations.get(roomnum);
                if(found == null){
                    response.add(new Room(roomnum, "Room num is empty"));
                    return new ResponseEntity<List<Room>>(response,HttpStatus.NOT_FOUND);
                }
                else{
                    response.add(reservations.get(roomnum));
                }
                break;
        }//end of switch
        return new ResponseEntity<List<Room>>(response, HttpStatus.OK);
        //return new ResponseEntity<List<Room>>(response, HttpStatus.OK);
    }

    @RequestMapping(value="/rooms", method=RequestMethod.POST)
    public ResponseEntity<Room> postReservation(@RequestBody String reservation)
    {
        ObjectMapper mapper = new ObjectMapper();
        Room response = new Room(0, "Error in reservation");
        try{
            response = mapper.readValue(reservation, Room.class);
            reservations.put(response.getRoomNum(), response);
        }
        catch(Exception ex){
            response.setGuest(ex.toString());//send error back for me to fix
            //later clean this up
        }

        return new ResponseEntity<Room>(response, HttpStatus.OK);
    }

    @RequestMapping(value="/rooms", method=RequestMethod.PUT)
    public ResponseEntity<Room> putReservation(@RequestParam(value="roomnum") int roomnum,
        @RequestParam(value="addon") String addon){
        Room response = new Room(0, "empty");

        String origGuest = reservations.get(roomnum).getGuest();
        reservations.get(roomnum).setGuest(origGuest + " and " + addon);
        response = reservations.get(roomnum);

        return new ResponseEntity<Room>(response, HttpStatus.OK);
    }

    @RequestMapping(value="/rooms", method=RequestMethod.DELETE)
    public ResponseEntity<Room> 
        deleteReservation(@RequestParam(value="roomnum") int roomnum){
        Room response = new Room(0, "empty");

        reservations.remove(roomnum);
        response.setRoomNum(roomnum);
        response.setGuest("deleted");

        return new ResponseEntity<Room>(response, HttpStatus.OK);
    }
}
