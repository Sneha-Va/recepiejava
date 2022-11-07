import java.sql.*;
import java.util.Scanner;

public class recipe {
    public static void main(String args[])
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipedb","root","");

        }
        catch (Exception e){
            System.out.println(e);
        }
        int choice;
        String recipename,preparedby,ingredients;                       ;
        int price;
        Scanner s= new Scanner(System.in);
        while(true){
            System.out.println("1.select any option");
            System.out.println("1.insert");
            System.out.println("2.select");
            System.out.println("3.search");
            System.out.println("4.update");
            System.out.println("5.delete");
            System.out.println("6.exit");
            System.out.println("enter the choice");
            choice = s.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("insertdata");
                    System.out.println("enter recipe name");
                    recipename=s.next();
                    System.out.println("enter  name");
                    preparedby=s.next();
                    System.out.println("enter ingridents");
                    ingredients=s.next();
                    System.out.println("enter price");
                    price=s.nextInt();

                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipedb","root","");

                        String sql="INSERT INTO `recipe`(`id`, `recipename`, `preparedby`, `ingredients`, `price`) VALUES (?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setString(1,recipename);
                        stmt.setString(2,preparedby);
                        stmt.setString(3,ingredients);
                        stmt.setInt(5,price);

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                case 2:
                    System.out.println("select data");
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipedb","root","");
                        String sql="SELECT `id`, `recipename`, `preparedby`, `ingredients`, `price` FROM `recipe` ";
                        Statement stmt = con.createStatement();
                        ResultSet rs= stmt.executeQuery(sql);
                        while (rs.next()){
                            String getrecipename=rs.getString("recipename");
                            String getpreparedby=rs.getString("preparedby");
                            String getingredients=rs.getString("ingredients");
                            String getprice=rs.getString("price");
                            System.out.println("recipename="+getrecipename);
                            System.out.println("preparedby="+getpreparedby);
                            System.out.println("ingredients="+getingredients);
                            System.out.println("price="+getprice);

                        }

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                case 3:
                    System.out.println("search data");
                    System.out.println("enter price:");
                    price=s.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipedb","root","");
                        String sql="SELECT `id`, `recipename`, `preparedby`, `ingredients`, `price` FROM `recipe` WHERE `price`="+price;
                        Statement stmt = con.createStatement();
                        ResultSet rs= stmt.executeQuery(sql);
                        while(rs.next()){
                            String getrecipename=rs.getString("recipename");
                            String getpreparedby=rs.getString("preparedby");
                            String getingredients=rs.getString("ingredients");
                            String getprice=rs.getString("price");
                            System.out.println("recipename="+getrecipename);
                            System.out.println("preparedby="+getpreparedby);
                            System.out.println("ingredients="+getingredients);
                            System.out.println("price="+getprice);

                        }
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                case 4:
                    System.out.println("update data");
                    System.out.println("enter recipe price");
                    price=s.nextInt();
                    System.out.println("enter recipe name to be updated");
                    recipename=s.next();
                    System.out.println("enter    name to be updated");
                    preparedby=s.next();
                    System.out.println("enter ingrident to be updated");
                    ingredients=s.next();
                    System.out.println("enter price to be updated");
                    int prices=s.nextInt();

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipedb","root","");
                        String sql="UPDATE `recipe` SET `recipename`='"+recipename+"' ,`preparedby`='"+preparedby+"',`ingredients`='"+ingredients+"',`price`='"+String.valueOf(prices)+"' WHERE `price`="+String.valueOf(price);
                        Statement stmt =con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("update successfully");
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }



                case 5:
                    System.out.println("delete data");
                    System.out.println("enter price:");
                    String rprice=s.next();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipedb","root","");
                        String sql="DELETE FROM `recipe` WHERE `price`="+rprice;
                        Statement stmt =con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("deleted successfully");
                    }
                    catch (Exception e){
                        System.out.println((e));
                    }
                case 6:
                    System.out.println("exit");
                    break;
            }
        }
    }
}




