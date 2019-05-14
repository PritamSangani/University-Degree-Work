using System;
using System.Collections;
using System.Collections.Generic;

namespace GlobalTradingDataApp
{
    public class AVLTree<T> : BSTree<T>, IEnumerable where T : IComparable
    {
        public AVLTree() => root = null;

        public new void InsertItem(T item) => insertItem(item, ref root);

        private void insertItem(T item, ref Node<T> tree)
        {
            if (tree == null)
                tree = new Node<T>(item);
            else if (item.CompareTo(tree.Data) < 0)
                insertItem(item, ref tree.Left);
            else if (item.CompareTo(tree.Data) > 0)
                insertItem(item, ref tree.Right);

            //BALANCING TREE AFTER INSERTION
            tree.BalanceFactor = height(tree.Left) - height(tree.Right);

            if (tree.BalanceFactor <= -2)
                rotateLeft(ref tree);
            else if (tree.BalanceFactor >= 2)
                rotateRight(ref tree);
        }

        public new void RemoveItem(T item) => removeItem(item, ref root);

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
            if (tree != null)
            {
                //BALANCING TREE AFTER DELETION
                tree.BalanceFactor = height(tree.Left) - height(tree.Right);

                if (tree.BalanceFactor <= -2)
                    rotateLeft(ref tree);
                else if (tree.BalanceFactor >= 2)
                    rotateRight(ref tree);
            }

        }

        private void rotateLeft(ref Node<T> tree)
        {
            //double rotate
            if (tree.Right.BalanceFactor > 0)
                rotateRight(ref tree.Right);

            Node<T> oldRoot, newRoot;

            //old root = top of tree
            oldRoot = tree;
            //new root is the right sub tree of the old root
            newRoot = oldRoot.Right;
            //left sub tree of the new root becomes right sub tree of the old root
            oldRoot.Right = newRoot.Left;
            //old root moves into the left sub tree of the new root.
            newRoot.Left = oldRoot;
            //new root becomes top of tree
            tree = newRoot;
        }

        private void rotateRight(ref Node<T> tree)
        {
            //double rotate
            if (tree.Left.BalanceFactor < 0)
                rotateLeft(ref tree.Left);

            Node<T> oldRoot, newRoot;

            //old root = top of tree
            oldRoot = tree;
            //new root is the left sub tree of the old root
            newRoot = oldRoot.Left;
            //right sub tree of the new root becomes left sub tree of the old root
            oldRoot.Left = newRoot.Right;
            //old root moves into the right sub tree of the new root.
            newRoot.Right = oldRoot;
            //new root becomes top of tree
            tree = newRoot;
        }

        public IEnumerator<T> GetEnumerator()
        {            
            Stack<Node<T>> stack = new Stack<Node<T>>();
            Node<T> tmp = root;

            while (tmp != null || stack.Count > 0)
            {
                while (tmp != null)
                {
                    stack.Push(tmp);
                    tmp = tmp.Left;
                }
                tmp = stack.Pop();
                yield return tmp.Data;
                tmp = tmp.Right;
            }
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return GetEnumerator();
        }
    }
}
