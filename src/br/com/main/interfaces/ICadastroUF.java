/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.main.interfaces;

/**
 *
 * @author renanperes
 */
public interface ICadastroUF extends ICadastro{
    void ufValida();
    void validarUf();
    
    @Override
    void entrada();
    
    @Override
    void imprimir();
}
