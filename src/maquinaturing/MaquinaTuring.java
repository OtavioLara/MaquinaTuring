/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquinaturing;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author otavio
 */
public class MaquinaTuring {

    private Fita fita;
    private Alfabeto alfabeto;
    private Alfabeto alfabetoEntrada;
    private Estados estados;
    private ArrayList<Transicao> transicao;
    private Estados estadosFinais;
    private int estadoInicial;
    private Arquivo arquivo;
    public MaquinaTuring(String nome) {
        arquivo = new Arquivo(nome,"r");
        MaquinaTuring mt = new MaquinaTuring();
        mt = arquivo.takeInstructions();
        fita = mt.getFita();
        alfabeto = mt.getAlfabeto();
        alfabetoEntrada = mt.getAlfabetoEntrada();
        estados = mt.getEstados();
        transicao = mt.getTransicao();
        estadosFinais = mt.getEstadosFinais();
        estadoInicial = mt.getEstadoInicial();
    }
    public MaquinaTuring(){
        fita = new Fita();
        alfabeto = new Alfabeto();
        alfabetoEntrada = new Alfabeto();
        estados = new Estados();
        transicao = new ArrayList<>();
        estadosFinais = new Estados();
        estadoInicial = 0;
    }
    public void imprimeMT(){
        System.out.println("Maquina de turing do Arquivo "+arquivo.getName());
        System.out.println("Fita: ");
        System.out.println(getFita().getFita());
        System.out.println("Alfabeto: ");
        imprimeLista(getAlfabeto().getAlfabeto(),false);
        System.out.println("Alfabeto de entrada:");
        imprimeLista(getAlfabetoEntrada().getAlfabeto(),false);
        System.out.println("Estados: ");
        imprimeLista(getEstados().getEstados(),true);
        System.out.println("Estados de transição:\n{");
        Iterator transIt = getTransicao().iterator();
        while(transIt.hasNext()){
            imprimeTransicao((Transicao)transIt.next());
        }
        System.out.println("},\nq"+getEstadoInicial()+",\n{");
        imprimeLista(getEstadosFinais().getEstados(), true);
        
    }
    private void imprimeTransicao(Transicao trans){
        System.out.println("(q"+trans.getEstadoCorrente()+", "+
                trans.getSimboloCorrente()+")->(q"+trans.getProximoEstado()+", "+
                trans.getProximoSimbolo()+", "+trans.getDirecao()+")");
    }
    
    private void imprimeLista(ArrayList lista, boolean estado){
       
        Iterator listaIt = lista.iterator();
        System.out.print("{");
        if(estado){
            while(listaIt.hasNext()){
                System.out.print("q"+listaIt.next()+", ");
            }
        }else{
            while(listaIt.hasNext()){
                System.out.print(listaIt.next()+", ");
            }
        }
        System.out.print("}\n");
    }

    /**
     * @return the fita
     */
    public Fita getFita() {
        return fita;
    }

    /**
     * @param fita the fita to set
     */
    public void setFita(Fita fita) {
        this.fita = fita;
    }

    /**
     * @return the alfabeto
     */
    public Alfabeto getAlfabeto() {
        return alfabeto;
    }

    /**
     * @param alfabeto the alfabeto to set
     */
    public void setAlfabeto(Alfabeto alfabeto) {
        this.alfabeto = alfabeto;
    }

    /**
     * @return the estados
     */
    public Estados getEstados() {
        return estados;
    }

    /**
     * @param estados the estados to set
     */
    public void setEstados(Estados estados) {
        this.estados = estados;
    }

    /**
     * @return the transicao
     */
    public ArrayList<Transicao> getTransicao() {
        return transicao;
    }

    /**
     * @param transicao the transicao to set
     */
    public void setTransicao(ArrayList<Transicao> transicao) {
        this.transicao = transicao;
    }

    /**
     * @return the estadosFinais
     */
    public Estados getEstadosFinais() {
        return estadosFinais;
    }

    /**
     * @param estadosFinais the estadosFinais to set
     */
    public void setEstadosFinais(Estados estadosFinais) {
        this.estadosFinais = estadosFinais;
    }

    /**
     * @return the estadoInicial
     */
    public int getEstadoInicial() {
        return estadoInicial;
    }

    /**
     * @param estadoInicial the estadoInicial to set
     */
    public void setEstadoInicial(int estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    /**
     * @return the alfabetoEntrada
     */
    public Alfabeto getAlfabetoEntrada() {
        return alfabetoEntrada;
    }

    /**
     * @param alfabetoEntrada the alfabetoEntrada to set
     */
    public void setAlfabetoEntrada(Alfabeto alfabetoEntrada) {
        this.alfabetoEntrada = alfabetoEntrada;
    }
    
    
}
