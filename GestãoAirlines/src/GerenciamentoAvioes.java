import java.util.*;
public class GerenciamentoAvioes{

    private List<Avioes> listaAvioes = new LinkedList<>();

    public void inserirAviaoLista(Avioes aviao){
        listaAvioes.add(aviao);
    }

    public void removerAviaoLista(Avioes aviao){
        listaAvioes.remove(aviao);
    }

    public Avioes inserirAviao(Scanner sc){

        System.out.print("Digite o código do avião: ");
        long codigo = sc.nextLong();
        sc.nextLine(); 

        System.out.print("Digite o modelo do avião: ");
        String modelo = sc.nextLine();

        System.out.print("Digite a capacidade máxima: ");
        int capacidade = sc.nextInt();

        Avioes aviao = new Avioes(codigo, modelo, capacidade);

        if (aviao.dadosValidos()) {
            inserirAviaoLista(aviao);
            System.out.println("Avião criado com sucesso!");
            return aviao;
        } 
        else {
            System.out.println("Dados inválidos. Avião não criado.");
        }
        return null;
    }

    public void exibirAviao(Scanner sc){

        System.out.println("Código: ");
        long codigo = sc.nextLong();
        sc.nextLine();

        System.out.print("Modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Capacidade: ");
        int cap = sc.nextInt();
    }

    public void listarAvioes(){
        if (listaAvioes.isEmpty()){
            System.out.println("Nenhum avião cadastrado.");
            return;
        }

        for (Avioes a : listaAvioes){
            a.exibirDados();
            System.out.println("----------------------");
        }
    }

    public void buscarAviaoPorCodigo(Scanner sc){

        System.out.print("Digite o código do avião: ");
        long codigo = sc.nextLong();

        for (Avioes a : listaAvioes) {
            if (a.getCodigo() == codigo) {
                System.out.println("Avião encontrado:");
                a.exibirDados();
                return;
            }
        }
        System.out.println("Avião não encontrado.");
    }

    public Avioes buscarAviaoPorCodigo(long codigo){
        for (Avioes a : listaAvioes) {
            if (a.getCodigo() == codigo) {
                return a;
            }
        }
        return null;
    }

    public Avioes removerAviao(Scanner sc){

        System.out.print("Digite o código do avião a remover: ");
        long codigo = sc.nextLong();

        for (int i = 0; i < listaAvioes.size(); i++) {
            Avioes a = listaAvioes.get(i);
            if (a.getCodigo() == codigo) {
                listaAvioes.remove(i); 
                System.out.println("Avião removido com sucesso.");
                return a;
            }
        }
        System.out.println("Avião não encontrado. Nenhum foi removido.");
        return null; // 👈 aqui
    }

    
}