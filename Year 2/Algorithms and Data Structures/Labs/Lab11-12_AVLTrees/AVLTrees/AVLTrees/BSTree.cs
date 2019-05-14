using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AVLTrees
{
    class BSTree<T> : BinTree<T> where T : IComparable
    {
        public BSTree()
        {
            root = null;
        }

        public void InsertItem(T item)
        {
            insertItem(item, ref root);
        }

        private void insertItem(T item, ref Node<T> tree)
        {
            if (tree == null)
                tree = new Node<T>(item);
            else if (item.CompareTo(tree.Data) < 0)
                insertItem(item, ref tree.Left);
            else if (item.CompareTo(tree.Data) > 0)
                insertItem(item, ref tree.Right);
        }
        //PORTFOLIO - WEEK 9>>>> 
        public int Height()
        {
            return height(root);
        }

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

        public int Count()
        {
            return count(root);
        }

        private int count(Node<T> tree)
        {
            //return number of nodes in the tree
            if (tree == null)
                return 0;
            else
                return 1 + count(tree.Left) + count(tree.Right);
        }

        public Boolean Contains(T item)
        {
            //Return true if item is in BSTree otherwise false.
            return contains(item, root);
        }

        private Boolean contains(T item, Node<T> tree)
        {
            if (tree == null)
            {
                return false;
            }
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

        //PORTFOLIO - WEEK 10>>>>
        public void RemoveItem(T item)
        {
            removeItem(item, ref root);
        }

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
                    T newRoot = leastItem(tree.Right);
                    tree.Data = newRoot;
                    removeItem(newRoot, ref tree.Right);
                }
            }
        }

        protected T leastItem(Node<T> tree)
        {
            if (tree.Left == null)
            {
                return tree.Data;
            }
            else
            {
                return leastItem(tree.Left);
            }
        }
    }
}
