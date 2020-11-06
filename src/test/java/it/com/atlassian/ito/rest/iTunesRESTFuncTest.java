package it.com.atlassian.ito.rest;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import com.atlassian.ito.rest.iTunesREST;
import com.atlassian.ito.rest.iTunesRESTModel;
import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;

public class iTunesRESTFuncTest {

    @Before
    public void setup() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void messageIsValid() {

        String baseUrl = System.getProperty("baseurl");
        String resourceUrl = baseUrl + "/rest/itunesrest/1.0/artists";

        RestClient client = new RestClient();
        Resource resource = client.resource(resourceUrl);

        iTunesRESTModel message = resource.get(iTunesRESTModel.class);

        assertEquals("wrong message","Hello World",message.getMessage());
    }
}
