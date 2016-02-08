/*
 * Author: Jason O'Connell
 * Student Number: 13710859
 * 
 */

package Runner;
import component.PreferenceTable;

public class Test {

	public static void main(String[] args) {
		PreferenceTable testing = new PreferenceTable("inputdata.txt");
		System.out.println(testing.toString());
	}

}
