using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GlobalTradingDataApp
{
    [TestFixture]
    class AVLTest
    {
        [TestCase]
        public void InsertItem()
        {
            AVLTree<int> tree = new AVLTree<int>();

            tree.InsertItem(1);
            tree.InsertItem(2);
            tree.InsertItem(3);
            tree.InsertItem(4);
            tree.InsertItem(5);
            tree.InsertItem(6);

            Assert.AreEqual(6, tree.Count);
            Assert.AreEqual(3, tree.Height);            
        }

        [TestCase]
        public void RemoveItem()
        {
            AVLTree<int> tree = new AVLTree<int>();

            tree.InsertItem(1);
            tree.InsertItem(2);
            tree.InsertItem(3);
            tree.InsertItem(4);
            tree.InsertItem(5);
            tree.InsertItem(6);

            tree.RemoveItem(4);

            Assert.AreEqual(false, tree.Contains(4));
            Assert.AreEqual(5, tree.Count);
            Assert.AreEqual(3, tree.Height);
        }

        [TestCase]
        public void Contains()
        {
            AVLTree<int> tree = new AVLTree<int>();

            tree.InsertItem(1);
            tree.InsertItem(2);
            tree.InsertItem(3);
            tree.InsertItem(4);
            tree.InsertItem(5);
            tree.InsertItem(6);

            Assert.AreEqual(true, tree.Contains(2));
            Assert.AreEqual(true, tree.Contains(6));
            Assert.AreEqual(false, tree.Contains(7));        
        }

        [TestCase]
        public void GetItem()
        {
            AVLTree<int> tree = new AVLTree<int>();

            tree.InsertItem(1);
            tree.InsertItem(2);
            tree.InsertItem(3);
            tree.InsertItem(4);
            tree.InsertItem(5);
            tree.InsertItem(6);

            Assert.AreEqual(1, tree.GetItem("1"));
        }
    }
}
