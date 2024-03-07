package com.pmli.lifeasia.translator.Exception.agent;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@Document(collection = "AgentFailure")
public class AgentFailure {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime entryTimeStamp;
    private String Request_id;
    private String Request_type;
    private HttpStatus Status;
    private String Request;
    private String ResponseError;
    private String Message;
    private String Path;
    private LocalDateTime exitTimeStamp;

    public AgentFailure() {
    }

    public AgentFailure(LocalDateTime entryTimeStamp, String request_id, String request_type, HttpStatus status, String request, String responseError, String message, String path, LocalDateTime exitTimeStamp) {
        this.entryTimeStamp = entryTimeStamp;
        Request_id = request_id;
        Request_type = request_type;
        Status = status;
        Request = request;
        ResponseError = responseError;
        Message = message;
        Path = path;
        this.exitTimeStamp = exitTimeStamp;
    }

    public LocalDateTime getEntryTimeStamp() {
        return entryTimeStamp;
    }

    public void setEntryTimeStamp(LocalDateTime entryTimeStamp) {
        this.entryTimeStamp = entryTimeStamp;
    }

    public String getRequest_id() {
        return Request_id;
    }

    public void setRequest_id(String request_id) {
        Request_id = request_id;
    }

    public String getRequest_type() {
        return Request_type;
    }

    public void setRequest_type(String request_type) {
        Request_type = request_type;
    }

    public HttpStatus getStatus() {
        return Status;
    }

    public void setStatus(HttpStatus status) {
        Status = status;
    }

    public String getRequest() {
        return Request;
    }

    public void setRequest(String request) {
        Request = request;
    }

    public String getResponseError() {
        return ResponseError;
    }

    public void setResponseError(String responseError) {
        ResponseError = responseError;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }

    public LocalDateTime getExitTimeStamp() {
        return exitTimeStamp;
    }

    public void setExitTimeStamp(LocalDateTime exitTimeStamp) {
        this.exitTimeStamp = exitTimeStamp;
    }

    @Override
    public String toString() {
        return "AgentFailure{" +
                "EntryTimeStamp=" + entryTimeStamp +
                ", Request_id='" + Request_id + '\'' +
                ", Request_type='" + Request_type + '\'' +
                ", Status=" + Status +
                ", Request='" + Request + '\'' +
                ", ResponseError='" + ResponseError + '\'' +
                ", Message='" + Message + '\'' +
                ", Path='" + Path + '\'' +
                ", ExitTimeStamp='" + exitTimeStamp + '\'' +
                '}';
    }
}

