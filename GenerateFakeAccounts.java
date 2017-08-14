package lesson_8;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GenerateFakeAccounts {
	public static void main(String[] args) throws Exception{
		List<String> maleNames = normalizeData(Files.readAllLines(Paths.get("test/male.txt"), StandardCharsets.UTF_8));
		List<String> femaleNames = normalizeData(Files.readAllLines(Paths.get("test/female.txt"), StandardCharsets.UTF_8));
		List<String> sureName = normalizeData(Files.readAllLines(Paths.get("test/surname.txt"), StandardCharsets.UTF_8));
		
		Collections.shuffle(sureName);
		Collections.shuffle(femaleNames);
		Collections.shuffle(maleNames);
		
		generate("test/male-accounts.txt", 100, maleNames, sureName);
		generate("test/female-accounts.txt", 100, femaleNames, sureName);
	}
	
	public static void generate(String filename, int count, List<String> names, List<String> sureNames) throws IOException{
		try(PrintWriter pw = new PrintWriter(new FileWriter(new File(filename)))){
			for(int i = 0; i < count && i < names.size() && !sureNames.isEmpty(); i++){
				pw.println(names.get(i)+" "+sureNames.remove(0));
			}
			pw.flush();
		}
	}
	
	private static List<String> normalizeData (List<String> source){
		Set<String>set = new LinkedHashSet<>();
		for(String name : source){
			String value = name.toLowerCase();
			value = toNameForm(value);
			if(value.length() > 0){
				set.add(value);
			}
		}
		return new LinkedList<>(set);
		
	}

	private static String toNameForm(String value) {
		if(value.length()>1){
			return Character.toUpperCase(value.charAt(0)) + value.substring(1);
		}else{
			return value.toUpperCase();
		}
	}
}
