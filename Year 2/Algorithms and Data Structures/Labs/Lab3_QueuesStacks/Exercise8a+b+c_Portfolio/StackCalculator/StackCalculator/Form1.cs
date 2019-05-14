using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace StackCalculator
{
    public partial class Form1 : Form
    {
        IntStack theStack = new IntStack(); 

        public Form1()
        {
            InitializeComponent();
        }



        private void btnEnter_Click(object sender, EventArgs e)
        {
           // theStack.Push(txtData.Text);
            process(txtData.Text);
            txtTopStack.Text = theStack.Peek().ToString();
            txtStackDisplay.Text = theStack.Print();
        }

        private void process(string input)
        {
            int rhs, lhs;
            switch (input)
            {
                case "+":
                    theStack.Push(theStack.Pop() + theStack.Pop());
                    break;
                case "-":
                    rhs = theStack.Pop();
                    lhs = theStack.Pop();
                    theStack.Push(lhs - rhs);
                    break;
                case "/":
                    rhs = theStack.Pop();
                    lhs = theStack.Pop();
                    theStack.Push(lhs / rhs);
                    break;
                case "*":
                    rhs = theStack.Pop();
                    lhs = theStack.Pop();
                    theStack.Push(lhs * rhs);
                    break;
                case "<>":
                    rhs = theStack.Pop();
                    lhs = theStack.Pop();
                    theStack.Push(rhs);
                    theStack.Push(lhs);
                    break;
                default:
                    theStack.Push(Convert.ToInt32(input));
                    break;
                

            }
            
        }

        private void txtData_TextChanged(object sender, EventArgs e)
        {

        }
    }
}