package com.u2d.produto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@ResponseStatus(value=HttpStatus.UNPROCESSABLE_ENTITY)
@Slf4j
public class NegocioException extends Exception{

	private static final long serialVersionUID = 5831810354539896407L;

	/**
     * Construtor padrão da exceção.
     * @param statusCode código de erro HTTP
     */
    public NegocioException() {
        super();
    }

    /**
     * Construtor onde pode ser informada a mensagem a ser apresentada.
     * @param statusCode código de erro HTTP
     * @param msg mensagem do erro
     */
    public NegocioException(String msg) {
        super(msg);
    }

    /**
     * Construtor onde pode ser informada a causa da exceção.
     * @param statusCode código de erro HTTP
     * @param cause causa origem da exceção lançada
     */
    public NegocioException(Throwable cause) {
        super(cause);
        log.error("Exception {} has occurred" , new Exception(cause));
    }

    /**
     * Construtor onde pode ser informada a causa e a mensagem da exceção.
     * @param statusCode código de erro HTTP
     * @param msg mensagem do erro
     * @param cause causa origem da exceção lançada
     */
    public NegocioException(String msg, Throwable cause) {
        super(msg, cause);
        log.error(msg , new Exception(cause));
    }
}
