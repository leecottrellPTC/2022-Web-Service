package com.leecottrell;
import java.io.*;
import java.nio.charset.*;
import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;
import org.apache.tomcat.util.codec.binary.Base64;


public class App 
{
    public static String buildAuth(String username, String password){
        String authHeader="";
        String temp = username + ":" + password;
        byte[] encoded =
            Base64.encodeBase64(temp.getBytes(Charset.forName("US-ASCII")));
        authHeader = "Basic " + new String(encoded);
        return authHeader;
    }

    final static CloseableHttpClient httpClient = HttpClients.createDefault();
    public static void getClient(){
        HttpGet request = new HttpGet("http://localhost:8080");
        String auth = buildAuth("lee", "hello");

        request.addHeader(HttpHeaders.AUTHORIZATION, auth);
        try{
            CloseableHttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            //do something with the response
            if(response.getStatusLine().getStatusCode() == 200){
                System.out.println("You are logged in!");
                //client logic here
            }
            else{
                System.out.println("You are not logged in, police are coming");
            }

            System.out.println(EntityUtils.toString(entity));
        }
        catch(Exception ex){
            System.out.println("IO Exception " + ex.toString());
        }
    }
    public static void main( String[] args )
    {
       getClient();
    }
}
