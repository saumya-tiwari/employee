package com.api.employee.exception;

public class EmployeeApiException extends Exception {

        private static final long serialVersionUID = 405089290568657115L;

        private String code;

        private String message;

        private String source;


    public EmployeeApiException(String code, String message, String source) {
            this(code, message, source, new Exception());
        }

    public EmployeeApiException(String code, String message, String source, Exception ex) {
        super(message, ex);
        this.code = code;
        this.message = message;
        this.source = source;
    }
}
