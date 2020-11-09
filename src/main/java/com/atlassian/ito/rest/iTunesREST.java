package com.atlassian.ito.rest;

import com.atlassian.plugins.rest.common.security.AnonymousAllowed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;


/**
 * A resource of message.
 */
@Path("/artists")
public class iTunesREST {

    @GET
    @AnonymousAllowed
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMessage(@QueryParam("name") String key) {

        if(key!=null) {
            return Response.temporaryRedirect(URI.create("https://itunes.apple.com/search?entity=allArtist&term="
                    + key)).build();
        }
        else
            return Response.ok(new iTunesRESTModel("error","Please enter the artist name")).build();
    }

}