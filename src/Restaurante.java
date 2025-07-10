import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Representa um Restaurante, que possui um nome e um cardápio (lista de itens).
 * A classe também controla o número total de restaurantes criados.
 */
public class Restaurante {

    // --- ATRIBUTOS PRIVADOS ---
    private String nome;
    private List<ItemCardapio> cardapio;

    // --- VARIÁVEIS STATIC ---
    private static int totalRestaurantes = 0;

    /**
     * --- CONSTRUTOR ---
     * Cria uma nova instância de um Restaurante.
     *
     * @param nome O nome do restaurante.
     */
    public Restaurante(String nome) {
        this.nome = nome;
        this.cardapio = new ArrayList<>();
        Restaurante.totalRestaurantes++;
    }

    // --- MÉTODOS PÚBLICOS ---

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

    /**
     * --- NOVO MÉTODO DE BUSCA ---
     * Busca no cardápio por itens que correspondam a um ou mais códigos fornecidos.
     *
     * @param codigos Uma sequência de um ou mais códigos (String) para buscar.
     * @return Uma List<ItemCardapio> com os itens encontrados. Retorna uma lista vazia se nenhum item for encontrado.
     */
    public List<ItemCardapio> buscarItens(String... codigos) {
        // Cria a lista que armazenará os resultados.
        List<ItemCardapio> itensEncontrados = new ArrayList<>();

        // Para uma busca eficiente, colocamos os códigos desejados em um Set.
        // A verificação .contains() em um Set é muito mais rápida (O(1) em média) do que em uma lista.
        Set<String> codigosParaBuscar = new HashSet<>(Arrays.asList(codigos));

        // Percorre o cardápio do restaurante uma única vez.
        for (ItemCardapio item : this.cardapio) {
            // Se o código do item atual está no conjunto de códigos que estamos procurando...
            if (codigosParaBuscar.contains(item.getCodigo())) {
                // ...adiciona o item à lista de resultados.
                itensEncontrados.add(item);
            }
        }

        // Retorna a lista de resultados (pode estar vazia).
        return itensEncontrados;
    }


    // --- MÉTODO STATIC PÚBLICO ---
    public static int getTotalRestaurantes() {
        return totalRestaurantes;
    }
}