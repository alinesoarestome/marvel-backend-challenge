package com.alineasoarestome.challenge.exception;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApiError implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public static final String CHARACTER_NOT_FOUND = "Character not found.";
    public static final String UNEXPECTED_ERROR = "Unexpected error.";
    
    private int code;
    private String msg;
    private Date date;
}