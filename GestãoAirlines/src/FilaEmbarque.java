import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;
public class FilaEmbarque{

    private Queue<Passageiros> filaComum;
    private PriorityQueue<Passageiros> filaPrioritaria;
    private int contadorChegada = 0;

    public FilaEmbarque(){
        filaComum = new LinkedList<>();

        // Comparator para prioridade + ordem de chegada
        filaPrioritaria = new PriorityQueue<>(new Comparator<Passageiros>(){
            @Override
            public int compare(Passageiros p1, Passageiros p2) {
                if (p1.getPrioridade() != p2.getPrioridade()) {
                    return Integer.compare(p2.getPrioridade(), p1.getPrioridade()); // maior prioridade primeiro
                }
                return Integer.compare(p1.getOrdemChegada(), p2.getOrdemChegada()); // menor chegada primeiro
            }
        });
    }

    // Venda de passagem (cria passageiro)
    public void venderPassagem(String nome, long doc, String voo) {
        contadorChegada++;
        Passageiros p = new Passageiros(nome, doc, voo, contadorChegada);
        filaComum.add(p);
        System.out.println("Passagem vendida. Passageiro inserido na fila comum.");
    }

    // Inserir passageiro com prioridade
    public void inserirPrioritario(String nome, long doc, String voo, int prioridade) {
        contadorChegada++;
        Passageiros p = new Passageiros(nome, doc, voo, prioridade, contadorChegada);
        filaPrioritaria.add(p);
        System.out.println("Passageiro inserido na fila prioritária.");
    }

    // Embarcar próximo passageiro
    public void embarcarProximo() {
        Passageiros p = null;

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

    // Exibir filas
    public void exibirFilas() {
        System.out.println("=== FILA PRIORITÁRIA ===");
        for (Passageiros p : filaPrioritaria) {
            System.out.println(p);
        }

        System.out.println("=== FILA COMUM ===");
        for (Passageiros p : filaComum) {
            System.out.println(p);
        }
    }
}