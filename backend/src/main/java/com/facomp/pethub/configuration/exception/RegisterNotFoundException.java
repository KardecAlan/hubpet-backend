package com.facomp.pethub.configuration.exception;

public class RegisterNotFoundException extends RuntimeException {

    public RegisterNotFoundException(String mensagem) {
        super(mensagem);
    }

}