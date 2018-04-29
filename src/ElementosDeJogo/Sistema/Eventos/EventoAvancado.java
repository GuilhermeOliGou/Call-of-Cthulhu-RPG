package ElementosDeJogo.Sistema.Eventos;

public class EventoAvancado extends Evento {
    
    //itens usados
    protected short[] caracteristicasNecessarias;
    protected short[] habilidadesNecessarias;

    //CONSTRUTORES
    
    public EventoAvancado() {
        super();
    }
    
    public EventoAvancado(short[] caracteristicasNecessarias, short[] habilidadesNecessarias) {
        super();
        this.caracteristicasNecessarias = caracteristicasNecessarias;
        this.habilidadesNecessarias = habilidadesNecessarias;
    }
    
    //FIM CONSTRUTORES

    //GETTERS AND SETTERS

    public short[] getCaracteristicasNecessarias() {
        return caracteristicasNecessarias;
    }

    public void setCaracteristicasNecessarias(short[] caracteristicasNecessarias) {
        this.caracteristicasNecessarias = caracteristicasNecessarias;
    }

    public short getCaracteristicaNecessaria(int indice) {
        return caracteristicasNecessarias[indice];
    }

    public void setCaracteristicaNecessaria(int indice, short valor) {
        this.caracteristicasNecessarias[indice] = valor;
    }

    public short[] getHabilidadesNecessarias() {
        return habilidadesNecessarias;
    }

    public void setHabilidadesNecessarias(short[] habilidadesNecessarias) {
        this.habilidadesNecessarias = habilidadesNecessarias;
    }

    public short getHabilidadeNecessaria(int indice) {
        return habilidadesNecessarias[indice];
    }

    public void setHabilidadeNecessaria(int indice, short valor) {
        this.habilidadesNecessarias[indice] = valor;
    }
    
    //FIM GETTERS AND SETTERS
    
}
