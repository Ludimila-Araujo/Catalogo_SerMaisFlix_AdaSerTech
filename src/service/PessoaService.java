package service;

import java.util.ArrayList;
import java.util.List;
import model.Ator;
import model.Diretor;

/**
 * Classe "PessoaService" que representa os serviços relacionados às pessoas do
 * sistema SerMaisFlix, como cadastro e busca de atores/atrizes e
 * diretores/diretoras.
 *
 * @author Ludimila Araujo
 */
public class PessoaService {

    //criação das listas que guardarão os atores e diretores
    private final List<Ator> atores = new ArrayList<>();
    private final List<Diretor> diretores = new ArrayList<>();

    //métodos de cadastros de atores e diretores:
    public void cadastrarAtor(Ator ator) {
        atores.add(ator);
    }

    public void cadastrarDiretor(Diretor diretor) {
        diretores.add(diretor);
    }

    //@author Maria Brenda
    public Ator buscarAtorPorNome(String nomeBuscado) {
        if (nomeBuscado == null || nomeBuscado.trim().isEmpty()) {
            return null;
        }
        for (Ator atorAtual : atores) {
            if (atorAtual.getNome().toLowerCase().contains(nomeBuscado.toLowerCase())) {
                return atorAtual;
            }
        }
        return null;
    }

    //@author Maria Brenda
    public Diretor buscarDiretorPorNome(String nomeBuscado) {
        if (nomeBuscado == null || nomeBuscado.trim().isEmpty()) {
            return null;
        }
        for (Diretor diretorAtual : diretores) {
            if (diretorAtual.getNome().toLowerCase().contains(nomeBuscado.toLowerCase())) {
                return diretorAtual;
            }
        }
        return null;
    }

    public List<Ator> listarAtores() {
        return atores;
    }

    public List<Diretor> listarDiretores() {
        return diretores;
    }

}
