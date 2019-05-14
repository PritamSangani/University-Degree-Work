namespace GlobalTradingDataApp
{
    partial class AddTradingPartnerForm
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
            this.components = new System.ComponentModel.Container();
            this.label1 = new System.Windows.Forms.Label();
            this.countryLabel = new System.Windows.Forms.Label();
            this.countriesDropDownList = new System.Windows.Forms.ComboBox();
            this.addTradingPartnerButton = new System.Windows.Forms.Button();
            this.countryBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.countryBindingSource1 = new System.Windows.Forms.BindingSource(this.components);
            ((System.ComponentModel.ISupportInitialize)(this.countryBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.countryBindingSource1)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(12, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(267, 26);
            this.label1.TabIndex = 0;
            this.label1.Text = "Add a Trading Partner for: ";
            this.label1.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            // 
            // countryLabel
            // 
            this.countryLabel.AutoSize = true;
            this.countryLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.countryLabel.Location = new System.Drawing.Point(285, 9);
            this.countryLabel.Name = "countryLabel";
            this.countryLabel.Size = new System.Drawing.Size(149, 26);
            this.countryLabel.TabIndex = 1;
            this.countryLabel.Text = "New Country";
            this.countryLabel.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // countriesDropDownList
            // 
            this.countriesDropDownList.DropDownHeight = 132;
            this.countriesDropDownList.FormattingEnabled = true;
            this.countriesDropDownList.IntegralHeight = false;
            this.countriesDropDownList.Location = new System.Drawing.Point(17, 86);
            this.countriesDropDownList.MaxDropDownItems = 50;
            this.countriesDropDownList.Name = "countriesDropDownList";
            this.countriesDropDownList.Size = new System.Drawing.Size(344, 21);
            this.countriesDropDownList.TabIndex = 2;
            // 
            // addTradingPartnerButton
            // 
            this.addTradingPartnerButton.Location = new System.Drawing.Point(118, 207);
            this.addTradingPartnerButton.Name = "addTradingPartnerButton";
            this.addTradingPartnerButton.Size = new System.Drawing.Size(142, 23);
            this.addTradingPartnerButton.TabIndex = 3;
            this.addTradingPartnerButton.Text = "Add Trading Partner";
            this.addTradingPartnerButton.UseVisualStyleBackColor = true;
            this.addTradingPartnerButton.Click += new System.EventHandler(this.addTradingPartnerButton_Click);
            // 
            // countryBindingSource
            // 
            this.countryBindingSource.DataSource = typeof(GlobalTradingDataApp.Country);
            // 
            // countryBindingSource1
            // 
            this.countryBindingSource1.DataSource = typeof(GlobalTradingDataApp.Country);
            // 
            // AddTradingPartnerForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoScroll = true;
            this.AutoSize = true;
            this.ClientSize = new System.Drawing.Size(574, 372);
            this.Controls.Add(this.addTradingPartnerButton);
            this.Controls.Add(this.countriesDropDownList);
            this.Controls.Add(this.countryLabel);
            this.Controls.Add(this.label1);
            this.Name = "AddTradingPartnerForm";
            this.Text = "Add Trading Partner";
            this.Load += new System.EventHandler(this.AddTradingPartnerForm_Load);
            ((System.ComponentModel.ISupportInitialize)(this.countryBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.countryBindingSource1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label countryLabel;
        private System.Windows.Forms.ComboBox countriesDropDownList;
        private System.Windows.Forms.BindingSource countryBindingSource;
        private System.Windows.Forms.BindingSource countryBindingSource1;
        private System.Windows.Forms.Button addTradingPartnerButton;
    }
}