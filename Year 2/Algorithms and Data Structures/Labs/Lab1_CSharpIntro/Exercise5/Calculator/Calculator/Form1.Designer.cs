namespace Calculator
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
            this.num1TextBox = new System.Windows.Forms.TextBox();
            this.num1Label = new System.Windows.Forms.Label();
            this.num2Label = new System.Windows.Forms.Label();
            this.num2TextBox = new System.Windows.Forms.TextBox();
            this.resultTextBox = new System.Windows.Forms.TextBox();
            this.resultLabel = new System.Windows.Forms.Label();
            this.operatorGroupBox = new System.Windows.Forms.GroupBox();
            this.divisionOperatorButton = new System.Windows.Forms.RadioButton();
            this.multiplicationOperatorButton = new System.Windows.Forms.RadioButton();
            this.subtractionOperatorButton = new System.Windows.Forms.RadioButton();
            this.additionOperatorButton = new System.Windows.Forms.RadioButton();
            this.calculateButton = new System.Windows.Forms.Button();
            this.powerOperatorButton = new System.Windows.Forms.RadioButton();
            this.operatorGroupBox.SuspendLayout();
            this.SuspendLayout();
            // 
            // num1TextBox
            // 
            this.num1TextBox.Location = new System.Drawing.Point(65, 46);
            this.num1TextBox.Name = "num1TextBox";
            this.num1TextBox.Size = new System.Drawing.Size(100, 20);
            this.num1TextBox.TabIndex = 0;
            this.num1TextBox.TextChanged += new System.EventHandler(this.num1TextBox_TextChanged);
            // 
            // num1Label
            // 
            this.num1Label.AutoSize = true;
            this.num1Label.Location = new System.Drawing.Point(4, 49);
            this.num1Label.Name = "num1Label";
            this.num1Label.Size = new System.Drawing.Size(53, 13);
            this.num1Label.TabIndex = 1;
            this.num1Label.Text = "Number 1";
            // 
            // num2Label
            // 
            this.num2Label.AutoSize = true;
            this.num2Label.Location = new System.Drawing.Point(5, 90);
            this.num2Label.Name = "num2Label";
            this.num2Label.Size = new System.Drawing.Size(53, 13);
            this.num2Label.TabIndex = 2;
            this.num2Label.Text = "Number 2";
            // 
            // num2TextBox
            // 
            this.num2TextBox.Location = new System.Drawing.Point(65, 90);
            this.num2TextBox.Name = "num2TextBox";
            this.num2TextBox.Size = new System.Drawing.Size(100, 20);
            this.num2TextBox.TabIndex = 3;
            // 
            // resultTextBox
            // 
            this.resultTextBox.Location = new System.Drawing.Point(65, 173);
            this.resultTextBox.Name = "resultTextBox";
            this.resultTextBox.Size = new System.Drawing.Size(100, 20);
            this.resultTextBox.TabIndex = 4;
            // 
            // resultLabel
            // 
            this.resultLabel.AutoSize = true;
            this.resultLabel.Location = new System.Drawing.Point(7, 176);
            this.resultLabel.Name = "resultLabel";
            this.resultLabel.Size = new System.Drawing.Size(37, 13);
            this.resultLabel.TabIndex = 5;
            this.resultLabel.Text = "Result";
            // 
            // operatorGroupBox
            // 
            this.operatorGroupBox.Controls.Add(this.powerOperatorButton);
            this.operatorGroupBox.Controls.Add(this.divisionOperatorButton);
            this.operatorGroupBox.Controls.Add(this.multiplicationOperatorButton);
            this.operatorGroupBox.Controls.Add(this.subtractionOperatorButton);
            this.operatorGroupBox.Controls.Add(this.additionOperatorButton);
            this.operatorGroupBox.Location = new System.Drawing.Point(185, 46);
            this.operatorGroupBox.Name = "operatorGroupBox";
            this.operatorGroupBox.Size = new System.Drawing.Size(200, 143);
            this.operatorGroupBox.TabIndex = 6;
            this.operatorGroupBox.TabStop = false;
            this.operatorGroupBox.Text = "Operator";
            // 
            // divisionOperatorButton
            // 
            this.divisionOperatorButton.AutoSize = true;
            this.divisionOperatorButton.Location = new System.Drawing.Point(7, 94);
            this.divisionOperatorButton.Name = "divisionOperatorButton";
            this.divisionOperatorButton.Size = new System.Drawing.Size(31, 17);
            this.divisionOperatorButton.TabIndex = 3;
            this.divisionOperatorButton.TabStop = true;
            this.divisionOperatorButton.Text = "÷";
            this.divisionOperatorButton.UseVisualStyleBackColor = true;
            // 
            // multiplicationOperatorButton
            // 
            this.multiplicationOperatorButton.AutoSize = true;
            this.multiplicationOperatorButton.Location = new System.Drawing.Point(7, 70);
            this.multiplicationOperatorButton.Name = "multiplicationOperatorButton";
            this.multiplicationOperatorButton.Size = new System.Drawing.Size(30, 17);
            this.multiplicationOperatorButton.TabIndex = 2;
            this.multiplicationOperatorButton.TabStop = true;
            this.multiplicationOperatorButton.Text = "x";
            this.multiplicationOperatorButton.UseVisualStyleBackColor = true;
            // 
            // subtractionOperatorButton
            // 
            this.subtractionOperatorButton.AutoSize = true;
            this.subtractionOperatorButton.Location = new System.Drawing.Point(7, 46);
            this.subtractionOperatorButton.Name = "subtractionOperatorButton";
            this.subtractionOperatorButton.Size = new System.Drawing.Size(28, 17);
            this.subtractionOperatorButton.TabIndex = 1;
            this.subtractionOperatorButton.TabStop = true;
            this.subtractionOperatorButton.Text = "-";
            this.subtractionOperatorButton.UseVisualStyleBackColor = true;
            // 
            // additionOperatorButton
            // 
            this.additionOperatorButton.AutoSize = true;
            this.additionOperatorButton.Location = new System.Drawing.Point(7, 20);
            this.additionOperatorButton.Name = "additionOperatorButton";
            this.additionOperatorButton.Size = new System.Drawing.Size(31, 17);
            this.additionOperatorButton.TabIndex = 0;
            this.additionOperatorButton.TabStop = true;
            this.additionOperatorButton.Text = "+";
            this.additionOperatorButton.UseVisualStyleBackColor = true;
            this.additionOperatorButton.CheckedChanged += new System.EventHandler(this.additionOperatorButton_CheckedChanged);
            // 
            // calculateButton
            // 
            this.calculateButton.Location = new System.Drawing.Point(65, 228);
            this.calculateButton.Name = "calculateButton";
            this.calculateButton.Size = new System.Drawing.Size(75, 23);
            this.calculateButton.TabIndex = 7;
            this.calculateButton.Text = "Calculate";
            this.calculateButton.UseVisualStyleBackColor = true;
            this.calculateButton.Click += new System.EventHandler(this.calculateButton_Click);
            // 
            // powerOperatorButton
            // 
            this.powerOperatorButton.AutoSize = true;
            this.powerOperatorButton.Location = new System.Drawing.Point(7, 118);
            this.powerOperatorButton.Name = "powerOperatorButton";
            this.powerOperatorButton.Size = new System.Drawing.Size(31, 17);
            this.powerOperatorButton.TabIndex = 4;
            this.powerOperatorButton.TabStop = true;
            this.powerOperatorButton.Text = "^";
            this.powerOperatorButton.UseVisualStyleBackColor = true;
            this.powerOperatorButton.CheckedChanged += new System.EventHandler(this.radioButton1_CheckedChanged);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(409, 330);
            this.Controls.Add(this.calculateButton);
            this.Controls.Add(this.operatorGroupBox);
            this.Controls.Add(this.resultLabel);
            this.Controls.Add(this.resultTextBox);
            this.Controls.Add(this.num2TextBox);
            this.Controls.Add(this.num2Label);
            this.Controls.Add(this.num1Label);
            this.Controls.Add(this.num1TextBox);
            this.Name = "Form1";
            this.Text = "Form1";
            this.operatorGroupBox.ResumeLayout(false);
            this.operatorGroupBox.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox num1TextBox;
        private System.Windows.Forms.Label num1Label;
        private System.Windows.Forms.Label num2Label;
        private System.Windows.Forms.TextBox num2TextBox;
        private System.Windows.Forms.TextBox resultTextBox;
        private System.Windows.Forms.Label resultLabel;
        private System.Windows.Forms.GroupBox operatorGroupBox;
        private System.Windows.Forms.RadioButton divisionOperatorButton;
        private System.Windows.Forms.RadioButton multiplicationOperatorButton;
        private System.Windows.Forms.RadioButton subtractionOperatorButton;
        private System.Windows.Forms.RadioButton additionOperatorButton;
        private System.Windows.Forms.Button calculateButton;
        private System.Windows.Forms.RadioButton powerOperatorButton;
    }
}

