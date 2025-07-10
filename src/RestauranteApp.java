import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class RestauranteApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurante restaurante = new Restaurante("Restaurante Interativo do Thiago3");

        carregarItensIniciais(restaurante);

        boolean executando = true;
        while (executando) {
            exibirMenuPrincipal();
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    cadastrarNovoItem(scanner, restaurante);
                    break;
                case "2":
                    restaurante.listarCardapio();
                    break;
                case "3":
                    realizarPedido(scanner, restaurante);
                    break;
                case "4":
                    exibirEstatisticas();
                    break;
                case "5":
                    executando = false;
                    System.out.println("\nEncerrando o sistema. Obrigado!");
                    break;
                default:
                    System.out.println("\n[ERRO] Opção inválida! Por favor, tente novamente.");
                    break;
            }
            if (executando) {
                System.out.print("\nPressione Enter para continuar...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    public static void exibirMenuPrincipal() {
        System.out.println("\n===== SISTEMA DE GESTÃO DE RESTAURANTE =====");
        System.out.println("1. Cadastrar item no cardápio");
        System.out.println("2. Ver cardápio completo");
        System.out.println("3. Fazer pedido");
        System.out.println("4. Ver estatísticas");
        System.out.println("5. Sair");
        System.out.println("==========================================");
    }

    private static void cadastrarNovoItem(Scanner scanner, Restaurante restaurante) {
        System.out.println("\n--- Cadastro de Novo Item ---");
        try {
            System.out.print("Digite o código do item (ex: B03): ");
            String codigo = scanner.nextLine();
            System.out.print("Digite o nome do item: ");
            String nome = scanner.nextLine();
            System.out.print("Digite o preço do item (ex: 12.50): ");
            double preco = scanner.nextDouble();
            scanner.nextLine();

            ItemCardapio novoItem = new ItemCardapio(codigo, nome, preco);
            restaurante.adicionarItem(novoItem);
            System.out.println("\n[SUCESSO] Item '" + nome + "' cadastrado com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("\n[ERRO] O preço deve ser um número. Operação cancelada.");
            scanner.nextLine();
        }
    }

    private static void realizarPedido(Scanner scanner, Restaurante restaurante) {
        System.out.println("\n--- Fazer um Pedido ---");
        restaurante.listarCardapio();
        System.out.print("Digite os códigos dos itens que deseja, separados por espaço: ");
        String linhaDeCodigos = scanner.nextLine();
        String[] codigos = linhaDeCodigos.split(" ");
        double valorTotal = restaurante.fazerPedido(codigos);
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        System.out.println("\n----------------------------------");
        System.out.println("Valor total do pedido: " + formatoMoeda.format(valorTotal));
        System.out.println("----------------------------------");
    }

    private static void exibirEstatisticas() {
        System.out.println("\n--- Estatísticas do Sistema ---");
        System.out.println("Total de restaurantes criados: " + Restaurante.getTotalRestaurantes());
        System.out.println("Total de itens já cadastrados no sistema: " + ItemCardapio.getTotalItens());
        System.out.println("-------------------------------");
    }

    private static void carregarItensIniciais(Restaurante restaurante) {
        restaurante.adicionarItem(new ItemCardapio("P01", "Pizza Margherita", 55.50));
        restaurante.adicionarItem(new ItemCardapio("M01", "Lasanha à Bolonhesa", 45.00));
        restaurante.adicionarItem(new ItemCardapio("S01", "Refrigerante", 8.00));
        restaurante.adicionarItem(new ItemCardapio("B02", "Hambúrguer Duplo", 35.75));
    }
}