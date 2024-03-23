package com.tgid.TesteTec.model;

import com.tgid.TesteTec.repository.Usuario;

public class Empresa implements Usuario {
    private String cnpj;
    private double saldo;
    private static final double TaxaFixa = 0.05;
   
    public Empresa(String cnpj, double taxa) {
        this.cnpj = cnpj;
   
    }

    public String getCnpj() {
        return cnpj;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        saldo -= valor;
    }

    public double calcularTaxa(double valor) {
    	return valor * TaxaFixa;
    }

    @Override
    public String getId() {
        return cnpj;
    }


}