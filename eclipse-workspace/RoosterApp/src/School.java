import java.util.ArrayList;

public class School 
{
	private String school_name;
	private String school_address;
	protected ArrayList<Teacher> allTeachersArray = new ArrayList<Teacher>();
	protected ArrayList<Student> allStudentsArray = new ArrayList<Student>();
	protected ArrayList<Classroom> allClassroomArray = new ArrayList<Classroom>();
	String[] openDays =  {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    
///////////////////// Name /////////////////////////// 
	
    public void setSchoolName(String SchoolName)
    {
    	this.school_name = SchoolName;
    }
    
    public String getSchoolName()
    {
    	return school_name;
    }
 
///////////////////// Address /////////////////////////// 
    
    public void setSchoolAddress(String SchoolAddress)
    {
    	this.school_address = SchoolAddress;
    }
    
    public String getSchoolAddress()
    {
    	return school_address;
    }
	
///////////////////// Teacher /////////////////////////// 
    public void addTeacher(Teacher newTeacher)
    {	
    	this.allTeachersArray.add(newTeacher);
    }
    
    public ArrayList<Teacher> getAllTeachers()
    {
    	return allTeachersArray;
    }
   
///////////////////// Student /////////////////////////// 
	public void addStudent(Student newStudent)
	{
		this.allStudentsArray.add(newStudent);
	}
	
	public ArrayList<Student> getAllStudents()
	{
		return allStudentsArray;
	}

    
	

}
