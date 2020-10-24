package com.messager.channels;

import com.messager.templates.ChannelTemplate;
import com.messager.enums.Channel;

public class FacebookChannel extends ChannelTemplate {
    private static final String  FACEBOOK_ID_PATTERN = "[-+]?\\d+";

    public FacebookChannel(String destination) {
        super(checkFacebookDestination(destination), Channel.FACEBOOK);
    }

    public static String checkFacebookDestination(String data) {
        if (!data.trim().toLowerCase().startsWith("id")
                || !data.trim().substring(2).matches(FACEBOOK_ID_PATTERN)
                || data.trim().length() > 7) {
            throw new IllegalArgumentException("User's Facebook ID" + data + " has incorrect format! Please fix it.");
        }
        return data;
    }
}
