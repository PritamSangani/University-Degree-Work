using LinkListGen;
using System.Collections.Generic;
using System;
using System.Drawing;
using System.IO;
using System.Windows.Forms;
using System.Text;

namespace GlobalTradingDataApp
{
    public partial class Form1 : Form
    {        
        AVLTree<Country> countries = new AVLTree<Country>();

        public Form1()
        {
            InitializeComponent();
            Icon icon = Icon.ExtractAssociatedIcon("globe.ico");
            this.Icon = icon;
        }
        //event called when load button under file menu is clicked
        private void LoadFileMenuItem_Click(object sender, EventArgs e) => InsertIntoListBox();

        //method to load data in AVL Tree into the countriesListBox
        public void InsertIntoListBox()
        {                                                           
            if (countries.Count == 0)
                countries = FileIntoDataStructure();

            populateCountriesListBox();
            refreshTreeStats();
                        
        }

        //method to load a file into an AVL Tree
        public AVLTree<Country> FileIntoDataStructure()
        {
            string[] headers = new string[6]; //column headers
            const int MAX_LINES_FILE = 50000;
            string[] AllLines = new string[MAX_LINES_FILE];            

            // Create an OpenFileDialog to request a file to open.
            OpenFileDialog openFile1 = new OpenFileDialog();

            // Determine whether the user selected a file from the OpenFileDialog.
            if (openFile1.ShowDialog() == System.Windows.Forms.DialogResult.OK && openFile1.FileName.Length > 0)
            {
                Console.WriteLine("Hello");
                AllLines = File.ReadAllLines(openFile1.FileName);
                foreach (string line in AllLines)
                {
                    Country temp;
                    String country = "", GDPGrowth = "", inflation = "", TradeBalance = "", HDI = "";
                    LinkListGen<string> tradePartners = new LinkListGen<string>();

                    if (line.StartsWith("Country")) //found first line - headers               
                        headers = line.Split(',');
                    else
                    {
                        //split data using commas
                        string[] columns = line.Split(',');
                        country = columns[0];
                        GDPGrowth = columns[1];
                        inflation = columns[2];
                        TradeBalance = columns[3];
                        HDI = columns[4];
                        country = country.Replace("_", " ");

                        string[] partners;
                        partners = columns[5].Split(';', '[', ']');

                        foreach (string tradePartner in partners)
                            if (tradePartner != "")
                                tradePartners.InsertInOrder(tradePartner.Replace("_", " "));                       

                        temp = new Country(country, GDPGrowth, inflation, TradeBalance, HDI, tradePartners);
                        countries.InsertItem(temp);
                    }
                }
            }
            return countries;
        }

        private void populateCountriesListBox()
        {
            foreach (Country c in countries)
                countriesListBox.Items.Add(c);
        }

        private void refreshTreeStats()
        {
            TreeHeightLabel.Text = countries.Height.ToString();
            UniqueCountriesLabel.Text = countries.Count.ToString();
            BiggestPotentialForTradeLabel.Text = BiggestPotentialForTrade();
        }

        /*
         * method that defines what happens when another country is selected from the listbox.
         */
        private void countriesListBox_SelectedIndexChanged(object sender, EventArgs e)
        {                      
            //clear the items from the list box so if a new country is selected the new trade partners are not 
            //added to the trade partners of the previously selected country
            TradePartnersListBox.Items.Clear();
            // Get the currently selected item in the Countries ListBox.
            Country selectedCountry = (Country)countriesListBox.SelectedItem;

            if (selectedCountry != null)
            {
                //fill in text boxes with relevant data from selected country in the countriesListBox
                CountryNameTextBox.Text = selectedCountry.CountryName;
                GDPGrowthTextBox.Text = selectedCountry.GDPGrowth;
                InflationTextBox.Text = selectedCountry.Inflation;
                TradeBalanceTextBox.Text = selectedCountry.TradeBalance;
                HDIRankingTextBox.Text = selectedCountry.HDI;

                foreach (string tradePartner in selectedCountry.TradingPartners)
                    TradePartnersListBox.Items.Add(tradePartner);
            }
        }

        /*
         * Method that defines what happens when the SaveCountry button is pressed 
         */        
        private void SaveCountryButton_Click(object sender, EventArgs e)
        {
            Country selectedCountry = (Country)countriesListBox.SelectedItem;                       
            if (selectedCountry != null)
            {
                selectedCountry.CountryName = CountryNameTextBox.Text;
                selectedCountry.GDPGrowth = GDPGrowthTextBox.Text;
                selectedCountry.Inflation = InflationTextBox.Text;
                selectedCountry.TradeBalance = TradeBalanceTextBox.Text;
                selectedCountry.HDI = HDIRankingTextBox.Text;

                refreshTreeStats();
            }                           
        }            

        /*
         * Method that allows a Country to be removed from both the AVL Tree and the ListBox
         */ 
        private void RemoveCountryButton_Click(object sender, EventArgs e)
        {
            Country selectedCountry = (Country)countriesListBox.SelectedItem;
            int index = countriesListBox.SelectedIndex;   
            if(selectedCountry != null)
            {
                countries.RemoveItem(selectedCountry);
                countriesListBox.Items.RemoveAt(index);

                if (index < countriesListBox.Items.Count)
                    countriesListBox.SelectedIndex = index;
                else if (index == countriesListBox.Items.Count)
                    countriesListBox.SelectedIndex = (index - 1);

                refreshTreeStats();
            }                                                                 
        }

        private void AddNewCountryButton_Click(object sender, EventArgs e)
        {
            NewCountryForm newCountryForm = new NewCountryForm(countries);

            newCountryForm.ShowDialog();

            populateCountriesListBox();
            refreshTreeStats();
        }

        /*
         * Method that enables the user to go to the details of a selected Trade Partner Country
         */
        private void GotoTradePartnerButton_Click(object sender, EventArgs e)
        {
            String selectedTradePartner = (String)TradePartnersListBox.SelectedItem;

            foreach (Country c in countriesListBox.Items)
            {
                String country = countriesListBox.GetItemText(c);

                if (country.Equals(selectedTradePartner))
                {
                    countriesListBox.SelectedItem = c;
                    break;
                }
            }
        }

        private void RemoveTradePartnerButton_Click(object sender, EventArgs e)
        {
            String selectedTradePartner = (String)TradePartnersListBox.SelectedItem;
            Country selectedCountry = (Country)countriesListBox.SelectedItem;

            if (selectedCountry != null && selectedTradePartner != null)
            {
                selectedCountry.TradingPartners.RemoveItem(selectedTradePartner);
                countriesListBox.SelectedItems.Clear();
                countriesListBox.SelectedItem = selectedCountry;

                refreshTreeStats();
            }            
        }     

        private void AddTradePartnerButton_Click(object sender, EventArgs e)
        {
            Country selectedCountry = (Country)countriesListBox.SelectedItem;

            AddTradingPartnerForm addTradingPartnerForm = new AddTradingPartnerForm(selectedCountry, countries);
            addTradingPartnerForm.ShowDialog();

            countriesListBox.SelectedItems.Clear();
            countriesListBox.SelectedItem = selectedCountry;

            refreshTreeStats();
        }

        /*
         * Finding Country with Biggest Potential For Trade
         * BPFT calculated by summing GDP Growth Attribute for each of its Trading Partner Countries
         */ 

        private string BiggestPotentialForTrade()
        {
            string bpftCountry = "";
            double bpftValue = -999;

            foreach(Country c in countries)
            {
                double summedGDPGrowth = 0.0;
                foreach(string tp in c.TradingPartners)
                {
                    Country tradePartner;
                    if (countries.Contains(tp))
                    {
                        tradePartner = countries.GetItem(tp);
                        summedGDPGrowth += Convert.ToDouble(tradePartner.GDPGrowth);
                    }
                }

                if(summedGDPGrowth > bpftValue)
                {
                    bpftValue = summedGDPGrowth;
                    bpftCountry = c.CountryName;
                }
                else if(summedGDPGrowth == bpftValue)
                {
                    bpftValue = summedGDPGrowth;
                    bpftCountry += ", " + c.CountryName;
                }
            }

            return bpftCountry + ": " + bpftValue;
        }        

        /*
         * Search for a country in the TextBox 
         */
        private void countrySearchBox_TextChanged(object sender, EventArgs e)
        {
            FindCountry(countrySearchBox.Text);
        }

        private void FindCountry(string searchString)
        {
            countriesListBox.Items.Clear();
            if (searchString != "")
            {
                List<Country> returnedCountries = new List<Country>();

                countries.Search(searchString, ref returnedCountries);

                foreach (Country c in returnedCountries)
                    countriesListBox.Items.Add(c);
            }
            else
                populateCountriesListBox();
                               
        }        

        private void tradingPartnersSearchButton_Click(object sender, EventArgs e)
        {
            string country = mainTradePartnersSearchBox.Text;

            if(country != "")
            {
                if(countries.Contains(country))
                {
                    countriesListBox.Items.Clear();

                    Country c = countries.GetItem(country);
                    List<Country> tradingPartners = new List<Country>();
                    foreach(string tp in c.TradingPartners)                    
                        tradingPartners.Add(countries.GetItem(tp));                    

                    foreach(Country tp in tradingPartners)                    
                        countriesListBox.Items.Add(tp);                    

                    searchStatusLabel.Text = "Displaying Trade Partners of " + c.CountryName;
                    
                }
            }
        }

        private void mainTradePartnersSearchBox_TextChanged(object sender, EventArgs e)
        {
            if(mainTradePartnersSearchBox.Text == "")
            {
                countriesListBox.Items.Clear();
                foreach (Country c in countries)
                    countriesListBox.Items.Add(c);
            }
        }

        private void refreshListBoxButton_Click(object sender, EventArgs e)
        {
            countriesListBox.Items.Clear();
            mainTradePartnersSearchBox.Clear();
            if(countries.Count!=0)            
                populateCountriesListBox();                                     
        }

        private void saveToFileToolStripMenuItem_Click(object sender, EventArgs e)
        {
            string[] headers = new string[6]; //column headers
            const int MAX_LINES_FILE = 50000;
            string[] AllLines = new string[MAX_LINES_FILE];
            
            SaveFileDialog saveFile = new SaveFileDialog();

            if (saveFile.ShowDialog() == System.Windows.Forms.DialogResult.OK && saveFile.FileName.Length > 0)
            {
                StringBuilder csv = new StringBuilder();

                csv.AppendLine("Country,GDP growth,Inflation,Trade Balance,HDI Ranking,Trade Partners");
                foreach(Country c in countries)
                {
                    string CountryName = c.CountryName;
                    string GDPGrowth = c.GDPGrowth;
                    string Inflation = c.Inflation;
                    string TradeBalance = c.TradeBalance;
                    string HDIRanking = c.HDI;
                    string TradePartners = "[";

                    foreach(string tp in c.TradingPartners)                    
                        TradePartners += tp + ";";

                    TradePartners = TradePartners.Remove(TradePartners.Length - 1);
                    TradePartners += "]";

                    string line = String.Format("{0},{1},{2},{3},{4},{5}", CountryName,GDPGrowth,Inflation,TradeBalance,HDIRanking,TradePartners);

                    csv.AppendLine(line);
                }

                File.WriteAllText(saveFile.FileName, csv.ToString());
            }
        }

        /*
         * Method that allows user to exit the application when pressing the exit button in the menu bar
         */
        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        
    }
}
