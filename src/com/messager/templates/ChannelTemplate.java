package com.messager.templates;

import com.messager.enums.Channel;

/**
 * The general template for channels.
 *
 * @author Aliaksandr Tkachou
 * @version 1.3.1 8 Nov 2020
 */

public abstract class ChannelTemplate {
    public String destination;
    public Channel channel;

    public ChannelTemplate(String destination, Channel channel) {
        this.destination = destination;
        this.channel = channel;
    }

    @Override
    public String toString() {
        return destination + " " + channel;
    }
}
