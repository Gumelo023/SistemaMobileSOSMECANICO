package com.tcc.tccmecanico;

public class Usuario {



    private String nome;
    private String email;
    private String senha;
    private String nivelAcesso;
    private String foto;
    private String dataCadastro;
    private String statusUsuario;



    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(String statusUsuario) {
        this.statusUsuario = statusUsuario;
    }

    public Usuario( String nome1, String email, String senha, String nivelAcesso, String foto, String dataCadastro, String statusUsuario) {

        this.nome = nome1;
        this.email = email;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
        this.foto = foto;
        this.dataCadastro = dataCadastro;
        this.statusUsuario = statusUsuario;
    }
}
