using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CalcExtended
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void resultButton_Click(object sender, EventArgs e)
        {
            char[] delimiterChars = { '+', '-', 'x', '/'};
            string calculation = expressionTextBox.Text;
            string[] expression = calculation.Split(' ');

            int num1 = Convert.ToInt32(expression[0]);
            int num2 = Convert.ToInt32(expression[2]);

            if (expression[1].Equals('+'))
            {
                resultTextBox.Text = Convert.ToString(num1 + num2);
            }
            else if (expression[1].Equals('-'))
            {
                resultTextBox.Text = Convert.ToString(num1 - num2);
            }
            else if (expression[1].Equals('x'))
            {
                resultTextBox.Text = Convert.ToString(num1 * num2);
            }
            else if (expression[1].Equals('/'))
            {
                resultTextBox.Text = Convert.ToString(num1 / num2);
            }


        }
    }
}
