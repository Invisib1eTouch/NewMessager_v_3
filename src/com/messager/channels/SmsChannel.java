package com.messager.channels;

import com.messager.templates.ChannelTemplate;
import com.messager.enums.Channel;

public class SmsChannel extends ChannelTemplate {
    private static final String SMS_PATTERN = "\\d{3}(\\d{4}|[-]\\d{2}[-]\\d{2})";

    public SmsChannel(String destination) {
        super(checkSmsDestination(destination), Channel.SMS);
          }

    public static String checkSmsDestination(String data){
        if (!data.matches(SMS_PATTERN)){
            throw new IllegalArgumentException("The phone number " + data + " has incorrect format! Please fix it.");
        }
        return data;
    }
}
