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

    public Ator buscarAtorPorNome(String nomeBuscado) {
        for (Ator atorAtual : atores) {
            if (atorAtual.getNome().equalsIgnoreCase(nomeBuscado)) {
                return atorAtual;
            }
        }
        System.out.println("⚠️ Ator/Atriz não encontrado(a) no sistema.");
        return null;
    }

    public Diretor buscarDiretorPorNome(String nomeBuscado) {
        for (Diretor diretorAtual : diretores) {
            if (diretorAtual.getNome().equalsIgnoreCase(nomeBuscado)) {
                return diretorAtual;
            }
        }
        System.out.println("⚠️ Diretor(a) não encontrado(a) no sistema.");
        return null;
    }

}
