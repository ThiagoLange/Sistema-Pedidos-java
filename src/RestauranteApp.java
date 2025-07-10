import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class RestauranteApp {

    public static void main(String[] args) {
        // --- Setup do Restaurante ---
        Restaurante cantina = new Restaurante("Cantina da Nona");
        cantina.adicionarItem(new ItemCardapio("P01", "Pizza Margherita", 55.50));
        cantina.adicionarItem(new ItemCardapio("M01", "Lasanha à Bolonhesa", 45.00));
        cantina.adicionarItem(new ItemCardapio("S01", "Refrigerante", 8.00));

        cantina.listarCardapio();

        // --- DEMONSTRAÇÃO DO MÉTODO FAZER PEDIDO ---
        System.out.println("\n===== REALIZANDO PEDIDOS =====");

        // Formata a saída para moeda (R$)
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        // Teste 1: Pedido simples com itens válidos (1 Pizza + 1 Refrigerante)
        double valorPedido1 = cantina.fazerPedido("P01", "S01");
        System.out.println("Pedido 1 (P01, S01): Valor total = " + formatoMoeda.format(valorPedido1)); // Esperado: 55.50 + 8.00 = 63.50

        // Teste 2: Pedido com item repetido e um código inválido (2 Lasanhas + 1 código lixo)
        double valorPedido2 = cantina.fazerPedido("M01", "X99", "M01");
        System.out.println("Pedido 2 (M01, X99, M01): Valor total = " + formatoMoeda.format(valorPedido2)); // Esperado: 45.00 + 0 + 45.00 = 90.00

        // Teste 3: Pedido com apenas códigos inválidos
        double valorPedido3 = cantina.fazerPedido("ABC", "DEF");
        System.out.println("Pedido 3 (ABC, DEF): Valor total = " + formatoMoeda.format(valorPedido3)); // Esperado: 0.00

        // Teste 4: Pedido vazio (sem códigos)
        double valorPedido4 = cantina.fazerPedido();
        System.out.println("Pedido 4 (sem itens): Valor total = " + formatoMoeda.format(valorPedido4)); // Esperado: 0.00
    }
}