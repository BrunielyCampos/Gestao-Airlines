import java.util.Scanner;

public class SistemaDeAvioesMain{
    public static void main(String[] args){
        
       Scanner sc = new Scanner(System.in);
        GerenciamentoAvioes ger = new GerenciamentoAvioes();

        int opcao;

        do {
            System.out.println("\n===== MENU - GERENCIAMENTO DE AVIÕES =====");
            System.out.println("1 - Inserir avião");
            System.out.println("2 - Listar aviões");
            System.out.println("3 - Buscar avião por código");
            System.out.println("4 - Remover avião");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    ger.inserirAviao(sc);
                    break;

                case 2:
                    ger.listarAvioes();
                    break;

                case 3:
                    ger.buscarAviaoPorCodigo(sc);
                    break;

                case 4:
                    ger.removerAviao(sc);
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } 
        while (opcao != 0);

        sc.close();
    }
}