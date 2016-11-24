package com.models.sendbirdUser;

public class CreateSBUResponseSuccess {
    private String user_id;
    private String access_token;
    private boolean is_online;
    private long last_seen_at;
    private String nickname;
    private String profile_url;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public boolean is_online() {
        return is_online;
    }

    public void setIs_online(boolean is_online) {
        this.is_online = is_online;
    }

    public long getLast_seen_at() {
        return last_seen_at;
    }

    public void setLast_seen_at(long last_seen_at) {
        this.last_seen_at = last_seen_at;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProfile_url() {
        return profile_url;
    }

    public void setProfile_url(String profile_url) {
        this.profile_url = profile_url;
    }
}
