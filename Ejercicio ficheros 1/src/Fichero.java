import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Fichero {
	public static final String pathFile = "src/fichero/fichero.txt";
	
	
	
	public void leerFichero() {
		String cadena;
		BufferedReader b = null;
		FileReader f;
		//Comprobar que fichero existe Files.exist(pathFile)
		try {
		//f = new FileReader(pathFile,true); <- No reescribir
        f = new FileReader(pathFile);
        b = new BufferedReader(f);
        
			while((cadena = b.readLine())!=null) {
			    System.out.println(cadena);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				b.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        
	}
	
	public void escribirFichero() {
		 FileWriter fichero = null;
	     PrintWriter pw = null;
	        try
	        {
	            fichero = new FileWriter(pathFile);
	            pw = new PrintWriter(fichero);

	            for (int i = 0; i < 10; i++)
	                pw.println("Linea " + i);

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	           try {
	           if (null != fichero)
	              fichero.close();
	           } catch (Exception e2) {
	              e2.printStackTrace();
	           }
	        }
	}
	
	public void leerFicheroLambda() {
		
		Path path = Paths.get(pathFile);
		List<String> lista = new ArrayList();
		try {
			Stream<String> stream = Files.lines(path);
			
			stream.forEach((s)->{
				lista.add(s);
				System.out.println(lista);});
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void escribirFicheroLambda() {
	      String[] lines = new String[] { "line 1", "line 2", "line 2" };
	      Path path = Paths.get("outputfile.txt");
	      
	      /*newBufferedWriter(path,
          Charset.defaultCharset(), StandardOpenOption.APPEND)<-Añadir contenido
          
          newBufferedWriter(path,
	              Charset.defaultCharset(), StandardOpenOption.WRITE)<-scribir contenido sin crear el fichero si no existe
          */
	      
	      try (BufferedWriter br = Files.newBufferedWriter(path,
	              Charset.defaultCharset(), StandardOpenOption.CREATE)) {
	           Arrays.stream(lines).forEach((s) -> {
	              try {
	                 br.write(s);
	                 br.newLine();
	              } catch (IOException e) {
	                 throw new UncheckedIOException(e);
	              }

	           });
	        } catch (Exception e) {
	           e.printStackTrace();
	        }
	}
}
