package RegrasDeNegocio;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Validador {
    
    public short ValidadorDeIdade(int idade) throws RegraNegocioException{
        if (idade < 15 || idade > 75)
            throw new RegraNegocioException("IDADE FORA DO INTERVALO PEERMITIDO, "
                + "ENTRE 15 E 75 ANOS!");
        return (short)idade;
    }
    
    public String ValidadorNome(String nome) throws RegraNegocioException{
        if (nome.isEmpty())
            throw new RegraNegocioException("NOME VAZIO");
        if (CaracteresValidos(nome))
            throw new RegraNegocioException("NOME POSSUI CARACTERES INVÁLIDOS!");
        return nome;
    }
    
    private boolean CaracteresValidos(String nome){
        Pattern pattern = Pattern.compile("[a-z][A-Z]",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(nome);
        return matcher.find();
    }
    
}
