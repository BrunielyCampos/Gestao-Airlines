import java.util.Scanner;
public class SistemaDeAvioesMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GerenciamentoAvioes gerAvioes = new GerenciamentoAvioes();
        FilaEmbarque fila = new FilaEmbarque();
        PilhaHistorico historico = new PilhaHistorico(); 

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
            sc.nextLine();

            switch (opcao) {
                case 1:
                    menuAvioes(sc, gerAvioes, historico);
                    break;

                case 2:
                    menuPassageiros(sc, fila, gerAvioes, historico);
                    break;

                case 3:
                    menuHistorico(sc, historico, gerAvioes, fila);
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

    private static void menuAvioes(Scanner sc, GerenciamentoAvioes ger, PilhaHistorico historico) {
        int op;

        do {
            System.out.println("\n--- GERENCIAMENTO DE AVIÕES ---");
            System.out.println("1 - Cadastrar novo avião");
            System.out.println("2 - Listar aviões");
            System.out.println("3 - Buscar avião por código");
            System.out.println("4 - Remover avião");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    Avioes a = ger.inserirAviao(sc);
                    if (a != null) historico.registrar(new Operacao<>("ADD", a));
                    break;

                case 2:
                    ger.listarAvioes();
                    break;

                case 3:
                    ger.buscarAviaoPorCodigo(sc);
                    break;

                case 4:
                    Avioes removido = ger.removerAviao(sc);
                    if (removido != null) historico.registrar(new Operacao<>("REMOVE", removido));
                    break;
            }

        } 
        while (op != 0);
    }

    private static void menuPassageiros(Scanner sc, FilaEmbarque fila, GerenciamentoAvioes ger, PilhaHistorico historico) {
        int op = -1;

        do {
            System.out.println("\n--- GESTÃO DE PASSAGEIROS ---");
            System.out.println("1 - Vender passagem");
            System.out.println("2 - Inserir prioritário");
            System.out.println("3 - Embarcar próximo");
            System.out.println("4 - Exibir filas");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            if (!sc.hasNextInt()) {
                System.out.println("Digite apenas números.");
                sc.nextLine();
                continue;
            }

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Documento: ");
                    long doc = sc.nextLong(); sc.nextLine();
                    System.out.print("Código do avião: ");
                    long codAviao = sc.nextLong(); sc.nextLine();

                    Avioes aviao = ger.buscarAviaoPorCodigo(codAviao);
                    if (aviao == null) { System.out.println("Avião não encontrado."); break; }

                    System.out.print("Código do voo: ");
                    String codVoo = sc.nextLine();
                    System.out.print("Origem: ");
                    String origem = sc.nextLine();
                    System.out.print("Destino: ");
                    String destino = sc.nextLine();

                    Voo voo = new Voo(codVoo, origem, destino, aviao);
                    Passageiro p = fila.venderPassagem(nome, doc, voo);
                    if (p != null) historico.registrar(new Operacao<>("ADD", p));
                    break;

                case 2:
                    System.out.print("Nome: ");
                    nome = sc.nextLine();
                    System.out.print("Documento: ");
                    doc = sc.nextLong(); sc.nextLine();
                    System.out.print("Código do avião: ");
                    codAviao = sc.nextLong(); sc.nextLine();

                    aviao = ger.buscarAviaoPorCodigo(codAviao);
                    if (aviao == null) { System.out.println("Avião não encontrado."); break; }

                    System.out.print("Código do voo: ");
                    codVoo = sc.nextLine();
                    System.out.print("Origem: ");
                    origem = sc.nextLine();
                    System.out.print("Destino: ");
                    destino = sc.nextLine();
                    System.out.print("Prioridade: ");
                    int prioridade = sc.nextInt(); sc.nextLine();

                    voo = new Voo(codVoo, origem, destino, aviao);
                    p = fila.inserirPrioritario(nome, doc, voo, prioridade);
                    if (p != null) historico.registrar(new Operacao<>("ADD", p));
                    break;

                case 3:
                    p = fila.embarcarProximo();
                    if (p != null) historico.registrar(new Operacao<>("EMBARQUE", p));
                    break;

                case 4:
                    fila.exibirFilas();
                    break;
            }

        } while (op != 0);
    }

    private static void menuHistorico(Scanner sc, PilhaHistorico historico, GerenciamentoAvioes ga, FilaEmbarque fe) {
        int op;

        do {
            System.out.println("\n--- HISTÓRICO ---");
            System.out.println("1 - Listar histórico");
            System.out.println("2 - Desfazer última operação");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1:
                    historico.listar();
                    break;
                case 2:
                    historico.desfazer(ga, fe);
                    break;
            }

        } 
        while (op != 0);
    }
}