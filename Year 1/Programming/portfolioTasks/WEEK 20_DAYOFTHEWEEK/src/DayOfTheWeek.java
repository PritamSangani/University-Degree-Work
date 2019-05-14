import javax.swing.*;
import java.awt.event.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class DayOfTheWeek extends JPanel implements ActionListener
{
	//declare components of JPanel as variables
	JLabel Date;
	JLabel Month;
	JLabel Year;
	
	JTextField inputDate;
	JTextField inputMonth;
	JTextField inputYear;
	
	JButton getDay;
	
	JLabel output;
	
	//constructor
	DayOfTheWeek()
	{
		//instantiate components
		Date = new JLabel("Date: ");
		Month = new JLabel("Month: ");
		Year = new JLabel("Year: ");
		
		inputDate = new JTextField(2);
		inputMonth = new JTextField(2);
		inputYear = new JTextField(4);
		
		getDay = new JButton("Get Day");
		
		output = new JLabel("");
		
		//send button event to this
		getDay.addActionListener(this);
		
		//populate components on to panel
		add(Date);
		add(inputDate);
		add(Month);
		add(inputMonth);
		add(Year);
		add(inputYear);
		add(getDay);
		add(output);
	}
	
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("Day of the Week Calculator");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//add an instance of panel
		frame.add(new DayOfTheWeek());
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getSource() == getDay)
		{
			calculateDay();
		}
	}
	void calculateDay()
	{
		try
		{
			int dateValue = Integer.parseInt(inputDate.getText());
			int monthValue = Integer.parseInt(inputMonth.getText());
			int yearValue = Integer.parseInt(inputYear.getText());
			
			int dayOfWeek = Doomsday.GetDayOfWeek(dateValue, monthValue, yearValue);
			String day = "";
			
			switch(dayOfWeek)
			{
				case 0:
				{
					day = "Sunday";
				}
				break;
				case 1: 
				{
					day = "Monday";
				}
				break;
				case 2:
				{
					day = "Tuesday";
				}
				break;
				case 3:
				{
					day = "Wednesday";
				}
				break;
				case 4:
				{
					day = "Thursday";
				}
				break;
				case 5:
				{
					day = "Friday";
				}
				break;
				case 6:
				{
					day = "Saturday";
				}
				break;
			}
			
			String outputDate = (dateValue + "/" + monthValue + "/" + yearValue);
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date currentDate = new Date();
			Date compareDate = dateFormat.parse(outputDate);
			
			System.out.println(currentDate); 
			System.out.println(compareDate);
			
			if(getDatePart(compareDate) == getDatePart(currentDate))
			{
				output.setText(dateValue + " / " + monthValue + " / " + yearValue + " is a " + day);
			}
			else if(compareDate.before(currentDate))
			{
				output.setText(dateValue + " / " + monthValue + " / " + yearValue + " was a " + day);
			}
			else
			{
				output.setText(dateValue + " / " + monthValue + " / " + yearValue + " will be a " + day);
			}
			
		}
		catch(Exception event)
		{
			output.setText("Invalid Input");
			event.printStackTrace(System.out);
			
		}
	}
	
	public static long getDatePart(Date date) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.set(Calendar.HOUR_OF_DAY, 0);
	    cal.set(Calendar.MINUTE, 0);
	    cal.set(Calendar.SECOND, 0);
	    cal.set(Calendar.MILLISECOND, 0);

	    return cal.getTimeInMillis();
	}
}
