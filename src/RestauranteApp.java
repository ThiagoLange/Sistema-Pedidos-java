public class RestauranteApp {

    public static void main(String[] args) {
        // Antes de criar qualquer coisa, os contadores são 0
        System.out.println("Total de restaurantes no sistema (início): " + Restaurante.getTotalRestaurantes());
        System.out.println("Total de itens no sistema (início): " + ItemCardapio.getTotalItens());
        System.out.println("\n===== CRIANDO RESTAURANTE 1: CANTINA DA NONA =====");

        // 1. Criar a instância do primeiro restaurante
        Restaurante cantina = new Restaurante("Cantina da Nona");

        // 2. Criar os itens do cardápio
        ItemCardapio p1 = new ItemCardapio("P01", "Pizza Margherita", 55.00);
        ItemCardapio p2 = new ItemCardapio("M01", "Lasanha à Bolonhesa", 45.00);
        ItemCardapio s1 = new ItemCardapio("S01", "Refrigerante", 8.00);

        // 3. Adicionar os itens ao cardápio do restaurante
        cantina.adicionarItem(p1);
        cantina.adicionarItem(p2);
        cantina.adicionarItem(s1);

        // 4. Listar o cardápio
        cantina.listarCardapio();

        System.out.println("\n===== CRIANDO RESTAURANTE 2: SUSHI EXPRESS =====");

        // 5. Criar um segundo restaurante e seus itens
        Restaurante sushi = new Restaurante("Sushi Express");
        sushi.adicionarItem(new ItemCardapio("C01", "Combinado Salmão (20 peças)", 75.00));
        sushi.adicionarItem(new ItemCardapio("T01", "Temaki Filadélfia", 28.00));

        sushi.listarCardapio();

        System.out.println("\n===== TOTAIS DO SISTEMA =====");
        // Verificando os contadores estáticos no final
        System.out.println("Total de restaurantes no sistema (final): " + Restaurante.getTotalRestaurantes());
        System.out.println("Total de itens no sistema (final): " + ItemCardapio.getTotalItens());
    }
}