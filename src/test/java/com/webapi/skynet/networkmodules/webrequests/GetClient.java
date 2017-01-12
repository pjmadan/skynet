package com.webapi.skynet.networkmodules.webrequests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by pmadan on 12/25/16.
 */
public class GetClient {


    public GetClient(String uri) {
        try {

            URL url = new URL(uri);


        } catch (MalformedURLException e) {

            e.printStackTrace();

        }
    }

    public void connect(URL url, String requestType)
    {
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(requestType);
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();
        }
        catch (IOException e) {

            e.printStackTrace();

        }
    }
}
