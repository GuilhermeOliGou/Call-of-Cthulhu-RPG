package Elementos;


public class CriaturaFactory {
    public Criatura criaCriatura(String tipoCriatura){
        if(tipoCriatura.equals("Yog")){
            return new YogSothothCriatura();
        } else if (tipoCriatura.equals("Nya")){
            return new NyarlathotepCriatura();
        } else if(tipoCriatura.equals("MiniYog")){
            return new MiniYogCriatura();
        } else if(tipoCriatura.equals("Shog")){
            return new Shoggoths();
        }else return null;
    }
}
