package systems;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Stack {
	
	//String url="jdbc:sqlserver://DAZYBPC:1433;databaseName=stacktest;integratedSecurity=true";
	

	int top=0;
	public int top() 
	{
		int top=0;
		try 
		{
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Systems", "root", "sherry");
			Statement st= c.createStatement();
			ResultSet rs=st.executeQuery("select count(*) as 'TOP' from Beverages");
			while(rs.next()) 
			{
				top=rs.getInt("TOP");
			}
		}
		catch(Exception e) 
		{
			System.err.println("Got an Exception!");
			System.err.println(e.getMessage());
		}
		return top;
	}
	


	

	public void push(String Name,int Quantity, int Price) 
	{
		
		//String url;
		//url=this.url;
		int stackTop=this.top();
		try 
		{
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Systems", "root", "sherry");
			PreparedStatement prest=conn.prepareStatement("insert into Beverages(ID,Name,Quantity,Price) values(?,?,?,?)");
			prest.setInt(1, stackTop+1);
			prest.setString(2, Name);
			prest.setInt(3, Quantity);
			prest.setInt(4, Price);
			prest.executeUpdate();
		}
		catch(Exception e) 
		{
			System.err.println("Got an Exception!");
			System.err.println(e.getMessage());
		}
		
		
	}
	
	public void pop() 
	{
		int popVal=this.top();
		try 
		{
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Systems", "root", "sherry");
			PreparedStatement prest=conn.prepareStatement("delete from Beverages where Id="+popVal);
			popVal--;
			prest.executeUpdate();
		}
		catch(Exception e) 
		{
			System.err.println("Got an Exception!");
			System.err.println(e.getMessage());
		}
		
		
	}
	

	public static void main(String[] args) {
		
		Stack st=new Stack();
//		st.push("Fanta", 500, 2);
//		st.push("Sprite", 500, 2);
//		st.push("Malt", 500, 2);
//		st.push("Hello3C1", "Hello3C2", "Hello3C3");
//		st.pop();
//		st.pop();
	}

}
