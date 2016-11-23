package com.app.sources;

/**
 * Created by blue on 04/11/16.
 */

public interface ChatIDE {

    String API_ID = "A00D0081-E945-44C5-86F2-87632756ED8F"; /* Sigap01 */

    String API_TOKEN = "b75dc7b3fe0ed861646415fe8b935f7b3f71e4ec"; /* Sigap01 */

    String DEFAULT_ADMIN = "polresbaritoutara"; /* Sigap01 */

    /**
     * Create member into sendbird
     * */
    String SENDBIRD_CREATE_USER_V3 = "https://api.sendbird.com/v3/users"; /* Method : POST */

    String SENDBIRD_ISSUE_ACCESS_TOKEN = "issue_access_token";

    String SENDBIRD_NICKNAME = "nickname";

    String SENDBIRD_PROFILE_URL = "profile_url";

    String SENDBIRD_USER_ID = "user_id";
    /**
     * End of Create member into sendbird
     * */

}