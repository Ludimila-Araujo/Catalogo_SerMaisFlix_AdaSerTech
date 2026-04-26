package ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

/**
 * Classe que valida entradas do usuário para garantir que sejam válidas.
 *
 * @author Enei Pereira
 */
public final class InputValidator {

    private InputValidator() {
    }

    public static DateTimeFormatter criarFormatadorData() {
        return new DateTimeFormatterBuilder()
                .parseStrict()
                .appendOptional(DateTimeFormatter.ofPattern("d/M/uuuu"))
                .appendOptional(DateTimeFormatter.ofPattern("dd/MM/uuuu"))
                .toFormatter()
                .withResolverStyle(ResolverStyle.STRICT);
    }

    public static LocalDate lerDataValida(Scanner scanner, DateTimeFormatter formatadorData, String mensagemPrompt) {
        while (true) {
            System.out.print(mensagemPrompt);
            String dataTexto = scanner.nextLine();
            try {
                return LocalDate.parse(dataTexto, formatadorData);
            } catch (DateTimeParseException e) {
                System.out.println("Data invalida! Use d/M/yyyy ou dd/MM/yyyy (ex.: 5/4/2024 ou 05/04/2024).");
            }
        }
    }

    public static int lerInteiroValido(Scanner scanner, String mensagemPrompt) {
        while (true) {
            System.out.print(mensagemPrompt);
            String valorTexto = scanner.nextLine().trim();
            try {
                return Integer.parseInt(valorTexto);
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida! Digite um numero inteiro (ex.: 0, 1, 2).");
            }
        }
    }

    public static double lerDoubleValido(Scanner scanner, String mensagemPrompt) {
        while (true) {
            System.out.print(mensagemPrompt);
            String valorTexto = scanner.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(valorTexto);
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida! Digite um numero valido (ex.: 1500 ou 1500,50).");
            }
        }
    }

    public static String lerStringNaoVazia(Scanner scanner, String mensagemPrompt) {
        while (true) {
            System.out.print(mensagemPrompt);
            String texto = scanner.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("Entrada invalida! O valor não pode ficar em branco.");
        }
    }
}
