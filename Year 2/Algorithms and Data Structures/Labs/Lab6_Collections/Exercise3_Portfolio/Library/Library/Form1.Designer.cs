namespace Library
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.ISBNTextBox = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.TitleTextBox = new System.Windows.Forms.TextBox();
            this.AddBookButton = new System.Windows.Forms.Button();
            this.RemoveBookButton = new System.Windows.Forms.Button();
            this.SearchBookButton = new System.Windows.Forms.Button();
            this.BookISBNTextBox = new System.Windows.Forms.TextBox();
            this.ChangeLoanStatusButton = new System.Windows.Forms.Button();
            this.LoanStatusTextBook = new System.Windows.Forms.TextBox();
            this.BookTitleTextBox = new System.Windows.Forms.TextBox();
            this.StatusTextBox = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // ISBNTextBox
            // 
            this.ISBNTextBox.Location = new System.Drawing.Point(50, 13);
            this.ISBNTextBox.Name = "ISBNTextBox";
            this.ISBNTextBox.Size = new System.Drawing.Size(196, 20);
            this.ISBNTextBox.TabIndex = 0;
            this.ISBNTextBox.Text = "Enter ISBN";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 16);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(32, 13);
            this.label1.TabIndex = 1;
            this.label1.Text = "ISBN";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(10, 48);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(27, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "Title";
            // 
            // TitleTextBox
            // 
            this.TitleTextBox.Location = new System.Drawing.Point(50, 45);
            this.TitleTextBox.Name = "TitleTextBox";
            this.TitleTextBox.Size = new System.Drawing.Size(196, 20);
            this.TitleTextBox.TabIndex = 3;
            this.TitleTextBox.Text = "Enter the title of the book";
            // 
            // AddBookButton
            // 
            this.AddBookButton.Location = new System.Drawing.Point(100, 78);
            this.AddBookButton.Name = "AddBookButton";
            this.AddBookButton.Size = new System.Drawing.Size(75, 23);
            this.AddBookButton.TabIndex = 6;
            this.AddBookButton.Text = "Add Book";
            this.AddBookButton.UseVisualStyleBackColor = true;
            this.AddBookButton.Click += new System.EventHandler(this.AddBookButton_Click);
            // 
            // RemoveBookButton
            // 
            this.RemoveBookButton.AutoSize = true;
            this.RemoveBookButton.Location = new System.Drawing.Point(185, 78);
            this.RemoveBookButton.Name = "RemoveBookButton";
            this.RemoveBookButton.Size = new System.Drawing.Size(85, 23);
            this.RemoveBookButton.TabIndex = 7;
            this.RemoveBookButton.Text = "Remove Book";
            this.RemoveBookButton.UseVisualStyleBackColor = true;
            this.RemoveBookButton.Click += new System.EventHandler(this.RemoveBookButton_Click);
            // 
            // SearchBookButton
            // 
            this.SearchBookButton.AutoSize = true;
            this.SearchBookButton.Location = new System.Drawing.Point(13, 78);
            this.SearchBookButton.Name = "SearchBookButton";
            this.SearchBookButton.Size = new System.Drawing.Size(79, 23);
            this.SearchBookButton.TabIndex = 8;
            this.SearchBookButton.Text = "Search Book";
            this.SearchBookButton.UseVisualStyleBackColor = true;
            this.SearchBookButton.Click += new System.EventHandler(this.SearchBookButton_Click);
            // 
            // BookISBNTextBox
            // 
            this.BookISBNTextBox.Location = new System.Drawing.Point(13, 134);
            this.BookISBNTextBox.MaximumSize = new System.Drawing.Size(257, 80);
            this.BookISBNTextBox.Name = "BookISBNTextBox";
            this.BookISBNTextBox.ReadOnly = true;
            this.BookISBNTextBox.Size = new System.Drawing.Size(79, 20);
            this.BookISBNTextBox.TabIndex = 9;
            // 
            // ChangeLoanStatusButton
            // 
            this.ChangeLoanStatusButton.AutoSize = true;
            this.ChangeLoanStatusButton.Location = new System.Drawing.Point(50, 169);
            this.ChangeLoanStatusButton.Name = "ChangeLoanStatusButton";
            this.ChangeLoanStatusButton.Size = new System.Drawing.Size(179, 23);
            this.ChangeLoanStatusButton.TabIndex = 11;
            this.ChangeLoanStatusButton.Text = "Change Loan Status";
            this.ChangeLoanStatusButton.UseVisualStyleBackColor = true;
            this.ChangeLoanStatusButton.Click += new System.EventHandler(this.ChangeLoanStatusButton_Click);
            // 
            // LoanStatusTextBook
            // 
            this.LoanStatusTextBook.Location = new System.Drawing.Point(13, 207);
            this.LoanStatusTextBook.Name = "LoanStatusTextBook";
            this.LoanStatusTextBook.ReadOnly = true;
            this.LoanStatusTextBook.Size = new System.Drawing.Size(251, 20);
            this.LoanStatusTextBook.TabIndex = 12;
            // 
            // BookTitleTextBox
            // 
            this.BookTitleTextBox.Location = new System.Drawing.Point(100, 134);
            this.BookTitleTextBox.Name = "BookTitleTextBox";
            this.BookTitleTextBox.ReadOnly = true;
            this.BookTitleTextBox.Size = new System.Drawing.Size(170, 20);
            this.BookTitleTextBox.TabIndex = 13;
            // 
            // StatusTextBox
            // 
            this.StatusTextBox.Location = new System.Drawing.Point(13, 108);
            this.StatusTextBox.Name = "StatusTextBox";
            this.StatusTextBox.ReadOnly = true;
            this.StatusTextBox.Size = new System.Drawing.Size(257, 20);
            this.StatusTextBox.TabIndex = 14;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSize = true;
            this.ClientSize = new System.Drawing.Size(283, 263);
            this.Controls.Add(this.StatusTextBox);
            this.Controls.Add(this.BookTitleTextBox);
            this.Controls.Add(this.LoanStatusTextBook);
            this.Controls.Add(this.ChangeLoanStatusButton);
            this.Controls.Add(this.BookISBNTextBox);
            this.Controls.Add(this.SearchBookButton);
            this.Controls.Add(this.RemoveBookButton);
            this.Controls.Add(this.AddBookButton);
            this.Controls.Add(this.TitleTextBox);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.ISBNTextBox);
            this.Name = "Form1";
            this.Text = "Library";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox ISBNTextBox;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox TitleTextBox;
        private System.Windows.Forms.Button AddBookButton;
        private System.Windows.Forms.Button RemoveBookButton;
        private System.Windows.Forms.Button SearchBookButton;
        private System.Windows.Forms.TextBox BookISBNTextBox;
        private System.Windows.Forms.Button ChangeLoanStatusButton;
        private System.Windows.Forms.TextBox LoanStatusTextBook;
        private System.Windows.Forms.TextBox BookTitleTextBox;
        private System.Windows.Forms.TextBox StatusTextBox;
    }
}

