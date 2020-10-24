package com.messager;

import com.messager.channels.EmailChannel;
import com.messager.channels.FacebookChannel;
import com.messager.channels.SmsChannel;
import com.messager.enums.Attachment;
import com.messager.templates.ChannelTemplate;
import java.util.ArrayList;

public class Receiver {

    public ArrayList<Message> listOfTransformedMessages = new ArrayList<Message>();

    public void ReceiveMessage(Message message) {
        for (ChannelTemplate s : message.getChannel()) {
            String channel = s.toString().substring(s.toString().indexOf(" ") + 1);
            String destinationAddress = s.toString().substring(0, s.toString().indexOf(" "));
            if (channel.equals("EMAIL")) {
                Message emailMessage = new Message(message.getName(), message.getDate(), message.getText(), new EmailChannel(destinationAddress));
                for (Attachment a : message.getAttachment()) {
                    if (a.toString() == "IMAGE") {
                        emailMessage.addAttachment(Attachment.IMAGE);
                    } else if (a.toString() == "DOCUMENT") {
                        emailMessage.addAttachment(Attachment.DOCUMENT);
                    } else {
                        emailMessage.addAttachment(Attachment.AUDIO);
                    }
                }
                listOfTransformedMessages.add(emailMessage);
            }

            if (channel.equals("SMS")) {
                Message smsMessage = new Message(message.getName(), message.getDate(), message.getText(), new SmsChannel(destinationAddress));
                listOfTransformedMessages.add(smsMessage);
            }
            if (channel.equals("FACEBOOK")) {
                Message facebookMessage = new Message(message.getName(), message.getDate(), message.getText(), new FacebookChannel(destinationAddress));
                for (Attachment a : message.getAttachment()) {
                    if (a.toString() == "IMAGE") {
                        facebookMessage.addAttachment(Attachment.IMAGE);
                    } else if (a.toString() == "DOCUMENT") {
                        facebookMessage.addAttachment(Attachment.DOCUMENT);
                    }
                }
                listOfTransformedMessages.add(facebookMessage);
            }
        }
    }

    public void SendMessage() {
        System.out.println("The message was successfully processed and sent with appropriate format. Next messages is sent:\n\n");
        for (Message m : listOfTransformedMessages) {
            String channel = m.getChannel().toString().substring(m.getChannel().toString().indexOf(" ") + 1, m.getChannel().toString().indexOf("]"));
            System.out.println("Channel: " + channel);
            System.out.println("Date: " + m.getDate());
            System.out.println("Title: " + m.getName());
            System.out.println("Text: " + m.getText());
            System.out.println("Attachment(s): " + m.getAttachment() + "\n");
        }
    }
}
