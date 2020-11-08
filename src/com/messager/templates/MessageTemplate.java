package com.messager.templates;

import java.util.Date;

/**
 * The general template for messages.
 *
 * @author Aliaksandr Tkachou
 * @version 1.3.1 8 Nov 2020
 */

public abstract class MessageTemplate {
    public String name;
    public Date date;
    public String text;

    public MessageTemplate(String name, Date date, String text) {
        this.name = name;
        this.date = date;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public String getText() {
        return text;
    }
}
