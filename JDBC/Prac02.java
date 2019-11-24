package jdbc02;

import java.sql.*;
/**
   @author Faisal Akhtar
 */
public class JDBC02 {

    static Connection conn;
    static CallableStatement cstmt;

    static void createConnection() {
        try {
//          Class.forName("com.mysql.cj.jdbc.Driver");
//          conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","root");
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/prac;create=true;user=root;password=faisal");
        } catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            System.out.println(e);
        }
    }
    
    static void shutConnection() {
        try {
            if (cstmt!=null) {
                cstmt.close();
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
        cstmt = null;

        createConnection();
        if(conn!=null)  System.out.println("Connected!!");
        try {
            cstmt= conn.prepareCall("{CALL TotalCount(?)}");
            cstmt.registerOutParameter(1,java.sql.Types.INTEGER);
            cstmt.execute();
            int tot=cstmt.getInt(1);
            System.out.println("Total number of customers : "+tot);
        } catch (Exception e) {
            System.out.println(e);
        }
        shutConnection();
    }
}
/*
use PRAC;
CREATE TABLE CUSTOMERS (
    id     int         PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    name   varchar(25) NOT NULL
);

INSERT INTO CUSTOMERS (name) VALUES
( 'Faisal Akhtar'   ),
( 'Shubhangi Goyal' ),
( 'Ritick Singh'    ),
( 'Akhilesh Yadav'  ),
( 'Namrata Vishnoi' ),
( 'Gopal Trivedi'   ),
( 'Pooja Chauhan'   ),
( 'Adarsh Yadav'    );


DELIMITER //
CREATE PROCEDURE TotalCount (OUT tot INT)
 BEGIN
  SELECT COUNT(*) INTO param1 FROM CUSTOMERS;
 END;
//
*/