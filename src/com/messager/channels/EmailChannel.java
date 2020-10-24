package com.messager.channels;

import com.messager.templates.ChannelTemplate;
import com.messager.enums.Channel;

public class EmailChannel extends ChannelTemplate {
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public EmailChannel(String destination) {
        super(checkEmailDestination(destination), Channel.EMAIL);
    }

    public static String checkEmailDestination(String data) {
        if (!data.matches(EMAIL_PATTERN)) {
            throw new IllegalArgumentException("Error! The email address " + data + " has an incorrect format. Please fix it.");
        }
        return data;
    }

}
