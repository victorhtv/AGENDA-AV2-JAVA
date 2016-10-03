package com.br.andre.cadastrocaelum;

import java.io.Serializable;

/**
 * Created by andre on 03/09/16.
 */
public class Aluno implements Serializable {
    private int _id;
    private String nome, site, endereco, telefone, foto;
    private double nota;

   public String toString(){
        return nome;
   }

    //Gets
    public int getId() {
        return _id;
    }

    public String getNome() {
        return nome;
    }

    public String getSite() {
        return site;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getFoto() {
        return foto;
    }

    public double getNota() {
        return nota;
    }

    // Sets
    public void setId(int _id) {
        this._id = _id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
