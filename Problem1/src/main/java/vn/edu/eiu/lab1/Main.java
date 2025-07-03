package vn.edu.eiu.lab1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import vn.edu.eiu.lab1.entity.Course;
import vn.edu.eiu.lab1.entity.Student;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Student std1 = new Student("SDT-01", "Minh", "Tran", 2002, 9.1);
        Student std2 = new Student("SDT-02", "Man", "Truong", 2001, 8.6);
        Student std3 = new Student("SDT-03", "Khang", "Dang", 2003, 9.0);

        Course c1 = new Course("CSE 456", "Advanced Java Programming", 4, 60);
        Course c2 = new Course();
        c2.setIdCourse("CSE 301");
        c2.setName("Introduction to Database");
        c2.setCredits(4);
        c2.setHours(60);

        System.out.println("The list of students: ");
        System.out.println("Student 1: " + std1.toString());
//        System.out.println("Student 2: " + std2.toString());
//        System.out.println("Student 3: " + std3.toString());
//
//        System.out.println("The list of courses: ");
//        System.out.println("Course 1: " + c1.toString());
//        System.out.println("Course 2: " + c2.toString());

        //Object sang JSON
        ObjectMapper mapper = new ObjectMapper();
        String jstd1 = mapper.writeValueAsString(std1);
        System.out.println("Student 1 JSON format: " + jstd1);

        //JSON sang Object (lấy từ frontend, biến nó thành obj thuộc class Student)
        String jsonToObj = """
                {"id":"SDT-04","firstName":"Nam","lastName":"Tran","yearOfBirth":2003,"gpa":8.1}""";
        Student std4FromJson = mapper.readValue(jsonToObj, Student.class);
        System.out.println("Student 4: " + std4FromJson.toString());
    }
}