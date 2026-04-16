package ui;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import service.PessoaService;
import model.Ator;
import model.Diretor;


public class Main{
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        PessoaService pessoaService = new PessoaService();

        boolean sistemaRodando = true;

        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("=========================================");
        System.out.println("       🎬 BEM-VINDO AO SER_MAIS_FLIX 🎬    ");
        System.out.println("=========================================");

        while (sistemaRodando){

            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1 - Cadastrar Filme");
            System.out.println("2 - Cadastrar Ator/Atriz)");
            System.out.println("3 - Cadastrar Diretor/Diretora)");
            System.out.println("4 - Buscar Filme por Nome");
            System.out.println("5 - Associar ator/atriz, diretor(a) a um filme");
            System.out.println("0 - Sair do Sistema");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao){
                case 1: {


                    //ADICIONAR AQUI LÓGICA DE CADASTRO DE FILME


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


                    //ADICIONAR AQUI LÓGICA DE BUSCA DE FILME POR NOME



                    break;


                }

                case 5: {


                    //ADICIONAR AQUI LÓGICA DE ASSOCIAR ATOR/ATRIZ/DIRETOR(A) A UM FILME


                    break;
                }
                case 0:

                    //lembrar que, pela lógica contida aqui, aplicar "sitemRodando= false" para PARAR
                    //podem modificar se quiserem, só a título de ilustração



                    //ADICIONAR AQUI LÓGICA DE SAÍDA DO SISTEMA


            }
        }

        scanner.close();
    }
}







