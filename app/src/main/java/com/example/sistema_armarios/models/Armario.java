package com.example.sistema_armarios.models;



public class Armario {

    private int id_armario;
    private String cor;
    private String chave;

    @Override
    public String toString() {
        return chave;
    }
    // Construtores
    public Armario() {}
    public Armario(String cor, String chave) {
        this.cor = cor;
        this.chave = chave;
    }

    public int getId_armario() {
        return id_armario;
    }

    public void setId_armario(int id_armario) {
        this.id_armario = id_armario;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }
}
