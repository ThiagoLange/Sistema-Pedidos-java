import java.text.NumberFormat;
import java.util.Locale;

/**
 * Representa um item do cardápio de um restaurante.
 * A classe encapsula os dados de um item, garantindo a integridade
 * através de atributos privados e métodos de acesso controlados.
 */
public class ItemCardapio {

    // --- ATRIBUTOS PRIVADOS ---
    private String codigo;
    private String nome;
    private double preco;

    /**
     * --- CONSTRUTOR ---
     * Cria uma nova instância de um item do cardápio.
     *
     * @param codigo O código único do item (ex: "B01").
     * @param nome O nome do item (ex: "X-Salada").
     * @param preco O preço do item. O valor deve ser maior que zero.
     */
    public ItemCardapio(String codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        // Utiliza o próprio método setPreco para reaproveitar a lógica de validação
        this.setPreco(preco);
    }

    // --- MÉTODOS PÚBLICOS (GETTERS) ---

    /**
     * Retorna o código do item.
     * @return uma String contendo o código.
     */
    public String getCodigo() {
        return this.codigo;
    }

    /**
     * Retorna o nome do item.
     * @return uma String contendo o nome.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Retorna o preço atual do item.
     * @return um double representando o preço.
     */
    public double getPreco() {
        return this.preco;
    }

    // --- MÉTODOS PÚBLICOS (SETTERS) ---

    /**
     * Atualiza o preço do item.
     * O novo preço só é definido se for maior que zero.
     *
     * @param novoPreco O novo valor para o preço do item.
     */
    public void setPreco(double novoPreco) {
        if (novoPreco > 0) {
            this.preco = novoPreco;
        } else {
            // Ação defensiva: imprime um erro caso a validação falhe.
            // Em um sistema real, poderia lançar uma exceção (ex: IllegalArgumentException).
            System.err.println("Erro: O preço do item '" + this.nome + "' deve ser maior que zero. Valor não alterado.");
        }
    }

    // --- MÉTODO toString ---

    /**
     * Retorna uma representação em String do objeto ItemCardapio.
     * Facilita a exibição dos dados do item de forma legível.
     * A anotação @Override indica que estamos sobrescrevendo o método padrão da classe Object.
     *
     * @return uma String formatada com os dados do item.
     */
    @Override
    public String toString() {
        // Formata o preço para o padrão de moeda do Brasil (R$)
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        return String.format(
                "Item [Código: %s, Nome: %s, Preço: %s]",
                this.codigo,
                this.nome,
                formatoMoeda.format(this.preco)
        );
    }
}