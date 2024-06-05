package com.example.letsGo.controller.record;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RecordForm implements Serializable {
    @Setter
    @Getter
    private Record record;
    private boolean isPublic;

    public RecordForm(Record record, boolean isPublic) {
        this.record = record;
        this.isPublic = isPublic;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
}
