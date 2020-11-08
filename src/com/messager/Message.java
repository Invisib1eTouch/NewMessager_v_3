package com.messager;

import com.messager.enums.Attachment;
import com.messager.templates.ChannelTemplate;
import com.messager.templates.MessageTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Message class extends the general message template MessageTemplate to set up
 * the message with additional parameters like attachments.
 *
 * @author Aliaksandr Tkachou
 * @version 1.3.1 8 Nov 2020
 */

public class Message extends MessageTemplate {
    public ArrayList<Attachment> attachment = new ArrayList<>();
    public ArrayList<ChannelTemplate> channel = new ArrayList<>();

    /**
     * Constructor contains two channel parameters because the one channel is required to be in the message.
     */
    public Message(String name, Date date, String text, ChannelTemplate channel, ChannelTemplate... channels) {
        super(name, date, text);
        this.channel.add(channel);
        this.channel.addAll(Arrays.asList(channels));
    }

    /**
     * The method that add attachments to message.
     */
    public Message addAttachment(Attachment... attachment) {
        this.attachment.addAll(Arrays.asList(attachment));
        return this;
    }

    public ArrayList<ChannelTemplate> getChannel() {
        return channel;
    }

    public ArrayList<Attachment> getAttachment() {
        return attachment;
    }
}
