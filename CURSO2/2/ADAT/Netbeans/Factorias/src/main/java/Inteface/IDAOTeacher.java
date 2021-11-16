package Inteface;

import Class.Teacher;
import java.util.ArrayList;

public interface IDAOTeacher {
    public void CreateTeacher(Teacher teacher);
    public Teacher ReadTeacherByID(int teacherID);
    public ArrayList < Teacher > ReadTeachers();
    public void UpdateTeacher(Teacher teacher);
    public void DeleteTeacher(int teacherID);
}
