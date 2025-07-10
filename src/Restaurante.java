import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Restaurante {
    private String nome;
    private List<ItemCardapio> cardapio;
    private static int totalRestaurantes = 0;

    public Restaurante(String nome) {
        this.nome = nome;
        this.cardapio = new ArrayList<>();
        Restaurante.totalRestaurantes++;
    }

    public void adicionarItem(ItemCardapio item) {
        if (item != null) { this.cardapio.add(item); }
    }

    public void listarCardapio() {
        System.out.println("\n----------------------------------------");
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

    public double fazerPedido(String... codigos) {
        return this.buscarItens(codigos).stream()
                .mapToDouble(ItemCardapio::getPreco)
                .sum();
    }

    public static int getTotalRestaurantes() { return totalRestaurantes; }
}