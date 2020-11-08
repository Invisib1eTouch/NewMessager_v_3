package com.messager.channels;

import com.messager.templates.ChannelTemplate;
import com.messager.enums.Channel;

/**
 * SmsChannel class extends the general channel template ChannelTemplate to set up
 * the unique parameters for sms channel.
 *
 * @author Aliaksandr Tkachou
 * @version 1.3.1 8 Nov 2020
 */

public class SmsChannel extends ChannelTemplate {

    /**
     * The patter of the valid phone number.
     */
    private static final String PHONE_NUMBER_PATTERN = "\\d{3}(\\d{4}|[-]\\d{2}[-]\\d{2})";

    public SmsChannel(String destination) {
        super(checkSmsDestination(destination), Channel.SMS);
    }

    /**
     * The validation of the phone number for sms via the phone number pattern.
     */
    public static String checkSmsDestination(String data) {
        if (!data.matches(PHONE_NUMBER_PATTERN)) {
            throw new IllegalArgumentException("The phone number " + data + " has incorrect format! Please fix it.");
        }
        return data;
    }
}
