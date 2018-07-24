package com.javarush.task.task33.task3313;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.namespace.QName;
import java.util.Date;
import java.util.Map;

public class Event {
    public String name;

    @JsonFormat(pattern = "dd-MM-YYYY hh:mm:ss", shape = JsonFormat.Shape.ANY)
    public Date eventDate;

    // dd-MM-yyyy hh:mm:ss
    public Event(String name) {
        this.name = name;
        eventDate = new Date();
    }
}