package Algoritmos;

import Algoritmos.Interface.CompressaoCompactacao;

/**
 *
 * @author Arthur Felipe MS
 */
public class RunLength implements CompressaoCompactacao {
    
    
    // Método para compactar a string usando a codificação Run-Length
    public String compactar(String entrada) {
        StringBuilder compactada = new StringBuilder();
        int contagem = 1;

        for (int i = 1; i < entrada.length(); i++) {
            if (entrada.charAt(i) == entrada.charAt(i - 1)) {
                contagem++;
            } else {
                compactada.append(entrada.charAt(i - 1)).append(contagem);
                contagem = 1;
            }
        }

        // Adiciona o último caractere e a contagem
        compactada.append(entrada.charAt(entrada.length() - 1)).append(contagem);

        return compactada.toString();
    }

    // Método para descompactar a string
    public String descompactar(String compactada) {
        StringBuilder descompactada = new StringBuilder();

        for (int i = 0; i < compactada.length(); i++) {
            char caractere = compactada.charAt(i);
            i++;
            int contagem = Character.getNumericValue(compactada.charAt(i));

            for (int j = 0; j < contagem; j++) {
                descompactada.append(caractere);
            }
        }

        return descompactada.toString();
    }
    
}
