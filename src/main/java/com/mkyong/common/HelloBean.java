package com.mkyong.common;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;

@ManagedBean(name = "helloBean", eager = false)
@SessionScoped
public class HelloBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String messageFR;
    private String messageEN;
    private String messageES;
    private String language;
    private String messageRichText;

    public HelloBean() {
        System.out.println("constructor");
        init();
    }

    public void saveLanguage() {
        System.out.println("--> saveLanguage");
        switch (language) {
            case "FR":
                messageFR = messageRichText;
                break;
            case "EN":
                messageEN = messageRichText;
                break;
            case "ES":
                messageES = messageRichText;
                break;
        }
        System.out.println(this.toString());
    }

    public void save() {
        System.out.println("--> SAVE");
        System.out.println(this.toString());
        init();
    }

    public void init() {
        name = "";
        messageFR = "";
        messageEN = "";
        messageES = "";
        language = "FR";
        messageRichText = "";
    }

    public void onLanguageChange(ValueChangeEvent e) {
        System.out.println("--> onLanguageChange : " + messageRichText);
        switch (e.getNewValue().toString()) {
            case "FR":
                messageRichText = messageFR;
                break;
            case "EN":
                messageRichText = messageEN;
                break;
            case "ES":
                messageRichText = messageES;
                break;
        }
        System.out.println("language : " + language);
        System.out.println("messageRichText : " + messageRichText);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessageRichText() {
        return messageRichText;
    }

    public void setMessageRichText(String messageRichText) {
        this.messageRichText = messageRichText;
    }

    public String getMessageFR() {
        return messageFR;
    }

    public void setMessageFR(String messageFR) {
        this.messageFR = messageFR;
    }

    public String getMessageEN() {
        return messageEN;
    }

    public void setMessageEN(String messageEN) {
        this.messageEN = messageEN;
    }

    public String getMessageES() {
        return messageES;
    }

    public void setMessageES(String messageES) {
        this.messageES = messageES;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}