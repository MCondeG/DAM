package Inteface;

import Class.Student;
import java.util.ArrayList;

public interface IDAOStudent {
    public void CreateStudent(Student student);
    public Student ReadStudentByID(int studentID);
    public ArrayList < Student > ReadStudents();
    public void UpdateStudent(Student student);
    public void DeleteStudent(int studentID);
}
