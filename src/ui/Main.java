package ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import mock.Mock;
import model.Ator;
import model.Diretor;
import model.Filme;
import service.FilmeService;
import service.PessoaService;

/**
 * Classe principal da aplicação SerMaisFlix.
 *
 * @author Ludimila Araujo
 */
public class Main {

    //@author Ludimila Araujo
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        FilmeService filmeService = new FilmeService();
        PessoaService pessoaService = new PessoaService();

        Mock.inicializarDados(filmeService, pessoaService);

        int opcao = -1;

        DateTimeFormatter formatadorData = InputValidator.criarFormatadorData();

        System.out.println("=========================================");
        System.out.println("    🎬 BEM-VINDO AO SER_MAIS_FLIX 🎬    ");
        System.out.println("=========================================");

        while (opcao != 0) {

            System.out.println("\n--- MENU PRINCIPAL ---\n");
            System.out.println("1 - Cadastrar Filme");
            System.out.println("2 - Cadastrar Ator/Atriz");
            System.out.println("3 - Cadastrar Diretor/Diretora");
            System.out.println("4 - Associar ator/atriz, diretor(a) a um filme");
            System.out.println("5 - Buscar Filme por Nome");
            System.out.println("0 - Sair do Sistema");
            opcao = InputValidator.lerInteiroValido(scanner, "\nEscolha uma opção: ");

            switch (opcao) {
                //@author Enei Pereira
                case 1: {
                    System.out.println("\n--- CADASTRAR FILME ---\n");
                    String nome = InputValidator.lerStringNaoVazia(scanner, "Digite o nome do filme: ");

                    LocalDate dataLancamento = InputValidator.lerDataValida(
                            scanner,
                            formatadorData,
                            "Data de lançamento (ex: 5/4/2024 ou 05/04/2024): "
                    );
                    double orcamento = InputValidator.lerDoubleValido(scanner, "Digite o orçamento do filme: ");

                    String descricao = InputValidator.lerStringNaoVazia(scanner, "Digite uma breve descrição do filme: ");
                    Filme novoFilme = new Filme(nome, dataLancamento, orcamento, descricao);
                    filmeService.cadastrarFilme(novoFilme);
                    System.out.println("\nFilme cadastrado com sucesso: " + novoFilme.getNome());
                    break;

                }
                //@author Ludimila Araujo
                case 2: {
                    System.out.println("\n--- CADASTRAR ATOR/ATRIZ ---\n");

                    String nome = InputValidator.lerStringNaoVazia(scanner, "Nome: ");

                    LocalDate dataNascimento = InputValidator.lerDataValida(
                            scanner,
                            formatadorData,
                            "Data de nascimento (ex: 5/4/2024 ou 05/04/2024): "
                    );

                    String nacionalidade = InputValidator.lerStringNaoVazia(scanner, "Nacionalidade: ");

                    double cache = InputValidator.lerDoubleValido(scanner, "Cachê: R$ ");

                    Ator novoAtor = new Ator(nome, dataNascimento, nacionalidade, cache);

                    pessoaService.cadastrarAtor(novoAtor);
                    System.out.println("\nAtor/Atriz " + novoAtor.getNome() + " cadastrado(a) com sucesso!");

                    break;
                }
                //@author Ludimila Araujo
                case 3: {
                    System.out.println("\n--- CADASTRAR DIRETOR(A) ---\n");

                    String nome = InputValidator.lerStringNaoVazia(scanner, "Nome: ");

                    LocalDate dataNascimento = InputValidator.lerDataValida(
                            scanner,
                            formatadorData,
                            "Data de nascimento (ex: 5/4/2024 ou 05/04/2024): "
                    );

                    String nacionalidade = InputValidator.lerStringNaoVazia(scanner, "Nacionalidade: ");
                    String estilo = InputValidator.lerStringNaoVazia(scanner, "Estilo: ");

                    Diretor novoDiretor = new Diretor(nome, dataNascimento, nacionalidade, estilo);

                    pessoaService.cadastrarDiretor(novoDiretor);
                    System.out.println("\nDiretor(a) " + novoDiretor.getNome() + " cadastrado(a) com sucesso!");

                    break;
                }
                //@author Maria Brenda
                case 4: {
                    System.out.println("\n--- Central de Associações ---\n");
                    String nomeDoFilme = InputValidator.lerStringNaoVazia(scanner, "Digite o nome do filme: ");
                    Filme filme = filmeService.buscarFilmePorNome(nomeDoFilme);

                    if (filme == null) {
                        System.out.println("\nFilme não encontrado no sistema. Verifique o nome e tente novamente.");
                        break;
                    }

                    System.out.println("O que deseja associar a '" + filme.getNome() + "'?");
                    System.out.println("1 - Ator/Atriz");
                    System.out.println("2 - Diretor(a)");
                    int tipo = InputValidator.lerInteiroValido(scanner, "Escolha: ");

                    switch (tipo) {
                        case 1: {
                            System.out.println("\n--- Atores/Atrizes Disponíveis ---\n");
                            if (pessoaService.listarAtores().isEmpty()) {
                                System.out.println("Nenhum ator/atriz cadastrado(a) no sistema.");
                                break;
                            } else {
                                for (Ator a : pessoaService.listarAtores()) {
                                    System.out.println("- " + a.getNome());
                                }
                            }

                            Ator ator = pessoaService.buscarAtorPorNome(InputValidator.lerStringNaoVazia(scanner, "\nNome do(a) ator/atriz: "));
                            if (ator != null) {
                                filmeService.associarAtorAoFilme(filme, ator);
                                System.out.println("\nA associação entre ator/atriz e filme foi feita com sucesso!");
                            } else {
                                System.out.println("\nAtor/Atriz não encontrado(a) no sistema.");
                            }
                            break;
                        }
                        case 2: {
                            System.out.println("\n--- Diretores(as) Disponíveis ---\n");
                            if (pessoaService.listarDiretores().isEmpty()) {
                                System.out.println("Nenhum(a) diretor(a) cadastrado(a) no sistema.");
                                break;
                            } else {
                                for (Diretor d : pessoaService.listarDiretores()) {
                                    System.out.println("- " + d.getNome());
                                }
                            }

                            Diretor diretor = pessoaService.buscarDiretorPorNome(InputValidator.lerStringNaoVazia(scanner, "\nNome do(a) diretor(a): "));
                            if (diretor != null) {
                                filmeService.associarDiretorAoFilme(filme, diretor);
                                System.out.println("\nA associação entre diretor(a) e filme foi feita com sucesso!");
                            } else {
                                System.out.println("\nDiretor(a) não encontrado(a) no sistema.");
                            }
                            break;
                        }
                        default: {
                            System.out.println("Opção inválida. Escolha 1 para Ator/Atriz ou 2 para Diretor(a).");
                            break;
                        }
                    }

                    break;
                }
                //@author Maria Brenda
                case 5: {
                    System.out.println("\n--- BUSCAR FILME POR NOME ---");
                    String nomeBuscado = InputValidator.lerStringNaoVazia(scanner, "Digite o nome do filme a buscar: ");

                    Filme filmeBuscado = filmeService.buscarFilmePorNome(nomeBuscado);
                    if (filmeBuscado != null) {
                        System.out.println("\nFilme encontrado!\n");
                        System.out.println(filmeService.montarFichaTecnicaFilme(filmeBuscado));
                    } else {
                        System.out.println("\nFilme não encontrado no sistema. Verifique o nome e tente novamente.");
                    }

                    break;
                }
                //@author Ludimila Araujo
                case 0: {
                    System.out.println("\nEncerrando o programa... Até mais!");
                    break;
                }
                //@author Ludimila Araujo
                default: {
                    System.out.println("\nOpção inválida. Tente novamente.");
                    break;
                }
            }
        }

        scanner.close();
    }
}
