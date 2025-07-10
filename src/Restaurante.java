import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * Representa um Restaurante, que possui um nome e um cardápio (lista de itens).
 * A classe também controla o número total de restaurantes criados.
 */
public class Restaurante {

    // Atributos e Construtor (sem alterações)
    private String nome;
    private List<ItemCardapio> cardapio;
    private static int totalRestaurantes = 0;

    public Restaurante(String nome) {
        this.nome = nome;
        this.cardapio = new ArrayList<>();
        Restaurante.totalRestaurantes++;
    }

    // Métodos adicionarItem, listarCardapio e buscarItens (sem alterações)
    public void adicionarItem(ItemCardapio item) {
        if (item != null) {
            this.cardapio.add(item);
        }
    }

    public void listarCardapio() {
        System.out.println("----------------------------------------");
        System.out.println("   Cardápio do Restaurante: " + this.nome);
        System.out.println("----------------------------------------");
        if (this.cardapio.isEmpty()) {
            System.out.println("O cardápio está vazio no momento.");
        } else {
            for (ItemCardapio item : this.cardapio) {
                System.out.println(item);
            }
        }
        System.out.println("----------------------------------------");
    }

    public List<ItemCardapio> buscarItens(String... codigos) {
        List<ItemCardapio> itensEncontrados = new ArrayList<>();
        Set<String> codigosParaBuscar = new HashSet<>(Arrays.asList(codigos));
        for (ItemCardapio item : this.cardapio) {
            if (codigosParaBuscar.contains(item.getCodigo())) {
                itensEncontrados.add(item);
            }
        }
        return itensEncontrados;
    }

    /**
     * --- NOVO MÉTODO PARA FAZER PEDIDO ---
     * Calcula o valor total de um pedido com base nos códigos dos itens solicitados.
     * Códigos de itens que não são encontrados no cardápio são ignorados (somam 0 ao total).
     *
     * @param codigos Uma sequência de códigos (String) dos itens do pedido.
     * @return um double com o valor total do pedido.
     */
    public double fazerPedido(String... codigos) {
        // 1. Reutiliza o método buscarItens para obter uma lista de objetos ItemCardapio válidos.
        //    Isso já resolve o requisito de ignorar códigos não encontrados.
        List<ItemCardapio> itensDoPedido = this.buscarItens(codigos);

        // 2. Calcula a soma dos preços dos itens encontrados.
        //    Esta é uma forma moderna e concisa usando a API de Streams do Java 8+.
        return itensDoPedido.stream()                   // Cria um fluxo (stream) a partir da lista de itens
                .mapToDouble(ItemCardapio::getPreco) // Transforma cada ItemCardapio em seu preço (double)
                .sum();                              // Soma todos os preços do fluxo
    }

    // Método estático getTotalRestaurantes (sem alterações)
    public static int getTotalRestaurantes() {
        return totalRestaurantes;
    }
}