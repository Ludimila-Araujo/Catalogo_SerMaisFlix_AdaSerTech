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

}
