package RegrasDeNegocio;

import DTO.ElementosDeSistema.Evento;
import DTO.ElementosDeSistema.Local;
import java.util.ArrayList;

public class ModeratorValidaçãoEventos {
    
    //CONSTRUTORES
    
    public ModeratorValidaçãoEventos(){
        super();
    }
    
    //FUNÇÕES
    
    public ArrayList<Evento> GetEventosValidos(Local local){
        ArrayList<Evento> resposta = new ArrayList<>();
        local.getEventosDisponíveis().stream().filter((e) -> (e.isEventoValido())).forEachOrdered((e) -> {
            resposta.add(e);
        });
        return resposta;
    }
    
}
