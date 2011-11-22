package net.jeremybrooks.jinx;


import net.jeremybrooks.jinx.dto.Token;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class is used to set up the Flickr auth token and key/secret for
 * test cases.
 * <p/>
 * Test cases should call Setup.doSetup() in the setUpClass method.
 *
 * @author jeremyb
 */
public class Setup {


    public static void doSetup() throws Exception {
        Properties p = new Properties();
        InputStream in = Setup.class.getResourceAsStream("/net/jeremybrooks/jinx/secret.properties");
        p.load(in);

        String pathToTokenFile = p.getProperty("flickr.tokenfile");
        String key = p.getProperty("flickr.api_key");
        String secret = p.getProperty("flickr.secret");
        Token t = new Token();
        File file = new File(pathToTokenFile);
        t.load(file);

        Jinx jinx = Jinx.getInstance();
        jinx.init(key, secret, t);
    }
}
