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
public class Mensagens {
    private final String PAGAMENTO_FEITO = "Pagamento Já Foi Realizado!!";
    private final String PAGAMENTO_DEBITO = "Pagamento ainda em Debito!!";
    
    public String getPagamentoFeito(){
        return PAGAMENTO_FEITO;
    }
    
    public String getPagamentoDebito(){
        return PAGAMENTO_DEBITO;
    }
    
}
