package v2_UI;
import java.util.*;
import java.util.regex.*;
import java.awt.*;   
import java.awt.event.*;  




class LogIn 
{
	void getValue()
	{
	}
	
    public static void main(String args[])       
    {           
        /////////////////// PRINT OUT ALL THE Mi6 AGENTS FROM DB ///////////////////////////////////////////// 
        
        SecretAgent agent = new SecretAgent();
        agent.printAgents();
       
        /////////////////////////// USER INPUT /////////////////////////////////////////////

        // creating instance of Frame class   
 	    GUI f = new GUI();
 	    f.my_frame.setVisible(true);
 	   
 	    f.my_label.setText("Which is your agent number?");
 	    
 	    f.my_button.addActionListener(new ActionListener() { 
     	  public void actionPerformed(ActionEvent e) { 
     		 String agent_num_string = "";
             int num_int = 0;

             agent_num_string = f.my_field.getText(); //receive the agent number (as string) which the user has been typed in.

             if(Pattern.matches("[0-9]*",agent_num_string))
             {
                 num_int = Integer.valueOf(agent_num_string);
             }
             else
             {
                 f.my_label2.setText("That's not a valid number.");
                 return;
             }

             if ((num_int > 999) || (num_int < 0))
             {
            	 f.my_label2.setText("That's not a valid agent number.");
                 return;
             }
             
             if(agent_num_string.length() == 1)
             {
                 agent_num_string = ("00" + agent_num_string);
             }
             else if(agent_num_string.length() == 2)
             {
                 agent_num_string = ("0" + agent_num_string);
             }
             
             f.my_label2.setText(agent_num_string);
             
			///////////////////////////// CHECK IF AGENT NUMBER EXISTS /////////////////////////////////////////////
			if ( agent.existAgent(agent_num_string) )
			{
				String agent_name = agent.agentName(agent_num_string);
				String agent_surname = agent.agentSurname(agent_num_string);
				
				f.my_label2.setText("Welcome back, Agent " + agent_num_string + ". \nYour mission, should you decide to accept it, is... \nThis tape will self-destruct in five seconds. \nGood luck, " + agent_name + " " + agent_surname + ".");
			} 
			else
			{
				f.my_label2.setText("Agent " + agent_num_string +" does not exist!");
			}  
	
     	  } 
     	} );     
    }          
}