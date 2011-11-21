package net.jeremybrooks.jinx.api;

/**
 * User: Wursteisen David
 * Date: 22/11/11
 * Time: 00:18
 */
public enum FlickrExtra {

    DESCRIPTION("description"),
     LICENSE("licence"),
     DATE_UPLOAD("date_upload"),
     DATE_TAKEN("date_taken"),
     OWNER_NAME("owner_name"),
     ICON_SERVER("icon_server"),
     ORIGINAL_FORMAT("original_format"),
     LAST_UPDATE("last_update"),
     GEO("geo"),
     TAGS("tags"),
     MACHINE_TAGS("machine_tags"),
     O_DIMS("o_dims"),
     VIEWS("views"),
     MEDIA("media"),
     PATH_ALIAS("path_alias"),
     URL_SQ("url_sq"),
     URL_T("url_t"),
     URL_S("url_s"),
     URL_M("url_m"),
     URL_Z("url_z"),
     URL_L("url_l"),
     URL_O("url_m"),
     ALL("description,license,date_upload,date_taken," +
	    "owner_name,icon_server,original_format,last_update,geo,tags," +
	    "machine_tags,o_dims,views,media,path_alias,url_sq,url_t,url_s," +
	    "url_m,url_z,url_o");
    
    
    private String value;

    private FlickrExtra(String value) {
        this.value = value;
    }

    String getValue() {
        return value;
    }
}
