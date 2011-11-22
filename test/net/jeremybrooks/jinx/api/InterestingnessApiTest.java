package net.jeremybrooks.jinx.api;

import net.jeremybrooks.jinx.JinxUtils;
import net.jeremybrooks.jinx.Setup;
import net.jeremybrooks.jinx.dto.Photos;
import org.junit.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author jeremyb
 */
public class InterestingnessApiTest {

    private InterestingnessApi instance;

    public InterestingnessApiTest() {
    }


    @BeforeClass
    public static void setUpClass() throws Exception {
        Setup.doSetup();
    }


    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        instance = InterestingnessApi.getInstance();
    }

    @After
    public void tearDown() {
    }


    /**
     * Test of getInstance method, of class InterestingnessApi.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        InterestingnessApi result = InterestingnessApi.getInstance();
        assertNotNull(result);
    }


    /**
     * Test of getList method, of class InterestingnessApi.
     */
    @Test
    public void testGetList_0args() throws Exception {
        System.out.println("getList");
        Photos result = instance.getList();
        assertNotNull(result);
        assertTrue(result.getPhotos().size() > 0);
    }


    /**
     * Test of getList method, of class InterestingnessApi.
     */
    @Test
    public void testGetList_4args() throws Exception {
        System.out.println("getList");
        Date date = null;
        List<String> extras = null;
        int page = 0;
        int perPage = 10;
        Photos result = instance.getList(date, extras, page, perPage);
        assertNotNull(result);
        assertEquals(10, result.getPhotos().size());

        date = JinxUtils.parseMySqlDatetimeToDate("2011-01-01 00:00:00");
        result = instance.getList(date, extras, page, perPage);
        assertNotNull(result);
        assertEquals(10, result.getPhotos().size());
    }


    @Test
    public void testGetList_withEnumsAsArgs() throws Exception {
        Photos photos = instance.getList(null, 0, 4, FlickrExtra.URL_M, FlickrExtra.DATE_TAKEN);
        assertNotNull(photos);
        assertEquals(4, photos.getPhotos().size());
    }


    @Test
    public void testGetList_withListAsArgs() throws Exception {
        Photos photos = instance.getList(null, 0, 4, Arrays.asList(FlickrExtra.URL_M, FlickrExtra.DATE_TAKEN));
        assertNotNull(photos);
        assertEquals(4, photos.getPhotos().size());
    }

}