package jdbc01;

import java.sql.*;
import java.util.Scanner;
/**
   @author Faisal Akhtar
 */
public class JDBC01 {

    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    static Scanner sc;
    
    static void createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/prac;create=true;user=root;password=faisal");
        } catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            System.out.println(e);
        }
    }
    
    static void shutConnection() {
        try {
            if (rs!=null) {
                rs.close();
            }
            if (stmt!=null) {
                stmt.close();
            }
            if (conn!=null) {
                conn.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        conn = null;
        stmt = null;
        rs = null;
        sc = new Scanner(System.in);
        int ch;
        String c;

        createConnection();
        if(conn!=null)  System.out.println("Connected!!");
        try {
            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT COUNT(*) AS count FROM RESULTS");
            rs.next();
            System.out.println("Total number of students : " + rs.getInt("count"));

            rs = stmt.executeQuery("SELECT MAX(MARKS) FROM (SELECT name, subj1 as marks FROM RESULTS UNION ALL SELECT name, subj2 as marks FROM RESULTS UNION ALL SELECT name, subj3 as marks FROM RESULTS UNION ALL SELECT name, subj4 as marks FROM RESULTS)");
            rs.next();
            System.out.println("Total number of students : " + rs.getInt("marks"));

            do{
                System.out.println("MENU");
                System.out.println("1.FIND TOTAL STUDENTS");
                System.out.println("2.Each subject avergae marks");
                System.out.println("3.STUDENT NAME WITH HIGHEST MARKS");
                System.out.println("4.NO OF STUDENTS GETTING FIRST SECOND AND THIRD DIVISION");
                System.out.println("5.SUBJECT WISE TOPEERS");
                System.out.println("6.AVERGAE MARKS");
                System.out.println("7.STUDENT GETTING SECOND HIGHEST MARKS");
                System.out.println("Enter your Choice!!!");
                ch=sc.nextInt();

                switch(ch)
                {
                    case 1:
                        rs= stmt.executeQuery("select count(*) total from student");
                        rs.next();
                        int tot=rs.getInt("total");
                        System.out.println("Total number of Students are: "+tot);
                        break;

                    case 2:
                        System.out.println("Enter the subject you want to calculate average of: ");
                        String sub=sc.next();
                        rs=stmt.executeQuery("select AVG(ALL "+sub+" ) as Average_Marks from result");
                        rs.next();
                        int s=rs.getInt("Average_Marks");
                        System.out.println("Average Marks Obtained in "+sub+ " are:"+s);
                        break;

                    case 3:
                        rs=stmt.executeQuery("select Max(Total),Fname as name from Student");
                        rs.next();
                        String nam=rs.getString("name");
                        System.out.println("Name of Student who scored highest marks is: "+nam);
                        break;

                    case 4:
                        rs=stmt.executeQuery("Select Division,count(fname)as total_Number from Student group by Division");
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int columnsNumber = rsmd.getColumnCount();                     
                        System.out.println("\n\n\tNumber of Students scoring First and Second divion Respectively are: ");
                        while(rs.next()) {
                            for (int i=2;i<=columnsNumber ;i++ ) {
                                System.out.println(rs.getInt(i));
                            }
                        }
                        break;

                    case 5:
                        rs=stmt.executeQuery("select s.Fname as 'Name',max(r.Hindi),max(r.Maths) from Student s,Result r where r.Sid=s.Sid" );
                        while(rs.next()) {
                            System.out.println("Max MArks in Hindi is of "+rs.getString("Name"));
                            System.out.println("Max MArks in Maths is of "+rs.getString("Name"));
                        }
                        break;

                    case 6:
                        rs=stmt.executeQuery("select s.Fname as 'Name',(avg(r.Hindi)+avg(r.Maths))/2 as avg from Student s,Result r where r.Sid=s.Sid" );
                        while(rs.next()) {
                            System.out.println("Average marks of "+rs.getString("Name")+" are "+rs.getInt("avg"));
                        }
                        break;

                    case 7:
                        rs=stmt.executeQuery("Select Fname as Name from Student Order By Total Limit 2,1 ");
                        rs.next();
                        System.out.println("Second Topper"+rs.getString("Name"));
                        break;
                }
                System.out.println("Do u want to continue y/n");
                c=sc.next();
            } while("n".equals(c)||"N".equals(c));
        } catch (Exception e) {
            System.out.println(e);
        }
        shutConnection();
    }
    
}

/*
use PRAC;
CREATE TABLE RESULTS (
    rollno int PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    name   varchar(25) NOT NULL,
    subj1  dec(8,2),
    subj2  dec(8,2),
    subj3  dec(8,2),
    subj4  dec(8,2)
);

INSERT INTO RESULTS (name,subj1,subj2,subj3,subj4) VALUES
( 'Faisal Akhtar'  , 92, 88, 98, 90 ),
( 'Shubhangi Goyal', 93, 92, 96, 96 ),
( 'Ritick Singh'   , 80, 82, 84, 86 ),
( 'Akhilesh Yadav' , 76, 78, 80, 82 ),
( 'Namrata Vishnoi', 86, 81, 87, 88 ),
( 'Gopal Trivedi'  , 88, 86, 84, 89 ),
( 'Pooja Chauhan'  , 94, 90, 88, 84 ),
( 'Adarsh Yadav'   , 89, 91, 90, 92 );
*/