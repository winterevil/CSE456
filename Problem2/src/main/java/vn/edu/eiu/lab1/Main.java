package vn.edu.eiu.lab1;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        //Sử dụng các class cung cấp sẵn có trong thư viên JDBC (có trong JAVA SDK)
        //JDBC sẽ tự động kết nối với MySQL JDBC Server (MySQL connector/java)
        try {
            String url = "jdbc:mysql://localhost:3306/cse456_q4_2025";

            //Đối với Java mới thì Driver sẽ được tự động dò tìm trong URL mà ko cần lệnh này.
            //Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, "root", "123456789");
            System.out.println("Connected to database successfully");

            PreparedStatement ps = conn.prepareStatement("select * from student");
            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                System.out.print(rs.getString(1) + "|");
//                System.out.print(rs.getString("FirstName") + "|");
//                System.out.print(rs.getString("LastName") + "|");
//                System.out.print(rs.getString("YOB") + "|");
//                System.out.println(rs.getString("gpa"));
//            }
            while (rs.next()) {
                System.out.printf("|%4s|%-10s|%-10s|%4d|%4s|\n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
            }

            //Truy vấn sử dụng tham ố truyền vào mệnh đề
            //Insert dữ liệu vào bảng
            String stringSQL = "INSERT INTO student VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt1 = conn.prepareStatement(stringSQL);
            pstmt1.setString(1, "STD5");
            pstmt1.setString(2, "Lan");
            pstmt1.setString(3, "Truong");
            pstmt1.setInt(4, 2001);
            pstmt1.setDouble(5, 8.9);
//            pstmt1.executeUpdate();

            //Update điểm cho Lan lên 9.8
            String updateSQL = "update student set GPA = ? where id = ?";
            PreparedStatement pstmt2 = conn.prepareStatement(updateSQL);
            pstmt2.setDouble(1, 9.8);
            pstmt2.setString(2, "STD5");
            int rowEffected = pstmt2.executeUpdate();
            System.out.println(rowEffected + " rows affected");

            //Delete sinh viên
            String deleteSQL = "delete from student where id = ?";
            PreparedStatement pstmt3 = conn.prepareStatement(deleteSQL);
            pstmt3.setString(1, "STD5");
//            pstmt3.executeUpdate();

            conn.close();
            System.out.println("Connection closed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}