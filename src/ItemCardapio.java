import java.text.NumberFormat;
import java.util.Locale;

public class ItemCardapio {
    private String codigo;
    private String nome;
    private double preco;
    private static int totalItens = 0;

    public ItemCardapio(String codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        if (preco > 0) {
            this.preco = preco;
        } else {
            this.preco = 0; // Preço padrão em caso de valor inválido no construtor.
            System.err.println("Aviso: Preço inválido para " + nome + ". Definido como 0.");
        }
        ItemCardapio.totalItens++;
    }

    public String getCodigo() { return this.codigo; }
    public String getNome() { return this.nome; }
    public double getPreco() { return this.preco; }
    public static int getTotalItens() { return totalItens; }

    public void setPreco(double novoPreco) {
        if (novoPreco > 0) { this.preco = novoPreco; }
        else { System.err.println("Erro: O preço deve ser maior que zero."); }
    }

    @Override
    public String toString() {
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return String.format("Item [Código: %s, Nome: %s, Preço: %s]",
                this.codigo, this.nome, formatoMoeda.format(this.preco));
    }
}