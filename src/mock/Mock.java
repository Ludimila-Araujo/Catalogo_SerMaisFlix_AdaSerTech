package mock;

import java.time.LocalDate;
import model.Ator;
import model.Diretor;
import model.Filme;
import service.FilmeService;
import service.PessoaService;

/**
 * Classe "Mock" que representa a simulação de dados para o sistema SerMaisFlix,
 * permitindo a inicialização de filmes, atores e diretores pré-cadastrados.
 *
 * @author Enei Pereira
 */
public class Mock {

    private Mock() {
    }

    public static void inicializarDados(FilmeService filmeService, PessoaService pessoaService) {
        Filme filme = new Filme(
                "Estrelas da Noite",
                LocalDate.of(2021, 11, 12),
                7_500_000.00,
                "Um drama sobre cinco artistas que enfrentam desafios para montar um grande espetaculo."
        );

        Diretor diretor = new Diretor(
                "Helena Duarte",
                LocalDate.of(1978, 3, 19),
                "Brasileira",
                "Drama"
        );

        Ator ator1 = new Ator("Lucas Reis", LocalDate.of(1990, 6, 8), "Brasileiro", 120_000.00);
        Ator ator2 = new Ator("Marina Costa", LocalDate.of(1988, 9, 27), "Brasileira", 135_000.00);
        Ator ator3 = new Ator("Thiago Lima", LocalDate.of(1995, 1, 15), "Brasileiro", 95_000.00);
        Ator ator4 = new Ator("Carla Nunes", LocalDate.of(1992, 12, 3), "Brasileira", 110_000.00);
        Ator ator5 = new Ator("Renata Alves", LocalDate.of(1985, 4, 25), "Brasileira", 140_000.00);

        pessoaService.cadastrarDiretor(diretor);
        pessoaService.cadastrarAtor(ator1);
        pessoaService.cadastrarAtor(ator2);
        pessoaService.cadastrarAtor(ator3);
        pessoaService.cadastrarAtor(ator4);
        pessoaService.cadastrarAtor(ator5);

        filmeService.cadastrarFilme(filme);
        filmeService.associarDiretorAoFilme(filme, diretor);
        filmeService.associarAtorAoFilme(filme, ator1);
        filmeService.associarAtorAoFilme(filme, ator2);
        filmeService.associarAtorAoFilme(filme, ator3);
        filmeService.associarAtorAoFilme(filme, ator4);
        filmeService.associarAtorAoFilme(filme, ator5);
    }
}
