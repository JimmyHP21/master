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

    private final String ERRO_NOME1 = "Nome/Sobrenome Devem Conter apenas Letras!! Digite Novamente: ";
    private final String ERRO_NOME2 = "Caracteres Invalidos: Digite Novamente: ";
    private final String ERRO_NUMERO = "Numero Invalido!!Digite Apenas Numeros: ";
    private final String ERRO_NUMERO1 = "Numero Invalido!! Digite um numero valido: ";
    private final String ERRO_SIGLA1 = "Singla Invalida!! Digite uma Sigra Valida: ";
    private final String ERRO_SIGLA2 = "Não pode Conter numeros, Digite uma Sigra Valida: ";
    private final String ERRO_SIGLA3 = "Caracteres Invalidos, Digite uma Sigra Valida: ";
    private final String ERRO_ESTADO_NOT_FOUND = "Não Foi Possivel localizar esse estado! Digite Novamente: ";
    private final String ERRO_OPCAO = "Opção Invalida!! Digite Novamente: ";
    private final String ERRO_EMAIL1 = "Email Invalido!! Digite um email com pelo menos 10 caracteres: ";
    private final String ERRO_EMAIL2 = "Email Invalido!! Digite um email com menos de 64 caracteres: ";
    private final String ERRO_EMAIL3 = "Email Invalido!! Digite um email Valido: ";
    private final String ERRO_DDD1 = "DDD Invalido!! Digite Novamente: ";
    private final String ERRO_DDD2 = "DDD Invalido, Caracteres Invalidos, Digite apenas numeros!! Digite Novamente";
    private final String ERRO_CPF = "CPF Invalido, Digite Novamente";
    private final String ERRO_CNPJ = "CNPJ Invalido, Digite Novamente";
    private final String ERRO_CARACTER_PADRAO = "Caracteres Invalidos!!Digite Novamente: ";
    private final String ERRO_INSCEST = "INSCEST invalido!! Digite Novamente: ";
    private final String ERRO_NUMERO_PADRAO = "Digite apenas Numeros!! Digite Novamente: ";
    private final String ERRO_STRING_PADRAO = "Digite apenas letras!! Digite Novamente: ";
    private final String ERRO_DATA_PADRAO = "Data Invalida!! Digite Novamente";
    private final String ERRO_TAMANHO_DATA ="Data incorreta digite conforme mm/dd/aaaa!! Digite Novamente: ";
    private final String ERRO_TAMANHO_PADRAO = "Tamanho da Informções invalidas!! Digite Novamente: "; 
    private final String ERRO_DIA_JANEIRO = "Dia informado invalido!! Digite um dia correto (1 - 31)";
    private final String ERRO_DIA_FEVEREIRO = "Dia informado invalido!! Digite um dia correto (1 - 28)";
    private final String ERRO_DIA_MARCO = "Dia informado invalido!! Digite um dia correto (1 - 31)";
    private final String ERRO_DIA_ABRIL = "Dia informado invalido!! Digite um dia correto (1 - 30)";
    private final String ERRO_DIA_MAIO = "Dia informado invalido!! Digite um dia correto (1 - 31)";
    private final String ERRO_DIA_JUNHO = "Dia informado invalido!! Digite um dia correto (1 - 30)";
    private final String ERRO_DIA_JULHO = "Dia informado invalido!! Digite um dia correto (1 - 31)";
    private final String ERRO_DIA_AGOSTO = "Dia informado invalido!! Digite um dia correto (1 - 31)";
    private final String ERRO_DIA_SETEMBRO = "Dia informado invalido!! Digite um dia correto (1 - 30)";
    private final String ERRO_DIA_OUTUBRO = "Dia informado invalido!! Digite um dia correto (1 - 31)";
    private final String ERRO_DIA_NOVEMBRO = "Dia informado invalido!! Digite um dia correto (1 - 30)";
    private final String ERRO_DIA_DEZEMBRO = "Dia informado invalido!! Digite um dia correto (1 - 31)";
    private final String ERRO_MES_INVALIDO = "Digite um mês valido (1 - 12)!! Digite Novamente: ";
    private final String ERRO_ANO_INVALIDO1 ="Ano Invalido, Dado Superior ao atual!! Digite Novamante: ";
    private final String ERRO_ANO_INVALIDO2 ="Ano Invalido Digite conforme DIA/MES/XXXX!! Digite Novamente: ";
    private final String ERRO_DIA_INVALIDO ="Dia Invalido Digite conforme XX/MES/ANO!! Digite Novamente: ";
    private final String ERRO_LIMITE = "Limite não pode ser 0!! Digite Novamente: ";
    private final String ERRO_DATA_PADRAO_FORMATO = "Digite a Data no Formato dd/mm/aaaa !!Digite Novamente: ";
    private final String ERRO_SITE = "Site Invalido!! Digite Novamente";
    
    public String getERRO_DATA_PADRAO_FORMATO(){
        return ERRO_DATA_PADRAO_FORMATO;
    }
    
    public String getERRO_LIMITE(){
        return ERRO_LIMITE;
    }

    public String getERRO_DIA_INVALIDO() {
        return ERRO_DIA_INVALIDO;
    }

    
    public String getERRO_ANO_INVALIDO1() {
        return ERRO_ANO_INVALIDO1;
    }

    public String getERRO_ANO_INVALIDO2() {
        return ERRO_ANO_INVALIDO2;
    }

    
    public String getERRO_DIA_JANEIRO() {
        return ERRO_DIA_JANEIRO;
    }

    public String getERRO_DIA_FEVEREIRO() {
        return ERRO_DIA_FEVEREIRO;
    }

    public String getERRO_DIA_MARCO() {
        return ERRO_DIA_MARCO;
    }

    public String getERRO_DIA_ABRIL() {
        return ERRO_DIA_ABRIL;
    }

    public String getERRO_DIA_MAIO() {
        return ERRO_DIA_MAIO;
    }

    public String getERRO_DIA_JUNHO() {
        return ERRO_DIA_JUNHO;
    }

    public String getERRO_DIA_JULHO() {
        return ERRO_DIA_JULHO;
    }

    public String getERRO_DIA_AGOSTO() {
        return ERRO_DIA_AGOSTO;
    }

    public String getERRO_DIA_SETEMBRO() {
        return ERRO_DIA_SETEMBRO;
    }

    public String getERRO_DIA_OUTUBRO() {
        return ERRO_DIA_OUTUBRO;
    }

    public String getERRO_DIA_NOVEMBRO() {
        return ERRO_DIA_NOVEMBRO;
    }

    public String getERRO_DIA_DEZEMBRO() {
        return ERRO_DIA_DEZEMBRO;
    }

    public String getERRO_MES_INVALIDO() {
        return ERRO_MES_INVALIDO;
    }
    
    
    public String getERRO_TAMANHO_PADRAO(){
        return ERRO_TAMANHO_PADRAO;
    }
    
    public String getERRO_TAMANHO_DATA(){
        return ERRO_TAMANHO_DATA;
    }
    
    public String getERRO_DATA_PADRAO(){
        return ERRO_DATA_PADRAO;
    }
    
    public String getERRO_STRING_PADRAO(){
        return ERRO_STRING_PADRAO;
    }
    
    public String getERRO_NUMERO_PADRAO(){
        return ERRO_NUMERO_PADRAO;
    }
    
    public String getERRO_INSCEST(){
        return ERRO_INSCEST;
    }

    public String getERRO_CPF() {
        return ERRO_CPF;
    }

    public String getERRO_CNPJ() {
        return ERRO_CNPJ;
    }

    public String getERRO_CARACTER_PADRAO() {
        return ERRO_CARACTER_PADRAO;
    }

    public String getERRO_NOME1() {
        return ERRO_NOME1;
    }

    public String getERRO_NOME2() {
        return ERRO_NOME2;
    }

    public String getERRO_DDD1() {
        return ERRO_DDD1;
    }

    public String getERRO_DDD2() {
        return ERRO_DDD2;
    }

    public String getERRO_NUMERO1() {
        return ERRO_NUMERO1;
    }

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
