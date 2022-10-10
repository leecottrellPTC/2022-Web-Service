package com.leecottrell.zippolecture1;

import org.apache.http.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;

/**
 * Simple Apache HttpClient use
 *
 */
public class App {
    final static CloseableHttpClient httpClient = HttpClients.createDefault();
    public static void main(String[] args) {
        try {
            HttpGet request = new HttpGet("https://api.zippopotam.us/us/15071");
            CloseableHttpResponse response = httpClient.execute(request);

            HttpEntity entity = response.getEntity();
            System.out.println(EntityUtils.toString(entity));
            
        } catch (Exception ex) {
            System.out.println("You have an error, read the error and fix it!");
            System.out.println(ex.toString());
            System.exit(1);
        }
    }
}
