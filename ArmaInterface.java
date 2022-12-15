import java.util.HashMap;
import java.util.Map;

public interface ArmaInterface {

    public Map<String, Map<String, Integer>> ataques = new HashMap<String, Map<String, Integer>>();
    public Map<String, Map<String, Integer>> em_cooldown = new HashMap<String, Map<String, Integer>>();

    public void set_ataques(String nome_ataque,Integer dano,Integer stun, Integer cooldown,Integer cura);

    public void set_cooldown (Map<String, Map<String, Integer>> ataques,String nome_ataque, Integer rodada_atual);

    public Boolean get_cooldown (String nome_ataque, Map<String, Map<String, Integer>> ataques, Integer rodada_atual);
}
