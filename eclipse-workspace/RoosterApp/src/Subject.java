
public class Subject 
{
	protected String subject_name;
	protected boolean classroom;
	protected String[] subscribedStudentsArray = new String[3];
    
	
///////////////////// Subject name ///////////////////////////
	
    public void setSubjectName(String newSubjectName)
    {
      this.subject_name = newSubjectName;
    }
    
    public String getSubjectName()
    {
      return subject_name;
    }

}
