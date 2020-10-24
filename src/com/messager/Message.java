package com.messager;

import com.messager.enums.Attachment;
import com.messager.templates.ChannelTemplate;
import com.messager.templates.MessageTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Message extends MessageTemplate {
    public Date date;
    public ArrayList<Attachment> attachment = new ArrayList<Attachment>();
    public ArrayList<ChannelTemplate> channel = new ArrayList<ChannelTemplate>();

    public Message(String name, Date date, String text, ChannelTemplate channel, ChannelTemplate... channels) { // Добавляем Channel т.к. он обязателен при отправке сообщения
        super(name, date, text);
        this.channel.add(channel);
        this.channel.addAll(Arrays.asList(channels));
    }

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
