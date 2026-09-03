public class Passageiro {

    private String nome;
    private long docIdentificacao;
    private Voo voo;
    private int prioridade;     
    private int ordemChegada;    

    public Passageiro(String nome, long docIdentificacao, Voo voo, int prioridade, int ordemChegada) {
        this.nome = nome;
        this.docIdentificacao = docIdentificacao;
        this.voo = voo;
        this.prioridade = prioridade;
        this.ordemChegada = ordemChegada;
    }

    public Passageiro(String nome, long docIdentificacao, Voo voo, int ordemChegada) {
        this.nome = nome;
        this.docIdentificacao = docIdentificacao;
        this.voo = voo;
        this.prioridade = 0; 
        this.ordemChegada = ordemChegada;
    }

    public String getNome() {
        return nome;
    }

    public long getDocIdentificacao() {
        return docIdentificacao;
    }

    public Voo getVoo() {
        return voo;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public int getOrdemChegada() {
        return ordemChegada;
    }

    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Documento: " + docIdentificacao);
        System.out.println("Voo: " + voo.getCodigoVoo());
        System.out.println("Prioridade: " + prioridade);
        System.out.println("Ordem de chegada: " + ordemChegada);
    }

    @Override
    public String toString() {
        return "Passageiro [nome=" + nome +
               ", doc=" + docIdentificacao +
               ", voo=" + voo +
               ", prioridade=" + prioridade +
               ", chegada=" + ordemChegada + "]";
    }
}