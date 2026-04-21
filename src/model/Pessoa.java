package model;

import java.time.LocalDate;

/**
 * Classe "Pessoa" que representa as pessoas do sistema SerMaisFlix, como atores/atrizes e diretores/diretoras.
 * 
 * @author Ludimila Araujo
 */
public abstract class Pessoa {

    //atributos:

    private static  Long idCounter = 1L;
    private final Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String nacionalidade;

    //construtor:

    public Pessoa(String nome, LocalDate dataNascimento, String nacionalidade){
        this.id = idCounter++; //id gerado automaticamente
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
    }

    //getters and setters:

    public Long getId(){
        return id;
    }

    // não é preciso um setId o ID é gerado automaticamente!

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }


    //métodos: sem funções até o momento, se precisar, inserir aqui


}

