package twitterclone.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String messageName;
    private String messageShow;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    public String getMessageShow() {
        return messageShow;
    }

    public void setMessageShow(String messageShow) {
        this.messageShow = messageShow;
    }
}
