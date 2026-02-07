import java.util.Stack;

public class PilhaHistorico {

    private Stack<Operacao<?>> historico = new Stack<>();

    public void registrar(Operacao<?> op) {
        historico.push(op);
    }

    public void desfazer(GerenciamentoAvioes ga, FilaEmbarque fe) {
        if (historico.isEmpty()) {
            System.out.println("Nada para desfazer.");
            return;
        }

        Operacao<?> op = historico.pop();

        // ==== AVIÕES ====
        if (op.getDado() instanceof Avioes) {
            Avioes a = (Avioes) op.getDado();

            if (op.getTipoAcao().equals("ADD")) {
                ga.removerAviaoLista(a);
                System.out.println("Desfeito: cadastro do avião " + a.getCodigo());
            } 
            else if (op.getTipoAcao().equals("REMOVE")) {
                ga.inserirAviaoLista(a);
                System.out.println("Desfeito: remoção do avião " + a.getCodigo());
            }
        }

        // ==== PASSAGEIROS ====
        else if (op.getDado() instanceof Passageiro) {
            Passageiro p = (Passageiro) op.getDado();

            if (op.getTipoAcao().equals("ADD")) {
                fe.removerPassageiro(p);
                System.out.println("Desfeito: venda da passagem de " + p.getNome());
            } 
            else if (op.getTipoAcao().equals("EMBARQUE")) {
                fe.reinserirPassageiro(p);
                System.out.println("Desfeito: embarque de " + p.getNome());
            }
        }
    }

    public void listar() {
        if (historico.isEmpty()) {
            System.out.println("Histórico vazio.");
            return;
        }

        System.out.println("=== HISTÓRICO DE OPERAÇÕES ===");
        for (Operacao<?> op : historico) {
            System.out.println("Ação: " + op.getTipoAcao() + " | Objeto: " + op.getDado());
        }
    }
}
