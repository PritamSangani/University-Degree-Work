import javax.swing.*;
import java.awt.event.*;

public class Calculator extends JPanel implements ActionListener
{
	JButton buttonTimes;
	JButton buttonDivide;
	JButton buttonPlus;
	JButton buttonMinus;
	
	JTextField input1;
	JTextField input2;
	
	JLabel answer;
	
	Calculator()
	{
		//instantiate components
		input1 = new JTextField(8);
		input2 = new JTextField(8);
		
		buttonTimes = new JButton("x");
		buttonDivide = new JButton("/");
		buttonPlus = new JButton("+");
		buttonMinus = new JButton("-");
		
		answer = new JLabel("Answer: ");
		
		//send button events to this
		buttonTimes.addActionListener(this);
		buttonDivide.addActionListener(this);
		buttonPlus.addActionListener(this);
		buttonMinus.addActionListener(this);
		
		//populate the JPanel
		add(input1);
		add(input2);
		add(buttonTimes);
		add(buttonDivide);
		add(buttonPlus);
		add(buttonMinus);
		add(answer);
	}
	
	public static void main( String args[] )
	{
		JFrame frame = new JFrame("Calculator");
		frame.setSize(600, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//add an instance of panel
		frame.add(new Calculator());
		frame.setVisible(true);
	}

	enum Operand{TIMES, DIVIDE, PLUS, MINUS}

	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == buttonTimes)
		{
			Calculate(Operand.TIMES);
		}
		else if(event.getSource() == buttonDivide)
		{
			Calculate(Operand.DIVIDE);
		}
		else if(event.getSource() == buttonPlus)
		{
			Calculate(Operand.PLUS);
		}
		else if(event.getSource() == buttonMinus)
		{
			Calculate(Operand.MINUS);
		}
	}

	void Calculate(Operand Operation)
	{
		try
		{
			//get the operands
			float value1 = Float.parseFloat(input1.getText());
			float value2 = Float.parseFloat(input2.getText());
			
			float result = 0;
			//calculate result
			
			
			switch(Operation)
			{
				case TIMES: 
				{
					result = value1 * value2; 
				}
				break;
				case DIVIDE:
				{
					result = value1 / value2;
				}
				break;
				case PLUS:
				{
					result = value1 + value2;
				}
				break;
				case MINUS:
				{
					result = value1 - value2;
				}
				break;
			}
			answer.setText("Answer: " + result);
		}
		
		catch(Exception event)
		{
			answer.setText("Invalid Input");
		}
		
	}
	
}

