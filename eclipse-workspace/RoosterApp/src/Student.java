

public class Student extends Person
{
	protected int studentNumber;
	protected String[] chosenSubjectsArray = new String[2];

	
/////////////////////////////// Student number ///////////////////////////////////
	
	public void setStudentNumber(int newStudentNumber)
	{
		this.studentNumber = newStudentNumber;
	}
	
	public int getStudentNumber()
	{
		return studentNumber;
	}

	
///////////////////// Subjects, chosen by the Student ///////////////////////////
	
	public void setSubjects(String[] newSubjectList)
	{
		this.chosenSubjectsArray = newSubjectList;
	}
	
	public String[] getSubjects()
	{
		return chosenSubjectsArray;
	}
	
}