package com.messager.channels;

import com.messager.templates.ChannelTemplate;
import com.messager.enums.Channel;

/**
 * EmailChannel class extends the general channel template ChannelTemplate to set up
 * the unique parameters for email channel.
 *
 * @version   1.3.1 8 Nov 2020
 * @author    Aliaksandr Tkachou
 */

public class EmailChannel extends ChannelTemplate {

    /** The pattern of the valid email address. */
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public EmailChannel(String destination) {
        super(checkEmailDestination(destination), Channel.EMAIL);
    }

    /**
     * The validation of the email address via the email pattern.
     */
    public static String checkEmailDestination(String data) {
        if (!data.matches(EMAIL_PATTERN)) {
            throw new IllegalArgumentException("Error! The email address " + data +
                    " has an incorrect format. Please fix it.");
        }
        return data;
    }

}
