package com.incident.report.model;

public class Email {
    private String setTo;
    private String setFrom;
    private String setSubject;
    private String setText;

    public Email() {
    }

    public Email(String setTo, String setFrom, String setSubject, String setText) {
        this.setTo = setTo;
        this.setFrom = setFrom;
        this.setSubject = setSubject;
        this.setText = setText;
    }

    public String getSetTo() {
        return setTo;
    }

    public void setSetTo(String setTo) {
        this.setTo = setTo;
    }

    public String getSetFrom() {
        return setFrom;
    }

    public void setSetFrom(String setFrom) {
        this.setFrom = setFrom;
    }

    public String getSetSubject() {
        return setSubject;
    }

    public void setSetSubject(String setSubject) {
        this.setSubject = setSubject;
    }

    public String getSetText() {
        return setText;
    }

    public void setSetText(String setText) {
        this.setText = setText;
    }
}
