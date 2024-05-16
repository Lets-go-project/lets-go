package com.example.letsgo.controller.record;

import com.example.letsgo.domain.record.Record;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RecordForm implements Serializable {
    private Record record;
    private boolean isPublic;

    public RecordForm(Record record, boolean isPublic) {
        this.record = record;
        this.isPublic = isPublic;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
}
