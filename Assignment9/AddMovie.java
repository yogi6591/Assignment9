package Assignment9;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class AddMovie {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nEnter the movie details you want to add\n");
		System.out.println("Enter the movie id e.g. 101");
		int movieId = Integer.parseInt(bf.readLine());
		System.out.println("Enter the movie name");
		String movieName = bf.readLine();
		System.out.println("Enter the movie type");
		String movieType = bf.readLine();
		System.out.println("Enter the movie language");
		String movieLanguage = bf.readLine();
		System.out.println("Enter the release date in the format YYYY-MM-DD");
		String releaseDate = bf.readLine();
		System.out.println("Enter the cast of movie");
		String castingList = bf.readLine();
		System.out.println("Enter the rating");
		float rating = Float.parseFloat(bf.readLine());
		System.out.println("Enter the total revenue");
		float totalBusinessDone = Float.parseFloat(bf.readLine());
		
		try {
			DBConnection dbc = new DBConnection();
			Connection con = dbc.getInstance();
			String sql= "insert into Movie values(?,?,?,?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, movieId );
			pst.setString(2, movieName);
			pst.setString(3, movieType);
			pst.setString(4, movieLanguage);
			pst.setString(5, releaseDate);
			pst.setString(6, castingList);
			pst.setFloat(7, rating);
			pst.setFloat(8, totalBusinessDone);
			pst.executeUpdate();
			System.out.println("Movie details are successfully added");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
