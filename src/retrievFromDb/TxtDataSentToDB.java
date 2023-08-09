package retrievFromDb;
import java.util.*;
import java.sql.*;
import java.io.*;
public class TxtDataSentToDB {

	public static void main(String[] args) {
		try {
			  Scanner sc=new Scanner(System.in);
			  Class.forName("oracle.jdbc.driver.OracleDriver");
			  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","wahidur");
			  PreparedStatement ps=con.prepareStatement("insert into charTab51 values(?,?)");
			  System.out.println("Enter id");
			  ps.setString(1, sc.nextLine());
			  System.out.println("Enter fPath&name");
			  File f=new File(sc.nextLine());//E:\adv_Txt\emp_dept_salgrade.txt
			  if(f.exists())
			  {
				  FileReader fr=new FileReader(f);
				  ps.setCharacterStream(2, fr,f.length());
				  int k=ps.executeUpdate();
				  if(k>0) {
					  System.out.println("file sent to db succesfully");
				  }
				  else {
					  System.out.println("invalid input id");
					  fr.close();
				  }
			  }
			  else
			  {
				  System.out.println("invalid file path");
				  
			  }
			  sc.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
