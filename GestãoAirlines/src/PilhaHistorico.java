import java.util.Stack;

public class PilhaHistorico<T> {

   
    private Stack<Operacao<T>> historico = new Stack<>();

    public void RegistrarOperacao(Operacao<T> operacao) {
        this.historico.push(operacao);
    }

    public Operacao<T> DesfazerOperacao() {
        if (!historico.isEmpty()) {
            return historico.pop();
        }
        return null;
    }

    public void executarDesfazer(GerenciamentoAvioes ga, FilaEmbarque fe) {
        Operacao<T> op = DesfazerOperacao();
        
        if (op == null) {
            System.out.println("Nada para desfazer.");
            return;
        }

        if (op.getDado() instanceof Avioes) {
            Avioes a = (Avioes) op.getDado();
            if (op.getTipoAcao().equals("ADD")){
                ga.removerAviaoLista(a);
            } 
            else{
                ga.inserirAviaoLista(a);
            } 
        } 
        else if (op.getDado() instanceof Passageiros) {
            Passageiros p = (Passageiros) op.getDado();
        }
    }

    public void listar() {
        for (Operacao<T> op : historico) {
            System.out.println("Ação: " + op.getTipoAcao());
        }
    }
}