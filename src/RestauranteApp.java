import java.util.List;

public class RestauranteApp {

    public static void main(String[] args) {
        System.out.println("===== CRIANDO RESTAURANTE 1: CANTINA DA NONA =====");

        Restaurante cantina = new Restaurante("Cantina da Nona");
        ItemCardapio p1 = new ItemCardapio("P01", "Pizza Margherita", 55.00);
        ItemCardapio p2 = new ItemCardapio("M01", "Lasanha à Bolonhesa", 45.00);
        ItemCardapio s1 = new ItemCardapio("S01", "Refrigerante", 8.00);

        cantina.adicionarItem(p1);
        cantina.adicionarItem(p2);
        cantina.adicionarItem(s1);

        cantina.listarCardapio();

        // --- DEMONSTRAÇÃO DO MÉTODO DE BUSCA ---
        System.out.println("\n===== TESTANDO A BUSCA DE ITENS =====");

        // Teste 1: Buscar dois itens existentes ("Pizza" e "Refrigerante")
        System.out.println("\nBuscando por códigos 'P01' e 'S01':");
        List<ItemCardapio> resultado1 = cantina.buscarItens("P01", "S01");
        for (ItemCardapio item : resultado1) {
            System.out.println("Encontrado: " + item);
        }

        // Teste 2: Buscar um item existente e um inexistente
        System.out.println("\nBuscando por códigos 'M01' e 'X99' (inexistente):");
        List<ItemCardapio> resultado2 = cantina.buscarItens("M01", "X99");
        if (resultado2.isEmpty()) {
            System.out.println("Nenhum item encontrado.");
        } else {
            for (ItemCardapio item : resultado2) {
                System.out.println("Encontrado: " + item);
            }
        }

        // Teste 3: Buscar apenas por códigos inexistentes
        System.out.println("\nBuscando por códigos 'A01' e 'B02' (inexistentes):");
        List<ItemCardapio> resultado3 = cantina.buscarItens("A01", "B02");
        if (resultado3.isEmpty()) {
            System.out.println("Nenhum item encontrado com os códigos fornecidos.");
        } else {
            // Este bloco não será executado
            for(ItemCardapio item : resultado3){
                System.out.println("Encontrado: " + item);
            }
        }
    }
}