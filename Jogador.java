public class Jogador{
    public String nome;
    public Personagem personagem;
    
    public Jogador(String nome_jogador, String tipo_personagem){
        nome = nome_jogador;
        if(tipo_personagem.equals("1")){
            personagem = new Elfo();
        }else if(tipo_personagem.equals("2")){
            personagem = new Anao();
        }else if(tipo_personagem.equals("3")){
            personagem = new Troll();
        }
    }
}