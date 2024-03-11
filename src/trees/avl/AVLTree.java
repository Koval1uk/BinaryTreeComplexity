package trees.avl;

import interfaces.ITreeBase;

public class AVLTree<T> implements ITreeBase<T, AVLTreeNode<T>>
{

    private AVLTreeNode<T> root;

    public AVLTree() { root = null; }

    @Override
    public AVLTreeNode<T> insert(AVLTreeNode<T> root, int key, T value)
    {
        if(root == null)
            return new AVLTreeNode<T>(key, value);

        else if(key < root.getKey())
            root.setLeft(insert(root.getLeft(), key, value));

        else if(key > root.getKey())
            root.setRight(insert(root.getRight(), key, value));

        else
            return root;

        root.setHeight(Math.max(height(root.getLeft()), height(root.getRight())) + 1);

        int balance = getBalance(root);

        if(balance > 1 && key < root.getLeft().getKey())
            return rightRotate(root);

        else if(balance < -1 && key > root.getRight().getKey())
            return leftRotate(root);

        else if(balance > 1 && key > root.getLeft().getKey())
        {
            root.setLeft(leftRotate(root.getLeft()));
            return rightRotate(root);
        }

        else if(balance < -1 && key < root.getRight().getKey())
        {
            root.setRight(rightRotate(root.getRight()));
            return leftRotate(root);
        }
        return root;
    }

    @Override
    public AVLTreeNode<T> delete(AVLTreeNode<T> root, int key)
    {
        if (root == null)
            return null;

        if (key < root.getKey())
            root.setLeft(delete(root.getLeft(), key));

        else if (key > root.getKey())
            root.setRight(delete(root.getRight(), key));

        else
        {
            AVLTreeNode<T> temp;

            if (root.getLeft() == null || root.getRight() == null)
            {
                temp = root.getLeft() == null ? root.getRight() : root.getLeft();
                root = temp;
            }
            else
            {
                temp = findMinimum(root.getRight());

                root.setKey(temp.getKey());
                root.setValue(temp.getValue());
                root.setRight(delete(root.getRight(), temp.getKey()));
            }
        }
        if(root == null)
            return null;

        root.setHeight(Math.max(height(root.getLeft()), height(root.getRight())) + 1);

        int balance = getBalance(root);

        if(balance > 1)
        {
            if(key > root.getLeft().getKey())
                root.setLeft(leftRotate(root.getLeft()));

            return rightRotate(root);
        }
        else if(balance < -1)
        {
            if(key < root.getRight().getKey())
                root.setRight(rightRotate(root.getRight()));

            return leftRotate(root);
        }
        return root;
    }

    @Override
    public T search(AVLTreeNode<T> root, int key)
    {
        if(root == null)
            return null;

        if(key < root.getKey())
            return search(root.getLeft(), key);

        else if(key > root.getKey())
            return search(root.getRight(), key);

        else
            return root.getValue();
    }

    //Preorder
    public void printPreorder(AVLTreeNode<T> root)
    {
        if(root != null)
        {
            System.out.println(root.getKey() + " " + root.getValue());
            printPreorder(root.getLeft());
            printPreorder(root.getRight());
        }
    }

    private AVLTreeNode<T> rightRotate(AVLTreeNode<T> avlTreeNode)
    {
        AVLTreeNode<T> left = avlTreeNode.getLeft();
        AVLTreeNode<T> right = left.getRight();

        left.setRight(avlTreeNode);
        avlTreeNode.setLeft(right);

        avlTreeNode.setHeight(Math.max(height(avlTreeNode.getLeft()), height(avlTreeNode.getRight())) + 1);
        left.setHeight(Math.max(height(left.getLeft()), height(left.getRight())) + 1);

        return left;
    }

    private AVLTreeNode<T> leftRotate(AVLTreeNode<T> avlTreeNode)
    {
        AVLTreeNode<T> right = avlTreeNode.getRight();
        AVLTreeNode<T> left = right.getLeft();

        right.setLeft(avlTreeNode);
        avlTreeNode.setRight(left);

        avlTreeNode.setHeight(Math.max(height(avlTreeNode.getLeft()), height(avlTreeNode.getRight())) + 1);
        right.setHeight(Math.max(height(right.getLeft()), height(right.getRight())) + 1);

        return right;
    }


    private AVLTreeNode<T> findMinimum(AVLTreeNode<T> avlTreeNode)
    {
        if(avlTreeNode == null)
            return null;

        AVLTreeNode<T> temp = avlTreeNode;

        while (temp.getLeft() != null)
            temp = temp.getLeft();

        return temp;
    }

    public AVLTreeNode<T> getRoot() { return root; }
    public void setRoot(AVLTreeNode<T> root) { this.root = root; }

    private int height(AVLTreeNode<T> avlTreeNode) { return avlTreeNode == null ? 0 : avlTreeNode.getHeight(); }
    private int getBalance(AVLTreeNode<T> avlTreeNode) { return avlTreeNode == null ? 0 : height(avlTreeNode.getLeft()) - height(avlTreeNode.getRight()); }
}
