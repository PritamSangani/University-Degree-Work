using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Library
{
    public partial class Form1 : Form
    {
        Dictionary<string, Book> library = new Dictionary<string, Book>();

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void SearchBookButton_Click(object sender, EventArgs e)
        {
            string isbn = ISBNTextBox.Text;
            string title = TitleTextBox.Text;           

            if (library.ContainsKey(isbn))
            {
                foreach(KeyValuePair<string, Book> book in library)
                {
                    if (book.Value.Title.Contains(title))
                    {
                        BookISBNTextBox.Text = book.Value.ISBN;
                        BookTitleTextBox.Text = book.Value.Title;
                        StatusTextBox.Text = "Book Retrieved";
                        if (book.Value.Onloan == false)
                        {
                            LoanStatusTextBook.Text = "Available to Loan Out";
                        }
                        else
                        {
                            LoanStatusTextBook.Text = "Currently On Loan";
                        }
                    }
                }
            }
        }

        private void AddBookButton_Click(object sender, EventArgs e)
        {
            string isbn = ISBNTextBox.Text;
            string title = TitleTextBox.Text;

            library.Add(isbn, new Book(isbn, title));

            StatusTextBox.Text = "Book Added";
        }

        private void RemoveBookButton_Click(object sender, EventArgs e)
        {
            string isbn = ISBNTextBox.Text;
            library.Remove(isbn);
        }

        private void ChangeLoanStatusButton_Click(object sender, EventArgs e)
        {
            string isbn = BookISBNTextBox.Text;
            Book b = library[isbn];

            if(b.Onloan == false)
            {
                b.Onloan = true;
                LoanStatusTextBook.Text = "Currently On Loan";
            }
            else
            {
                b.Onloan = false;
                LoanStatusTextBook.Text = "Available to Loan Out";
            }
        }

        private void ViewLoanStatusButton_Click(object sender, EventArgs e)
        {

        }
    }
}
