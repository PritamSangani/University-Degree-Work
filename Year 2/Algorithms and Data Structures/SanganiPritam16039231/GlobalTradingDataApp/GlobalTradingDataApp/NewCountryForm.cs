using LinkListGen;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace GlobalTradingDataApp
{
    public partial class NewCountryForm : Form
    {
        AVLTree<Country> countries;
        LinkListGen<string> TradePartners = new LinkListGen<string>();

        public NewCountryForm(AVLTree<Country> countries)
        {
            InitializeComponent();
            this.countries = countries;          
        }

        private void AddTradePartnerButton_Click(object sender, EventArgs e)
        {
            AddTradingPartnerForm addTradingPartnerForm = new AddTradingPartnerForm(countries, TradePartners);

            addTradingPartnerForm.ShowDialog();

            TradePartnersListBox.Items.Clear();
            foreach (string tp in TradePartners)
                TradePartnersListBox.Items.Add(tp);
        }

        private void addNewCountryButton_Click(object sender, EventArgs e)
        {
            string CountryName = CountryNameTextBox.Text;
            string GDPGrowth = GDPGrowthTextBox.Text;
            string Inflation = InflationTextBox.Text;
            string TradeBalance = TradeBalanceTextBox.Text;
            string HDIRanking = HDIRankingTextBox.Text;           

            foreach (string tp in TradePartnersListBox.Items)
                TradePartners.InsertInOrder(tp);

            //if(CountryName == "" || GDPGrowth = "" || Inflation = "" || TR)
            Country newCountry = new Country(CountryName,GDPGrowth,Inflation,TradeBalance,HDIRanking,TradePartners);

            countries.InsertItem(newCountry);

            this.Close();
        }
    }
}
