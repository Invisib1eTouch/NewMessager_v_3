package com.messager.channels;

import com.messager.templates.ChannelTemplate;
import com.messager.enums.Channel;

/**
 * FacebookChannel class extends the general channel template ChannelTemplate to set up
 * the unique parameters for facebook channel.
 *
 * @version   1.3.1 8 Nov 2020
 * @author    Aliaksandr Tkachou
 */

public class FacebookChannel extends ChannelTemplate {

    /**
     * The patter of the valid facebook id.
     */
    private static final String FACEBOOK_ID_PATTERN = "[-+]?\\d+";

    public FacebookChannel(String destination) {
        super(checkFacebookDestination(destination), Channel.FACEBOOK);
    }

    /**
     * The validation of the facebook id via the facebook id pattern and additional conditions.
     */
    public static String checkFacebookDestination(String data) {
        if (!data.trim().toLowerCase().startsWith("id")
                || !data.trim().substring(2).matches(FACEBOOK_ID_PATTERN)
                || data.trim().length() > 7) {
            throw new IllegalArgumentException("User's Facebook ID" + data + " has incorrect format! Please fix it.");
        }
        return data;
    }
}
