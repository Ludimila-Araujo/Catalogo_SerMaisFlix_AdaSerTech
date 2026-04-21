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
                    System.out.print("Digite o nome do filme: ");
                    String nome = scanner.nextLine();

                    LocalDate dataLancamento = InputValidator.lerDataValida(
                            scanner,
                            formatadorData,
                            "Data de lançamento (ex: 5/4/2024 ou 05/04/2024): "
                    );
                    double orcamento = InputValidator.lerDoubleValido(scanner, "Digite o orçamento do filme: ");

                    System.out.print("Digite uma breve descrição do filme: ");
                    String descricao = scanner.nextLine();
                    Filme novoFilme = new Filme(nome, dataLancamento, orcamento, descricao);
                    filmeService.cadastrarFilme(novoFilme);
                    System.out.println("\nFilme cadastrado com sucesso: " + novoFilme.getNome());
                    break;

                }
                //@author Ludimila Araujo
                case 2: {
                    System.out.println("\n--- CADASTRAR ATOR/ATRIZ ---\n");

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    LocalDate dataNascimento = InputValidator.lerDataValida(
                            scanner,
                            formatadorData,
                            "Data de nascimento (ex: 5/4/2024 ou 05/04/2024): "
                    );

                    System.out.print("Nacionalidade: ");
                    String nacionalidade = scanner.nextLine();

                    double cache = InputValidator.lerDoubleValido(scanner, "Cachê: R$ ");

                    Ator novoAtor = new Ator(nome, dataNascimento, nacionalidade, cache);

                    pessoaService.cadastrarAtor(novoAtor);
                    System.out.println("\nAtor/Atriz " + novoAtor.getNome() + " cadastrado(a) com sucesso!");

                    break;
                }
                //@author Ludimila Araujo
                case 3: {
                    System.out.println("\n--- CADASTRAR DIRETOR(A) ---\n");

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    LocalDate dataNascimento = InputValidator.lerDataValida(
                            scanner,
                            formatadorData,
                            "Data de nascimento (ex: 5/4/2024 ou 05/04/2024): "
                    );

                    System.out.print("Nacionalidade: ");
                    String nacionalidade = scanner.nextLine();

                    System.out.print("Estilo: ");
                    String estilo = scanner.nextLine();

                    Diretor novoDiretor = new Diretor(nome, dataNascimento, nacionalidade, estilo);

                    pessoaService.cadastrarDiretor(novoDiretor);
                    System.out.println("\nDiretor(a) " + novoDiretor.getNome() + " cadastrado(a) com sucesso!");

                    break;
                }
                //@author Maria Brenda
                case 4: {
                    System.out.println("\n--- Central de Associações ---\n");
                    System.out.print("Digite o nome do filme: ");
                    String nomeDoFilme = scanner.nextLine();
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
                            System.out.print("Nome do(a) ator/atriz: ");
                            Ator ator = pessoaService.buscarAtorPorNome(scanner.nextLine());
                            if (ator != null) {
                                filmeService.associarAtorAoFilme(filme, ator);
                                System.out.println("\nA associação entre ator/atriz e filme foi feita com sucesso!");
                            } else {
                                System.out.println("\nAtor/Atriz não encontrado(a) no sistema.");
                            }
                            break;
                        }
                        case 2: {
                            System.out.print("Nome do(a) diretor(a): ");
                            Diretor diretor = pessoaService.buscarDiretorPorNome(scanner.nextLine());
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
                    System.out.print("Digite o nome do filme a buscar: ");
                    String nomeBuscado = scanner.nextLine();

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
