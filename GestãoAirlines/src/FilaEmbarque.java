import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;
public class FilaEmbarque{

    private Queue<Passageiro> filaComum;
    private PriorityQueue<Passageiro> filaPrioritaria;
    private int contadorChegada = 0;

    public FilaEmbarque(){
        filaComum = new LinkedList<>();
        filaPrioritaria = new PriorityQueue<>(new Comparator<Passageiro>(){
            @Override
            public int compare(Passageiro p1, Passageiro p2) {
                if (p1.getPrioridade() != p2.getPrioridade()) {
                    return Integer.compare(p2.getPrioridade(), p1.getPrioridade()); // maior prioridade primeiro
                }
                return Integer.compare(p1.getOrdemChegada(), p2.getOrdemChegada()); // menor chegada primeiro
            }
        });
    }
    private boolean documentoJaExiste(long doc) {
        for (Passageiro p : filaComum) {
            if (p.getDocIdentificacao() == doc) {
                return true;
            }
        }

        for (Passageiro p : filaPrioritaria) {
            if (p.getDocIdentificacao() == doc) {
                return true;
            }
        }
        return false;
    }

    public void venderPassagem(String nome, long doc, Voo voo) {
        if (documentoJaExiste(doc)) {
            System.out.println("Documento já cadastrado! Não é possível vender outra passagem com o mesmo documento.");
            return;
        }

        contadorChegada++;
        Passageiro p = new Passageiro(nome, doc, voo, contadorChegada);
        filaComum.add(p);

        System.out.println("Passagem vendida. Passageiro inserido na fila comum.");
    }   

    public void inserirPrioritario(String nome, long doc, Voo voo, int prioridade) {
        if (documentoJaExiste(doc)){
            System.out.println("Documento já cadastrado! Não é possível cadastrar outro passageiro com o mesmo documento.");
            return;
        }
        contadorChegada++;
        Passageiro p = new Passageiro(nome, doc, voo, prioridade, contadorChegada);
        filaPrioritaria.add(p);
        System.out.println("Passageiro inserido na fila prioritária.");
    }

    public void embarcarProximo() {
        Passageiro p = null;

        if (!filaPrioritaria.isEmpty()) {
            p = filaPrioritaria.poll();
        } 
        else if (!filaComum.isEmpty()) {
            p = filaComum.poll();
        }

        if (p != null) {
            System.out.println("Embarcando passageiro:");
            p.exibirDados();
        } 
        else {
            System.out.println("Não há passageiros para embarcar.");
        }
    }

    public void exibirFilas() {
        System.out.println("=== FILA PRIORITÁRIA ===");
        for (Passageiro p : filaPrioritaria) {
            System.out.println(p);
        }

        System.out.println("=== FILA COMUM ===");
        for (Passageiro p : filaComum) {
            System.out.println(p);
        }
    }
}