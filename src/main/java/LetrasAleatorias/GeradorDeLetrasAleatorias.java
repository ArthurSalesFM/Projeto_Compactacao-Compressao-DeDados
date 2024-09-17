package LetrasAleatorias;

import java.util.Random;

/**
 *
 * @author Arthur Felipe MS
 */
public class GeradorDeLetrasAleatorias {
    
    private char[] letras;
    
    public GeradorDeLetrasAleatorias(){
        
        this.letras = new char[26];
        this.setLetras();
    }
    
    public String gerarSequenciaDeLetrasAleatorias(int quantidadeDeLetras){
        String sequenciaDeLetras = "";
        Random random = new Random();
        
        for (int x = 0; x < quantidadeDeLetras; x++){
            sequenciaDeLetras += this.letras[random.nextInt(26)];
        }
        
        return sequenciaDeLetras;
    }
    
    private void setLetras(){        
        // Utilizando apenas as letras minúsculas
        for (int i = 0; i < this.letras.length; i++){
            this.letras[i] = (char)(97 + i);
        }
    }
    
}
