package tools;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


/**
 * read and write files line by line
 * @author Antoine
 *
 */
public class FileTools {

	public FileTools() {}
	
	/**
	 * write file line by line with records list
	 * @param fileName
	 * @param append true = si le fichier existe, les donn�es sont ajout�es � la suite, false = le fichier est �cras�
	 * @param records list de string a �crire
	 * @throws IOException
	 */
	public static void write(String fileName, boolean append, List<String> records) throws IOException {
		boolean first = true;
		try {
			FileWriter writer = new FileWriter(fileName, append);
			
			// on écrit dans le fichier
			for (String string : records) {
				if (!first) {
					writer.write(System.lineSeparator());
				} else {
					first = false;
				}
				writer.write(string);
				
			}
			writer.close();
		} finally {
			
		}
		
	}
	
	
	/**
	 * read file line by line and return arrayList of string
	 * @param fileName
	 * @return an arrayList of String
	 * @throws IOException
	 */
	public static ArrayList<String> read(String fileName) throws IOException {
		ArrayList<String> list = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    for(String line; (line = br.readLine()) != null; ) {
		    	list.add(line);
		    }
		}
		return list;
	}
	
	public static Set<String> readToSet(String fileName) throws IOException {
		Set<String> list = new TreeSet<>();
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    for(String line; (line = br.readLine()) != null; ) {
		    	list.add(line);
		    }
		}
		return list;
	}
	
	
	/**
	 * write file line by line with records list
	 * @param fileName
	 * @param append true = si le fichier existe, les donn�es sont ajout�es � la suite, false = le fichier est �cras�
	 * @param records set de string a �crire
	 * @throws IOException
	 */
	public static void write(String fileName, boolean append, Set<String> records) throws IOException {
		try {
			FileWriter writer = new FileWriter(fileName, append);
			
			// on écrit dans le fichier
			for (String string : records) {
				writer.write(string);
				writer.write(System.lineSeparator());
			}
			writer.close();
		} finally {
			
		}
	}
	
	public static boolean fileExist(String filePath) {
		File f = new File(filePath);
		if(f.exists() && !f.isDirectory()) { 
		   return true;
		}
		return false;
	}
	
}
