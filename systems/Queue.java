package systems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Queue {
	
	//String url = "jdbc:mysql://localhost:3306/Systems", "root", "sherry";

    public int count() 
	{
		int count=0;
		try 
		{
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Systems", "root", "sherry");
			Statement st= c.createStatement();
			ResultSet rs=st.executeQuery("select count(*) as 'COUNT' from BakingGoods");
			while(rs.next()) 
			{
				count=rs.getInt("COUNT");
			}
		}
		catch(Exception e) 
		{
			System.err.println("Got an Exception!");
			System.err.println(e.getMessage());
		}
		return count;
	}
	int front=0;
	int rear=0;	
	
	public void enQueue(String Name,int Quantity,double Price) 
	{
		//String url=this.url;

		int queuefront = this.count();
		try 
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Systems", "root", "sherry");
			PreparedStatement prest=con.prepareStatement("insert into BakingGoods(ID,Name,Quantity,Price) values(?,?,?,?)");
			prest.setInt(1, queuefront+1);
			prest.setString(2, Name);
			prest.setInt(3, Quantity);
			prest.setDouble(4, Price);
			prest.executeUpdate();
                        front++;
                        rear--;	
		}
		catch(Exception e) 
		{
			System.err.println("Got an Exception!");
			System.err.println(e.getMessage());
		}
		
	}
	
	public void deQueue() 
	{
		//String url=this.url;
            int front = this.count();
		int deQueueVal= 0;
		
		try 
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Systems", "root", "sherry");
			PreparedStatement prest=con.prepareStatement("delete from BakingGoods where ID="+deQueueVal);
			prest.executeUpdate();
		}
		catch(Exception e) 
		{
			System.err.println("Got an Exception!");
			System.err.println(e.getMessage());
		}
				
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		Queue que=new Queue();
//		que.enQueue("Hello1C1", "Hello1C2", "Hello1C3");
//		que.enQueue("Hello2C1", "Hello2C2", "Hello2C3");
//		que.enQueue("Hello3C1", "Hello3C2", "Hello3C3");
//		que.enQueue("Hello4C1", "Hello4C2", "Hello4C3");
		
		que.deQueue();
	}

}
