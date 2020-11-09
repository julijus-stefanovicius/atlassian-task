package ut.com.atlassian.ito.rest;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import com.atlassian.ito.rest.iTunesREST;
import com.atlassian.ito.rest.iTunesRESTModel;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.GenericEntity;

public class iTunesRESTTest {

    @Before
    public void setup() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void messageIsValid() {
        iTunesREST resource = new iTunesREST();

        //Response response = resource.getMessage("Hello World");
        //final iTunesRESTModel message = (iTunesRESTModel) response.getEntity();

        //assertEquals("wrong message","Hello World",message.getMessage());
    }
}
