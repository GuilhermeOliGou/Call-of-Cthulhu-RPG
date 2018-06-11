package elementos;

import java.util.Scanner;

public class TesteCriatura {

    public static void main(String[] args) {
        CriaturaFactory factory = new CriaturaFactory();
        
        Criatura criatura = null;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Qual tipo de criatura? (Yog/Nya/Mini)");
        
        if(sc.hasNext()){
            String tipo = sc.nextLine();
            
            criatura = factory.criaCriatura(tipo);
        }
        
        if(criatura != null){
            facaAlgo(criatura);
        }else System.out.println("Valor invalido");
         
    }
    
    public static void facaAlgo(Criatura criatura){
        criatura.surge();
        criatura.ataca();
    }
}
