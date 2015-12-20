/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquinaturing;

/**
 *
 * @author otavio
 */
class Transicao {
    private int estadoCorrente;
    private char simboloCorrente;
    private char proximoSimbolo;
    private int proximoEstado;
    private char direcao;

    public Transicao(){}
    /**
     * @return the estadoCorrente
     */
    public int getEstadoCorrente() {
        return estadoCorrente;
    }

    /**
     * @param estadoCorrente the estadoCorrente to set
     */
    public void setEstadoCorrente(int estadoCorrente) {
        this.estadoCorrente = estadoCorrente;
    }

    /**
     * @return the simboloCorrente
     */
    public char getSimboloCorrente() {
        return simboloCorrente;
    }

    /**
     * @param simboloCorrente the simboloCorrente to set
     */
    public void setSimboloCorrente(char simboloCorrente) {
        this.simboloCorrente = simboloCorrente;
    }

    /**
     * @return the proximoSimbolo
     */
    public char getProximoSimbolo() {
        return proximoSimbolo;
    }

    /**
     * @param proximoSimbolo the proximoSimbolo to set
     */
    public void setProximoSimbolo(char proximoSimbolo) {
        this.proximoSimbolo = proximoSimbolo;
    }

    /**
     * @return the proximoEstado
     */
    public int getProximoEstado() {
        return proximoEstado;
    }

    /**
     * @param proximoEstado the proximoEstado to set
     */
    public void setProximoEstado(int proximoEstado) {
        this.proximoEstado = proximoEstado;
    }

    /**
     * @return the direcao
     */
    public char getDirecao() {
        return direcao;
    }

    /**
     * @param direcao the direcao to set
     */
    public void setDirecao(char direcao) {
        this.direcao = direcao;
    }
}
