import java.util.ArrayList;
import java.util.List;

/**
 * Representa um Restaurante, que possui um nome e um cardápio (lista de itens).
 * A classe também controla o número total de restaurantes criados.
 */
public class Restaurante {

    // --- ATRIBUTOS PRIVADOS ---
    private String nome;
    private List<ItemCardapio> cardapio; // Usamos a interface List e a implementação ArrayList

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
        // É crucial inicializar a lista, senão teremos um NullPointerException
        this.cardapio = new ArrayList<>();
        // Incrementa o contador total de restaurantes
        Restaurante.totalRestaurantes++;
    }

    // --- MÉTODOS PÚBLICOS ---

    /**
     * Adiciona um item à lista do cardápio do restaurante.
     *
     * @param item O objeto ItemCardapio a ser adicionado.
     */
    public void adicionarItem(ItemCardapio item) {
        if (item != null) {
            this.cardapio.add(item);
        }
    }

    /**
     * Exibe no console todos os itens do cardápio do restaurante de forma organizada.
     */
    public void listarCardapio() {
        System.out.println("----------------------------------------");
        System.out.println("   Cardápio do Restaurante: " + this.nome);
        System.out.println("----------------------------------------");

        if (this.cardapio.isEmpty()) {
            System.out.println("O cardápio está vazio no momento.");
        } else {
            // Itera sobre a lista de itens e imprime cada um (usando o método toString() de ItemCardapio)
            for (ItemCardapio item : this.cardapio) {
                System.out.println(item);
            }
        }
        System.out.println("----------------------------------------");
    }

    // --- MÉTODO STATIC PÚBLICO ---

    /**
     * Retorna o número total de objetos Restaurante criados.
     * @return um int com o total de restaurantes.
     */
    public static int getTotalRestaurantes() {
        return totalRestaurantes;
    }
}