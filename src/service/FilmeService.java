package service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.Ator;
import model.Diretor;
import model.Filme;

/**
 * Classe "FilmeService" que representa os serviços relacionados aos filmes do
 * sistema SerMaisFlix, como cadastro, busca e associação de atores e diretores.
 *
 * @author Enei Pereira
 */
public class FilmeService {

    private final List<Filme> filmes = new ArrayList<>();
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void cadastrarFilme(Filme filme) {
        filmes.add(filme);
    }

    //@author Maria Brenda
    public Filme buscarFilmePorNome(String nomeBuscado) {
        if (nomeBuscado == null || nomeBuscado.trim().isEmpty()) {
            return null;
        }
        for (Filme filmeAtual : filmes) {
            if (filmeAtual.getNome().toLowerCase().contains(nomeBuscado.toLowerCase())) {
                return filmeAtual;
            }
        }
        return null;
    }

    //@author Maria Brenda
    public void associarAtorAoFilme(Filme filme, Ator ator) {
        filme.adicionarAtor(ator);
    }

    //@author Maria Brenda
    public void associarDiretorAoFilme(Filme filme, Diretor diretor) {
        filme.definirDiretor(diretor);
    }

    //@author Maria Brenda
    public String montarFichaTecnicaFilme(Filme filme) {
        StringBuilder ficha = new StringBuilder();
        ficha.append("--- Ficha Técnica do Filme ---\n");
        ficha.append("• Nome: ").append(filme.getNome()).append("\n");
        ficha.append("• Data de lançamento: ").append(filme.getDataLancamento().format(FMT)).append("\n");
        ficha.append(String.format("• Orçamento: R$ %.2f%n", filme.getOrcamento()));
        ficha.append("• Descrição: ").append(filme.getDescricao()).append("\n");
        if (filme.getDiretor() != null) {
            ficha.append("• Diretor(a) atual: ").append(filme.getDiretor().getNome()).append("\n");
        } else {
            ficha.append("• Diretor(a) atual: nenhum diretor foi associado a esse filme.\n");
        }

        ficha.append("• Elenco:\n");
        if (filme.getAtores().isEmpty()) {
            ficha.append("  nenhum ator foi associado a esse filme.\n");
        } else {
            for (Ator ator : filme.getAtores()) {
                ficha.append("  ").append(ator.getNome()).append("\n");
            }
        }
        return ficha.toString();
    }

}
