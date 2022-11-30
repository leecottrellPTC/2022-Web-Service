package com.leecottrell.hotelclient;

import java.util.*;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App 
{
    public final static CloseableHttpClient httpClient =
                    HttpClients.createDefault();

                    /*
                     * build a request
                     * connect
                     * get the response
                     * do something with the response
                     */
    public static void simpleGet() throws Exception{
        HttpGet request = new HttpGet("http://localhost:8080/rooms");

        CloseableHttpResponse response = httpClient.execute(request);
        HttpEntity entiy = response.getEntity();
       // System.out.println(EntityUtils.toString(entiy));

        //assumes that the connection works
        if(response.getStatusLine().getStatusCode() != 200){
            System.out.println("COnnection failed!! " + response.getStatusLine().getStatusCode());
            return;
        }

       ObjectMapper mapper = new ObjectMapper();
       List<Room> roomLit = new ArrayList<Room>();
      
       roomLit = mapper.readValue(EntityUtils.toString(entiy), 
        new TypeReference<List<Room>>() {
            
        });
        for(Room room: roomLit){
            System.out.println(room.getGuest() + " in " + room.getRoomNum());
        }

    }//end simpleGet

    public static void postRoom() throws Exception{
        //use JSON to send data
        HttpPost request = new HttpPost("http://localhost:8080/rooms");
        Room newRes = new Room(400, "Kate Elizabeth Upton");
        ObjectMapper mapper = new ObjectMapper();
        StringEntity json = new StringEntity(mapper.writeValueAsString(newRes),
            ContentType.APPLICATION_JSON);
        request.setEntity(json);

        CloseableHttpResponse response = httpClient.execute(request);
        if(response.getStatusLine().getStatusCode() != 200){
            System.out.println(newRes.getGuest() + " is not added");
        }


    }
    public static void main( String[] args ) throws Exception
    {
        postRoom();
        simpleGet();
    }
}
