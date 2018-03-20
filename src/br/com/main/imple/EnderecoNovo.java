/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.main.imple;

import br.com.main.Exceptions.Erros;
import br.com.main.interfaces.ICadastro;
import static br.com.main.interfaces.ICadastro.leia;
import br.com.main.interfaces.ICadastroCidade;
import br.com.main.interfaces.ICadastroUF;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author renanperes
 */
public class EnderecoNovo implements ICadastro, ICadastroUF, ICadastroCidade {

    private String uf;
    private String estado;
    private int opt;
    private String cidade;
    private Erros erro;

    public int getOpt() {
        return opt;
    }

    public void setOpt(int opt) {
        this.opt = leia.nextInt();
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf.toUpperCase();
    }

    public String getEstado() {
        return estado;
    }

    public void setUf(String uf) {
        this.uf = leia.next();
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public void imprimir() {
        System.out.println("Estado: " + uf + " - " + estado);
        System.out.println("Cidade: " + cidade);
    }

    @Override
    public void entrada() {
        System.out.println("Digite a Sigra de seu Estado: ");
        validarUf();
        System.out.println("//////////////////////--///////////////////////////");
        System.out.println("Digite a opção de sua cidade: ");
        selectCidade();
    }

    @Override
    public void ufValida() {
        do {
            setUf(uf);
            String ufOpt = uf.toUpperCase();
            if (ufOpt.length() != 2) {
                System.out.println(erro.getERRO_SIGLA1());
                uf = "";
            } else {
                Pattern pattern = Pattern.compile("\\d");
                Pattern pattern1 = Pattern.compile("\\W");
                Matcher matcher = pattern.matcher(ufOpt);
                Matcher matcher1 = pattern1.matcher(ufOpt);
                if (matcher.find()) {
                    System.out.println(erro.getERRO_SIGLA2());
                    uf = "";
                } else if (matcher1.find()) {
                    System.out.println(erro.getERRO_SIGLA3());
                    uf = "";
                }
            }
        } while (uf.isEmpty());
    }

    @Override
    public void validarUf() {
        Map<String, String> estados = new HashMap<>();
        estados.put("AC", "Acre");
        estados.put("AL", "Alagoas");
        estados.put("AP", "Amapá");
        estados.put("AM", "Amazonas");
        estados.put("BA", "Bahia");
        estados.put("CE", "Ceará");
        estados.put("DF", "Distrito Federal");
        estados.put("ES", "Espirito Santo");
        estados.put("GO", "Goiás");
        estados.put("MA", "Maranhão");
        estados.put("MT", "Mato Grosso");
        estados.put("MS", "Mato Grosso do Sul");
        estados.put("MG", "Minas Gerais");
        estados.put("PA", "Pará");
        estados.put("PB", "Paraíba");
        estados.put("PR", "Paraná");
        estados.put("PE", "Pernambuco");
        estados.put("PI", "Piauí");
        estados.put("RJ", "Rio de Janeiro");
        estados.put("RN", "Rio Grande do Norte");
        estados.put("RS", "Rio Grande do Sul");
        estados.put("RO", "Rondônia");
        estados.put("RR", "Roraima");
        estados.put("SC", "Santa Catarina");
        estados.put("SP", "São Paulo");
        estados.put("SE", "Sergipe");
        estados.put("TO", "Tocantins");
        do {
            ufValida();
            try {
                String ufOpt = uf.toUpperCase();
                String value = estados.get(ufOpt);
                if (!value.isEmpty()) {
                    uf = ufOpt;
                    estado = value;
                }
            } catch (NullPointerException e) {
                System.out.println(erro.getERRO_ESTADO_NOT_FOUND());
                uf = "";
                estado = "";
            }

        } while (uf.isEmpty());
    }

    @Override
    public void selectCidade() {
        switch (uf) {
            case "AC":
                cidadesAc();
                break;
            case "AL":
                cidadesAl();
                break;
            case "AP":
                cidadesAp();
                break;
            case "AM":
                cidadesAm();
                break;
            case "BA":
                cidadesBa();
                break;
            case "CE":
                cidadesCe();
                break;
            case "DF":
                cidadesDf();
                break;
            case "ES":
                cidadesEs();
                break;
        }
    }

    @Override
    public void validaOpt() {
        do {
            setOpt(opt);
            if (opt < 0 || opt > 5) {
                System.out.println(erro.getERRO_OPCAO());
                opt = -1;
            }

        } while (opt < 0);
    }

    @Override
    public void cidadesAc() {
        String[] city = new String[5];
        city[0] = "Acrelandia";
        city[1] = "Assis Brasil";
        city[2] = "Brasileia";
        city[3] = "Bujari";
        city[4] = "Capixaba";
        int numero = 1;
        System.out.println("------Cidades - AC-------");
        for (String s : city) {
            System.out.println(numero + " " + s);
            numero++;
        }
        do {
            validaOpt();
            switch (opt) {
                case 1:
                    cidade = city[0];
                    break;
                case 2:
                    cidade = city[1];
                    break;
                case 3:
                    cidade = city[2];
                    break;
                case 4:
                    cidade = city[3];
                    break;
                case 5:
                    cidade = city[4];
                    break;
            }

        } while (cidade.isEmpty());
    }

    @Override
    public void cidadesAl() {
        String[] city = new String[5];
        city[0] = "Agua Branca";
        city[1] = "Anadia";
        city[2] = "Arapiraca";
        city[3] = "Atalaia";
        city[4] = "Barra de Santo Antonio";
        int numero = 1;
        System.out.println("------Cidades - AL-------");
        for (String s : city) {
            System.out.println(numero + " " + s);
            numero++;
        }
        do {
            validaOpt();
            switch (opt) {
                case 1:
                    cidade = city[0];
                    break;
                case 2:
                    cidade = city[1];
                    break;
                case 3:
                    cidade = city[2];
                    break;
                case 4:
                    cidade = city[3];
                    break;
                case 5:
                    cidade = city[4];
                    break;
            }

        } while (cidade.isEmpty());
    }

    @Override
    public void cidadesAp() {
        String[] city = new String[5];
        city[0] = "Amapa";
        city[1] = "Calcoene";
        city[2] = "Cutias";
        city[3] = "Ferreira Gomes";
        city[4] = "Itaubal";
        int numero = 1;
        System.out.println("------Cidades - AP-------");
        for (String s : city) {
            System.out.println(numero + " " + s);
            numero++;
        }
        do {
            validaOpt();
            switch (opt) {
                case 1:
                    cidade = city[0];
                    break;
                case 2:
                    cidade = city[1];
                    break;
                case 3:
                    cidade = city[2];
                    break;
                case 4:
                    cidade = city[3];
                    break;
                case 5:
                    cidade = city[4];
                    break;
            }

        } while (cidade.isEmpty());
    }

    @Override
    public void cidadesAm() {
        String[] city = new String[5];
        city[0] = "Alvaraes";
        city[1] = "Amatura";
        city[2] = "Anama";
        city[3] = "Anori";
        city[4] = "Apui";
        int numero = 1;
        System.out.println("------Cidades - AM-------");
        for (String s : city) {
            System.out.println(numero + " " + s);
            numero++;
        }
        do {
            validaOpt();
            switch (opt) {
                case 1:
                    cidade = city[0];
                    break;
                case 2:
                    cidade = city[1];
                    break;
                case 3:
                    cidade = city[2];
                    break;
                case 4:
                    cidade = city[3];
                    break;
                case 5:
                    cidade = city[4];
                    break;
            }

        } while (cidade.isEmpty());
    }

    @Override
    public void cidadesBa() {
        String[] city = new String[5];
        city[0] = "Abaira";
        city[1] = "Abare";
        city[2] = "Acajutiba";
        city[3] = "Adustina";
        city[4] = "Agua Fria";
        int numero = 1;
        System.out.println("------Cidades - BA-------");
        for (String s : city) {
            System.out.println(numero + " " + s);
            numero++;
        }
        do {
            validaOpt();
            switch (opt) {
                case 1:
                    cidade = city[0];
                    break;
                case 2:
                    cidade = city[1];
                    break;
                case 3:
                    cidade = city[2];
                    break;
                case 4:
                    cidade = city[3];
                    break;
                case 5:
                    cidade = city[4];
                    break;
            }

        } while (cidade.isEmpty());
    }

    @Override
    public void cidadesCe() {
        String[] city = new String[5];
        city[0] = "Abaiara";
        city[1] = "Acarape";
        city[2] = "Acarau";
        city[3] = "Acopiara";
        city[4] = "Aiuaba";
        int numero = 1;
        System.out.println("------Cidades - CE-------");
        for (String s : city) {
            System.out.println(numero + " " + s);
            numero++;
        }
        do {
            validaOpt();
            switch (opt) {
                case 1:
                    cidade = city[0];
                    break;
                case 2:
                    cidade = city[1];
                    break;
                case 3:
                    cidade = city[2];
                    break;
                case 4:
                    cidade = city[3];
                    break;
                case 5:
                    cidade = city[4];
                    break;
            }

        } while (cidade.isEmpty());
    }

    @Override
    public void cidadesDf() {

    }

    @Override
    public void cidadesEs() {

    }

    @Override
    public void cidadesGo() {

    }

    @Override
    public void cidadesMa() {

    }

    @Override
    public void cidadesMt() {

    }

    @Override
    public void cidadesMs() {

    }

    @Override
    public void cidadesMg() {

    }

    @Override
    public void cidadesPa() {

    }

    @Override
    public void cidadesPb() {

    }

    @Override
    public void cidadesPr() {

    }

    @Override
    public void cidadesPe() {

    }

    @Override
    public void cidadesPi() {

    }

    @Override
    public void cidadesRj() {

    }

    @Override
    public void cidadesRn() {

    }

    @Override
    public void cidadesRs() {

    }

    @Override
    public void cidadesRo() {

    }

    @Override
    public void cidadesRr() {

    }

    @Override
    public void cidadesSc() {

    }

    @Override
    public void cidadesSp() {

    }

    @Override
    public void cidadesSe() {

    }

    @Override
    public void cidadesTo() {

    }

}
