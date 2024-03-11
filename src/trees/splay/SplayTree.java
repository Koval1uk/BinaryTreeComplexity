package trees.splay;

import interfaces.ITreeBase;


public class SplayTree<T> implements ITreeBase<T, SplayTreeNode<T>>
{
    private SplayTreeNode<T> root;
    

    public SplayTree()
    {
        root = null;
    }

    public SplayTreeNode<T> getRoot()
    {
        return root;
    }

    private void leftRotate(SplayTreeNode<T> node)
    {
        SplayTreeNode<T> right = node.getRight();
        SplayTreeNode<T> parent = node.getParent();
        
        if (right == null)
            return;
        
        node.setRight(right.getLeft());
        right.setLeft(node);
        
        if (parent != null)
        {
            if (node == parent.getLeft())
                parent.setLeft(right);
            else
                parent.setRight(right);
        }
        else
        {
            root = right;
            root.setParent(null);
        }
    }

    private void rightRotate(SplayTreeNode<T> node)
    {
        SplayTreeNode<T> left = node.getLeft();
        SplayTreeNode<T> parent = node.getParent();
        
        if (left == null)
            return;
        
        node.setLeft(left.getRight());
        left.setRight(node);
        
        if (parent != null)
        {
            if (node == parent.getLeft())
                parent.setLeft(left);
            else
                parent.setRight(left);
        }
        else
        {
            root = left;
            root.setParent(null);
        }
    }

    public void splay(SplayTreeNode<T> node)
    {
        if (node == null)
            return;
        
        while (node.getParent() != null)
        {
            SplayTreeNode<T> parent = node.getParent();
            SplayTreeNode<T> grandParent = parent.getParent();
            
            if (grandParent == null)
            {
                if (node == parent.getLeft())
                    rightRotate(parent);
                else
                    leftRotate(parent);
            }
            else if (node == parent.getLeft() && parent == grandParent.getLeft())
            {
                rightRotate(grandParent);
                rightRotate(parent);
            }
            else if (node == parent.getRight() && parent == grandParent.getRight())
            {
                leftRotate(grandParent);
                leftRotate(parent);
            }
            else if (node == parent.getRight() && parent == grandParent.getLeft())
            {
                leftRotate(parent);
                rightRotate(grandParent);
            }
            else
            {
                rightRotate(parent);
                leftRotate(grandParent);
            }
        }
    }

    @Override
    public SplayTreeNode<T> insert(SplayTreeNode<T> _root, int key, T value)
    {
        SplayTreeNode<T> newNode = new SplayTreeNode<T>(key, value);

        if (root == null)
        {
            root = newNode;
            return null;
        }
        
        root.insert(newNode);
        splay(newNode);
        return null;
    }

    @Override
    public SplayTreeNode<T> delete(SplayTreeNode<T> _root, int key) {
        SplayTreeNode<T> node = root.find(key);
        splay(node);
        
        if (node.getLeft() == null)
        {
            root = node.getRight();
            if (root != null)
                root.setParent(null);
        }
        else
        {
            SplayTreeNode<T> max = node.getLeft().findMax();
            splay(max);
            max.setRight(node.getRight());
            root = max;
            if (root != null)
                root.setParent(null);
        }
        return null;
    }

    @Override
    public T search(SplayTreeNode<T> _root, int key)
    {
        SplayTreeNode<T> node = root.find(key);
        splay(node);

        return node.getValue();
    }

    @Override
    public String toString() {
        return root+"";
    }
}
