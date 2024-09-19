package Algoritmos;

import Algoritmos.Interface.CompressaoCompactacao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Arthur Felipe MS
 */
public class LZW implements CompressaoCompactacao{
    
    public String compactar(String entrada) {
        // Inicializa o dicionário com caracteres ASCII padrão
        Map<String, Integer> dicionario = new HashMap<>();
        for (int i = 0; i < 256; i++) {
            dicionario.put("" + (char) i, i);
        }

        StringBuilder p = new StringBuilder();
        StringBuilder resultado = new StringBuilder();
        int codigo = 256; // Próximo código disponível no dicionário

        for (char c : entrada.toCharArray()) {
            String pc = p.toString() + c;
            if (dicionario.containsKey(pc)) {
                p.append(c);
            } else {
                // Adiciona o código correspondente à string compactada no resultado
                resultado.append(dicionario.get(p.toString())).append(" ");
                dicionario.put(pc, codigo++);
                p = new StringBuilder("" + c);
            }
        }

        // Adiciona o último valor ao resultado
        if (!p.isEmpty()) {
            resultado.append(dicionario.get(p.toString())).append(" ");
        }

        return resultado.toString().trim();
    }

    public String descompactar(String compactada) {
        // Inicializa o dicionário com caracteres ASCII padrão
        Map<Integer, String> dicionario = new HashMap<>();
        for (int i = 0; i < 256; i++) {
            dicionario.put(i, "" + (char) i);
        }

        // Converte a string compactada de volta para uma lista de inteiros
        String[] partes = compactada.split(" ");
        List<Integer> codigos = new ArrayList<>();
        for (String parte : partes) {
            codigos.add(Integer.parseInt(parte));
        }

        StringBuilder resultado = new StringBuilder();
        String anterior = "" + (char) (int) codigos.remove(0);  // Primeiro código
        resultado.append(anterior);
        int codigo = 256;

        for (int i : codigos) {
            String entrada;
            if (dicionario.containsKey(i)) {
                entrada = dicionario.get(i);
            } else if (i == codigo) {
                entrada = anterior + anterior.charAt(0);
            } else {
                throw new IllegalArgumentException("Código inválido: " + i);
            }

            resultado.append(entrada);
            dicionario.put(codigo++, anterior + entrada.charAt(0));
            anterior = entrada;
        }

        return resultado.toString();
    }
    
}