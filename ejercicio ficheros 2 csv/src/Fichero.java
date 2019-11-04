import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Fichero {
	public static final String pathFile = "src/fichero/train.csv";
	public void leerFicheroLambda() {
		
		Path path = Paths.get(pathFile);
		List<String> lista = new ArrayList();
		List <String> contenido;
		Map<String,List<String>> map = new HashMap();
		try {
			Stream<String> stream = Files.lines(path);
			
			lista=stream.findFirst()
			.map((line)->Arrays.asList(line.trim().split(","))).get();
			
			lista.forEach((s)-> {
				map.put(s, new ArrayList<String>(Arrays.asList(s)));
			});
			
			stream = Files.lines(path);
			
			stream.skip(1).forEach((s)->{
				String []valore = s.trim().split(",");
				int contador = 0;
				for(String keySet: map.keySet()) {
					map.get(keySet).add(valore[contador]);
					contador++;
				}
			});
			
			System.out.println(map.get("Embarked"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
