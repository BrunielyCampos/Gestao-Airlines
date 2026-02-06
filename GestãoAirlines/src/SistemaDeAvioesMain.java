import java.util.Scanner;

public class SistemaDeAvioesMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GerenciamentoAvioes gerAvioes = new GerenciamentoAvioes();
        FilaEmbarque fila = new FilaEmbarque();

        int opcao;

        do {
            System.out.println("========================================");
            System.out.println("SISTEMA DE GESTÃO DE EMPRESA AÉREA");
            System.out.println("========================================");
            System.out.println("1 - Gerenciamento de Aviões");
            System.out.println("2 - Gestão de Passageiros e Embarque");
            System.out.println("3 - Histórico de Operações");
            System.out.println("0 - Encerrar Sistema");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    menuAvioes(sc, gerAvioes);
                    break;

                case 2:
                    menuPassageiros(sc, fila);
                    break;

                case 3:
                    System.out.println("Histórico ainda será ligado aqui ");
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }

    // 🔹 Submenu de Aviões
    private static void menuAvioes(Scanner sc, GerenciamentoAvioes ger) {
        int op;

        do {
            System.out.println("\n----------------------------------------");
            System.out.println("GERENCIAMENTO DE AVIÕES");
            System.out.println("----------------------------------------");
            System.out.println("1 - Cadastrar novo avião");
            System.out.println("2 - Listar aviões cadastrados");
            System.out.println("3 - Buscar avião por código");
            System.out.println("4 - Remover avião");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            op = sc.nextInt();

            switch (op) {
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
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (op != 0);
    }

    // 🔹 Submenu de Passageiros e Embarque
    private static void menuPassageiros(Scanner sc, FilaEmbarque fila) {
        int op;

        do {
            System.out.println("\n----------------------------------------");
            System.out.println("GESTÃO DE PASSAGEIROS E EMBARQUE");
            System.out.println("----------------------------------------");
            System.out.println("1 - Vender passagem");
            System.out.println("2 - Inserir passageiro na fila comum");
            System.out.println("3 - Inserir passageiro na fila prioritária");
            System.out.println("4 - Embarcar próximo passageiro");
            System.out.println("5 - Exibir filas de embarque");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            op = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (op) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Documento: ");
                    long doc = sc.nextLong();
                    sc.nextLine(); 
                    System.out.print("Voo: ");
                    String voo = sc.nextLine();
                    fila.venderPassagem(nome, doc, voo);
                    break;

                case 2:
                    System.out.print("Nome: ");
                    nome = sc.nextLine();
                    System.out.print("Documento: ");
                    doc = sc.nextLong();
                    sc.nextLine(); 
                    System.out.print("Voo: ");
                    voo = sc.nextLine();
                    System.out.print("Prioridade (ex: 1, 2, 3...): ");
                    int prioridade = sc.nextInt();
                    fila.inserirPrioritario(nome, doc, voo, prioridade);
                    break;

                case 3:
                    fila.embarcarProximo();
                    break;

                case 4:
                    fila.exibirFilas();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } 
        while (op != 0);
    }

}