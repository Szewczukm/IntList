package intList;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ListHandling {
	
	private ArrayList<String> intList = new ArrayList<String>();
	private static String path = System.getenv("APPDATA")+"\\INTLIST\\intlist.txt";
	private File file = new File(path);
	private FileWriter fw;
	private BufferedWriter bw;
	private PrintWriter out;
	private FileReader fr;
	private BufferedReader br;
	
	/**
	 * Creates a file if one does not exist in the users AppData folder
	 */
	public void createFile(){
		try{
			if(!file.exists()){
				file.getParentFile().mkdirs();
			}
			if(file.createNewFile()){
				System.out.println("File created.");
			}
			else{
				System.out.println("File already exists");
			}
		} 
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Appends a string to the end of the text file
	 * @param name
	 * @throws IOException
	 */
	public void appendToEnd(String name) throws IOException{
		fw = new FileWriter(path, true);
		bw = new BufferedWriter(fw);
		out = new PrintWriter(bw);
		
		if(!name.equals(null) && this.check(name)==false){
			System.out.println("NAME NOT NULL");
			out.println(name);
			this.populate();
		}
		else{
			System.out.println("NAME IN FILE");
		}
		out.close();	
	}
	
	/**
	 * 
	 * @return Populated array with items from text file
	 * @throws IOException
	 */
	public ArrayList<String> populateArray() throws IOException{
		ArrayList<String> intlist = new ArrayList<String>();
		fr = new FileReader(file);
		br = new BufferedReader(fr);
		
		String line;
		while((line = br.readLine()) != null){
			intlist.add(line);
		}
		br.close();
		
		return intlist;
	}

	/**
	 * populate a class-based array (possibly useless?)
	 * @throws IOException
	 */
	public void populate() throws IOException{
		fr = new FileReader(file);
		br = new BufferedReader(fr);
		
		String line;
		while((line = br.readLine()) != null){
			intList.add(line);
		}
		br.close();

	}
	
	/**
	 * Checks class-based array if username is within the array
	 * @param username
	 */
	public boolean check(String username){
		for(int i = 0; i < intList.size();i++){
			if(intList.get(i).equalsIgnoreCase(username)){
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * displays a message to console
	 * @param msg
	 */
	public void display(String msg){
		System.out.println(msg);
	}
	
	/**
	 * On start of program, createFile (if none exist) and populate class array from file
	 * @throws IOException
	 */
	public void onStart() throws IOException{
		this.createFile();
		this.populate();
	}
	
	public static void main(String[] args) throws IOException {
		ListHandling j = new ListHandling();
		j.createFile();
		j.appendToEnd("topkek");
		j.populate();
		j.check("topkek");
	}
}


