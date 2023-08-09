package txtSentToDb;
import java.util.*;
import java.io.*;
import java.sql.*;

public class RetrievvedTxtDataFromDb {

	public static void main(String[] args) {
    try {
    	Scanner sc=new Scanner(System.in);
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","wahidur");
		  PreparedStatement ps=con.prepareStatement("select * from charTab51 where id=?");
		  System.out.println("Enter id");
		  ps.setString(1, sc.nextLine());
		  ResultSet rs=ps.executeQuery();
		  if(rs.next())
		  {
			 Clob c=rs.getClob(2); 
			 Reader r=c.getCharacterStream();
			 System.out.println("Enter fName&fPath");//E:\adv_Txt\retrieveTxtFromDB.txt
			 File f=new File(sc.nextLine());
			 FileWriter fr=new FileWriter(f);
			 int k;
			 while((k=r.read())!=-1)
			 {
				 fr.write(k);
			 }
			 System.out.println("file successfully stored");
			 fr.close();
		  }else
		  {
			  System.out.println("invalid id ");
		  }
    	  sc.close();
    }catch(Exception e)
    {
    	e.printStackTrace();
    }
		

	}

}
