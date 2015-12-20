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
class Alfabeto {
    private ArrayList<Character> alfabeto;

    public Alfabeto(){}
    /**
     * @return the alfabeto
     */
    public ArrayList<Character>  getAlfabeto() {
        return alfabeto;
    }

    /**
     * @param alfabeto the alfabeto to set
     */
    public void setAlfabeto(ArrayList<Character> alfabeto) {
        this.alfabeto = alfabeto;
    }
}
