namespace StackCalculator
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
            this.btnEnter = new System.Windows.Forms.Button();
            this.txtData = new System.Windows.Forms.TextBox();
            this.txtTopStack = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.txtStackDisplay = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // btnEnter
            // 
            this.btnEnter.Location = new System.Drawing.Point(139, 45);
            this.btnEnter.Name = "btnEnter";
            this.btnEnter.Size = new System.Drawing.Size(75, 23);
            this.btnEnter.TabIndex = 0;
            this.btnEnter.Text = "Enter";
            this.btnEnter.UseVisualStyleBackColor = true;
            this.btnEnter.Click += new System.EventHandler(this.btnEnter_Click);
            // 
            // txtData
            // 
            this.txtData.Location = new System.Drawing.Point(33, 47);
            this.txtData.Name = "txtData";
            this.txtData.Size = new System.Drawing.Size(100, 20);
            this.txtData.TabIndex = 1;
            this.txtData.TextChanged += new System.EventHandler(this.txtData_TextChanged);
            // 
            // txtTopStack
            // 
            this.txtTopStack.Location = new System.Drawing.Point(251, 47);
            this.txtTopStack.Name = "txtTopStack";
            this.txtTopStack.Size = new System.Drawing.Size(100, 20);
            this.txtTopStack.TabIndex = 2;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(270, 31);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(69, 13);
            this.label1.TabIndex = 3;
            this.label1.Text = "Top of Stack";
            // 
            // txtStackDisplay
            // 
            this.txtStackDisplay.Location = new System.Drawing.Point(251, 93);
            this.txtStackDisplay.Multiline = true;
            this.txtStackDisplay.Name = "txtStackDisplay";
            this.txtStackDisplay.Size = new System.Drawing.Size(100, 92);
            this.txtStackDisplay.TabIndex = 4;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(386, 218);
            this.Controls.Add(this.txtStackDisplay);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.txtTopStack);
            this.Controls.Add(this.txtData);
            this.Controls.Add(this.btnEnter);
            this.Name = "Form1";
            this.Text = "Stack Calculator";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnEnter;
        private System.Windows.Forms.TextBox txtData;
        private System.Windows.Forms.TextBox txtTopStack;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtStackDisplay;
    }
}

