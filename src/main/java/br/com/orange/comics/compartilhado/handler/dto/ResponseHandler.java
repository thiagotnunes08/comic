package br.com.orange.comics.compartilhado.handler.dto;

import java.time.LocalDateTime;

public class ResponseHandler {

    private final String campo;
    private final String mensagem;
    private final String status;
    private final LocalDateTime ocorridoEm = LocalDateTime.now();

    public ResponseHandler(String campo, String mensagem, String status) {
        this.campo = campo;
        this.mensagem = mensagem;
        this.status = status;

    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getOcorridoEm() {
        return ocorridoEm;
    }
}
