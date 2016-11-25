package com.app.sigap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.iid.FirebaseInstanceId;
import com.sendbird.android.SendBird;
import com.sendbird.android.SendBirdException;
import com.sendbird.android.User;

/**
 * Created by blue on 24/11/16.
 */

public class ChatSampleActivity extends AppCompatActivity {

    /**
     * Variables
     * */
    private String ACCESS_TOKEN = "b75dc7b3fe0ed861646415fe8b935f7b3f71e4ec";
    private String APP_ID = "A00D0081-E945-44C5-86F2-87632756ED8F";
    private String USER_ID = "user";
    private enum State { DISCONNECTED, CONNECTING, CONNECTED }
    /**
     * End of Variables
     * */

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        /**
         * Config
         * */
        initSendbird();
        connectSendbirdWithUserID();
        /**
         * End of Config
         * */
    }

    private void connectSendbirdWithUserID ()
    {
        SendBird.connect(USER_ID, new SendBird.ConnectHandler() {
            @Override
            public void onConnected(User user, SendBirdException e)
            {
                if (e != null) {
                    // Error.
                    return;
                }

                //  User data
                String NICKNAME = user.getNickname();
                String PROFILE_URL = user.getProfileUrl();

                //  Updating user profile
                SendBird.updateCurrentUserInfo(NICKNAME, PROFILE_URL, new SendBird.UserInfoUpdateHandler()
                {
                    @Override
                    public void onUpdated(SendBirdException e) {
                        if (e != null) {
                            // Error.
                            setState(State.DISCONNECTED);
                            return;
                        }
                    }
                });

                if (FirebaseInstanceId.getInstance().getToken() == null)
                {
                    return;
                }

                /**
                 * Register and unregister FCM registration token in SendBird SDK and parse SendBird FCM messages
                 * */
                String token = FirebaseInstanceId.getInstance().getToken();
                SendBird.registerPushTokenForCurrentUser(
                    token, new SendBird.RegisterPushTokenWithStatusHandler()
                {
                    @Override
                    public void onRegistered(SendBird.PushTokenRegistrationStatus status, SendBirdException e) {
                        if (e != null) {
                            // Error.
                            return;
                        }

                        if (status == SendBird.PushTokenRegistrationStatus.PENDING) {
                            // Try registration after connection is established.
                        }
                    }
                });

            }
        });
    }

    private void connectSendbirdWithUserIDAndAccessToken ()
    {
        SendBird.connect(USER_ID, ACCESS_TOKEN, new SendBird.ConnectHandler() {
            @Override
            public void onConnected(User user, SendBirdException e) {
                if (e != null) {
                    // Error.
                    return;
                }
            }
        });

    }

    private void initSendbird ()
    {
        SendBird.init(APP_ID, ChatSampleActivity.this);
    }

    private void setState(State state) {
        switch (state) {
            case DISCONNECTED:
            case CONNECTING:
                findViewById(R.id.btn_send).setEnabled(false);
                break;
            case CONNECTED:
                findViewById(R.id.btn_send).setEnabled(true);
                break;
        }
    }

}
