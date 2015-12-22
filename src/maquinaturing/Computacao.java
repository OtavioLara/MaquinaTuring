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
public class Computacao {
    private MaquinaTuring mt;
    private int cabeca;
    Computacao(MaquinaTuring mt,int cabeca){
        this.mt = mt;
        this.cabeca = cabeca;
        this.executa();
    }
    Computacao(MaquinaTuring mt){
        this.mt = mt;
        this.executa();
    }
    Computacao(){}
    private boolean validaTransicao(int index){
        if(mt.getEstados().getEstados().contains(mt.getTransicao().get(index).getEstadoCorrente())){
            if(mt.getEstados().getEstados().contains(mt.getTransicao().get(index).getProximoEstado())){
                if(mt.getAlfabeto().getAlfabeto().contains(mt.getTransicao().get(index).getSimboloCorrente())){
                    if(mt.getAlfabeto().getAlfabeto().contains(mt.getTransicao().get(index).getProximoSimbolo())){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean moverFita(int index){
        if(this.validaTransicao(index)){
                return true;
        }
    }

    private void executa() {
        
        while(e)
    }
}
