package com.mkyong.common;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;

@ManagedBean(name = "helloBean2")
@SessionScoped
public class HelloBean2 implements Serializable {

    private static final long serialVersionUID = 1L;

    private String messageRichText;
    private String messageFR;
    private String messageEN;

    private String language;
    private String languagePrev = "";

    public HelloBean2() {
        System.out.println("constructor");
        messageFR = "";
        messageEN = "";
        language = "EN";
        languagePrev = "EN";
    }

    public void languageChanged(ValueChangeEvent e) {
        language = e.getNewValue().toString();
        languagePrev = e.getOldValue().toString();
    }

    public void messageChanged(ValueChangeEvent e) {
        messageRichText = e.getNewValue().toString();
        System.out.println("messageChanged : " + messageRichText);
    }

    public void updateMessage() {
        // mise à jour du message précédent
        if (languagePrev.equals("FR")) {
            messageFR = messageRichText;
        }
        else {
            messageEN = messageRichText;
        }
        // mise à jour de la valeur du composant richText
        if (language.equals("FR")) {
            messageRichText = messageFR;
        } else {
            messageRichText = messageEN;
        }
        System.out.println("updateMessage : " + messageRichText);
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguagePrev() {
        return languagePrev;
    }

    public void setLanguagePrev(String languagePrev) {
        this.languagePrev = languagePrev;
    }
}