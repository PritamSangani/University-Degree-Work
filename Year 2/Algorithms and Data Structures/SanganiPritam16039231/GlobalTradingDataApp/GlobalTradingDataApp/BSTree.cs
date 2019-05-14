using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GlobalTradingDataApp
{
    public class BSTree<T> : BinTree<T> where T : IComparable
    {
        public BSTree() => root = null;

        public void InsertItem(T item) => insertItem(item, ref root);

        private void insertItem(T item, ref Node<T> tree)
        {
            if (tree == null)
                tree = new Node<T>(item);
            else if (item.CompareTo(tree.Data) < 0)
                insertItem(item, ref tree.Left);
            else if (item.CompareTo(tree.Data) > 0)
                insertItem(item, ref tree.Right);
        }

        public int Height => height(root);

        protected int height(Node<T> tree)
        {
            if (tree == null)
                return 0;
            else
                return 1 + max(height(tree.Left), height(tree.Right));
        }
        

        private int max(int x, int y)
        {
            if (x.CompareTo(y) >= 0)
                return x;
            else
                return y;
        }

        public int Count => count(root);

        private int count(Node<T> tree)
        {
            //return number of nodes in the tree
            if (tree == null)
                return 0;
            else
                return 1 + count(tree.Left) + count(tree.Right);
        }

        public Boolean Contains(T item) => contains(item, root);

        private Boolean contains(T item, Node<T> tree)
        {
            if (tree == null)        
                return false;          
            else
            {
                if (item.CompareTo(tree.Data) == 0)
                    return true;
                else if (item.CompareTo(tree.Data) > 0)
                    return contains(item, tree.Right);
                else if (item.CompareTo(tree.Data) < 0)
                    return contains(item, tree.Left);
                else
                    return false;
            }
        }

        public Boolean Contains(string item) => contains(item, root);

        private Boolean contains(string item, Node<T> tree)
        {
            if (tree == null)
                return false;
            else
            {
                if (item.CompareTo(tree.Data.ToString()) == 0)
                    return true;
                else if (item.CompareTo(tree.Data.ToString()) > 0)
                    return contains(item, tree.Right);
                else if (item.CompareTo(tree.Data.ToString()) < 0)
                    return contains(item, tree.Left);
                else
                    return false;
            }
        }

        public T GetItem(string item) => getItem(item, root);

        private T getItem(string item, Node<T> tree)
        {
            if (tree == null)
                return default(T);
            else
            {
                if (item.CompareTo(tree.Data.ToString()) == 0)
                    return tree.Data;
                else if (item.CompareTo(tree.Data.ToString()) > 0)
                    return getItem(item, tree.Right);
                else if (item.CompareTo(tree.Data.ToString()) < 0)
                    return getItem(item, tree.Left);
                else
                    return default(T);
            }
        }

        public void Search(string item, ref List<T> retrievedItems) => search(item, ref retrievedItems, root);

        private void search(string item, ref List<T> retrievedItems, Node<T> tree)
        {           
            if (tree == null)
                return;
            else
            {
                if (tree.Data.ToString().ToLower().StartsWith(item.ToLower()))
                {
                    retrievedItems.Add(tree.Data);
                    search(item, ref retrievedItems, tree.Left);
                    search(item, ref retrievedItems, tree.Right);
                }
                else if (item.ToLower().CompareTo(tree.Data.ToString().ToLower()) > 0)
                    search(item, ref retrievedItems, tree.Right);
                else if (item.ToLower().CompareTo(tree.Data.ToString().ToLower()) < 0)
                    search(item, ref retrievedItems, tree.Left);
                else
                    return;
            }
        }

        public void RemoveItem(T item) => removeItem(item, ref root);

        private void removeItem(T item, ref Node<T> tree)
        {
            if (tree == null)
                return;
            else if (item.CompareTo(tree.Data) < 0)
                removeItem(item, ref tree.Left);
            else if (item.CompareTo(tree.Data) > 0)
                removeItem(item, ref tree.Right);
            else
            {
                if (tree.Left == null)
                    tree = tree.Right;
                else if (tree.Right == null)
                    tree = tree.Left;
                else
                {
                    T newRoot = LeastItem(tree.Right);
                    tree.Data = newRoot;
                    removeItem(newRoot, ref tree.Right);
                }
            }
        }

        protected T LeastItem(Node<T> tree)
        {
            if (tree.Left == null)            
                return tree.Data;            
            else            
                return LeastItem(tree.Left);            
        }               
    }
}