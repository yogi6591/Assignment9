package Assignment9;

import java.io.*;
import java.io.Serializable;
import java.util.*;

public class Serialization {
	static List<Movie> movies;

	static {
		movies = new ArrayList<>();
	}

	static void serialize(String fname) {
		try {
			Movie m = new Movie(101,"Avenger","Action","English","2021-03-07","Tony Stark",(float) 9.9,10000000);
			FileOutputStream file = new FileOutputStream(new File(fname));
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(m);
			System.out.println("Serialization is done");
			out.close();
			file.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	static List<Movie> deserialize(String fname) {
		List<Movie> temp = new ArrayList<Movie>();
		try {
			FileInputStream file = new FileInputStream(new File(fname));
			ObjectInputStream in = new ObjectInputStream(file);
			Movie m=(Movie)in.readObject(); 
			System.out.println(m);
			System.out.println("Deserialization is done");
			in.close();
			file.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		}
		return temp;
	}

	public static void main(String args[]) {
		String file = "C:\\Users\\HP\\eclipse-workspace\\Persistent_Assignments\\src\\Assignment9\\Movie1.txt";
		serialize(file);
		deserialize(file);
	}
}
