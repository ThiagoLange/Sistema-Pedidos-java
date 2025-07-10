import java.text.NumberFormat;
import java.util.Locale;

public class ItemCardapio {

    // --- ATRIBUTOS PRIVADOS ---
    private String codigo;
    private String nome;
    private double preco;

    // --- VARIÁVEL STATIC ---
    // Pertence à classe, não a um objeto individual. Conta todos os itens criados.
    private static int totalItens = 0;

    // --- CONSTRUTOR ---
    public ItemCardapio(String codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.setPreco(preco);

        // Incrementa o contador total de itens toda vez que um novo item é criado
        ItemCardapio.totalItens++;
    }

    // --- GETTERS E SETTERS (permanecem os mesmos) ---
    public String getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double novoPreco) {
        if (novoPreco > 0) {
            this.preco = novoPreco;
        } else {
            System.err.println("Erro: O preço do item '" + this.nome + "' deve ser maior que zero. Valor não alterado.");
        }
    }

    // --- MÉTODO toString (permanece o mesmo) ---
    @Override
    public String toString() {
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return String.format(
                "Item [Código: %s, Nome: %s, Preço: %s]",
                this.codigo,
                this.nome,
                formatoMoeda.format(this.preco)
        );
    }

    // --- MÉTODO STATIC PÚBLICO ---
    /**
     * Retorna o número total de objetos ItemCardapio criados durante a execução do programa.
     * @return um int com o total de itens.
     */
    public static int getTotalItens() {
        return totalItens;
    }
}