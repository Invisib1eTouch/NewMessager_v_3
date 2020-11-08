package com.messager;

import com.messager.channels.EmailChannel;
import com.messager.channels.FacebookChannel;
import com.messager.channels.SmsChannel;
import com.messager.enums.Attachment;

import java.io.InvalidObjectException;
import java.util.Date;

/**
 * The Main class where creates the objects of the channels to which the message will be sent, the message object
 * that will be sent, the receiver object with that help the message will be sent to channels.
 *
 * @author Aliaksandr Tkachou
 * @version 1.3.1 8 Nov 2020
 */

public class Main {

    public static void main(String[] args) throws InvalidObjectException {

        /** The object of the date that provides the date and time for message. */
        Date date = new Date();

        /** The object of the email channel to which the message will be sent. */
        EmailChannel email1 = new EmailChannel("alex@gmail.com");

        /** The object of the facebook channel to which the message will be sent. */
        FacebookChannel facebookAlex = new FacebookChannel("id12345");

        /** The object of the sms channel to which the message will be sent. */
        SmsChannel smsChannel = new SmsChannel("123-45-67");

        /** The object of the message that needs to be sent any channel with any attachments. */
        Message ms = new Message("Name of the message", date, "I hope that this text is fine.", email1,
                facebookAlex, smsChannel).addAttachment(Attachment.AUDIO, Attachment.DOCUMENT, Attachment.IMAGE);

        /** The object of the receiver that helps with processing and sending the message. */
        Receiver receiver = new Receiver();

        /** Processing the initial message to sent with appropriate parameters to each destination channel. */
        receiver.receiveMessage(ms);

        /** Sending the message to channels. */
        receiver.sendMessage();
    }
}
