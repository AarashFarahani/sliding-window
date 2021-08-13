package com.mastercard;

import java.sql.Timestamp;

public class Record {
    private int value;
    private Timestamp timestamp;

    public Record(int value, Timestamp timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
