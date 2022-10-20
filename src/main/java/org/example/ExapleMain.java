package org.example;

import java.io.IOException;
import java.util.Properties;

import static sun.awt.FontConfiguration.loadProperties;

public class ExampleMain {

    static Properties prop = new Properties();

    public static void main(String[] args)throws IOException {
        loadProperties();
        OkHttpClient client = new OkHttpClient();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(prop.getProperty("BASE_HOST"))
                .addPathSegment(prop.getProperty("FORECAST"))
                .addPathSegment(prop.getProperty("API_VERSION"))
                .addPathSegment(prop.getProperty("FORECAST_TYPE"))
                .addPathSegment(prop.getProperty("FORECAST_PERIOD"))
                .addPathSegment(prop.getProperty("SAINT_PETERSBURG_KEY"))
                .addQueryParameter("apikey",prop.getProperty("API_KEY"))
                .addQueryParameter("Languige","ru-ru")
                .addQueryParameter("metric","true")
                .build();

        System.out.println(url.toString());
        Request requesthttp = new  Request.Builder()
                .addHeader("Accept","application/json")
                .url(url)
                .build();

        String jsonResponse = client.newCall(requesthttp).execute().body().string();
        System.out.println(jsonResponse);








    }
}