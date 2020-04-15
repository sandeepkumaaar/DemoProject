package com.example.demoapp.modal;

public class DataModel {

     private String status_code;
     private String status_message;
     private Data data;

    public DataModel(String status_code, String status_message, Data data) {
        this.status_code = status_code;
        this.status_message = status_message;
        this.data = data;
    }

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public String getStatus_message() {
        return status_message;
    }

    public void setStatus_message(String status_message) {
        this.status_message = status_message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
