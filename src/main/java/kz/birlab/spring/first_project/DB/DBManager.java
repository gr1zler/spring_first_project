package kz.birlab.spring.first_project.DB;

import java.util.ArrayList;

public class DBManager {
    static ArrayList<Student>students=new ArrayList<>();
    static Long id =3L;
    static{
        students.add(new Student(1L,"Damir","Zhanibekov",99,"A"));
        students.add(new Student(2L,"Omar","Muslim",45,"C"));
        students.add(new Student(3L,"Ernar","Zhumabekov",78,"B"));
    }
    public static ArrayList<Student> getStudents(){
        return students;
    }
    public static void addStudent(Student student){
        student.setId(++id);
        students.add(student);
    }

}
