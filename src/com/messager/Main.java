package com.messager;

import com.messager.channels.EmailChannel;
import com.messager.channels.FacebookChannel;
import com.messager.channels.SmsChannel;
import com.messager.enums.Attachment;
import java.io.InvalidObjectException;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws InvalidObjectException {
        Date date = new Date();
        EmailChannel email1 = new EmailChannel("alex@gmail.com");
        FacebookChannel facebookAlex = new FacebookChannel("id12345");
        SmsChannel smsChannel = new SmsChannel("123-45-67");

        Message ms = new Message("Name of the message",date,"I hope that this text is fine for you.", email1, facebookAlex, smsChannel).addAttachment(Attachment.AUDIO, Attachment.DOCUMENT, Attachment.IMAGE);

        Receiver receiver = new Receiver();
        receiver.ReceiveMessage(ms);
        receiver.SendMessage();

    }
}
