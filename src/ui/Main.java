package ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import model.Ator;
import model.Diretor;
import model.Filme;
import service.FilmeService;
import service.PessoaService;


public class Main{
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        FilmeService filmeService = new FilmeService();
        PessoaService pessoaService = new PessoaService();

        boolean sistemaRodando = true;

        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("=========================================");
        System.out.println("       🎬 BEM-VINDO AO SER_MAIS_FLIX 🎬    ");
        System.out.println("=========================================");

        while (sistemaRodando){

            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1 - Cadastrar Filme");
            System.out.println("2 - Cadastrar Ator/Atriz");
            System.out.println("3 - Cadastrar Diretor/Diretora");
            System.out.println("4 - Buscar Filme por Nome");
            System.out.println("5 - Associar Ator/Atriz, Diretor(a) a um Filme");
            System.out.println("0 - Sair do Sistema");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao){
                case 1: {

                    System.out.println("\n--- CADASTRAR FILME ---");
                    System.out.print("Digite o nome do filme: ");
                    String nome = scanner.nextLine();

                    LocalDate dataLancamento = null;
                    while (dataLancamento == null) {
                        System.out.print("Digite a data de lançamento (dd/MM/yyyy): ");
                        String data = scanner.nextLine();
                        try {
                            dataLancamento = LocalDate.parse(data, formatadorData);
                        } catch (DateTimeParseException e) {
                            System.out.println("Formato de data inválido! Utilize o formato dd/MM/yyyy.");
                        }
                    }
                    System.out.print("Digite o orçamento do filme: ");
                    double orcamento = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Digite uma breve descrição do filme: ");
                    String descricao = scanner.nextLine();
                    Filme novoFilme = new Filme(nome, dataLancamento, orcamento, descricao);
                    filmeService.cadastrarFilme(novoFilme);
                    break;

                }

                case 2: {

                    System.out.println("\n--- CADASTRAR ATOR/ATRIZ ---");

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    LocalDate dataNascimento = null;
                    while (dataNascimento == null){
                        System.out.print("Data de nascimento (dd/MM/yyyy): ");
                        String dataNascimentoTexto = scanner.nextLine();
                        try{
                            dataNascimento = LocalDate.parse(dataNascimentoTexto, formatadorData);
                        } catch(DateTimeParseException e){
                            System.out.println("(Formato inválido! Por favor, utilize o formato dd/MM/yyyy.");
                        }
                    }

                    System.out.print("Nacionalidade: ");
                    String nacionalidade = scanner.nextLine();

                    System.out.print("Cachê: R$ ");
                    double cache = scanner.nextDouble();
                    scanner.nextLine();

                    Ator novoAtor = new Ator(nome, dataNascimento, nacionalidade, cache);

                    pessoaService.cadastrarAtor(novoAtor);

                    break;
                }

                case 3: {

                    System.out.println("\n--- CADASTRAR DIRETOR(A) ---");

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    LocalDate dataNascimento = null;
                    while (dataNascimento == null){
                        System.out.print("Data de nascimento (dd/MM/yyyy): ");
                        String dataNascimentoTexto = scanner.nextLine();
                        try{
                            dataNascimento = LocalDate.parse(dataNascimentoTexto, formatadorData);
                        } catch(DateTimeParseException e){
                            System.out.println("(Formato inválido! Por favor, utilize o formato dd/MM/yyyy.");
                        }
                    }

                    System.out.print("Nacionalidade: ");
                    String nacionalidade = scanner.nextLine();

                    System.out.print("Estilo:  ");
                    String estilo = scanner.nextLine();

                    Diretor novoDiretor = new Diretor(nome, dataNascimento, nacionalidade, estilo);

                    pessoaService.cadastrarDiretor(novoDiretor);

                    break;
                }

                case 4: {

                    System.out.println("\n--- Buscar por filme ---");

                    System.out.print("Digite o nome do filme: ");
                    String nomeDoFilme = scanner.nextLine();

                    Filme filme = filmeService.buscarFilmePorNome(nomeDoFilme);

                    if (filme != null) {
                        filmeService.imprimirFichaTecnicaFilme(filme);

                    }

                    break;
                }

                case 5: {

                    System.out.println("\n--- Central de Associações ---");
                    System.out.print("Digite o nome do filme: ");
                    String nomeDoFilme = scanner.nextLine();
                    Filme filme = filmeService.buscarFilmePorNome(nomeDoFilme);

                    if (filme == null) {
                        System.out.println("Filme não encontrado!");
                    } else {
                        System.out.println("O que deseja associar a '" + filme.getNome() + "'?");
                        System.out.println("1 - Ator/Atriz");
                        System.out.println("2 - Diretor(a)");
                        System.out.print("Escolha: ");
                        int tipo = scanner.nextInt();
                        scanner.nextLine();

                        if (tipo == 1) {
                            System.out.print("Nome do(a) ator/atriz: ");
                            Ator ator = pessoaService.buscarAtorPorNome(scanner.nextLine());
                            if (ator != null) {
                                filmeService.associarAtorAoFilme(filme, ator);
                            } else {
                                System.out.println("Ator/Atriz não encontrado(a).");
                            }
                        } else if (tipo == 2) {
                            System.out.print("Nome do(a) diretor(a): ");
                            Diretor diretor = pessoaService.buscarDiretorPorNome(scanner.nextLine());
                            if (diretor != null) {
                                filmeService.associarDiretorAoFilme(filme, diretor);
                            } else {
                                System.out.println("Diretor(a) não encontrado(a).");
                            }
                        } else {
                            System.out.println("Opção inválida.");
                        }
                    }

                    break;
                }

                case 0:

                    System.out.println("\nEncerrando o programa... Até mais!");
                default: System.out.println("\nOpção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}







