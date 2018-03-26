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
import com.sun.xml.internal.ws.util.StringUtils;
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
    private final Erros erro = new Erros();
    private String rua;
    private String numero;
    private String cep;
    private String bairro;
    private String complemento;
    
    public void excluir(){
        bairro = "";
        cep = "";
        cidade = "";
        complemento = "";
        estado = "";
        numero = "";
        rua = "";
        uf = "";
    }
    
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = leia.next();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = leia.next();
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = leia.next();
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro() {
        this.bairro = leia.next();

    }

    public String getComplemento() {
        return StringUtils.capitalize(complemento);
    }

    public void setComplemento(String complementos) {
        this.complemento = leia.next();
    }

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
        System.out.println("-------------------ENDEREÇO-----------------------");
        System.out.println("Estado: " + uf + " - " + estado);
        System.out.println("Cidade: " + cidade);
        System.out.println("Bairro:" + bairro);
        System.out.println("Rua: " + rua);
        System.out.println("CEP: " + cep);
        System.out.println("Numero: " + numero);
        try {
            if (!complemento.isEmpty()) {
                System.out.println("Dados Complementares: " + complemento);
            }
        } catch (NullPointerException e) {
            System.out.println("Sem Dados Complementares!");
        }
    }

    @Override
    public void entrada() {
        System.out.println("-------------------ENDEREÇO-----------------------");
        System.out.println("Digite a Sigra de seu Estado: ");
        validarUf();
        System.out.println("//////////////////////--///////////////////////////");
        System.out.println("Digite a opção de sua cidade: ");
        selectCidade();
        System.out.println("Digite seu CEP (Apenas Numeros): ");
        validarCep();
        System.out.println("Bairro: ");
        validarBairro();
        System.out.println("Digite a sua Rua: ");
        ruaValida();
        System.out.println("Digite o Numero da Casa :");
        numeroValido();
        comple();

    }

    @Override
    public void ufValida() {
        do {
            setUf(uf);
            String ufOpt = uf.toUpperCase();
            Pattern pattern = Pattern.compile("\\d");
            Pattern pattern1 = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(ufOpt);
            Matcher matcher1 = pattern1.matcher(ufOpt);
            if (ufOpt.length() != 2) {
                System.out.println(erro.getERRO_SIGLA1());
                uf = "";
            } else if (matcher.find()) {
                System.out.println(erro.getERRO_SIGLA2());
                uf = "";
            } else if (matcher1.find()) {
                System.out.println(erro.getERRO_SIGLA3());
                uf = "";
            } else {
                uf = ufOpt.toUpperCase();
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

    public void validarBairro() {
        do {
            setBairro();
            String br = getBairro().toLowerCase();
            Pattern pattern = Pattern.compile("\\W");
            Pattern pattern1 = Pattern.compile("\\d");
            Matcher matcher = pattern.matcher(br);
            Matcher matcher1 = pattern1.matcher(br);
            if (matcher.find()) {
                System.out.println(erro.getERRO_CARACTER_PADRAO());
                bairro = "";
            } else if (matcher1.find()) {
                System.out.println(erro.getERRO_NUMERO_PADRAO());
                bairro = "";
            } else {
                bairro = StringUtils.capitalize(br);
            }
        } while (bairro.isEmpty());

    }

    public void numeroValido() {
        do {
            setNumero(numero);
            String num = getNumero();
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(num);
            if (matcher.find()) {
                System.out.println(erro.getERRO_CARACTER_PADRAO());
                numero = "";
            } else if (num.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                System.out.println(erro.getERRO_NUMERO_PADRAO());
                numero = "";
            } else {
                numero = num;
            }
        } while (numero.isEmpty());

    }

    public void ruaValida() {
        do {
            setRua(rua);
            String r = getRua().toLowerCase();
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(r);
            if (matcher.find()) {
                System.out.println(erro.getERRO_CARACTER_PADRAO());
                rua = "";
            } else if (r.matches("\\d")) {
                System.out.println(erro.getERRO_STRING_PADRAO());
                rua = "";
            } else {
                rua = StringUtils.capitalize(r);
            }
        } while (rua.isEmpty());

    }

    public void validarCep() {
        do {
            setCep(cep);
            String cp = getCep();
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(cp);
            if (matcher.find()) {
                System.out.println(erro.getERRO_CARACTER_PADRAO());
                cep = "";
            } else if (cp.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                System.out.println(erro.getERRO_NUMERO_PADRAO());
                cep = "";
            } else {
                cep = cp.substring(0, 5) + "-" + cp.substring(5);
            }
        } while (cep.isEmpty());
    }

    public void comple() {
        System.out.println("Deseja Inserir Dados Complementares sobre seu Endereço? ");
        System.out.println("1 - SIM || 2 - NÃO");
        System.out.print("|Opcão ---> ");
        do {
            setOpt(opt);
            if (opt == 1) {
                setComplemento(complemento);
            } else if (opt < 1 || opt > 2) {
                System.out.println(erro.getERRO_OPCAO());
                opt = -1;
            } else if (opt == 2) {
                complemento = "";
            }
        } while (opt < 0);
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
            case "GO":
                cidadesGo();
                break;
            case "MA":
                cidadesMa();
                break;
            case "MT":
                cidadesMt();
                break;
            case "MS":
                cidadesMs();
                break;
            case "MG":
                cidadesMg();
                break;
            case "PA":
                cidadesPa();
                break;
            case "PB":
                cidadesPb();
                break;
            case "PR":
                cidadesPr();
                break;
            case "PE":
                cidadesPe();
                break;
            case "PI":
                cidadesPi();
                break;
            case "RJ":
                cidadesRj();
                break;
            case "RN":
                cidadesRn();
                break;
            case "RS":
                cidadesRs();
                break;
            case "RO":
                cidadesRo();
                break;
            case "RR":
                cidadesRo();
                break;
            case "SC":
                cidadesSc();
                break;
            case "SP":
                cidadesSp();
                break;
            case "SE":
                cidadesSe();
                break;
            case "TO":
                cidadesSc();
                break;
        }
    }

    @Override
    public void validaOpt() {
        do {
            System.out.print("|Opcão ---> ");
            try {
                setOpt(opt);
                int optN = getOpt();
                if (opt < 0 || opt > 5) {
                    System.out.println(erro.getERRO_OPCAO());
                    opt = -1;
                }
            } catch (Exception e) {
                System.out.println(erro.getERRO_CARACTER_PADRAO());
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
            System.out.println("|" + numero + " " + s);
            System.out.print("|");
            System.out.println("-------------------------");
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
            System.out.println("|" + numero + " " + s);
            System.out.print("|");
            System.out.println("-------------------------");
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
            System.out.println("|" + numero + " " + s);
            System.out.print("|");
            System.out.println("-------------------------");
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
            System.out.println("|" + numero + " " + s);
            System.out.print("|");
            System.out.println("-------------------------");
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
            System.out.println("|" + numero + " " + s);
            System.out.print("|");
            System.out.println("-------------------------");
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
            System.out.println("|" + numero + " " + s);
            System.out.print("|");
            System.out.println("-------------------------");
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
        String[] city = new String[5];
        city[0] = "Abadia de Goias";
        city[1] = "Abadiania";
        city[2] = "Acreuna";
        city[3] = "Adelandia";
        city[4] = "Agua Fria de Goias";
        int numero = 1;
        System.out.println("------Cidades - DF-------");
        for (String s : city) {
            System.out.println("|" + numero + " " + s);
            System.out.print("|");
            System.out.println("-------------------------");
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
    public void cidadesEs() {
        String[] city = new String[5];
        city[0] = "Afonso Claudio";
        city[1] = "Agua Doce do Norte";
        city[2] = "Aguia Branca";
        city[3] = "Alegre";
        city[4] = "Alfredo Chaves";
        int numero = 1;
        System.out.println("------Cidades - ES-------");
        for (String s : city) {
            System.out.println("|" + numero + " " + s);
            System.out.print("|");
            System.out.println("-------------------------");
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
    public void cidadesGo() {
        String[] city = new String[5];
        city[0] = "Barro Alto";
        city[1] = "Bela Vista de Goias";
        city[2] = "Bom Jardim de Goias";
        city[3] = "Bom Jesus de Goias";
        city[4] = "Bonfinopolis";
        int numero = 1;
        System.out.println("------Cidades - GO-------");
        for (String s : city) {
            System.out.println("|" + numero + " " + s);
            System.out.print("|");
            System.out.println("-------------------------");
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
    public void cidadesMa() {
        String[] city = new String[5];
        city[0] = "Acailandia";
        city[1] = "Afonso Cunha";
        city[2] = "Agua Doce do Maranhao";
        city[3] = "Alcantara";
        city[4] = "Aldeias Altas";
        int numero = 1;
        System.out.println("------Cidades - MA-------");
        for (String s : city) {
            System.out.println("|" + numero + " " + s);
            System.out.print("|");
            System.out.println("-------------------------");
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
    public void cidadesMt() {
        String[] city = new String[5];
        city[0] = "Acorizal";
        city[1] = "Agua Boa";
        city[2] = "Alta Floresta";
        city[3] = "Alto Araguaia";
        city[4] = "Alto Boa Vista";
        int numero = 1;
        System.out.println("------Cidades - MT-------");
        for (String s : city) {
            System.out.println("|" + numero + " " + s);
            System.out.print("|");
            System.out.println("-------------------------");
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
    public void cidadesMs() {
        String[] city = new String[5];
        city[0] = "Agua Clara";
        city[1] = "Alcinopolis";
        city[2] = "Amambai";
        city[3] = "Anastacio";
        city[4] = "Anaurilandia";
        int numero = 1;
        System.out.println("------Cidades - MS-------");
        for (String s : city) {
            System.out.println("|" + numero + " " + s);
            System.out.print("|");
            System.out.println("-------------------------");
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
    public void cidadesMg() {
        String[] city = new String[5];
        city[0] = "Abadia dos Dourados";
        city[1] = "Abaete";
        city[2] = "Abre Campo";
        city[3] = "Acaiaca";
        city[4] = "Acucena";
        int numero = 1;
        System.out.println("------Cidades - MG-------");
        for (String s : city) {
            System.out.println("|" + numero + " " + s);
            System.out.print("|");
            System.out.println("-------------------------");
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
    public void cidadesPa() {
        String[] city = new String[5];
        city[0] = "Abaetetuba";
        city[1] = "Abel Figueiredo";
        city[2] = "Acara";
        city[3] = "Afua";
        city[4] = "Agua Azul do Norte";
        int numero = 1;
        System.out.println("------Cidades - PA-------");
        for (String s : city) {
            System.out.println("|" + numero + " " + s);
            System.out.print("|");
            System.out.println("-------------------------");
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
    public void cidadesPb() {
        String[] city = new String[5];
        city[0] = "Agua Branca";
        city[1] = "Aguiar";
        city[2] = "Alagoa Grande";
        city[3] = "Alagoa Nova";
        city[4] = "Alagoinha";
        int numero = 1;
        System.out.println("------Cidades - PB-------");
        for (String s : city) {
            System.out.println("|" + numero + " " + s);
            System.out.print("|");
            System.out.println("-------------------------");
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
    public void cidadesPr() {
        String[] city = new String[5];
        city[0] = "Abatia";
        city[1] = "Adrianopolis";
        city[2] = "Agudos do Sul";
        city[3] = "Almirante Tamandare";
        city[4] = "Altamira do Parana";
        int numero = 1;
        System.out.println("------Cidades - PR-------");
        for (String s : city) {
            System.out.println("|" + numero + " " + s);
            System.out.print("|");
            System.out.println("-------------------------");
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
    public void cidadesPe() {
        String[] city = new String[5];
        city[0] = "Abreu e Lima";
        city[1] = "Afogados da Ingazeira";
        city[2] = "Afranio";
        city[3] = "Agrestina";
        city[4] = "Agua Preta";
        int numero = 1;
        System.out.println("------Cidades - PE-------");
        for (String s : city) {
            System.out.println("|" + numero + " " + s);
            System.out.print("|");
            System.out.println("-------------------------");
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
    public void cidadesPi() {
        String[] city = new String[5];
        city[0] = "Acaua";
        city[1] = "Agricolandia";
        city[2] = "Agua Branca";
        city[3] = "Alagoinha do Piaui";
        city[4] = "Alegrete do Piaui";
        int numero = 1;
        System.out.println("------Cidades - PI-------");
        for (String s : city) {
            System.out.println("|" + numero + " " + s);
            System.out.print("|");
            System.out.println("-------------------------");
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
    public void cidadesRj() {
        String[] city = new String[5];
        city[0] = "Rio de Janeiro";
        city[1] = "Petrópoles";
        city[2] = "Cabo Frio";
        city[3] = "Angla dos Reis";
        city[4] = "Macaé";
        int numero = 1;
        System.out.println("------Cidades - RJ-------");
        for (String s : city) {
            System.out.println("|" + numero + " " + s);
            System.out.print("|");
            System.out.println("-------------------------");
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
    public void cidadesRn() {
        String[] city = new String[5];
        city[0] = "Acari";
        city[1] = "Acu";
        city[2] = "Afonso Bezerra";
        city[3] = "Agua Nova";
        city[4] = "Alexandria";
        int numero = 1;
        System.out.println("------Cidades - RN-------");
        for (String s : city) {
            System.out.println("|" + numero + " " + s);
            System.out.print("|");
            System.out.println("-------------------------");
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
    public void cidadesRs() {
        String[] city = new String[5];
        city[0] = "Agua Santa";
        city[1] = "Agudo";
        city[2] = "Ajuricaba";
        city[3] = "Alecrim";
        city[4] = "Alegrete";
        int numero = 1;
        System.out.println("------Cidades - RS-------");
        for (String s : city) {
            System.out.println("|" + numero + " " + s);
            System.out.print("|");
            System.out.println("-------------------------");
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
    public void cidadesRo() {
        String[] city = new String[5];
        city[0] = "Alta Floresta d'Oeste";
        city[1] = "Alto Alegre do Parecis";
        city[2] = "Alto Paraiso";
        city[3] = "Alvorada d'Oeste";
        city[4] = "Ariquemes";
        int numero = 1;
        System.out.println("------Cidades - RO-------");
        for (String s : city) {
            System.out.println("|" + numero + " " + s);
            System.out.print("|");
            System.out.println("-------------------------");
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
    public void cidadesRr() {
        String[] city = new String[5];
        city[0] = "Alto Alegre";
        city[1] = "Amajari";
        city[2] = "Boa Vista";
        city[3] = "Bonfim";
        city[4] = "Canta";
        int numero = 1;
        System.out.println("------Cidades - RR-------");
        for (String s : city) {
            System.out.println("|" + numero + " " + s);
            System.out.print("|");
            System.out.println("-------------------------");
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
    public void cidadesSc() {
        String[] city = new String[5];
        city[0] = "Chapeco";
        city[1] = "Blumenau";
        city[2] = "Joinville";
        city[3] = "São José";
        city[4] = "Florianópolis";
        int numero = 1;
        System.out.println("------Cidades - SC-------");
        for (String s : city) {
            System.out.println("|" + numero + " " + s);
            System.out.print("|");
            System.out.println("-------------------------");
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
    public void cidadesSp() {
        String[] city = new String[5];
        city[0] = "Campinas";
        city[1] = "Jundiaí";
        city[2] = "Santos";
        city[3] = "São Paulo";
        city[4] = "Sorocaba";
        int numero = 1;
        System.out.println("------Cidades - SP-------");
        for (String s : city) {
            System.out.println("|" + numero + " " + s);
            System.out.print("|");
            System.out.println("-------------------------");
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
    public void cidadesSe() {
        String[] city = new String[5];
        city[0] = "Amparo de Sao Francisco";
        city[1] = "Aquidaba";
        city[2] = "Aracaju";
        city[3] = "Araua";
        city[4] = "Areia Branca";
        int numero = 1;
        System.out.println("------Cidades - SE-------");
        for (String s : city) {
            System.out.println("|" + numero + " " + s);
            System.out.print("|");
            System.out.println("-------------------------");
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
    public void cidadesTo() {
        String[] city = new String[5];
        city[0] = "Araguaína";
        city[1] = "Almas";
        city[2] = "Gurupi";
        city[3] = "Palmas";
        city[4] = "Paranã";

        int numero = 1;
        System.out.println("------Cidades - TO-------");
        for (String s : city) {
            System.out.println("|" + numero + " " + s);
            System.out.print("|");
            System.out.println("-------------------------");
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

}
