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
        for (Ator atorAtual : atores) {
            if (atorAtual.getNome().equalsIgnoreCase(nomeBuscado)) {
                return atorAtual;
            }
        }
        return null;
    }

    //@author Maria Brenda
    public Diretor buscarDiretorPorNome(String nomeBuscado) {
        for (Diretor diretorAtual : diretores) {
            if (diretorAtual.getNome().equalsIgnoreCase(nomeBuscado)) {
                return diretorAtual;
            }
        }
        return null;
    }

}
