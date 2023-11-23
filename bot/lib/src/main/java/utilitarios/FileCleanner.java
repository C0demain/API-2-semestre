package utilitarios;

import java.io.*;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.xml.serialize.*;


import org.apache.tika.sax.*;
import org.apache.tika.parser.*;
import java.net.URL;
import utilitarios.FileUtils.*;

import java.io.InputStream;




public class FileCleanner {

	public static List<String> arquivos = new ArrayList<String>();

	public static String formatText(String path) throws FileNotFoundException {
        //Inspired by Mateus Madeira's code in https://github.com/C0demain/API-2-semestre/blob/master/bot/lib/src/main/java/utilitarios/LimpaArquivo.java

//		InputStream stream = new ByteArrayInputStream(path.getBytes());
	
		InputStream stream = new FileInputStream(path);
		
        Parser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        ParseContext context = new ParseContext();
        String doccontent = null;
        
        try {

            String dir = null;

            if (FileUtils.checkTXT(path)) {
                dir = path.replace(".txt", ".txt");
                parser.parse(stream, handler, metadata, context);
                doccontent = handler.toString();
                System.out.println(handler.toString());
            }
            else if (FileUtils.checkPDF(path)){
                dir = path.replace(".pdf", ".txt");
                parser.parse(stream, handler, metadata, context);
                doccontent = handler.toString();
                System.out.println(handler.toString());
            }
            else if (FileUtils.checkDOCX(path)) {
                dir = path.replace(".docx", ".txt");
                parser.parse(stream, handler, metadata, context);
                doccontent = handler.toString();
                System.out.println(handler.toString());
            }
            stream.close();

            assert doccontent != null;

            BufferedReader reader = new BufferedReader(new StringReader(doccontent));

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
            return dir;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TikaException e) {
            throw new RuntimeException(e);       
        }
        catch (Exception e) {
        	throw new RuntimeException(e);
        }
        return null;
    }
}
