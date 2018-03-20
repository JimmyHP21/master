/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.main.classes.abstracts;

import br.com.main.Exceptions.Erros;
import br.com.main.imple.EnderecoNovo;
import br.com.main.interfaces.ICadastro;
import com.sun.xml.internal.ws.util.StringUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author renanperes
 */
public abstract class Pessoa extends EnderecoNovo implements ICadastro {

    private int PES_CODIGO;
    private String PES_NOME;
    private String PES_SOBRENOME;
    private String PES_EMAIL;
    private String PES_CELULAR;
    private String PES_FONE;
    private String DDD;
    private EnderecoNovo endereco;
    private Long codigo;
    private final int MAX_LENGHT = 64;
    private final int MIN_LENGHT = 10;
    private Erros erro;

    public String getPesNome() {
        return StringUtils.capitalize(PES_NOME);
    }

    public String getPesSobreNome() {
        return StringUtils.capitalize(PES_SOBRENOME);
    }

    public String getPesEmail() {
        return PES_EMAIL;
    }

    public String getPesCelular() {
        return PES_CELULAR;
    }

    public String getPesFone() {
        return PES_FONE;
    }
    
    public String getDDD(){
        return DDD;
    }

    public void setPesNome(String nome) {
        this.PES_NOME = leia.next();
    }

    public void setPesSobreNome(String sobreNome) {
        this.PES_SOBRENOME = leia.next();
    }

    public void setPesEmail(String email) {
        this.PES_EMAIL = leia.next();
    }
    
    public void setDDD(String ddd){
        this.DDD = leia.next();
    }
    
    public void setPesCelular(String celular) {
        this.PES_CELULAR = leia.next();
    }

    public void setPesFone(String fone) {
        this.PES_FONE = leia.next();
    }

    @Override
    public void entrada() {
        System.out.println("Digite Seu Nome: ");
        setPesNome(PES_NOME);
        System.out.println("Digite seu Sobre Nome: ");
        setPesSobreNome(PES_SOBRENOME);
        System.out.println("Digite seu E-mail");
        validarEmail();
        System.out.println("Digite um Celular");
        super.entrada();
    }

    public void validarEmail() {
        do {
            setPesEmail(PES_EMAIL);
            String email = getPesEmail().toLowerCase();
            if (email.length() < MIN_LENGHT) {
                System.out.println(erro.getERRO_EMAIL1());
                PES_EMAIL = "";
            } else if (email.length() > MAX_LENGHT) {
                System.out.println(erro.getERRO_EMAIL2());
                PES_EMAIL = "";
            } else if (!email.contains("@")) {
                System.out.println(erro.getERRO_EMAIL3());
                PES_EMAIL = "";
            }else{
                PES_EMAIL = email;
            }

        } while (PES_EMAIL.isEmpty());
    }

    public void validarCelular() {
        do {
            setPesCelular(PES_CELULAR);
            String cel = getPesCelular().toLowerCase();
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(cel);
            if (matcher.find()) {
                System.out.println(erro.getERRO_NUMERO());
            } else if (cel.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                System.out.println(erro.getERRO_NUMERO());
            } else if (cel.length() == 9){
                System.out.println("Digite seu DDD: ");
                do{
                    
                }while(DDD.isEmpty());
                setDDD(DDD);
            }else{
                PES_CELULAR = cel;
            }
        } while (PES_CELULAR.isEmpty());
    }
}
