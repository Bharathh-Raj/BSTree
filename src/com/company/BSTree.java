package com.company;

public class BSTree {
    node root=null;
    int leftheight,rightheight;

    class node{
        int data;
        node left,right;

        node(int data) {
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public node create(int data) {
        if (root == null) {
            root=new node(data);
            return root;
        }
        else{
            return new node(data);
        }
    }

    public node insert(node head,int data) {
        if (head == null) {
            return create(data);
        }
        else{
            if (data < head.data) {
                head.left = insert(head.left, data);
            } else if (data > head.data) {
                head.right = insert(head.right, data);
            }else{
                return null;
            }
        }
        return head;
    }

    public node findmin(node head) {
        while (head.left != null) {
            head=head.left;
        }
        return head;
    }

    public void inorder(node head) {
        if (head == null) {
            return;
        }
        inorder(head.left);
        System.out.print("\t"+head.data);
        inorder(head.right);
    }

    public void preorder(node head) {
        if (head == null) {
            return;
        }
        System.out.print("\t"+head.data);
        preorder(head.left);
        preorder(head.right);
    }

    public void postorder(node head) {
        if (head == null) {
            return;
        }
        postorder(head.left);
        postorder(head.right);
        System.out.print("\t"+head.data);
    }

    public node delete(node head, int data) {
        if (head == null) {
            return null;
        }
        else{
            if (data < head.data) {
                head.left=delete(head.left, data);
            } else if (data > head.data) {
                head.right=delete(head.right, data);
            }
            else{
                if (head.left == null && head.right == null) {
                    head=null;
                } else if (head.left == null) {
                    head=head.right;
                } else if (head.right == null) {
                    head=head.left;
                }else{
                    node temp = findmin(head.right);
                    head.data=temp.data;
                    head.right=delete(head.right, temp.data);
                }
            }

        }
        return head;
    }

    public int height(node head) {
        if (head == null) {
            return -1;
        }
        leftheight = height(head.left);
        rightheight = height(head.right);
        return leftheight-rightheight<0?rightheight+1:leftheight+1;
    }
}
