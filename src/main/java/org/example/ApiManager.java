package org.example;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ApiManager {

    public String getJokeByApi(String category){
        try {
            HttpResponse<String> response = Unirest.get("https://v2.jokeapi.dev/joke/" + category + "?format=txt")
                    .asString();
            return response.getBody();
        } catch (UnirestException e) {
            throw new RuntimeException("Error fetching joke from JokeAPI", e);
        }
    }

    public String getMathApi(String category) {
        try {
            HttpResponse<String> response = Unirest.get("http://numbersapi.com/random/" + category)
                    .asString();
            return response.getBody();
        } catch (UnirestException e) {
            throw new RuntimeException("Error fetching math fact from NumbersAPI", e);
        }
    }

    public String getFactApi(){
        try {
            HttpResponse<String> response = Unirest.get("https://catfact.ninja/fact")
                    .asString();
            return response.getBody();
        } catch (UnirestException e) {
            throw new RuntimeException("Error fetching cat fact from Cat Fact API", e);
        }
    }
}
