public class Troll extends Personagem{
    public Troll(){
        tipo = "Troll";
        vida = 2000;
        ataque = 200;
        armadura = 80;
    }
    public void set_arma(String tipo_arma){
        super.set_arma(tipo_arma);
    }
}
