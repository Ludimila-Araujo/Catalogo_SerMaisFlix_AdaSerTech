package service;

import java.util.ArrayList;
import java.util.List;
import model.*;

public class FilmeService {
  private final List<Filme> filmes = new ArrayList<>();

  public void cadastrarFilme(Filme filme) {
    filmes.add(filme);
    System.out.println("\nFilme cadastrado com sucesso: " + filme.getNome());
  }

  public Filme buscarFilmePorNome(String nomeBuscado) {
    for (Filme filmeAtual : filmes) {
      if (filmeAtual.getNome().equalsIgnoreCase(nomeBuscado)) {
        return filmeAtual;
      }
    }
    System.out.println("⚠️ Filme não encontrado no sistema.");
    return null;
  }

  public void associarAtorAoFilme(Filme filme, Ator ator) {
    filme.adicionarAtor(ator);

    System.out.println("A associação entre ator/atriz e filme foi feita com sucesso!");

  }

  public void associarDiretorAoFilme(Filme filme, Diretor diretor) {
    filme.definirDiretor(diretor);

    System.out.println("A associação entre diretor(a) e filme foi feita com sucesso!");
  }

  public void imprimirFichaTecnicaFilme (Filme filme) {

    System.out.println("--- Ficha Técnica do Filme ---");
    System.out.println("• Nome: " +filme.getNome()+";");
    System.out.println("• Data de lançamento: " +filme.getDataLancamento()+";");
    System.out.println("• Diretor(a) atual: " +filme.getDiretor().getNome()+";");
    System.out.println("• Elenco: ");

    for (Ator ator : filme.getAtores()) {
      System.out.println("  "+ator.getNome());
    }

  }

}
