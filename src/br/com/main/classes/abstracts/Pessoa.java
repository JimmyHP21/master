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

    private Long PES_CODIGO;
    private String PES_NOME;
    private String PES_SOBRENOME;
    private String PES_FULL_NAME;
    private String PES_EMAIL;
    private String PES_CELULAR;
    private String PES_FONE;
    private String DDD;
    private String sn;
    private final int MAX_LENGHT = 64;
    private final int MIN_LENGHT = 10;
    private final Erros erro = new Erros();
    
    //VAI SAIR DEPOIS
    public Long getPesCodigo() {
        return PES_CODIGO;
    }

    public void setPesCodigo(Long codigo) {
        this.PES_CODIGO = leia.nextLong();
    }

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

    public String getDDD() {
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

    public void setDDD(String ddd) {
        this.DDD = leia.next();
    }

    public void setPesCelular(String celular) {
        this.PES_CELULAR = leia.next();
    }

    public void setPesFone(String fone) {
        this.PES_FONE = leia.next();
    }

    public void setSn(String sn) {
        this.sn = leia.next();
    }

    public String getSn() {
        return sn.toLowerCase();
    }

    @Override
    public void entrada() {
        System.out.println("Digite Seu Nome: ");
        validarNome();
        System.out.println("Digite seu Sobrenome: ");
        validarSobrenome();
        fullName();
        System.out.println("Já tem um E-mail ? ");
        validaOpcao();
        System.out.println("Digite um Celular(Sem DDD): ");
        validarCelular();
        System.out.println("Digite um Telefone Fixo: ");
        setPesFone(PES_FONE);
        super.entrada();
    }

    @Override
    public void imprimir() {
        System.out.println("Nome Completo: " + PES_FULL_NAME);
        System.out.println("E-mail: " + PES_EMAIL);
        System.out.println("Celeular: " + PES_CELULAR);
        System.out.println("Fone: " +"("+DDD+")"+ PES_FONE);
        super.imprimir();
    }

    public void fullName() {
        PES_FULL_NAME = "";
        String primeiro = getPesNome();
        String segundo = getPesSobreNome();
        PES_FULL_NAME = primeiro + " " + segundo;
    }

    public void validaOpcao() {
        do {
            setSn(sn);
            String opt = getSn();
            if (opt.length() > 1 || opt.length() < 0) {
                System.out.println(erro.getERRO_OPCAO());
                sn = "";
            }else if(opt.equals("s")){
                validarEmail();
            }else if(opt.equals("n")){
                criarEmail();
            }else if(!opt.equals("s") || !opt.equals("n")){
                System.out.println(erro.getERRO_OPCAO());
                sn = "";
            }
        } while (sn.isEmpty());
    }

    public void criarEmail() {
        System.out.println("Digite um endereço de E-mail que deseje usar: ");
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
            } else if (!email.contains(".com")) {
                System.out.println(erro.getERRO_EMAIL3());
                PES_EMAIL = "";
            } else {
                PES_EMAIL = email;
            }
        } while (PES_EMAIL.isEmpty());
    }

    public void validarEmail() {
        System.out.println("Digite seu E-mail: ");
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
            } else if (!email.contains(".com")) {
                System.out.println(erro.getERRO_EMAIL3());
                PES_EMAIL = "";
            } else {
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
                PES_CELULAR = "";
            } else if (cel.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                System.out.println(erro.getERRO_NUMERO());
                PES_CELULAR = "";
            } else if (cel.length() == 9) {
                System.out.println("Digite seu DDD: ");
                do {
                    setDDD(DDD);
                    String ddd = getDDD();
                    Pattern patternDDD = Pattern.compile("\\W");
                    Matcher matcherDDD = patternDDD.matcher(ddd);
                    if (ddd.length() != 2) {
                        System.out.println(erro.getERRO_DDD1());
                        DDD = "";
                    } else if (matcherDDD.find()) {
                        System.out.println(erro.getERRO_DDD2());
                        DDD = "";
                    } else if (ddd.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                        System.out.println(erro.getERRO_DDD2());
                        DDD = "";
                    } else {
                        DDD = ddd;
                        PES_CELULAR = "(" + DDD + ")" + cel.substring(0, 5) + "-" + cel.substring(5);
                    }
                } while (DDD.isEmpty());
            } else if (cel.length() == 8) {
                String numeroCorrigido = "9" + getPesCelular();
                PES_CELULAR = numeroCorrigido;
                System.out.println("Digite seu DDD: ");
                do {
                    setDDD(DDD);
                    String ddd = getDDD();
                    Pattern patternDDD = Pattern.compile("\\W");
                    Matcher matcherDDD = patternDDD.matcher(ddd);
                    if (ddd.length() != 2) {
                        System.out.println(erro.getERRO_DDD1());
                        DDD = "";
                    } else if (matcherDDD.find()) {
                        System.out.println(erro.getERRO_DDD2());
                        DDD = "";
                    } else if (ddd.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                        System.out.println(erro.getERRO_DDD2());
                        DDD = "";
                    } else {
                        DDD = ddd;
                        PES_CELULAR = "(" + DDD + ")" + "9" + cel.substring(0, 4) + "-" + cel.substring(4);
                    }
                } while (DDD.isEmpty());

            } else {
                System.out.println(erro.getERRO_NUMERO1());
            }
        } while (PES_CELULAR.isEmpty());
    }

    public void validarNome() {
        do {
            setPesNome(PES_NOME);
            String nome = getPesNome();
            Pattern pattern = Pattern.compile("\\d");
            Pattern pattern1 = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(nome);
            Matcher matcher1 = pattern1.matcher(nome);
            if (matcher.find()) {
                System.out.println(erro.getERRO_NOME1());
                PES_NOME = "";
            } else if (matcher1.find()) {
                System.out.println(erro.getERRO_NOME2());
                PES_NOME = "";
            }else{
                PES_NOME = nome.toLowerCase();
            }
        } while (PES_NOME.isEmpty());
    }

    public void validarSobrenome() {
        do {
            setPesSobreNome(PES_SOBRENOME);
            String sobreNome = getPesSobreNome();
            Pattern pattern = Pattern.compile("\\d");
            Pattern pattern1 = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(sobreNome);
            Matcher matcher1 = pattern1.matcher(sobreNome);
            if (matcher.find()) {
                System.out.println(erro.getERRO_NOME1());
                PES_SOBRENOME = "";
            } else if (matcher1.find()) {
                System.out.println(erro.getERRO_NOME2());
                PES_SOBRENOME = "";
            } else {
                PES_SOBRENOME = sobreNome.toLowerCase();
            }
        } while (PES_SOBRENOME.isEmpty());
    }
}
