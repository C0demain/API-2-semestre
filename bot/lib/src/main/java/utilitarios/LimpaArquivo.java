package utilitarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class LimpaArquivo {

    public static void limparArquivo(String caminhoArquivo) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo, Charset.forName("UTF8")));
            String dir = caminhoArquivo.replace(".txt", "_limpo.txt"); // Nome do arquivo limpo

            BufferedWriter writer = new BufferedWriter(new FileWriter(dir, Charset.forName("UTF8")));
            String line;
            StringBuilder content = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.matches("\\d+")) {
                    content.append(line).append("\n");
                }
            }

            reader.close();
            content = new StringBuilder(content.toString().replace(".", ".\n"));
            content = new StringBuilder(content.toString().replace("\n\n", "\n"));
            content = new StringBuilder(content.toString().replace("\t", ""));
            writer.write(content.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso correto: java LimpaArquivo <caminho do arquivo>");
            return;
        }

        String caminhoArquivo = args[0];
        limparArquivo(caminhoArquivo);
    }
}
