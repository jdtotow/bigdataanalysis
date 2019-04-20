import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class PrepareData {
	private String folder_name;
	
	public PrepareData(String _folder){
		folder_name = _folder;
	}
	public ArrayList<String> readFolder(){
		ArrayList<String> files =new ArrayList<>();
		//Dir
		return files;
	}
	public ArrayList<String> getWords(String _file){
		ArrayList<String> results = new ArrayList<>();
		try {
			FileReader file = new FileReader(folder_name+"/"+_file);
			BufferedReader reader = new BufferedReader(file);
			String line;
			try {
				while((line = reader.readLine()) != null){
					String[] words = line.split(" ");
					for(String word : words){
						results.add(word);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return results;
	}
	public ArrayList<String> getStopWords(){
		ArrayList<String> results = new ArrayList<>();
		try {
			FileReader file = new FileReader("stop_words.txt");
			BufferedReader reader =new BufferedReader(file);
			String line;
			try {
				while((line = reader.readLine()) != null){
					results.add(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return results;
	}
	public ArrayList<String> removeStopWords(ArrayList<String> _words){
		ArrayList<String> results = new ArrayList<>();
		
		ArrayList<String> stop_words = getStopWords();
		for(String word : _words){
			if(!stop_words.contains(word)){
				results.add(word);
			}
		}
		
		return results;
	}
	
}
