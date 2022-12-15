import java.util.Scanner;
import java.util.Map;

public class Jogo{
    public static int rodada_atual;
    public static Jogador[] jogador = new Jogador[2];
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] argv){
        rodada_atual = 1;
        criar_jogadores();
        Jogador jogador_atual = jogador[0];
        Jogador jogador_oponente = jogador[1];
        while(true){
            System.out.print("\n\nRodada: "+rodada_atual+"");
            System.out.print("\nVez de "+jogador_atual.nome);
            System.out.print("\nVida atual: "+jogador_atual.personagem.vida);

            Map<String, Integer> golpe = escolher_golpe(jogador_atual);   
            calcular_dano(golpe,jogador_atual,jogador_oponente);

            if(golpe.get("Atordoar") > 0){
                jogador_oponente.personagem.stuned = golpe.get("Atordoar");
            }

            if(jogador_oponente.personagem.vida <= 0){
                System.out.println("\n"+jogador_atual.nome+" venceu o jogo, Parabéns!!");
                break;
            }

            rodada_atual ++;

            if (jogador_oponente.personagem.stuned > 0){
                jogador_oponente.personagem.stuned --;
                System.out.println("\nJogador estava stunado");
            }else{
                if (jogador_atual == jogador[0]){
                    jogador_atual = jogador[1];
                    jogador_oponente = jogador[0];
                }else{
                    jogador_atual = jogador[0];
                    jogador_oponente = jogador[1];
                }
            }
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

    public static Map<String,Integer> escolher_golpe(Jogador jogador){
        int comando = 0;
        while (true){
            System.out.print("\n\nEscolha o golpe - \n1 - "+ jogador.personagem.arma.ataques.keySet().toArray()[0] +
            "\n2 - "+ jogador.personagem.arma.ataques.keySet().toArray()[1] +
            "\n3 - "+ jogador.personagem.arma.ataques.keySet().toArray()[2] +
            "\n4 - "+ jogador.personagem.arma.ataques.keySet().toArray()[3] +"\n");          
            comando = sc.nextInt(); 
            if(jogador.personagem.arma.get_cooldown(String.valueOf(jogador.personagem.arma.ataques.keySet().toArray()[(comando-1)]),jogador.personagem.arma.ataques,rodada_atual)){
                System.out.print("\nHabilidade em cooldown, escolha novamente");
            }
            else{
                break;
            }
        }
        return jogador.personagem.arma.ataques.get(jogador.personagem.arma.ataques.keySet().toArray()[(comando-1)]);
    }

    public static void calcular_dano(Map<String, Integer> golpe, Jogador jogador_atual,Jogador jogador_oponente){
        if(golpe.get("Dano") > 0){
            double dano = ((jogador_atual.personagem.ataque * 0.33) * golpe.get("Dano")) / jogador_oponente.personagem.armadura;
            jogador_oponente.personagem.vida -= dano;

            System.out.print("\nVida de "+jogador_oponente.nome+": "+jogador_oponente.personagem.vida+":");
        }

        if (golpe.get("Cura") > 0){
            jogador_atual.personagem.vida += golpe.get("Cura");
            System.out.print("\nCura realizada, vida atual: "+jogador_atual.personagem.vida);
        }
    }
}
