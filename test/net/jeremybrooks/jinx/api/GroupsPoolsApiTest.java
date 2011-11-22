package net.jeremybrooks.jinx.api;

import net.jeremybrooks.jinx.JinxConstants;
import net.jeremybrooks.jinx.Setup;
import net.jeremybrooks.jinx.dto.Context;
import net.jeremybrooks.jinx.dto.Groups;
import net.jeremybrooks.jinx.dto.Photo;
import net.jeremybrooks.jinx.dto.Photos;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author jeremyb
 */
public class GroupsPoolsApiTest {


    private static final String GROUP = "46824474@N00";
    private static final String PHOTO = "5687715664";
    private static final String CONTEXT_PHOTO = "381471546";
    private static final String CONTEXT_PREV_PHOTO = "377026216";
    private static final String CONTEXT_NEXT_PHOTO = "2635151545";


    public GroupsPoolsApiTest() {
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
    }

    @After
    public void tearDown() {
    }


    /**
     * Test of getInstance method, of class GroupsPoolsApi.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        GroupsPoolsApi result = GroupsPoolsApi.getInstance();
        assertNotNull(result);
    }


    /**
     * Test of add method, of class GroupsPoolsApi.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        GroupsPoolsApi instance = GroupsPoolsApi.getInstance();
        instance.add(PHOTO, GROUP);
    }


    /**
     * Test of getContext method, of class GroupsPoolsApi.
     */
    @Test
    public void testGetContext() throws Exception {
        System.out.println("getContext");
        GroupsPoolsApi instance = GroupsPoolsApi.getInstance();
        Context expResult = null;
        Context result = instance.getContext(CONTEXT_PHOTO, GROUP);
        assertNotNull(result);
        assertNotNull(result.getNextPhoto());
        assertNotNull(result.getPreviousPhoto());
        assertEquals(CONTEXT_NEXT_PHOTO, result.getNextPhoto().getId());
        assertEquals(CONTEXT_PREV_PHOTO, result.getPreviousPhoto().getId());
    }


    /**
     * Test of getGroups method, of class GroupsPoolsApi.
     */
    @Test
    public void testGetGroups_0args() throws Exception {
        System.out.println("getGroups");
        GroupsPoolsApi instance = GroupsPoolsApi.getInstance();
        Groups result = instance.getGroups();
        assertNotNull(result);
        assertTrue(result.getGroups().size() > 0);
    }


    /**
     * Test of getGroups method, of class GroupsPoolsApi.
     */
    @Test
    public void testGetGroups_int_int() throws Exception {
        System.out.println("getGroups");
        int page = 0;
        int perPage = 10;
        GroupsPoolsApi instance = GroupsPoolsApi.getInstance();
        Groups result = instance.getGroups(page, perPage);
        assertNotNull(result);
        assertEquals(perPage, result.getGroups().size());
    }


    /**
     * Test of getPhotos method, of class GroupsPoolsApi.
     */
    @Test
    public void testGetPhotos_String() throws Exception {
        System.out.println("getPhotos");
        GroupsPoolsApi instance = GroupsPoolsApi.getInstance();
        Photos result = instance.getPhotos(GROUP);
        assertNotNull(result);
        assertTrue(result.getPhotos().size() > 0);
        boolean hasPhoto = false;
        for (Photo photo : result.getPhotos()) {
            if (photo.getId().equals(PHOTO)) {
                hasPhoto = true;
            }
        }
        assertTrue(hasPhoto);
    }


    /**
     * Test of getPhotos method, of class GroupsPoolsApi.
     */
    @Test
    public void testGetPhotos_6args() throws Exception {
        System.out.println("getPhotos");
        String groupNsid = GROUP;
        String tag = "";
        String userNsid = "";
        List<String> extras = new ArrayList<String>();
        extras.add(JinxConstants.EXTRAS_DESCRIPTION);
        extras.add(JinxConstants.EXTRAS_DATE_UPLOAD);
        extras.add(JinxConstants.EXTRAS_DATE_TAKEN);
        int page = 0;
        int perPage = 3;
        GroupsPoolsApi instance = GroupsPoolsApi.getInstance();
        Photos expResult = null;
        Photos result = instance.getPhotos(groupNsid, tag, userNsid, extras, page, perPage);
        assertNotNull(result);
        assertEquals(perPage, result.getPhotos().size());
        for (Photo photo : result.getPhotos()) {
            assertNotNull(photo.getDateUploaded());
        }
    }


    /**
     * Test of remove method, of class GroupsPoolsApi.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        GroupsPoolsApi instance = GroupsPoolsApi.getInstance();
        instance.remove(PHOTO, GROUP);
    }

}