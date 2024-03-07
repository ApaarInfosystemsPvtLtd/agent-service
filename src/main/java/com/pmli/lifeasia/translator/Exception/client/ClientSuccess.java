package com.pmli.lifeasia.translator.Exception.client;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "ClientSuccess")
public class ClientSuccess
{
    private LocalDateTime entryTimeStamp;
    private String Request_Id;
    private String Request_Type;
    private String Request;
    private String Response;
    private LocalDateTime exitTimeStamp;

    public ClientSuccess() {
    }

    public ClientSuccess(LocalDateTime entryTimeStamp, String request_Id, String request_Type, String request, String response, LocalDateTime exitTimeStamp) {
        this.entryTimeStamp = entryTimeStamp;
        Request_Id = request_Id;
        Request_Type = request_Type;
        Request = request;
        Response = response;
        this.exitTimeStamp = exitTimeStamp;
    }

    public LocalDateTime getEntryTimeStamp() {
        return entryTimeStamp;
    }

    public void setEntryTimeStamp(LocalDateTime entryTimeStamp) {
        this.entryTimeStamp = entryTimeStamp;
    }

    public String getRequest() {
        return Request;
    }

    public void setRequest(String request) {
        Request = request;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }

    public String getRequest_Type() {
        return Request_Type;
    }

    public void setRequest_Type(String agent) {
        Request_Type = agent;
    }

    public String getRequest_Id() {
        return Request_Id;
    }

    public void setRequest_Id(String request_Id) {
        Request_Id = request_Id;
    }

    public LocalDateTime getExitTimeStamp() {
        return exitTimeStamp;
    }

    public void setExitTimeStamp(LocalDateTime exitTimeStamp) {
        this.exitTimeStamp = exitTimeStamp;
    }

    @Override
    public String toString() {
        return "ClientSuccess{" +
                "EntryTimeStamp='" + entryTimeStamp + '\''+
                ", Request='" + Request + '\'' +
                ", Response='" + Response + '\'' +
                ", Request_Type='" + Request_Type + '\'' +
                ", Request_Id'" + Request_Id + '\'' +
                ", ExitTimeStamp'" + exitTimeStamp + '\'' +
                '}';
    }
}
