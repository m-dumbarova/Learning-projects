import java.util.ArrayList;

public class Classroom 
{
	public String classroom_location;
	public String name;
	public ArrayList<AvailableHour> allAvailableHoursArray = new ArrayList<AvailableHour>();
	int max_people = 3; // max room capacity

///////////////////////////////////////// CR name /////////////////////////////////////////
	
	public Classroom (String name) 
	{
		this.name = name;
	}

///////////////////////////////////////// Available hours /////////////////////////////////////////
	
	public void addAvailableHour(String my_day, String my_time) 
	{
		AvailableHour new_hour = new AvailableHour(my_day,my_time);
		allAvailableHoursArray.add(new_hour);
	}
	
	public void addBooking (int id) 
	{
		allAvailableHoursArray.toArray(AvailableHour[]::new)[id].nr_booked += 1;
	}
}


class AvailableHour
{
	String day;
	String hour;
	int nr_booked = 0;
	
	public AvailableHour(String my_day, String my_time) 
	{
		this.hour = my_time ;
		this.day = my_day ;
	}
}
