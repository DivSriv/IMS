package com.proj.IMS.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
@ResponseBody
public class InternNotFoundException extends RuntimeException {
    public InternNotFoundException(String message) {

        super("Intern not found with id : " + message);
        super.getMessage();
//        System.out.println("Intern not found with id : " + id);
    }
}
