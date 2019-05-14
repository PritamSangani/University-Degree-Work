using System;

namespace GlobalTradingDataApp
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.countriesListBox = new System.Windows.Forms.ListBox();
            this.label1 = new System.Windows.Forms.Label();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.refreshListBoxButton = new System.Windows.Forms.Button();
            this.tradingPartnersSearchButton = new System.Windows.Forms.Button();
            this.searchStatusLabel = new System.Windows.Forms.Label();
            this.label16 = new System.Windows.Forms.Label();
            this.label15 = new System.Windows.Forms.Label();
            this.mainTradePartnersSearchBox = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.countrySearchBox = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.FileMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.LoadFileMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.saveToFileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.exitToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.label17 = new System.Windows.Forms.Label();
            this.AddNewCountryButton = new System.Windows.Forms.Button();
            this.SaveCountryButton = new System.Windows.Forms.Button();
            this.RemoveCountryButton = new System.Windows.Forms.Button();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.AddTradePartnerButton = new System.Windows.Forms.Button();
            this.GotoTradePartnerButton = new System.Windows.Forms.Button();
            this.RemoveTradePartnerButton = new System.Windows.Forms.Button();
            this.TradePartnersListBox = new System.Windows.Forms.ListBox();
            this.label10 = new System.Windows.Forms.Label();
            this.HDIRankingTextBox = new System.Windows.Forms.TextBox();
            this.label9 = new System.Windows.Forms.Label();
            this.TradeBalanceTextBox = new System.Windows.Forms.TextBox();
            this.label8 = new System.Windows.Forms.Label();
            this.InflationTextBox = new System.Windows.Forms.TextBox();
            this.label7 = new System.Windows.Forms.Label();
            this.GDPGrowthTextBox = new System.Windows.Forms.TextBox();
            this.label6 = new System.Windows.Forms.Label();
            this.CountryNameTextBox = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.groupBox4 = new System.Windows.Forms.GroupBox();
            this.BiggestPotentialForTradeLabel = new System.Windows.Forms.Label();
            this.UniqueCountriesLabel = new System.Windows.Forms.Label();
            this.TreeHeightLabel = new System.Windows.Forms.Label();
            this.label14 = new System.Windows.Forms.Label();
            this.label13 = new System.Windows.Forms.Label();
            this.label12 = new System.Windows.Forms.Label();
            this.label11 = new System.Windows.Forms.Label();
            this.groupBox1.SuspendLayout();
            this.menuStrip1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.groupBox3.SuspendLayout();
            this.groupBox4.SuspendLayout();
            this.SuspendLayout();
            // 
            // countriesListBox
            // 
            this.countriesListBox.FormattingEnabled = true;
            this.countriesListBox.Location = new System.Drawing.Point(16, 51);
            this.countriesListBox.Name = "countriesListBox";
            this.countriesListBox.Size = new System.Drawing.Size(255, 316);
            this.countriesListBox.TabIndex = 0;
            this.countriesListBox.SelectedIndexChanged += new System.EventHandler(this.countriesListBox_SelectedIndexChanged);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(13, 35);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(60, 13);
            this.label1.TabIndex = 1;
            this.label1.Text = "Countries";
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.refreshListBoxButton);
            this.groupBox1.Controls.Add(this.tradingPartnersSearchButton);
            this.groupBox1.Controls.Add(this.searchStatusLabel);
            this.groupBox1.Controls.Add(this.label16);
            this.groupBox1.Controls.Add(this.label15);
            this.groupBox1.Controls.Add(this.mainTradePartnersSearchBox);
            this.groupBox1.Controls.Add(this.label3);
            this.groupBox1.Controls.Add(this.countrySearchBox);
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.Location = new System.Drawing.Point(16, 340);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(257, 195);
            this.groupBox1.TabIndex = 2;
            this.groupBox1.TabStop = false;
            // 
            // refreshListBoxButton
            // 
            this.refreshListBoxButton.Location = new System.Drawing.Point(98, 145);
            this.refreshListBoxButton.Name = "refreshListBoxButton";
            this.refreshListBoxButton.Size = new System.Drawing.Size(75, 23);
            this.refreshListBoxButton.TabIndex = 8;
            this.refreshListBoxButton.Text = "Refresh ListBox";
            this.refreshListBoxButton.UseVisualStyleBackColor = true;
            this.refreshListBoxButton.Click += new System.EventHandler(this.refreshListBoxButton_Click);
            // 
            // tradingPartnersSearchButton
            // 
            this.tradingPartnersSearchButton.Location = new System.Drawing.Point(10, 145);
            this.tradingPartnersSearchButton.Name = "tradingPartnersSearchButton";
            this.tradingPartnersSearchButton.Size = new System.Drawing.Size(75, 23);
            this.tradingPartnersSearchButton.TabIndex = 7;
            this.tradingPartnersSearchButton.Text = "Search";
            this.tradingPartnersSearchButton.UseVisualStyleBackColor = true;
            this.tradingPartnersSearchButton.Click += new System.EventHandler(this.tradingPartnersSearchButton_Click);
            // 
            // searchStatusLabel
            // 
            this.searchStatusLabel.AutoSize = true;
            this.searchStatusLabel.Location = new System.Drawing.Point(57, 172);
            this.searchStatusLabel.Name = "searchStatusLabel";
            this.searchStatusLabel.Size = new System.Drawing.Size(111, 13);
            this.searchStatusLabel.TabIndex = 6;
            this.searchStatusLabel.Text = "No search made yet...";
            // 
            // label16
            // 
            this.label16.AutoSize = true;
            this.label16.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label16.Location = new System.Drawing.Point(7, 172);
            this.label16.Name = "label16";
            this.label16.Size = new System.Drawing.Size(51, 13);
            this.label16.TabIndex = 5;
            this.label16.Text = "Status: ";
            // 
            // label15
            // 
            this.label15.AutoSize = true;
            this.label15.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label15.Location = new System.Drawing.Point(6, 34);
            this.label15.Name = "label15";
            this.label15.Size = new System.Drawing.Size(117, 13);
            this.label15.TabIndex = 4;
            this.label15.Text = "Search for Country:";
            // 
            // mainTradePartnersSearchBox
            // 
            this.mainTradePartnersSearchBox.Location = new System.Drawing.Point(10, 118);
            this.mainTradePartnersSearchBox.Name = "mainTradePartnersSearchBox";
            this.mainTradePartnersSearchBox.Size = new System.Drawing.Size(236, 20);
            this.mainTradePartnersSearchBox.TabIndex = 3;
            this.mainTradePartnersSearchBox.TextChanged += new System.EventHandler(this.mainTradePartnersSearchBox_TextChanged);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(7, 101);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(197, 13);
            this.label3.TabIndex = 2;
            this.label3.Text = "Search by Main Trading Partners:";
            // 
            // countrySearchBox
            // 
            this.countrySearchBox.Location = new System.Drawing.Point(10, 77);
            this.countrySearchBox.Name = "countrySearchBox";
            this.countrySearchBox.Size = new System.Drawing.Size(236, 20);
            this.countrySearchBox.TabIndex = 1;
            this.countrySearchBox.TextChanged += new System.EventHandler(this.countrySearchBox_TextChanged);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(7, 59);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(104, 13);
            this.label2.TabIndex = 0;
            this.label2.Text = "Search by Name:";
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.FileMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(949, 24);
            this.menuStrip1.TabIndex = 3;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // FileMenuItem
            // 
            this.FileMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.LoadFileMenuItem,
            this.saveToFileToolStripMenuItem,
            this.exitToolStripMenuItem});
            this.FileMenuItem.Image = ((System.Drawing.Image)(resources.GetObject("FileMenuItem.Image")));
            this.FileMenuItem.Name = "FileMenuItem";
            this.FileMenuItem.ShowShortcutKeys = false;
            this.FileMenuItem.Size = new System.Drawing.Size(53, 20);
            this.FileMenuItem.Text = "File";
            this.FileMenuItem.TextImageRelation = System.Windows.Forms.TextImageRelation.TextBeforeImage;
            // 
            // LoadFileMenuItem
            // 
            this.LoadFileMenuItem.Name = "LoadFileMenuItem";
            this.LoadFileMenuItem.Size = new System.Drawing.Size(180, 22);
            this.LoadFileMenuItem.Text = "Load File";
            this.LoadFileMenuItem.Click += new System.EventHandler(this.LoadFileMenuItem_Click);
            // 
            // saveToFileToolStripMenuItem
            // 
            this.saveToFileToolStripMenuItem.Name = "saveToFileToolStripMenuItem";
            this.saveToFileToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.saveToFileToolStripMenuItem.Text = "Save to File";
            this.saveToFileToolStripMenuItem.Click += new System.EventHandler(this.saveToFileToolStripMenuItem_Click);
            // 
            // exitToolStripMenuItem
            // 
            this.exitToolStripMenuItem.Name = "exitToolStripMenuItem";
            this.exitToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.exitToolStripMenuItem.Text = "Exit";
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.label17);
            this.groupBox2.Controls.Add(this.AddNewCountryButton);
            this.groupBox2.Controls.Add(this.SaveCountryButton);
            this.groupBox2.Controls.Add(this.RemoveCountryButton);
            this.groupBox2.Controls.Add(this.groupBox3);
            this.groupBox2.Controls.Add(this.label10);
            this.groupBox2.Controls.Add(this.HDIRankingTextBox);
            this.groupBox2.Controls.Add(this.label9);
            this.groupBox2.Controls.Add(this.TradeBalanceTextBox);
            this.groupBox2.Controls.Add(this.label8);
            this.groupBox2.Controls.Add(this.InflationTextBox);
            this.groupBox2.Controls.Add(this.label7);
            this.groupBox2.Controls.Add(this.GDPGrowthTextBox);
            this.groupBox2.Controls.Add(this.label6);
            this.groupBox2.Controls.Add(this.CountryNameTextBox);
            this.groupBox2.Controls.Add(this.label5);
            this.groupBox2.Location = new System.Drawing.Point(274, 45);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(647, 490);
            this.groupBox2.TabIndex = 4;
            this.groupBox2.TabStop = false;
            // 
            // label17
            // 
            this.label17.AutoSize = true;
            this.label17.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label17.Location = new System.Drawing.Point(5, 398);
            this.label17.Name = "label17";
            this.label17.Size = new System.Drawing.Size(101, 13);
            this.label17.TabIndex = 15;
            this.label17.Text = "Country Options:";
            // 
            // AddNewCountryButton
            // 
            this.AddNewCountryButton.Location = new System.Drawing.Point(40, 446);
            this.AddNewCountryButton.Name = "AddNewCountryButton";
            this.AddNewCountryButton.Size = new System.Drawing.Size(154, 23);
            this.AddNewCountryButton.TabIndex = 14;
            this.AddNewCountryButton.Text = "Add new Country";
            this.AddNewCountryButton.UseVisualStyleBackColor = true;
            this.AddNewCountryButton.Click += new System.EventHandler(this.AddNewCountryButton_Click);
            // 
            // SaveCountryButton
            // 
            this.SaveCountryButton.Location = new System.Drawing.Point(131, 418);
            this.SaveCountryButton.Name = "SaveCountryButton";
            this.SaveCountryButton.Size = new System.Drawing.Size(105, 23);
            this.SaveCountryButton.TabIndex = 13;
            this.SaveCountryButton.Text = "Save";
            this.SaveCountryButton.UseVisualStyleBackColor = true;
            this.SaveCountryButton.Click += new System.EventHandler(this.SaveCountryButton_Click);
            // 
            // RemoveCountryButton
            // 
            this.RemoveCountryButton.Location = new System.Drawing.Point(5, 418);
            this.RemoveCountryButton.Name = "RemoveCountryButton";
            this.RemoveCountryButton.Size = new System.Drawing.Size(104, 23);
            this.RemoveCountryButton.TabIndex = 12;
            this.RemoveCountryButton.Text = "Remove";
            this.RemoveCountryButton.UseVisualStyleBackColor = true;
            this.RemoveCountryButton.Click += new System.EventHandler(this.RemoveCountryButton_Click);
            // 
            // groupBox3
            // 
            this.groupBox3.BackColor = System.Drawing.SystemColors.ControlLight;
            this.groupBox3.Controls.Add(this.AddTradePartnerButton);
            this.groupBox3.Controls.Add(this.GotoTradePartnerButton);
            this.groupBox3.Controls.Add(this.RemoveTradePartnerButton);
            this.groupBox3.Controls.Add(this.TradePartnersListBox);
            this.groupBox3.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.groupBox3.Location = new System.Drawing.Point(2, 265);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(234, 127);
            this.groupBox3.TabIndex = 11;
            this.groupBox3.TabStop = false;
            // 
            // AddTradePartnerButton
            // 
            this.AddTradePartnerButton.BackColor = System.Drawing.SystemColors.Control;
            this.AddTradePartnerButton.Location = new System.Drawing.Point(159, 94);
            this.AddTradePartnerButton.Name = "AddTradePartnerButton";
            this.AddTradePartnerButton.Size = new System.Drawing.Size(75, 23);
            this.AddTradePartnerButton.TabIndex = 3;
            this.AddTradePartnerButton.Text = "Add";
            this.AddTradePartnerButton.UseVisualStyleBackColor = false;
            this.AddTradePartnerButton.Click += new System.EventHandler(this.AddTradePartnerButton_Click);
            // 
            // GotoTradePartnerButton
            // 
            this.GotoTradePartnerButton.BackColor = System.Drawing.SystemColors.Control;
            this.GotoTradePartnerButton.Location = new System.Drawing.Point(79, 94);
            this.GotoTradePartnerButton.Name = "GotoTradePartnerButton";
            this.GotoTradePartnerButton.Size = new System.Drawing.Size(75, 23);
            this.GotoTradePartnerButton.TabIndex = 2;
            this.GotoTradePartnerButton.Text = "Goto";
            this.GotoTradePartnerButton.UseVisualStyleBackColor = false;
            this.GotoTradePartnerButton.Click += new System.EventHandler(this.GotoTradePartnerButton_Click);
            // 
            // RemoveTradePartnerButton
            // 
            this.RemoveTradePartnerButton.BackColor = System.Drawing.SystemColors.Control;
            this.RemoveTradePartnerButton.Location = new System.Drawing.Point(1, 94);
            this.RemoveTradePartnerButton.Name = "RemoveTradePartnerButton";
            this.RemoveTradePartnerButton.Size = new System.Drawing.Size(75, 23);
            this.RemoveTradePartnerButton.TabIndex = 1;
            this.RemoveTradePartnerButton.Text = "Remove";
            this.RemoveTradePartnerButton.UseVisualStyleBackColor = false;
            this.RemoveTradePartnerButton.Click += new System.EventHandler(this.RemoveTradePartnerButton_Click);
            // 
            // TradePartnersListBox
            // 
            this.TradePartnersListBox.FormattingEnabled = true;
            this.TradePartnersListBox.Location = new System.Drawing.Point(1, 2);
            this.TradePartnersListBox.Name = "TradePartnersListBox";
            this.TradePartnersListBox.Size = new System.Drawing.Size(233, 82);
            this.TradePartnersListBox.Sorted = true;
            this.TradePartnersListBox.TabIndex = 0;
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label10.Location = new System.Drawing.Point(0, 249);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(122, 13);
            this.label10.TabIndex = 10;
            this.label10.Text = "Main Trade Partners";
            // 
            // HDIRankingTextBox
            // 
            this.HDIRankingTextBox.Location = new System.Drawing.Point(3, 218);
            this.HDIRankingTextBox.Name = "HDIRankingTextBox";
            this.HDIRankingTextBox.Size = new System.Drawing.Size(233, 20);
            this.HDIRankingTextBox.TabIndex = 9;
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label9.Location = new System.Drawing.Point(0, 202);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(80, 13);
            this.label9.TabIndex = 8;
            this.label9.Text = "HDI Ranking";
            // 
            // TradeBalanceTextBox
            // 
            this.TradeBalanceTextBox.Location = new System.Drawing.Point(3, 174);
            this.TradeBalanceTextBox.Name = "TradeBalanceTextBox";
            this.TradeBalanceTextBox.Size = new System.Drawing.Size(233, 20);
            this.TradeBalanceTextBox.TabIndex = 7;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label8.Location = new System.Drawing.Point(-1, 158);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(90, 13);
            this.label8.TabIndex = 6;
            this.label8.Text = "Trade Balance";
            // 
            // InflationTextBox
            // 
            this.InflationTextBox.Location = new System.Drawing.Point(3, 130);
            this.InflationTextBox.Name = "InflationTextBox";
            this.InflationTextBox.Size = new System.Drawing.Size(233, 20);
            this.InflationTextBox.TabIndex = 5;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label7.Location = new System.Drawing.Point(0, 114);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(53, 13);
            this.label7.TabIndex = 4;
            this.label7.Text = "Inflation";
            // 
            // GDPGrowthTextBox
            // 
            this.GDPGrowthTextBox.Location = new System.Drawing.Point(3, 86);
            this.GDPGrowthTextBox.Name = "GDPGrowthTextBox";
            this.GDPGrowthTextBox.Size = new System.Drawing.Size(233, 20);
            this.GDPGrowthTextBox.TabIndex = 3;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label6.Location = new System.Drawing.Point(0, 70);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(77, 13);
            this.label6.TabIndex = 2;
            this.label6.Text = "GDP Growth";
            // 
            // CountryNameTextBox
            // 
            this.CountryNameTextBox.Enabled = false;
            this.CountryNameTextBox.Location = new System.Drawing.Point(3, 42);
            this.CountryNameTextBox.Name = "CountryNameTextBox";
            this.CountryNameTextBox.Size = new System.Drawing.Size(233, 20);
            this.CountryNameTextBox.TabIndex = 1;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.Location = new System.Drawing.Point(0, 26);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(86, 13);
            this.label5.TabIndex = 0;
            this.label5.Text = "Country Name";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.Location = new System.Drawing.Point(276, 36);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(84, 13);
            this.label4.TabIndex = 5;
            this.label4.Text = "Editable Data";
            // 
            // groupBox4
            // 
            this.groupBox4.Controls.Add(this.BiggestPotentialForTradeLabel);
            this.groupBox4.Controls.Add(this.UniqueCountriesLabel);
            this.groupBox4.Controls.Add(this.TreeHeightLabel);
            this.groupBox4.Controls.Add(this.label14);
            this.groupBox4.Controls.Add(this.label13);
            this.groupBox4.Controls.Add(this.label12);
            this.groupBox4.Location = new System.Drawing.Point(516, 45);
            this.groupBox4.Name = "groupBox4";
            this.groupBox4.Size = new System.Drawing.Size(405, 122);
            this.groupBox4.TabIndex = 6;
            this.groupBox4.TabStop = false;
            // 
            // BiggestPotentialForTradeLabel
            // 
            this.BiggestPotentialForTradeLabel.AutoSize = true;
            this.BiggestPotentialForTradeLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.BiggestPotentialForTradeLabel.Location = new System.Drawing.Point(6, 37);
            this.BiggestPotentialForTradeLabel.Name = "BiggestPotentialForTradeLabel";
            this.BiggestPotentialForTradeLabel.Size = new System.Drawing.Size(0, 13);
            this.BiggestPotentialForTradeLabel.TabIndex = 5;
            // 
            // UniqueCountriesLabel
            // 
            this.UniqueCountriesLabel.AutoSize = true;
            this.UniqueCountriesLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.UniqueCountriesLabel.Location = new System.Drawing.Point(111, 95);
            this.UniqueCountriesLabel.Name = "UniqueCountriesLabel";
            this.UniqueCountriesLabel.Size = new System.Drawing.Size(0, 13);
            this.UniqueCountriesLabel.TabIndex = 4;
            // 
            // TreeHeightLabel
            // 
            this.TreeHeightLabel.AutoSize = true;
            this.TreeHeightLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TreeHeightLabel.Location = new System.Drawing.Point(84, 65);
            this.TreeHeightLabel.Name = "TreeHeightLabel";
            this.TreeHeightLabel.Size = new System.Drawing.Size(0, 13);
            this.TreeHeightLabel.TabIndex = 3;
            // 
            // label14
            // 
            this.label14.AutoSize = true;
            this.label14.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label14.Location = new System.Drawing.Point(6, 95);
            this.label14.Name = "label14";
            this.label14.Size = new System.Drawing.Size(109, 13);
            this.label14.TabIndex = 2;
            this.label14.Text = "Number of Countries: ";
            // 
            // label13
            // 
            this.label13.AutoSize = true;
            this.label13.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label13.Location = new System.Drawing.Point(4, 64);
            this.label13.Name = "label13";
            this.label13.Size = new System.Drawing.Size(69, 13);
            this.label13.TabIndex = 1;
            this.label13.Text = "Tree Height: ";
            // 
            // label12
            // 
            this.label12.AutoSize = true;
            this.label12.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label12.Location = new System.Drawing.Point(5, 12);
            this.label12.Name = "label12";
            this.label12.Size = new System.Drawing.Size(138, 13);
            this.label12.TabIndex = 0;
            this.label12.Text = "Biggest Potential for Trade: ";
            // 
            // label11
            // 
            this.label11.AutoSize = true;
            this.label11.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label11.Location = new System.Drawing.Point(518, 37);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(100, 13);
            this.label11.TabIndex = 7;
            this.label11.Text = "Tree Information";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(949, 547);
            this.Controls.Add(this.label11);
            this.Controls.Add(this.groupBox4);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.countriesListBox);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "Form1";
            this.Text = "International Trading Data";
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.groupBox3.ResumeLayout(false);
            this.groupBox4.ResumeLayout(false);
            this.groupBox4.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ListBox countriesListBox;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.TextBox mainTradePartnersSearchBox;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox countrySearchBox;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem FileMenuItem;
        private System.Windows.Forms.ToolStripMenuItem LoadFileMenuItem;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.TextBox HDIRankingTextBox;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.TextBox TradeBalanceTextBox;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.TextBox InflationTextBox;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.TextBox GDPGrowthTextBox;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.TextBox CountryNameTextBox;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.Button GotoTradePartnerButton;
        private System.Windows.Forms.Button RemoveTradePartnerButton;
        private System.Windows.Forms.ListBox TradePartnersListBox;
        private System.Windows.Forms.Button AddTradePartnerButton;
        private System.Windows.Forms.Button AddNewCountryButton;
        private System.Windows.Forms.Button SaveCountryButton;
        private System.Windows.Forms.Button RemoveCountryButton;
        private System.Windows.Forms.GroupBox groupBox4;
        private System.Windows.Forms.Label label12;
        private System.Windows.Forms.Label label11;
        private System.Windows.Forms.Label label13;     
        private System.Windows.Forms.Label label14;
        private System.Windows.Forms.Label UniqueCountriesLabel;
        private System.Windows.Forms.Label TreeHeightLabel;
        private System.Windows.Forms.ToolStripMenuItem saveToFileToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem exitToolStripMenuItem;
        private System.Windows.Forms.Label BiggestPotentialForTradeLabel;
        private System.Windows.Forms.Label label15;
        private System.Windows.Forms.Label searchStatusLabel;
        private System.Windows.Forms.Label label16;
        private System.Windows.Forms.Button tradingPartnersSearchButton;
        private System.Windows.Forms.Label label17;
        private System.Windows.Forms.Button refreshListBoxButton;
    }
}

