/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquinaturing;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author otavio
 */
public class Arquivo {

    private File f;
    private FileWriter fw;
    private FileReader fr;
    private BufferedReader br;
    private BufferedWriter bw;
    private String name;
    private String openType;
    Arquivo(String name, String openType){
        this.name = name;
        this.openType = openType;
        this.f = new File(this.getName());
        if (this.f.exists()) {
            if (openType == "r") {
                try {
                    this.fr = new FileReader(this.f);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                this.br = new BufferedReader(this.fr);
            }
            if (openType == "w") {
                try {
                    this.fw = new FileWriter(this.f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                this.bw = new BufferedWriter(this.fw);
            }
        }
    }

    Arquivo() {
    }

    private void openFile(String name) {
        if (this.f == null) {
            this.name = name;
            this.f = new File(this.getName());
            if (this.f.exists()) {
                try {
                    this.fr = new FileReader(this.f);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                this.br = new BufferedReader(this.fr);
                try {
                    this.fw = new FileWriter(this.f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                this.bw = new BufferedWriter(this.fw);
            }
        }
    }

    public MaquinaTuring takeInstructions() {
        //Objetos para criação da maquina de turing:
        Estados est = new Estados();
        ArrayList<Integer> estado = new ArrayList<>();
        ArrayList<Integer> estadoFinal = new ArrayList<>();
        Alfabeto alfa = new Alfabeto();
        ArrayList<Character> alfabeto = new ArrayList<>();
        ArrayList<Character> alfabetoEntrada = new ArrayList<>();
        Alfabeto alfaEntrada = new Alfabeto();
        ArrayList<Transicao> listTrans = new ArrayList<>();
        Transicao trans = new Transicao();
        Estados estFinal = new Estados();
        
        //Maquina de Turring para o retorno:
        MaquinaTuring tm = new MaquinaTuring();
        
        String s = this.readInstructions();
        int cont = 3;
        // adicionando os estados da maquina
        while (s.charAt(cont) != '{') {
            estado.add(Character.getNumericValue(s.charAt(cont))); //problema dos numero maiores do que 9
            cont+=3;
        }
        est.setEstados(estado);
        tm.setEstados(est);
        // adicionando o alfabeto de entrada
        cont++;
        while (s.charAt(cont) != ',') {
            alfabetoEntrada.add(s.charAt(cont));
            cont+=2;
        }
        alfaEntrada.setAlfabeto(alfabetoEntrada);
        tm.setAlfabetoEntrada(alfaEntrada);
        cont += 2;
        // adicionando o alfabeto da fita
        while (s.charAt(cont) != ',') {
            alfabeto.add(s.charAt(cont));
            cont+=2;
        }
        alfa.setAlfabeto(alfabeto);
        tm.setAlfabeto(alfa);
        cont++;
        //para no primeiro |número| do estado de transiçao
        while (s.charAt(cont) != '}') {
            trans = new Transicao();
            cont+=3;
            trans.setEstadoCorrente(Character.getNumericValue(s.charAt(cont)));
            cont+=2;
            trans.setSimboloCorrente(s.charAt(cont));
            cont+=6;
            trans.setProximoEstado(Character.getNumericValue(s.charAt(cont)));
            
            cont+=2;
            trans.setProximoSimbolo(s.charAt(cont));
            cont+=2;
            
            trans.setDirecao(s.charAt(cont));
            cont+=2;
            listTrans.add(trans);
        }
        tm.setTransicao(listTrans);
        cont+=3;
        tm.setEstadoInicial(Character.getNumericValue(s.charAt(cont)));
        cont+=3;
        
        while(s.charAt(cont) != ')'){
            cont++;
            estadoFinal.add(Character.getNumericValue(s.charAt(cont)));
            cont+=2;
        }
        estFinal.setEstados(estadoFinal);
        tm.setEstadosFinais(estFinal);
        return tm;
    }

    private String readInstructions() {
        String Instructions = new String();
        if (this.f.exists()) {
            if ("r".equals(this.openType)) {
                try {
                    while (this.br.ready()) {
                        Instructions += this.br.readLine();
                    }
                } catch (IOException e) {
                }
            } else {
                System.out.println("this file was not open to read mode");
                return null;
            }
            return Instructions;
        }
        System.out.println("this file was not created");
        return null;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
}
