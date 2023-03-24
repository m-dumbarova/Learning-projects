

public class ClassroomRooster {

	public static void main(String[] args) 
	{

		////////////////////////////////////////////////////// New SCHOOL //////////////////////////////////////////////////////////////////////
		School my_school = new School();

		//////////////////// TEACHERS ///////////////////
		
		Teacher teacher1 = new Teacher();
		teacher1.setName("Frank");
		teacher1.setSurname("Hoens");
		teacher1.setFunction("Teacher");
		teacher1.setSpecialty("Programming");
		my_school.addTeacher(teacher1);

		Teacher teacher2 = new Teacher();
		teacher2.setName("Miranda");
		teacher2.setSurname("Janssen");
		teacher2.setFunction("Teacher");
		teacher2.setSpecialty("Logopedie");
		my_school.addTeacher(teacher2);
		
		Teacher teacher3 = new Teacher();
		teacher3.setName("Pedro");
		teacher3.setSurname("Cazaba");
		teacher3.setFunction("Teacher");
		teacher3.setSpecialty("Spanish");
		my_school.addTeacher(teacher3);
		
		
		//////////////////// STUDENTS ///////////////////
	
		Student student1 = new Student();
		student1.setName("Martina");
		student1.setSurname("Dumbarova");
		student1.setFunction("Student");
		student1.setStudentNumber(125);
		my_school.addStudent(student1);
		
		Student student2 = new Student();
		student2.setName("Boriana");
		student2.setSurname("Todorova");
		student2.setFunction("Student");
		student2.setStudentNumber(126);
		my_school.addStudent(student2);
		
		Student student3 = new Student();
		student3.setName("Joost");
		student3.setSurname("Gerrits");
		student3.setFunction("Student");
		student3.setStudentNumber(127);
		my_school.addStudent(student3);
		
		Student student4 = new Student();
		student4.setName("Sunil");
		student4.setSurname("Kalil");
		student4.setFunction("Student");
		student4.setStudentNumber(128);
		my_school.addStudent(student4);
		
		Student student5 = new Student();
		student5.setName("Emily");
		student5.setSurname("Gans");
		student5.setFunction("Student");
		student5.setStudentNumber(129);
		my_school.addStudent(student5);
		
		Student student6 = new Student();
		student6.setName("Michel");
		student6.setSurname("Bolton");
		student6.setFunction("Student");
		student6.setStudentNumber(130);
		my_school.addStudent(student6);
		
		Student student7 = new Student();
		student7.setName("Hans");
		student7.setSurname("Anderssen");
		student7.setFunction("Student");
		student7.setStudentNumber(131);
		my_school.addStudent(student7);
		
		Student student8 = new Student();
		student8.setName("Tom");
		student8.setSurname("Hanks");
		student8.setFunction("Student");
		student8.setStudentNumber(132);
		my_school.addStudent(student8);
		
		Student student9 = new Student();
		student9.setName("Jannie");
		student9.setSurname("van Dorp");
		student9.setFunction("Student");
		student9.setStudentNumber(133);
		my_school.addStudent(student9);
		
		Student student10 = new Student();
		student10.setName("Koen");
		student10.setSurname("van Wijk");
		student10.setFunction("Student");
		student10.setStudentNumber(134);
		my_school.addStudent(student10);
		
		
		////////////////////////////////////////////////////// New CLASSROOM //////////////////////////////////////////////////////////////////////		
		
		Classroom room = new Classroom("Classroom 1");
		
		/////////////////////////////// Classroom 1 /////////////////////////
		room.addAvailableHour("Monday", "09:00 - 10:00");
		room.addAvailableHour("Monday", "10:00 - 11:00");
		room.addAvailableHour("Monday", "11:00 - 12:00");
		room.addAvailableHour("Tuesday", "09:00 - 10:00");
		room.addAvailableHour("Tuesday", "10:00 - 11:00");
		room.addAvailableHour("Tuesday", "11:00 - 12:00");
		room.addAvailableHour("Wednesday", "09:00 - 10:00");
		room.addAvailableHour("Wednesday", "10:00 - 11:00");
		room.addAvailableHour("Wednesday", "11:00 - 12:00");
		room.addAvailableHour("Thursday", "09:00 - 10:00");
		room.addAvailableHour("Thursday", "10:00 - 11:00");
		room.addAvailableHour("Thursday", "11:00 - 12:00");
		room.addAvailableHour("Friday", "09:00 - 10:00");
		room.addAvailableHour("Friday", "10:00 - 11:00");
		room.addAvailableHour("Friday", "11:00 - 12:00");
		//room.allAvailableHoursArray.get(2).nr_booked=2;
		//room.allAvailableHoursArray.get(10).nr_booked=1;
		my_school.allClassroomArray.add(room);
		
		room = new Classroom("Classroom 2");
		/////////////////////////////// Classroom 2 /////////////////////////
		room.addAvailableHour("Monday", "09:00 - 10:00");
		room.addAvailableHour("Monday", "10:00 - 11:00");
		room.addAvailableHour("Monday", "11:00 - 12:00");
		room.addAvailableHour("Tuesday", "09:00 - 10:00");
		room.addAvailableHour("Tuesday", "10:00 - 11:00");
		room.addAvailableHour("Tuesday", "11:00 - 12:00");
		room.addAvailableHour("Wednesday", "09:00 - 10:00");
		room.addAvailableHour("Wednesday", "10:00 - 11:00");
		room.addAvailableHour("Wednesday", "11:00 - 12:00");
		room.addAvailableHour("Thursday", "09:00 - 10:00");
		room.addAvailableHour("Thursday", "10:00 - 11:00");
		room.addAvailableHour("Thursday", "11:00 - 12:00");
		room.addAvailableHour("Friday", "09:00 - 10:00");
		room.addAvailableHour("Friday", "10:00 - 11:00");
		room.addAvailableHour("Friday", "11:00 - 12:00");
		my_school.allClassroomArray.add(room);
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		UI window = new UI(my_school);
		window.showContent();
	}
}
