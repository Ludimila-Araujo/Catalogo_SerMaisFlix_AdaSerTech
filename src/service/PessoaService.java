package service;

import model.Ator;
import model.Diretor;
import java.util.ArrayList;
import java.util.List;

public class PessoaService {

    //criação das listas que guardarão os atores e diretores

    private List<Ator> atores = new ArrayList<>();
    private List<Diretor> diretores = new ArrayList<>();

    //métodos de cadastros de atores e diretores:

    public void cadastrarAtor(Ator ator){
        atores.add(ator);
        System.out.println("Ator/Atriz " + ator.getNome() + " cadastrado(a) com sucesso!");
    }

    public void cadastrarDiretor(Diretor diretor){
        diretores.add(diretor);
        System.out.println("Diretor/Diretora " + diretor.getNome() + " cadastrado(a) com sucesso!");
    }

}
