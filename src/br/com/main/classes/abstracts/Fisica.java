/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.main.classes.abstracts;

import br.com.main.Exceptions.Erros;
import br.com.main.interfaces.ICadastro;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author renanperes
 */
public abstract class Fisica extends Pessoa implements ICadastro {

    private String PES_CPF;
    private String PES_RG;
    private final Erros erro = new Erros();

    public String getCPf() {
        return PES_CPF;
    }

    public String getRg() {
        return PES_RG;
    }

    public void setCpf(String cpf) {
        this.PES_CPF = leia.next();
    }

    public void setRg(String rg) {
        this.PES_RG = leia.next();
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("-------PESSOA FISICA INFORMAÇÕES ADCIONAIS-------");
        System.out.println("CPF: " + PES_CPF);
        System.out.println("RG: " + PES_RG);
    }

    @Override
    public void entrada() {
        super.entrada();
        System.out.println("--------INFORMAÇÕES ADCIONAIS PESSOA FISICA--------");
        System.out.println("Digite seu CPF: ");
        validarCpf();
        System.out.println("Digite seu RG: ");
        validarRg();
    }

    public void validarCpf() {
        do {
            setCpf(PES_CPF);
            String cpf = getCPf();
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(cpf);
            if (cpf.length() != 11) {
                System.out.println(erro.getERRO_TAMANHO_PADRAO());
                PES_CPF = "";
            } else if (cpf.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                System.out.println(erro.getERRO_NUMERO_PADRAO());
                PES_CPF = "";
            } else if (matcher.find()) {
                System.out.println(erro.getERRO_CARACTER_PADRAO());
                PES_CPF = "";
            } else if (cpf.length() != 11) {
                System.out.println(erro.getERRO_CPF());
                PES_CPF = "";
            } else {
//                ( XXX.XXX.XXX-XX ) 
                PES_CPF = cpf.substring(0, 3)
                        + "." + cpf.substring(3, 5)
                        + "." + cpf.substring(5, 7)
                        + "-" + cpf.substring(7);
            }

        } while (PES_CPF.isEmpty());
    }

    public void validarRg() {
        do {
            setRg(PES_RG);
            String rg = getRg();
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(rg);
            if (rg.length() < 13) {
                System.out.println(erro.getERRO_TAMANHO_PADRAO());
                PES_RG = "";
            } else if (matcher.find()) {
                System.out.println(erro.getERRO_CARACTER_PADRAO());
                PES_RG = "";
            } else {
                PES_RG = rg;
            }
        } while (PES_RG.isEmpty());
    }

}
