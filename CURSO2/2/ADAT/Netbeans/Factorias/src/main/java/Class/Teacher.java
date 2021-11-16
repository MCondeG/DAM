package Class;

public class Teacher {
    //Atributos:
    private int teacherID;
    private String username;
    private String name;
    private String password;
    
    //Constructores:
    public Teacher () { }
    
    public Teacher(int teacherID, String username, String name, String password){
        this.teacherID = teacherID;
        this.username = username;
        this.name = name;
        this.password = password;
    }
    
    //Métodos:
    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
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
}
