/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.main.classes;

import br.com.main.classes.abstracts.Financeiro;

/**
 *
 * @author renanperes
 */
public class Pagar extends Financeiro{
    private String FIN_FORNECEDOR;
    private String FIN_BOLETO;
    
    @Override
    public void imprimir(){
        super.imprimir();
    }
    
    @Override
    public void entrada(){
        super.entrada();
    }
}
