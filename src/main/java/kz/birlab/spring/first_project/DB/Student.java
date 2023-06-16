package kz.birlab.spring.first_project.DB;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Student {
    private Long id;
    private String name;
    private String surname;
    private int exam;
    private String mark;

}
