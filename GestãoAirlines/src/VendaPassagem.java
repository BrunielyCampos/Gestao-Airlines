
public class VendaPassagem {
    private Passageiros passageiro;
    private String destinoViagem;
    private String origemViagem;
    private Avioes aviao;
    private String assento;
    private double preco;


    public VendaPassagem(Passageiros passageiro, Avioes aviao, String assento, double preco){
        this.passageiro = passageiro;
        this.aviao = aviao;
        this.assento = assento;
        this.preco = preco;
    }
    
    public Passageiros getPassageiro() {
        return passageiro;
    } 
    
    public String getDestinoViagem() {
        return destinoViagem;
    }

    public String getOrigemViagem() {
        return origemViagem;
    }

    public void setPassageiro(Passageiros passageiro) {
        this.passageiro = passageiro;
    }

    public Avioes getAviao() {
        return aviao;
    }


    public void setAviao(Avioes aviao) {
        this.aviao = aviao;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void OrigemDaViagem(){
        System.out.println("Origem: ");
    }

    public String DestinoDaViagem(){
       
        return this.destinoViagem;
    }
 
}