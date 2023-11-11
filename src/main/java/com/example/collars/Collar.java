package com.example.collars;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Collar {

    @EmbeddedId
    private CollarId collarId;

    @Column(name = "collar_message")
    private String collarMessage;

    public CollarId getCollarId() {
        return collarId;
    }

    public void setCollarId(CollarId collarId) {
        this.collarId = collarId;
    }

    public String getCollarMessage() {
        return collarMessage;
    }

    public void setCollarMessage(String collarMessage) {
        this.collarMessage = collarMessage;
    }

    public Collar(CollarId collarId, String collarMessage) {
        this.collarId = collarId;
        this.collarMessage = collarMessage;
    }

    public Collar() {
    }

}
