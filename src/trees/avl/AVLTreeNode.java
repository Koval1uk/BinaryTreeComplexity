package trees.avl;

import trees.TreeNodeBase;

public class AVLTreeNode<T> extends TreeNodeBase<T>
{
    private int height;
    public AVLTreeNode(int key, T value)
    {
        this.key = key;
        this.height = 1;
        this.left = this.right = null;
        this.value = value;
    }

    public int getKey() { return key; }
    public int getHeight() { return height; }
    public T getValue() { return value; }
    public AVLTreeNode<T> getLeft() { return (AVLTreeNode<T>) left; }
    public AVLTreeNode<T> getRight() { return (AVLTreeNode<T>) right; }

    public void setKey(int key) { this.key = key; }
    public void setValue(T value) { this.value = value; }
    public void setHeight(int height) { this.height = height; }
    public void setLeft(AVLTreeNode<T> left) { this.left = left; }
    public void setRight(AVLTreeNode<T> right) { this.right = right; }
}
