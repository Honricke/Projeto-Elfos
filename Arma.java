import java.util.HashMap;
import java.util.Map;

public class Arma implements ArmaInterface {
    public Map<String, Map<String, Integer>> ataques = new HashMap<String, Map<String, Integer>>();
    public Map<String, Map<String, Integer>> em_cooldown = new HashMap<String, Map<String, Integer>>();

    public void set_ataques(String nome_ataque,Integer dano,Integer stun, Integer cooldown,Integer cura){
        Map<String, Integer> ataque = new HashMap<String, Integer>();
        ataque.put("Dano", dano);
        ataque.put("Atordoar", stun);
        ataque.put("Cooldown", cooldown);
        ataque.put("Cura", cura);
        ataques.put(nome_ataque,ataque);
    }

    public void set_cooldown(Map<String, Map<String, Integer>> ataques,String nome_ataque, Integer rodada_atual){
        
        em_cooldown.put(nome_ataque, ataques.get(nome_ataque));
        System.out.print("Habilidade "+nome_ataque+" foi posta em cooldown por");
    }

    public Boolean get_cooldown(String nome_ataque, Map<String, Map<String, Integer>> ataques, Integer rodada_atual){
        if (em_cooldown.containsKey(nome_ataque)){
            if(rodada_atual > em_cooldown.get(nome_ataque).get("Cooldown")){
                em_cooldown.remove(nome_ataque);
                return false; 
            }else{
                return true;
            }
        }
        else{
            set_cooldown(ataques, nome_ataque, rodada_atual);
            return false;
        }
    }
}
