/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.main.classes;

import br.com.main.classes.abstracts.Pessoa;

/**
 *
 * @author renanperes
 */
public class Teste extends Pessoa {

    private String nome;

    public Teste() {
        this.nome = "";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = leia.next();
    }

    @Override
    public void entrada() {
        System.out.println("Digite seu Nome: ");
        setNome(nome);
        super.entrada();
    }

    @Override
    public void imprimir() {
        System.out.println("Nome: " + nome);
        super.imprimir();

    }

}
