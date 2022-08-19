package dinuka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        String url="jdbc:mysql://localhost:3308/mynew";
        String username="root";
        String pwd="";

        try {
            Connection connection= DriverManager.getConnection(url,username,pwd);
            //inserting a row
            /*String sql="INSERT into customer(id,fname,lname)values(?,?,?)";
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1,10002);
            statement.setString(2,"Dinuka");
            statement.setString(3, "Ekanayake");

            int rows=statement.executeUpdate();

            if (rows>0){
                System.out.println("one row added");
            }
            statement.close();*/
            //displaying the rows
            String sql="select * from customer";
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);

            while (resultSet.next()){
                int id=resultSet.getInt(1);
                String fname=resultSet.getString(2);
                String lname=resultSet.getString(3);
                System.out.println(id+" "+fname+" "+lname);
            }
            connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
