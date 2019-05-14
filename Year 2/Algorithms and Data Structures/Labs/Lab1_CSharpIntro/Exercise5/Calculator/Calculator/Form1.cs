using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Calculator
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void num1TextBox_TextChanged(object sender, EventArgs e)
        {
            
        }

        private void additionOperatorButton_CheckedChanged(object sender, EventArgs e)
        {
            
        }

        private void calculateButton_Click(object sender, EventArgs e)
        {
            if (additionOperatorButton.Checked == true)
            {
                int num1 = Convert.ToInt32(num1TextBox.Text);
                int num2 = Convert.ToInt32(num2TextBox.Text);
                int result = num1 + num2;
                resultTextBox.Text = Convert.ToString(result);
            }
            else if (subtractionOperatorButton.Checked == true)
            {
                int num1 = Convert.ToInt32(num1TextBox.Text);
                int num2 = Convert.ToInt32(num2TextBox.Text);
                int result = num1 - num2;
                resultTextBox.Text = Convert.ToString(result);
            }
            else if (multiplicationOperatorButton.Checked == true)
            {
                int num1 = Convert.ToInt32(num1TextBox.Text);
                int num2 = Convert.ToInt32(num2TextBox.Text);
                int result = num1 * num2;
                resultTextBox.Text = Convert.ToString(result);
            }
            else if (divisionOperatorButton.Checked == true)
            {
                float num1 = (float)Convert.ToDouble(num1TextBox.Text);
                float num2 = (float)Convert.ToDouble(num2TextBox.Text);
                float result = num1 / num2;
                resultTextBox.Text = Convert.ToString(result);
            }
            else if (powerOperatorButton.Checked == true)
            {
                int num1 = Convert.ToInt32(num1TextBox.Text);
                int num2 = Convert.ToInt32(num2TextBox.Text);
                int result = 1;
  
                for (int i = 0; i < num2; i++)
                {
                    result = result * num1;
                }
                resultTextBox.Text = Convert.ToString(result);
            }
        }

        private void radioButton1_CheckedChanged(object sender, EventArgs e)
        {

        }
    }
}
