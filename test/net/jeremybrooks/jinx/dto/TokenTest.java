package net.jeremybrooks.jinx.dto;

import net.jeremybrooks.jinx.Jinx;
import net.jeremybrooks.jinx.Setup;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * User: Wursteisen David
 * Date: 22/11/11
 * Time: 22:50
 */
public class TokenTest {

    @BeforeClass
    public static void setUpTest() throws Exception {
        Setup.doSetup();
    }


    @Test
    public void serialize() throws IOException {
        Token token = Jinx.getInstance().getToken();
        String result = token.serialize();
        assertNotNull(result);

        Token newToken = new Token();
        newToken.load(result);

        assertEquals(newToken.getFullname(), token.getFullname());
        assertEquals(newToken.getNsid(), token.getNsid());
    }
}
