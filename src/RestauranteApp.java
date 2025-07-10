public class RestauranteApp {

    public static void main(String[] args) {
        System.out.println("--- Criando Itens do Cardápio ---");

        // 1. Criando instâncias (objetos) da classe ItemCardapio
        ItemCardapio item1 = new ItemCardapio("P01", "Pizza Margherita", 55.00);
        ItemCardapio item2 = new ItemCardapio("B02", "Hambúrguer Clássico", 38.50);
        ItemCardapio item3 = new ItemCardapio("S03", "Suco de Laranja", 8.00);

        System.out.println("\n--- Exibindo Itens Criados (usando toString()) ---");
        System.out.println(item1);
        System.out.println(item2);
        System.out.println(item3); // Note que o preço será 0.0, pois o valor inicial era inválido

        System.out.println("\n--- Acessando dados com Getters ---");
        System.out.println("Nome do item 1: " + item1.getNome());
        System.out.println("Preço do item 2: " + item1.getPreco());

        System.out.println("\n--- Alterando o Preço (usando setPreco()) ---");
        System.out.println("Preço antigo do item 1: " + item1.getPreco());
        item1.setPreco(60.50); // Alteração válida
        System.out.println("Preço novo do item 1: " + item1.getPreco());

        System.out.println("\n--- Tentando alterar para um preço inválido ---");
        System.out.println("Preço atual do item 2: " + item2.getPreco());
        item2.setPreco(-40.00); // Alteração inválida
        System.out.println("Preço do item 2 após tentativa inválida: " + item2.getPreco());

        System.out.println("\n--- Cardápio Final ---");
        System.out.println(item1);
        System.out.println(item2);
        System.out.println(item3);
    }
}