package tree;

import java.util.Stack;

/**
 * Created by huangzhibo on 4/7/16.
 */
public class BinaryTree {
    private TreeNode root=null;

    public BinaryTree(){
        root=new TreeNode(1,"rootNode(A)");
    }
    public void createBinTree(TreeNode root){
        TreeNode newNodeB = new TreeNode(2,"B");
        TreeNode newNodeC = new TreeNode(3,"C");
        TreeNode newNodeD = new TreeNode(4,"D");
        TreeNode newNodeE = new TreeNode(5,"E");
        TreeNode newNodeF = new TreeNode(6,"F");
        root.leftChild=newNodeB;
        root.rightChild=newNodeC;
        root.leftChild.leftChild=newNodeD;
        root.leftChild.rightChild=newNodeE;
        root.rightChild.rightChild=newNodeF;
    }
    public boolean isEmpty(){
        return root==null;
    }

    //树的高度
    public int height(){
        return height(root);
    }

    //节点个数
    public int size(){
        return size(root);
    }


    private int height(TreeNode subTree){
        if(subTree==null)
            return 0;//递归结束：空树高度为0
        else{
            int i=height(subTree.leftChild);
            int j=height(subTree.rightChild);
            return (i<j)?(j+1):(i+1);
        }
    }

    private int size(TreeNode subTree){
        if(subTree==null){
            return 0;
        }else{
            return 1+size(subTree.leftChild)
                    +size(subTree.rightChild);
        }
    }
    public void visted(TreeNode subTree){
        subTree.isVisted=true;
        System.out.println("key:"+subTree.key+"--name:"+subTree.data);;
    }

    //前序遍历
    public void preOrder(TreeNode subTree){
        if(subTree!=null){
            visted(subTree);
            preOrder(subTree.leftChild);
            preOrder(subTree.rightChild);
        }
    }

    //中序遍历
    public void inOrder(TreeNode subTree){
        if(subTree!=null){
            inOrder(subTree.leftChild);
            visted(subTree);
            inOrder(subTree.rightChild);
        }
    }

    //后续遍历
    public void postOrder(TreeNode subTree) {
        if (subTree != null) {
            postOrder(subTree.leftChild);
            postOrder(subTree.rightChild);
            visted(subTree);
        }
    }
    //前序遍历的非递归实现
    public void nonRecPreOrder(TreeNode p){
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode node=p;
        while(node!=null||stack.size()>0){
            while(node!=null){
                visted(node);
                stack.push(node);
                node=node.leftChild;
            }
            if (stack.size()>0){
                node=stack.pop();
                node=node.rightChild;
            }
        }
    }

    //中序遍历的非递归实现
    public void nonRecInOrder(TreeNode p){
        Stack<TreeNode> stack =new Stack<TreeNode>();
        TreeNode node =p;
        while(node!=null||stack.size()>0){
            //存在左子树
            while(node!=null){
                stack.push(node);
                node=node.leftChild;
            }
            //栈非空
            if(stack.size()>0){
                node=stack.pop();
                visted(node);
                node=node.rightChild;
            }
        }
    }

    //后序遍历的非递归实现
    public void noRecPostOrder(TreeNode p){
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode node =p;
        while(p!=null){
            //左子树入栈
            for(;p.leftChild!=null;p=p.leftChild){
                stack.push(p);
            }
            //当前结点无右子树或右子树已经输出
            while(p!=null&&(p.rightChild==null||p.rightChild==node)){
                visted(p);
                //纪录上一个已输出结点
                node =p;
                if(stack.empty())
                    return;
                p=stack.pop();
            }
            //处理右子树
            stack.push(p);
            p=p.rightChild;
        }
    }

    //测试
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinTree(bt.root);
        System.out.println("the size of the tree is " + bt.size());
        System.out.println("the height of the tree is " + bt.height());

        System.out.println("*******(前序遍历)[ABDECF]遍历*****************");
        bt.preOrder(bt.root);

        System.out.println("*******(中序遍历)[DBEACF]遍历*****************");
        bt.inOrder(bt.root);

        System.out.println("*******(后序遍历)[DEBFCA]遍历*****************");
        bt.postOrder(bt.root);

        System.out.println("***非递归实现****(前序遍历)[ABDECF]遍历*****************");
        bt.nonRecPreOrder(bt.root);

        System.out.println("***非递归实现****(中序遍历)[DBEACF]遍历*****************");
        bt.nonRecInOrder(bt.root);

        System.out.println("***非递归实现****(后序遍历)[DEBFCA]遍历*****************");
        bt.noRecPostOrder(bt.root);
    }

}
