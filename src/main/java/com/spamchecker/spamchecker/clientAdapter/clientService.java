package com.spamchecker.spamchecker.clientAdapter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class clientService {
    /**
     * @param email
     * @return 
     * @return
     * @throws InterruptedException
     * @throws IOException
     */
    public ResponseDTO getResponse(String email) throws IOException, InterruptedException{

        String client= "https://mailcheck.p.rapidapi.com/?domain=";
        String uri = client.concat(email);

		HttpRequest request = HttpRequest.newBuilder()
							  .uri(URI.create(uri))
							  .header("X-RapidAPI-Key", "X")
							  .header("X-RapidAPI-Host", "mailcheck.p.rapidapi.com")
							  .method("GET", HttpRequest.BodyPublishers.noBody())
							  .build();
							  
		HttpResponse<String> response = HttpClient.newHttpClient().send(request,HttpResponse.BodyHandlers.ofString());

        Gson g = new Gson();
        ResponseDTO responseDTO = g.fromJson(response.body(), ResponseDTO.class);
        return responseDTO;
    }
}

