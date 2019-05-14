namespace Lab1_GUI
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
            this.ColourCheckBox = new System.Windows.Forms.CheckBox();
            this.messageTextBox = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // ColourCheckBox
            // 
            this.ColourCheckBox.AutoSize = true;
            this.ColourCheckBox.Location = new System.Drawing.Point(63, 157);
            this.ColourCheckBox.Name = "ColourCheckBox";
            this.ColourCheckBox.Size = new System.Drawing.Size(46, 17);
            this.ColourCheckBox.TabIndex = 0;
            this.ColourCheckBox.Text = "Red";
            this.ColourCheckBox.UseVisualStyleBackColor = true;
            this.ColourCheckBox.CheckedChanged += new System.EventHandler(this.checkBox1_CheckedChanged);
            // 
            // messageTextBox
            // 
            this.messageTextBox.Location = new System.Drawing.Point(63, 74);
            this.messageTextBox.Name = "messageTextBox";
            this.messageTextBox.Size = new System.Drawing.Size(100, 20);
            this.messageTextBox.TabIndex = 1;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(284, 261);
            this.Controls.Add(this.messageTextBox);
            this.Controls.Add(this.ColourCheckBox);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.CheckBox ColourCheckBox;
        private System.Windows.Forms.TextBox messageTextBox;
    }
}

