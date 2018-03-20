/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.main.Exceptions;

/**
 *
 * @author renanperes
 */
public class Erros {
    private final String ERRO_NUMERO = "Numero Invalido!!Digite Apenas Numeros: ";
    private final String ERRO_SIGLA1 = "Singla Invalida!! Digite uma Sigra Valida: ";
    private final String ERRO_SIGLA2 = "Não pode Conter numeros, Digite uma Sigra Valida: ";
    private final String ERRO_SIGLA3 = "Caracteres Invalidos, Digite uma Sigra Valida: ";
    private final String ERRO_ESTADO_NOT_FOUND = "Não Foi Possivel localizar esse estado! Digite Novamente: ";
    private final String ERRO_OPCAO = "Opção Invalida!! Digite Novamente: ";
    private final String ERRO_EMAIL1 = "Email Invalido!! Digite um email com pelo menos 10 caracteres: ";
    private final String ERRO_EMAIL2 = "Email Invalido!! Digite um email com menos de 64 caracteres: ";
    private final String ERRO_EMAIL3 = "Email Invalido!! Digite um email Valido: ";

    public String getERRO_NUMERO() {
        return ERRO_NUMERO;
    }

    public String getERRO_SIGLA1() {
        return ERRO_SIGLA1;
    }

    public String getERRO_EMAIL1() {
        return ERRO_EMAIL1;
    }

    public String getERRO_EMAIL2() {
        return ERRO_EMAIL2;
    }

    public String getERRO_EMAIL3() {
        return ERRO_EMAIL3;
    }

    public String getERRO_SIGLA2() {
        return ERRO_SIGLA2;
    }

    public String getERRO_SIGLA3() {
        return ERRO_SIGLA3;
    }

    public String getERRO_ESTADO_NOT_FOUND() {
        return ERRO_ESTADO_NOT_FOUND;
    }

    public String getERRO_OPCAO() {
        return ERRO_OPCAO;
    }
    
    
}
