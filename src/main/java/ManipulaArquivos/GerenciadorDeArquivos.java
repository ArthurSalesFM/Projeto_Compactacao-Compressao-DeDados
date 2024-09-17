package ManipulaArquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

/**
 *
 * @author Arthur Felipe MS
 */
public class GerenciadorDeArquivos {

    // Método para escrever texto em um arquivo usando caminho relativo
    public void escreverNoArquivo(String nomeArquivo, String conteudo) {
        // Define o caminho relativo para a pasta 'src/main/Arquivos'
        String caminhoRelativo = "src/main/Arquivos";

        // Cria o caminho completo do arquivo
        String caminhoCompleto = caminhoRelativo + File.separator + nomeArquivo;

        // Cria a pasta se não existir
        File pasta = new File(caminhoRelativo);
        if (!pasta.exists()) {
            pasta.mkdirs(); // Cria a pasta e subpastas, se necessário
        }

        // Escreve no arquivo
        try (FileWriter escritor = new FileWriter(caminhoCompleto)) {
            escritor.write(conteudo); // Escreve o conteúdo no arquivo
            System.out.println("Arquivo escrito com sucesso em: " + caminhoCompleto);
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    // Método para ler o conteúdo de um arquivo e retornar como uma String
    public String lerArquivo(String nomeArquivo) {
        String caminhoRelativo = "src/main/Arquivos";
        String caminhoCompleto = caminhoRelativo + File.separator + nomeArquivo;
        
        StringBuilder conteudoDoArquivo = new StringBuilder(); // Armazena o conteúdo do arquivo

        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoCompleto))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                conteudoDoArquivo.append(linha).append("\n"); // Adiciona cada linha ao StringBuilder
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return conteudoDoArquivo.toString(); // Retorna o conteúdo como String
    }
}