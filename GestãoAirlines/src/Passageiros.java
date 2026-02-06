public class Passageiros {

    private String nome;
    private long docIdentificacao;
    private String voo;
    private int prioridade;     
    private int ordemChegada;    // Para desempate quando a prioridade for igual

    public Passageiros(String nome, long docIdentificacao, String voo, int prioridade, int ordemChegada) {
        this.nome = nome;
        this.docIdentificacao = docIdentificacao;
        this.voo = voo;
        this.prioridade = prioridade;
        this.ordemChegada = ordemChegada;
    }

    // Construtor sem prioridade (fila comum)
    public Passageiros(String nome, long docIdentificacao, String voo, int ordemChegada) {
        this.nome = nome;
        this.docIdentificacao = docIdentificacao;
        this.voo = voo;
        this.prioridade = 0; // 0 = sem prioridade
        this.ordemChegada = ordemChegada;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public long getDocIdentificacao() {
        return docIdentificacao;
    }

    public String getVoo() {
        return voo;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public int getOrdemChegada() {
        return ordemChegada;
    }

    // Exibir dados do passageiro
    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Documento: " + docIdentificacao);
        System.out.println("Voo: " + voo);
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