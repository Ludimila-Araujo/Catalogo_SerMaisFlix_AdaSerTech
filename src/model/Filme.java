package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe "Filme" que representa os filmes do sistema SerMaisFlix.
 *
 * @author Enei Pereira
 */
public class Filme {

    //atributos:
    private static Long idCounter = 1L;

    private final Long id;
    private final String nome;
    private final LocalDate dataLancamento;
    private final double orcamento;
    private final String descricao;

    //@author Maria Brenda
    private Diretor diretor;
    //@author Maria Brenda
    private final List<Ator> atores = new ArrayList<>();

    //construtor:
    public Filme(String nome, LocalDate dataLancamento, double orcamento, String descricao) {
        this.id = idCounter++;
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.descricao = descricao;

    }

    //getters e setters:
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    //métodos: métodos visualizados dentro do diagrama UML
    public void definirDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public void adicionarAtor(Ator ator) {
        this.atores.add(ator);
    }

    @Override
    public String toString() {
        String nomeDir = (diretor != null) ? diretor.getNome() : "N/A";
        return String.format("[ID %d] %s (%s)\n   Diretor: %s | Elenco: %d atores\n   Resumo: %s",
                id, nome, dataLancamento, nomeDir, atores.size(), descricao);
    }
}
