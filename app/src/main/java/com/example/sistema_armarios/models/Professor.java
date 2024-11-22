package com.example.sistema_armarios.models;

public class Professor {
    private int id_prof;
    private String nome;
    private int matricula;
    private int fk_armario;

        // Construtores
    public Professor() {}
    public Professor(String nome, int matricula, int fk_armario) {
        this.nome = nome;
        this.matricula = matricula;
        this.fk_armario = fk_armario;
    }

    public int getId_prof() {
        return id_prof;
    }

    public void setId_prof(int id_prof) {
        this.id_prof = id_prof;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getFk_armario() {
        return fk_armario;
    }

    public void setFk_armario(int fk_armario) {
        this.fk_armario = fk_armario;
    }
}
