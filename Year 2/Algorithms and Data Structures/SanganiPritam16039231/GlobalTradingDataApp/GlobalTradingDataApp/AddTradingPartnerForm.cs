using LinkListGen;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Windows.Forms;

namespace GlobalTradingDataApp
{
    public partial class AddTradingPartnerForm : Form
    {
        public AVLTree<Country> countries;
        public Country Country;

        public LinkListGen<string> tradePartners;
        
        public AddTradingPartnerForm(Country Country, AVLTree<Country> countries)
        {
            InitializeComponent();
            this.Country = Country;
            this.countries = countries;           
        }

        public AddTradingPartnerForm(AVLTree<Country> countries, LinkListGen<string> tradePartners)
        {
            InitializeComponent();
            this.countries = countries;
            this.tradePartners = tradePartners;
        }

        private void AddTradingPartnerForm_Load(object sender, EventArgs e)
        {    
            if(Country != null)
            {
                countryLabel.Text = Country.CountryName;
                if (countriesDropDownList.SelectedItem.ToString() == countryLabel.Text)
                    addTradingPartnerButton.Enabled = false;
            }
            

            foreach (Country c in countries)
                countriesDropDownList.Items.Add(c);
                
            countriesDropDownList.DropDownStyle = ComboBoxStyle.DropDownList;

            countriesDropDownList.SelectedIndex = 0;
            this.countriesDropDownList.SelectedIndexChanged +=
                new System.EventHandler(countriesDropDownList_SelectedIndexChanged);

        }

        private void countriesDropDownList_SelectedIndexChanged(object sender, EventArgs e)
        {           
            if (countriesDropDownList.SelectedItem.ToString() == countryLabel.Text)            
                addTradingPartnerButton.Enabled = false;          
            else            
                addTradingPartnerButton.Enabled = true;

            if(Country != null)
            {
                foreach (string tp in Country.TradingPartners)
                {
                    if (countriesDropDownList.SelectedItem.ToString() == tp)
                        addTradingPartnerButton.Enabled = false;
                }
            }
            else
            {
                foreach (string tp in tradePartners)
                {
                    if (countriesDropDownList.SelectedItem.ToString() == tp)
                        addTradingPartnerButton.Enabled = false;
                }
            }
                        
        }

        private void addTradingPartnerButton_Click(object sender, EventArgs e)
        {            
            string selectedNewTradePartner;
            selectedNewTradePartner = countriesDropDownList.SelectedItem.ToString();
            if (Country != null)
                Country.TradingPartners.InsertInOrder(selectedNewTradePartner);
            else
                tradePartners.InsertInOrder(selectedNewTradePartner);
            
            this.Close();
        }
    }
}
