package com.tgid.TesteTec.model;

import com.tgid.TesteTec.repository.Usuario;

public class Cliente implements Usuario {
    private String cpf;

    public Cliente(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String getId() {
        return cpf;
    }
}