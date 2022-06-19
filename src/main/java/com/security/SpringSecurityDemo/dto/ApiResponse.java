package com.security.SpringSecurityDemo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {
    private Integer statusCode;
    private String message;
    private Object result;
    private Integer totalRow;
    private Boolean permission;

    public ApiResponse(Integer statusCode, String message, Object result) {
        this.statusCode = statusCode;
        this.message = message;
        this.result = result;
    }

    public ApiResponse(Integer statusCode, String message, Object result, Integer totalRow) {
        this.statusCode = statusCode;
        this.message = message;
        this.result = result;
        this.totalRow = totalRow;
    }

    public ApiResponse(Integer statusCode, String message, Object result, Integer totalRow, Boolean permission) {
        this.statusCode = statusCode;
        this.message = message;
        this.result = result;
        this.totalRow = totalRow;
        this.permission = permission;
    }
}
