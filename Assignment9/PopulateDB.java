package Assignment9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PopulateDB {
	
	public static void main(String[] args) throws IOException, SQLException {
		// TODO Auto-generated method stub
		String file="C:\\Users\\HP\\eclipse-workspace\\Persistent_Assignments\\src\\Assignment9\\Movie.txt";
		FileReader fileReader = null;
		BufferedReader bufferedReader= null;
		fileReader=new FileReader(file);
		bufferedReader = new BufferedReader(fileReader);
		String l="";
		while((l=bufferedReader.readLine())!=null)
		{
			String s[]= l.split(",");
			int rownum=insertRow(s);
			System.out.println(rownum+" is inserted");
		}
		bufferedReader.close();
		
		showDataBase();
	}
	

	public static int insertRow(String []s) throws SQLException {
		int rowCount=0;
		try {
			DBConnection dbc = new DBConnection();
			Connection con = dbc.getInstance();
			String sql= "insert into Movie values(?,?,?,?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, Integer.parseInt(s[0]) );
			pst.setString(2, s[1]);
			pst.setString(3, s[2]);
			pst.setString(4, (s[3]));
			pst.setString(5, s[4]);
			pst.setString(6, s[5]);
			pst.setFloat(7, Float.parseFloat(s[6]));
			pst.setFloat(8, Float.parseFloat(s[7]));
			rowCount= pst.executeUpdate();
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return rowCount;
	}
	
	
	public static void showDataBase() throws IOException {
		try {
			DBConnection dbc = new DBConnection();
			Connection con = dbc.getInstance();
			if (con != null) {
				String sql = "select * from movie";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
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
				}
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}
}
