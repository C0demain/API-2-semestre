package utilitarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class LimpaArquivo {

	public static void main(String[] args) {
    	String arq = "C:\\Users\\Manhã\\Desktop\\prince.txt";
    	String dir = "C:\\Users\\Manhã\\Desktop\\aux.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(arq , Charset.forName("UTF8")));
            BufferedWriter writer = new BufferedWriter(new FileWriter(dir , Charset.forName("UTF8")));
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
        
        arq = dir;
        dir  = "C:\\Users\\Manhã\\Desktop\\result.txt";
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(arq , Charset.forName("UTF8")));
            BufferedWriter writer = new BufferedWriter(new FileWriter(dir , Charset.forName("UTF8")));
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
}
