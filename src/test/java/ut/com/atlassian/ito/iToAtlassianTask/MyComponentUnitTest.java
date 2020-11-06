package ut.com.atlassian.ito.iToAtlassianTask;

import org.junit.Test;
import com.atlassian.ito.iToAtlassianTask.api.MyPluginComponent;
import com.atlassian.ito.iToAtlassianTask.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}