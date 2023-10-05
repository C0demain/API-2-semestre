package utilitarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;



public class LimpaArquivo {

    public static void limparArquivo(String caminhoArquivo) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo, Charset.forName("UTF8")));
            String dir = caminhoArquivo.replace(".txt", "_limpo.txt"); // Nome do arquivo limpo

            BufferedWriter writer = new BufferedWriter(new FileWriter(dir, Charset.forName("UTF8")));
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.matches("\\d+")) {
                    line = line.replace(".", ".\n").replace("\n\n", "\n").replace("\t", "");
                    writer.write(line + "\n");
                }
            }

            reader.close();
            writer.close();
            
            // Tornar o arquivo oculto
            Path arquivoPath = Path.of(dir);
            Files.setAttribute(arquivoPath, "dos:hidden", true);
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
