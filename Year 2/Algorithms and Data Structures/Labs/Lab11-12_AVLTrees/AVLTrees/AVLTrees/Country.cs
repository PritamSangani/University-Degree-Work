using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AVLTrees
{
    class Country : IComparable
    {
        private String countryName, gdpGrowth, inflation, tradeBalance, hdi;
        private LinkedList<String> tradingPartners;

        public Country(String country, String gdpGrowth, String inflation, String tradeBalance, String hdi, LinkedList<String> tradingPartners)
        {
            this.CountryName = country;
            this.GDPGrowth = GDPGrowth;
            this.Inflation = inflation;
            this.TradeBalance = tradeBalance;
            this.HDI = hdi;
            this.TradingPartners = tradingPartners;
        }

        //PROPERTIES
        public string CountryName { get => countryName; set => countryName = value; }
        public string GDPGrowth { get => gdpGrowth; set => gdpGrowth = value; }
        public string Inflation { get => inflation; set => inflation = value; }
        public string TradeBalance { get => tradeBalance; set => tradeBalance = value; }
        public string HDI { get => hdi; set => hdi = value; }
        public LinkedList<string> TradingPartners { get => tradingPartners; set => tradingPartners = value; }

        public override string ToString() => CountryName;

        //int IComparable.CompareTo(Country other) => this.CountryName.CompareTo(other.CountryName);

        public int CompareTo(object other)
        {
            Country temp = (Country)other;
            return CountryName.CompareTo(temp.CountryName);
        }



    }
}
