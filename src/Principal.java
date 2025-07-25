import java.util.Scanner;

public class Principal {

    private static final String[] MOEDAS = {"USD", "BRL", "ARS", "COP", "CLP", "BOB"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CONVERSOR DE MOEDAS ===");

        while (true) {
            System.out.println("\nEscolha a moeda de ORIGEM:");
            exibirOpcoes();
            String origem = MOEDAS[scanner.nextInt() - 1];

            System.out.println("Escolha a moeda de DESTINO:");
            exibirOpcoes();
            String destino = MOEDAS[scanner.nextInt() - 1];

            System.out.print("Digite o valor a ser convertido: ");
            double valor = scanner.nextDouble();

            try {
                double taxa = ConversorMoedas.obterTaxa(origem, destino);
                double resultado = ConversorMoedas.converter(valor, taxa);

                System.out.printf("\n%.2f %s = %.2f %s\n", valor, origem, resultado, destino);
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

            System.out.print("\nDeseja fazer outra conversão? Responda apenas sim ou não: ");
            String continuar = scanner.next().toLowerCase();
            if (!continuar.equals("sim")) {
                System.out.println("Encerrando o programa.");
                break;
            }
        }

        scanner.close();
    }

    private static void exibirOpcoes() {
        for (int i = 0; i < MOEDAS.length; i++) {
            System.out.println((i + 1) + " - " + MOEDAS[i]);
        }
        System.out.print("Digite a opção: ");
    }
}
