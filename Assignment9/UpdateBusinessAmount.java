package Assignment9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateBusinessAmount {
	public static void main(String[] args) throws NumberFormatException, IOException {
		try {
			DBConnection dbc = new DBConnection();
			Connection con = dbc.getInstance();
			if (con != null) {
				BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter the id of the movie you want to update");
				int movieid = Integer.parseInt(bf.readLine());
				System.out.println("Enter the new business amount of the movie you want to update");
				float businessAmount = Float.parseFloat(bf.readLine());
				
				String sql = "UPDATE movie set totalBusinessDone ="+businessAmount+" WHERE movieId ="+movieid;
				Statement st = con.createStatement();
				int update = st.executeUpdate(sql);
	
				String sql1 = "Select * from movie where movieId ="+movieid;
				ResultSet rs = st.executeQuery(sql1);
				int size = 0;
				while (rs.next()) {
					System.out.println("*************************************");
					System.out.println(rs.getInt("movieId"));
					System.out.println(rs.getString("movieName"));
					System.out.println(rs.getString("movieType"));
					System.out.println(rs.getString("movieLanguage"));
					System.out.println(rs.getString("releaseDate"));
					System.out.println(rs.getString("castingList"));
					System.out.println(rs.getString("rating"));
					System.out.println(rs.getString("totalBusinessDone"));
					size += 1;
				}
				if (size == 0) {
					System.out.println("No movie for this Id");
				}
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
