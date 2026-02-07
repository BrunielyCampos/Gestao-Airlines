public class Voo {

    private String codigoVoo;
    private String origem;
    private String destino;
    private Avioes aviao;

    public Voo(String codigoVoo, String origem, String destino, Avioes aviao) {
        this.codigoVoo = codigoVoo;
        this.origem = origem;
        this.destino = destino;
        this.aviao = aviao;
    }

    public String getCodigoVoo() {
        return codigoVoo;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public Avioes getAviao() {
        return aviao;
    }

    public void exibirDados() {
        System.out.println("Voo: " + codigoVoo + " | Origem: " + origem + " | Destino: " + destino);
    }

    @Override
    public String toString() {
        return codigoVoo + " | " + origem + " -> " + destino + " | Avião: " + aviao.getModelo();
    }
}