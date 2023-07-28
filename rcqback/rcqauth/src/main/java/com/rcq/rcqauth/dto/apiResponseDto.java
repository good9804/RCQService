package com.rcq.rcqauth.dto;

import lombok.Data;

@Data
public class apiResponseDto {
    private String message;
    private String success="Success";
    private String error="Error";
    public apiResponseDto(boolean isSuccess){
        if(isSuccess){
            this.message=success;
        }else this.message=error;
    }
}
