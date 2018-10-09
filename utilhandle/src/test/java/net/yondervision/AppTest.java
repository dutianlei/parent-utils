package net.yondervision;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testUtils()
    {
        String str = "asbcccksjrew";
        String substring = StringUtils.substring(str, -20);
        System.out.println(substring);


    }
}
