using LinkListGen;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GlobalTradingDataApp
{
    [TestFixture]
    class LinkListGenTest
    {
        [TestCase]
        public void AddItem()
        {
            LinkListGen<int> linkList = new LinkListGen<int>();

            linkList.AddItem(1);
            linkList.AddItem(2);
            linkList.AddItem(3);
            linkList.AddItem(4);
            linkList.AddItem(5);
            linkList.AddItem(6);

            Assert.AreEqual(6, linkList.NumberOfItems());
        }


    }
}
