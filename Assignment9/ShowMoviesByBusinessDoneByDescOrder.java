package Assignment9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowMoviesByBusinessDoneByDescOrder {
	public static void main(String[] args) throws NumberFormatException, IOException {	
		try {
			DBConnection dbc = new DBConnection();
			Connection con = dbc.getInstance();
			if (con != null) {
				BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter the businessDone amount");
				float businessModel = Float.parseFloat(bf.readLine());		
				String sql = "select * from movie where totalBusinessDone > '"+businessModel+"'order by totalBusinessDone desc";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
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
				if(size==0) {
					System.out.println("No movie");
				}
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
