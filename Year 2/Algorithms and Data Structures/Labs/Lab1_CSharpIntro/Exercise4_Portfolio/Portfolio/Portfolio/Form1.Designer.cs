namespace Portfolio
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
            this.messageTextBox = new System.Windows.Forms.TextBox();
            this.ColourCheckBox = new System.Windows.Forms.CheckBox();
            this.SuspendLayout();
            // 
            // messageTextBox
            // 
            this.messageTextBox.Location = new System.Drawing.Point(44, 48);
            this.messageTextBox.Name = "messageTextBox";
            this.messageTextBox.Size = new System.Drawing.Size(100, 20);
            this.messageTextBox.TabIndex = 0;
            // 
            // ColourCheckBox
            // 
            this.ColourCheckBox.AutoSize = true;
            this.ColourCheckBox.Location = new System.Drawing.Point(44, 128);
            this.ColourCheckBox.Name = "ColourCheckBox";
            this.ColourCheckBox.Size = new System.Drawing.Size(46, 17);
            this.ColourCheckBox.TabIndex = 1;
            this.ColourCheckBox.Text = "Red";
            this.ColourCheckBox.UseVisualStyleBackColor = true;
            this.ColourCheckBox.CheckedChanged += new System.EventHandler(this.ColourCheckBox_CheckedChanged);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(284, 261);
            this.Controls.Add(this.ColourCheckBox);
            this.Controls.Add(this.messageTextBox);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox messageTextBox;
        private System.Windows.Forms.CheckBox ColourCheckBox;
    }
}

