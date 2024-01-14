package com.example.letras;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;


public class RAE {
    String baseUrl = "https://dle.rae.es/data/";
    String USER_AGENT = "Cifras y Letras CFNetwork/808.2.16 Darwin/16.3.0";
    String TOKEN = "Basic cDY4MkpnaFMzOmFHZlVkQ2lFNDM0";
    HttpURLConnection httpConnection;
    Gson gson = new Gson();


    public boolean comprobarPalabra(String palabra) throws Exception {
        URL url = new URL(baseUrl + "search?w=" + palabra );
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();

        // Método de solicitud
        httpConnection.setRequestMethod("GET");


        // Añade encabezados de solicitud
        httpConnection.setRequestProperty("User-Agent", USER_AGENT);
        httpConnection.setRequestProperty("Authorization", TOKEN);

        int responseCode = httpConnection.getResponseCode();
        System.out.println("Response Code : " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // Si el código de respuesta es 200 (OK)
            BufferedReader in = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));

            StringBuffer response = new StringBuffer();

            Map<String, Object> map = gson.fromJson(in.readLine(), Map.class);
            double approx = (double) map.get("approx");
            ArrayList res = (ArrayList) map.get("res");

            in.close();

            return approx == 0.0 && res.size() != 0;

        } else {
            throw new Exception("Http Response Error " + httpConnection.getResponseCode());
        }

    }

}
