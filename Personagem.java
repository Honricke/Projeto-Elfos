public class Personagem {
    public String tipo;
    public String tipo_arma;
    public int vida;
    public int ataque;
    public int armadura;
    public Arma arma;

    public void set_arma(String tipo){
        if(tipo.equals("1")){
            arma = new Espada();
        }
        else if(tipo.equals("2")){
            arma = new Cajado();
        }
        else if(tipo.equals("3")){
            arma = new Arco();
        }
    }
}
