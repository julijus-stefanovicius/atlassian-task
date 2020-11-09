package com.atlassian.ito.rest;

import com.atlassian.plugins.rest.common.security.AnonymousAllowed;

import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


/**
 * A resource of message.
 */
@Path("/artists")
public class iTunesREST {

    @GET
    @AnonymousAllowed
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMessage(@QueryParam("name") String key) throws IOException {

        //requesto parsinimo sprendimas nr1
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("https://itunes.apple.com/search?entity=allArtist&term="+key);
        HttpResponse response = client.execute(request);

        BufferedReader rd = new BufferedReader
                (new InputStreamReader(
                        response.getEntity().getContent()));

        String line = "";
        StringBuilder textView = new StringBuilder();
        while ((line = rd.readLine()) != null) {
            textView.append(line);
        }
        System.out.println(textView);

        //requesto parsinimo sprendimas nr2
        URL url = new URL("https://itunes.apple.com/search?entity=allArtist&term="+key);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responsecode = conn.getResponseCode();
        if(responsecode != 200)
        throw new RuntimeException("HttpResponseCode: " +responsecode);
        else
        {
            Scanner sc = new Scanner(url.openStream());
            StringBuilder inline = new StringBuilder();
            while(sc.hasNext())
            {
                inline.append(sc.nextLine());
            }
            System.out.println("JSON:");
            System.out.println(inline);
            sc.close();
        }

        //requesto parsinimo sprendimas nr3
        Client client2 = ClientBuilder.newClient();
        WebTarget resource = client2.target("https://itunes.apple.com/search?entity=allArtist&term"+key);

        Invocation.Builder invocationBuilder = resource.request();
        invocationBuilder.accept(MediaType.APPLICATION_JSON);

        Response response2 = invocationBuilder.get();
        System.out.println(response2.getEntity());
        if (response2.getStatus() == 200) {
            System.out.println(response2.getEntity());
        } else {
            System.out.println("ERROR! " + response2.getStatus());
        }

        //redirection sprendimas
        if(key!=null) {
            return Response.temporaryRedirect(URI.create("https://itunes.apple.com/search?entity=allArtist&term="
                    + key)).build();
        }
        else
            return Response.ok(new iTunesRESTModel("error","Please enter the artist name")).build();
    }

}