package vn.edu.eiu.lab1.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor //Constructor không tham số
@AllArgsConstructor //Constructor full tham số
@ToString
public class Course {
    private String idCourse;
    private String name;
    private int credits;
    private double hours;
}
