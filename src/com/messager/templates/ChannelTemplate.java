package com.messager.templates;

import com.messager.enums.Channel;

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
