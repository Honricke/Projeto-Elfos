import java.util.Scanner;

public class Jogo{
    public static int rodada_atual;
    public static Jogador[] jogador = new Jogador[2];
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] argv){
        rodada_atual = 0;
        criar_jogadores();
        while(true){
            System.out.print("\nVez de "+jogador[rodada_atual].nome+":");

            Object golpe = escolher_golpe(jogador[rodada_atual]);   
            System.out.print("\nGolpe: "+golpe);

            rodada_atual = (rodada_atual == 0 ? 1 : 0);
            }
    }

    public static void criar_jogadores(){
        for(int i = 0; i < 2; i++){
            System.out.print("Diga o nome do Jogador "+(i+1)+" : ");
            String nome_jogador = sc.nextLine();
            System.out.print("\nDiga o seu personagem - \n1 - Elfo\n2 - Anão\n3 - Troll\n");
            String tipo_personagem = sc.nextLine();
            jogador[i] = new Jogador(nome_jogador,tipo_personagem);
            System.out.println("Nome do Jogador "+(i+1)+": " + jogador[i].nome + "\nPersonagem do Jogador "+(i+1)+": " + jogador[i].personagem.tipo);
            System.out.print("\nDiga sua arma - \n1 - Espada\n2 - Cajado\n3 - Arco\n");
            String tipo_arma = sc.nextLine();
            jogador[i].personagem.set_arma(tipo_arma);
        }
    }

    public static Object escolher_golpe(Jogador jogador){
        System.out.print("\nEscolha o golpe - \n1 - "+ jogador.personagem.arma.ataques.keySet().toArray()[0] +
        "\n2 - "+ jogador.personagem.arma.ataques.keySet().toArray()[1] +
        "\n3 - "+ jogador.personagem.arma.ataques.keySet().toArray()[2] +
        "\n4 - "+ jogador.personagem.arma.ataques.keySet().toArray()[3] +"\n");          
        int comando = sc.nextInt(); 
        if(jogador.personagem.arma.get_cooldown(String.valueOf(jogador.personagem.arma.ataques.keySet().toArray()[(comando-1)]),jogador.personagem.arma.ataques,rodada_atual)){
            System.out.print("Habilidade em cooldown");
        }
        return jogador.personagem.arma.ataques.get(jogador.personagem.arma.ataques.keySet().toArray()[(comando-1)]);
    }
}
