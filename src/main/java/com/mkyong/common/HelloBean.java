package com.mkyong.common;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;

@ManagedBean(name = "helloBean")
@SessionScoped
public class HelloBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message = "HELLO WORLD";
    private String messageFR = "BONJOUR TOUT LE MONDE";
    private String messageEN = "HELLO WORLD";

    private String localeCode = "EN"; //default value
    private String localeCodeOld = "EN"; //default value

    public void countryLocaleCodeChanged(ValueChangeEvent e) {
        System.out.println("--> countryLocaleCodeChanged");
        localeCode = e.getNewValue().toString();
        System.out.println("old : " + e.getOldValue().toString());
        System.out.println("new : " + localeCode);
        localeCodeOld = e.getOldValue().toString();
    }

    public void messageChanged(ValueChangeEvent e) {
        System.out.println("--> messageChanged");
        message = e.getNewValue().toString();
        System.out.println("old : " + e.getOldValue().toString());
        System.out.println("new : " + message);
    }

    public void updateMessage() {
        System.out.println("--> updateMessage");
        // mise à jour de l'ancien message
        if (localeCodeOld.equals("FR")) {
            messageFR = message;
        }
        else {
            messageEN = message;
        }
        // mise à jour de la valeur du composant richText
        if (localeCode.equals("FR")) {
            message = messageFR;
        } else {
            message = messageEN;
        }
    }

    public String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}