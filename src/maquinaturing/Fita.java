/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquinaturing;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author otavio
 */
class Fita {
    private String fita;

    public Fita(){
        fita = "BBBBBBBBBBB";
    }
    public String  getFita() {
        return fita;
    }

    /**
     * @param fita the fita to set
     */
    public void setFita(String fita) {
        this.fita = fita;
    }
}
