package com.webapi.skynet.networkmodules.webrequests;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by pmadan on 12/25/16.
 */
public class PostClient {
    String string = "";

    public void PostClient() {
        try

        {
            InputStream inputStream = null;
            inputStream = new FileInputStream("/Users/<username>/Documents/CrunchifyJSON.txt");
            InputStreamReader crunchifyReader = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(crunchifyReader);
            String line;

            while ((line = br.readLine()) != null) {
                string += line + "\n";
            }


            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(string);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            System.out.println(jsonObject);

            // Step2: Now pass JSON File Data to REST Service
            try {
                URL url = new URL("http://localhost:8080/CrunchifyTutorials/api/crunchifyService");
                URLConnection connection = url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                out.write(jsonObject.toString());
                out.close();

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                while (in.readLine() != null) {
                }
                System.out.println("\nREST Service Invoked Successfully..");
                in.close();
            } catch (Exception e) {
                System.out.println("\nError while calling  REST Service");
                System.out.println(e);
            }

            br.close();
        } catch (FileNotFoundException e1)

        {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void postdata(){

    }
}

