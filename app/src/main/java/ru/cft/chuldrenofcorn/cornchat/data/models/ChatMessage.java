package ru.cft.chuldrenofcorn.cornchat.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * User: azhukov
 * Date: 26.08.2016
 * Time: 14:35
 */
@DatabaseTable(tableName = "chatMessages")
public class ChatMessage {

    @Getter @Setter private String senderName;
    @Getter @Setter private String senderJID;
    @Getter @Setter private String text;
    @Getter @Setter private String date;
    @Getter @Setter private String msgId;
    @Getter @Setter private boolean isLocal; //если true - сообщение написал пользователь, если false - пришло из вне

    public ChatMessage(final String senderName, final String text, final String date) {
        this.senderName = senderName;
        this.text = text;
        this.date = date;
        this.isLocal = isLocal;
    }

    @Override
    public String toString() {
        return text;
    }

    public boolean isLocal() {
        return isLocal;
    }
}
