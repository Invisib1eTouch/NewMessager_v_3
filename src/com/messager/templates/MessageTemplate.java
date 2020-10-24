package com.messager.templates;

import java.util.Date;

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
