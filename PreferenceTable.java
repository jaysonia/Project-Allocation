/*
 * Author: Jason O'Connell
 * Student Number: 13710859
 * 
 */

package component;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.Iterator;

public class PreferenceTable {
	
	private Vector<Vector<String>> preferences = null;
	
	//Empty Constructor for Preference table
	public PreferenceTable(){};
	
	//Constructor that accepts a filename in
	public PreferenceTable(String filename){
		preferences = loadContentFromFile(filename);
	}
	
	//Private method for reading a file and returns a Vector of Vectors
	private Vector<Vector<String>> loadContentFromFile(String filename){
		
		//Variable for use within the method
		String line;
		StringTokenizer	tokens;
		Vector<Vector<String>> preferenceList = new Vector<Vector<String>>();
		
		//try, catch on the file input reader.
		try{
			//file input variables and a temporary vector to store current line
			FileInputStream in = new FileInputStream(filename);
			BufferedReader input = new BufferedReader(new InputStreamReader(in));
			Vector<String> choices = null;
			
			
			//Reads in line and splits the line into tokens
			while((line = input.readLine()) !=null){
				choices = new Vector<String>();
				tokens = new StringTokenizer(line,"\t");
				
				//add all the tokens into a vector
				while(tokens.hasMoreTokens()){
					choices.add(tokens.nextToken());
				}
				preferenceList.add(choices);
			}
			input.close();
			
		}
		catch(Exception error){
			System.out.println(error);
		}
		
		return preferenceList;
	}
	
	//returns a string of the data to allow it to be printed.
	public String toString(){
		String list = "";
		Iterator<Vector<String>> iter =  preferences.iterator();
		
		while(iter.hasNext()){
			list += iter.next().toString();
			if(iter.hasNext())
				list += "\n";
		}
		
		return list;
	}

}
