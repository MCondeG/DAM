package Class;

public class Student {
    //Atributos:
    private int studentID;
    private String username;
    private String name;
    private String password;
    private int groupID;
    
    //Constructores:
    public Student () { }
    
    public Student(int studentID, String username, String name, String password, int groupID){
        this.studentID = studentID;
        this.username = username;
        this.name = name;
        this.password = password;
        this.groupID = groupID;
    }
    
    //Métodos:
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }
}