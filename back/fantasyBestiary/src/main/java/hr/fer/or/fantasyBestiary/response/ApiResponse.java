package hr.fer.or.fantasyBestiary.response;

import java.time.LocalDateTime;

public class ApiResponse<T> {
    private String status;
    private LocalDateTime timestamp;
    private T data;

    public ApiResponse(String status, T data) {
        this.status = status;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public T getData() {
        return data;
    }
}
