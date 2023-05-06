package RBI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;


public class main {
	static final String DB_URL ="jdbc:mysql://localhost:3306/rbi";
	static final String USER = "root";
	static final String PASS="Mysql@123";
	public static void main(String args[]) throws SQLException
	{
		Connection conn = null;
		Statement stmt = null;
		//char c='y';
		int n;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("connecting to the database");
			
			conn=DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
		do
		{
				conn=DriverManager.getConnection(DB_URL,USER,PASS);
				stmt = conn.createStatement();	
			System.out.println("Menu:\n1.Insert\n2.Display\n3.Update\n4.Delete");
			System.out.println("Enter choice:");
			BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
			int a=Integer.parseInt(b.readLine());
		switch(a)
		{
		case 1:{
				System.out.println("Inserting :");
			
			//which table?
			
			System.out.println("Menu:\n1.Payment Systems\n2.Regulatory Frameworks\n3.Economic Indicators\n4.Foreign Exchange\n5.Financial Institutions");
			System.out.println("Enter choice:");
			
			int table_choice=Integer.parseInt(b.readLine());
			
			
			switch(table_choice) {
			case 1: {
				//table 1
				String query = " insert into PS3(PaymentID,Date,TransactionID,Availability)"+" values(?,?,?,?) ";
				
				System.out.println("Enter PaymentID:");
				String PaymentID=b.readLine();
				System.out.println("Enter Date:");
				String Date=b.readLine();
				System.out.println("Enter TransactionID:");
				int TransactionID=Integer.parseInt(b.readLine());
				System.out.println("Enter Availability:");
				String Availability=b.readLine();
			
				PreparedStatement prep_stmt;
				prep_stmt=conn.prepareStatement(query);
				prep_stmt.setString(1,PaymentID);
				prep_stmt.setString(2,Date);
				prep_stmt.setInt(3,TransactionID);
				prep_stmt.setString(4,Availability);
				
				prep_stmt.execute();
				
				
				//table 2
				String query2 = " insert into PS4(PaymentID,Type,Operator,Participant)"+" values(?,?,?,?) ";
				
				System.out.println("Enter PaymentID:");
				       PaymentID=b.readLine();
				System.out.println("Enter Type:");
				String Type=b.readLine();
				System.out.println("Enter Operator:");
				String Operator=b.readLine();
				System.out.println("Enter Participant:");
				String Participant=b.readLine();
			
				PreparedStatement prep_stmt2;
				prep_stmt2=conn.prepareStatement(query2);
				prep_stmt2.setString(1,PaymentID);
				prep_stmt2.setString(2,Type);
				prep_stmt2.setString(3,Operator);
				prep_stmt2.setString(4,Participant);
				
				prep_stmt2.execute();
				
				
				//table 3
				String query3 = " insert into PS5(TransactionID,Volume,Value,Time)"+" values(?,?,?,?) ";
				
				System.out.println("Enter TransactionID:");
				TransactionID=Integer.parseInt(b.readLine());
				System.out.println("Enter Volume:");
				int Volume=Integer.parseInt(b.readLine());
				System.out.println("Enter Value:");
				int Value=Integer.parseInt(b.readLine());
				System.out.println("Enter Time:");
				String Time=b.readLine();
			
				PreparedStatement prep_stmt3;
				prep_stmt3=conn.prepareStatement(query3);
				prep_stmt3.setInt(1,TransactionID);
				prep_stmt3.setInt(2,Volume);
				prep_stmt3.setInt(3,Value);
				prep_stmt3.setString(4,Time);
				
				prep_stmt3.execute();
				
				
			
				//stmt.executeUpdate(query);
			}
			
			case 2:{
				String query = " insert into rf(Category,RegulationTitle,InstitutionsInv,ImpDate,CompDate,RegAuth)"+" values(?,?,?,?,?,?) ";
				
				System.out.println("Enter Regulation Category:");
				String Category=b.readLine();
				System.out.println("Enter Regulation Title:");
				String RegulationTitle=b.readLine();
				System.out.println("Enter Institutions involved:");
				int InstitutionsInv=Integer.parseInt(b.readLine());
				System.out.println("Enter Implementation date:");
				String ImpDate=b.readLine();
				System.out.println("Enter the compliance date:");
				String CompDate=b.readLine();			
				System.out.println("Enter Regulatory Authority:");
				String RegAuth=b.readLine();
			
			
				PreparedStatement prep_stmt;
				prep_stmt=conn.prepareStatement(query);
				prep_stmt.setString(1,Category);
				prep_stmt.setString(2,RegulationTitle);
				prep_stmt.setInt(3,InstitutionsInv);
				prep_stmt.setString(4,ImpDate);
				prep_stmt.setString(5,CompDate);
				prep_stmt.setString(6,RegAuth);
				
				prep_stmt.execute();
			}
			
			//economic indicator 
			
			case 3: {
				
			}
			
			case 4:{
				//Foreign Exchange
				String query = " insert into fe(Date,curr,exrate,transType,transValue,Counterparty,purpose,settdate)"+" values(?,?,?,?,?,?,?,?) ";
				
				System.out.println("Enter Date of trade:");
				String Date=b.readLine();
				System.out.println("Enter currency pair");
				String curr=b.readLine();
				System.out.println("Enter exchange rate: ");
				int exrate=Integer.parseInt(b.readLine());
				System.out.println("Enter transaction type :");
				String transType=b.readLine();
				System.out.println("Enter the transaction value:");
				int transValue=Integer.parseInt(b.readLine());
				System.out.println("Enter Counterparty involved:");
				String Counterparty=b.readLine();
				System.out.println("Enter purpose of trade:");
				String purpose=b.readLine();
				System.out.println("Enter the settlement date:");
				String settdate=b.readLine();
			
			
				PreparedStatement prep_stmt;
				prep_stmt=conn.prepareStatement(query);
				prep_stmt.setString(1,Date);
				prep_stmt.setString(2,curr);
				prep_stmt.setInt(3,exrate);
				prep_stmt.setString(4,transType);
				prep_stmt.setInt(5,transValue);
				prep_stmt.setString(6,Counterparty);
				prep_stmt.setString(7,purpose);
				prep_stmt.setString(8,settdate);
				
				prep_stmt.execute();
				
			}
			 // bank tables 
			case 5:{
				
				String query = " insert into bank1(InstName,InstType,BankID,Loc,Contact,Licence)"+" values(?,?,?,?,?,?) ";
				
				System.out.println("Enter Institution name: ");
				String InstName=b.readLine();
				System.out.println("Enter the institution type:");
				String InstType=b.readLine();
				System.out.println("Enter Bank Id: ");
				int BankID=Integer.parseInt(b.readLine());
				System.out.println("Enter Location:");
				String Loc=b.readLine();
				System.out.println("Enter the contact info:");
				String Contact=b.readLine();
				System.out.println("Enter Licence:");
				String Licence=b.readLine();
				
			
				PreparedStatement prep_stmt;
				prep_stmt=conn.prepareStatement(query);
				prep_stmt.setString(1,InstName);
				prep_stmt.setString(2,InstType);
				prep_stmt.setInt(3,BankID);
				prep_stmt.setString(4,Loc);
				prep_stmt.setString(5,Contact);
				prep_stmt.setString(6,Licence);
				
				
				prep_stmt.execute();
				
				
				
				String query2 = " insert into bank2(bankid,rev,products,CA,RC)"+" values(?,?,?,?,?,?) ";
				
				System.out.println("Enter Institution name: ");
				int bankid=Integer.parseInt(b.readLine());
				System.out.println("Enter the institution type:");
				int rev=Integer.parseInt(b.readLine());
				System.out.println("Enter Bank Id: ");
				String products=b.readLine();
				System.out.println("Enter Location:");
				int CA=Integer.parseInt(b.readLine());
				System.out.println("Enter the contact info:");
				String RC=b.readLine();
				
				
			
				PreparedStatement prep_stmt2;
				prep_stmt2=conn.prepareStatement(query2);
				prep_stmt2.setInt(1,bankid);
				prep_stmt2.setInt(2,rev);
				prep_stmt2.setString(3,products);
				prep_stmt2.setInt(4,CA);
				prep_stmt2.setString(5,RC);
				
				
				
				prep_stmt2.execute();
				
				
			}
			case 6:{
			//monetary poicy	
			}
			
			}
			
			conn.close();
			break;
			
		}
			
			
			
			
		
		case 2:{
			System.out.println("DISPLAYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
			
			//which table?
			
			System.out.println("Menu:\n1.Payment Systems\n2.Regulatory Frameworks\n3.Economic Indicators\n4.Foreign Exchange\n5.Financial Institutions");
			System.out.println("Enter choice:");
			
			int table_choice=Integer.parseInt(b.readLine());
			
			switch(table_choice) {
			case 1: {
				//payment systems table 1
				
				System.out.println("Database contains:");
				String query1 = " select * from payment_t1" ;
				int count1 = 0;
				ResultSet rs=stmt.executeQuery(query1);
				while(rs.next())
				{
				String PaymentID=rs.getString("Payment_ID");
				int TransactionID=rs.getInt("Transaction_ID");
				String Date=rs.getString("Date");
				String Availability=rs.getString("Availability");
				String output = "User #%d: %d - %s - %s -%d -%d - %s - %d";//%s for strings and %d for integers
				System.out.println(String.format(output, ++count1,TransactionID, Date,Availability,PaymentID));
				}
				
				//table 2
				
				System.out.println("Database contains:");
				String query2 = " select * from payment_t2" ;
				int count2 = 0;
				ResultSet res=stmt.executeQuery(query2);
				while(rs.next())
				{
				String PaymentID=res.getString("Payment_ID");
				String Type=res.getString("Type");
				String Opeartor=res.getString("Opeartor");
				String Particpant=res.getString("Participant");
				int Tid=res.getInt("Tid");
				String output = "User #%d: %d - %s - %s -%d -%d - %s - %d";//%s for strings and %d for integers
				System.out.println(String.format(output, ++count2,Tid,Type,Opeartor,Particpant,PaymentID));
				}
				
				//table 3
				
				System.out.println("Database contains:");
				String query3 = " select * from payment_t3" ;
				int count3 = 0;
				ResultSet resu=stmt.executeQuery(query2);
				while(rs.next())
				{
				int TID=resu.getInt("TID");
				int Volume=resu.getInt("Volume");
				int Value=resu.getInt("Value");
				String Time=resu.getString("Time");
				String output = "User #%d: %d - %s - %s -%d -%d - %s - %d";//%s for strings and %d for integers
				System.out.println(String.format(output, ++count3,Value,Volume,Time,TID));
				}
			}
			//table reg_frameworks
				case 2:{
					
					System.out.println("Database contains:");
					String query1 = " select * from rf" ;
					int count1 = 0;
					ResultSet rs=stmt.executeQuery(query1);
					while(rs.next())
					{
					String Category=rs.getString("Category");
					String Regulation_Title=rs.getString("Regulation Title");
					String Implementation_date=rs.getString("Implementation date");
					String Regulatory_Compilance=rs.getString("Regulatory Compilance");
					String II=rs.getString("Insitutions involved (FK)");
					String Compliance_date=rs.getString("Compliance date");
					String Regulatory_Authority=rs.getString("Regulatory Authority");
					String output = "User #%d: %d - %s - %s -%d -%d - %s - %d";//%s for strings and %d for integers
					System.out.println(String.format(output, ++count1,Compliance_date,Regulatory_Compilance,Regulatory_Authority,Category,Regulation_Title,Implementation_date,II));
					}
				}
				
				case 3:{
					//economic indicator
					
				}
				case 4:{
					//Foreign Exchange
					System.out.println("Database contains:");
					String query1 = " select * from  foreign_exchange1" ;
					int count1 = 0;
					ResultSet rs=stmt.executeQuery(query1);
					while(rs.next())
					{
					String Date=rs.getString("Date");
					String Curriences=rs.getString("Curriences");
					String Transaction_type=rs.getString("Transaction type");
					String Bank=rs.getString("Bank");
					String Settlement_Date=rs.getString("Settlement Date");
					String Purpose=rs.getString("Purpose");
					int Bank_ID=rs.getInt("Bank ID");
					Double Exchange_Rate=rs.getDouble("Exchange Rate");
					int Transaction_value=rs.getInt("Transaction Value");
					String output = "User #%d: %d - %s - %s -%d -%d - %s - %d";//%s for strings and %d for integers
					System.out.println(String.format(output, ++count1,Bank_ID,Bank,Settlement_Date,Purpose,Transaction_value,Date,Curriences,Transaction_type,Exchange_Rate));
					}
				}
				
				case 5:{
					// bank tables
					System.out.println("Database contains:");
					String query1 = " select * from bank_table1" ;
					int count1 = 0;
					ResultSet rs=stmt.executeQuery(query1);
					while(rs.next())
					{
					String Institution_Name=rs.getString("Institution Name");
					String Institution_Type=rs.getString("Institution Type");
                     int Bank_Id=rs.getInt("Bank ID");
                    String Location=rs.getString("Location");
                    String Contact_Info=rs.getString("Contact Info");
					String Licence=rs.getString("Licence");
					String output = "User #%d: %d - %s - %s -%d -%d - %s - %d";//%s for strings and %d for integers
					System.out.println(String.format(output, ++count1,Licence,Institution_Type,Institution_Name,Location,Bank_Id,Contact_Info));
					}
					
					System.out.println("Database contains:");
					String query2 = " select * from bank_t2" ;
					int count2 = 0;
					ResultSet res=stmt.executeQuery(query1);
					while(rs.next())
					{
					int Bank_ID=rs.getInt("Bank ID");
					int Revenue=res.getInt("Revenue");
					String Products=rs.getString("Products");
					String Regulatory_Compliance=rs.getString("Regulatory Compilance");
					int Capital_Adequency=rs.getInt("Capital Adequency");
	
					String output = "User #%d: %d - %s - %s -%d -%d - %s - %d";//%s for strings and %d for integers
					System.out.println(String.format(output, ++count2,Bank_ID,Regulatory_Compliance,Revenue,Products,Capital_Adequency));
					}
					
				}
				case 6:{	
					//monetary policy
					System.out.println("Database contains:");
					String query1 = " select * from monetary_policy" ;
					int count1 = 0;
					ResultSet rs=stmt.executeQuery(query1);
					while(rs.next())
					{
					String Date=rs.getString("Date");
					String Instrument_type=rs.getString("Instrument type");
                     int Instrument_Value=rs.getInt("Instrument_Value");
                    String Target_Variable=rs.getString("Target Variable");
                    String Impact=rs.getString("Impact");
                    String output = "User #%d: %d - %s - %s -%d -%d - %s - %d";//%s for strings and %d for integers
					System.out.println(String.format(output, ++count1,Date,Instrument_type,Instrument_Value,Target_Variable,Impact));
					}
				}
			}
			conn.close();
			break;
		}
		
		case 3:
			{
				System.out.println("UPDATEeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
				System.out.println("Menu:\n1.Payment Systems\n2.Regulatory Frameworks\n3.Economic Indicators\n4.Foreign Exchange\n5.Financial Institutions");
				System.out.println("Enter choice:");
				
				int table_choice=Integer.parseInt(b.readLine());
				
				
				switch(table_choice) {
				case 1: {
					//payment table 1
					System.out.println("Enter Payment_ID to be updated:");
					int Payment_ID=Integer.parseInt(b.readLine());
					System.out.println("Want to update Transaction_ID ");
					int Transaction_ID=Integer.parseInt(b.readLine());
					if(Transaction_ID==1)
					{
					System.out.println("Enter Transaction_ID to be updated");
					job=b.readLine();

					query = " update emp123 set job=?" + " where empno= ?";
					prep_stmt=conn.prepareStatement(query);
					prep_stmt.setString(1, job);
					prep_stmt.setInt(2,empno);
					prep_stmt.execute();
					}
					System.out.println("Want to update salary?");
					c=Integer.parseInt(b.readLine());
					if(c==1)
					{
					System.out.println("Enter salary:");
					salary=Integer.parseInt(b.readLine());
					query = " update emp123 set salary=?" + " where empno= ?";
					prep_stmt=conn.prepareStatement(query);
					prep_stmt.setInt(1, salary);
					prep_stmt.setInt(2,empno);
					prep_stmt.execute();
					}
					System.out.println("Want to update commission?");
					c=Integer.parseInt(b.readLine());
					if(c==1)
					{
					System.out.println("Enter commission:");
					comm=Integer.parseInt(b.readLine());
					query = " update emp123 set commission=?" + " where empno= ?";
					prep_stmt=conn.prepareStatement(query);
					prep_stmt.setInt(1, comm);
					prep_stmt.setInt(2,empno);
					prep_stmt.execute();
					}
					System.out.println("Want to update dept no?");
					c=Integer.parseInt(b.readLine());
					if(c==1)
					{
					System.out.println("Enter dept_no:");
					dep=Integer.parseInt(b.readLine());
					query = " update emp123 set dept_no=?" + " where empno= ?";
					prep_stmt=conn.prepareStatement(query);
					prep_stmt.setInt(1,dep);
					prep_stmt.setInt(2,empno);
					prep_stmt.execute();
					}
			}
			
			
		case 4:System.out.println("Deleting:");
			System.out.println("Enter empno to be deleted:");
			
			empno=Integer.parseInt(b.readLine());
			query = " delete from emp123 where empno= ?";
			prep_stmt=conn.prepareStatement(query);
			prep_stmt.setInt(1,empno);
			prep_stmt.execute();
			conn.close();
			break;
		default:System.out.println("Wrong input!!");
		
		}
		System.out.println("continue");
		n=Integer.parseInt(b.readLine());
		
		}while(n==1);
		}
		catch(Exception e)
		{
		System.out.println(e);
		}
	}
}

