package com.imarkofu.designpatterns.k;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 组合模式
 * 		组合模式有时又叫部分-整体模式，在处理类似树形结构的问题时比较方便
 * 
 * 总结
 * 		将多个对象组合在一起进行操作，常用于表示树形结构中，例如二叉树，树等。
 * 
 * @author clovec
 *
 */
public class CompositePatterns {

	public static void main(String[] args) {
		Tree tree = new Tree("A");
		TreeNode B = new TreeNode("B");
		TreeNode C = new TreeNode("C");
		B.add(C);
		tree.root.add(B);
		System.out.println("build the tree finished!");
	}
}
class TreeNode {
	private String name;
	private TreeNode parent;
	private Vector<TreeNode> children = new Vector<TreeNode>();
	public TreeNode(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TreeNode getParent() {
		return parent;
	}
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	public void add(TreeNode node) {
		this.children.add(node);
	}
	public void remove(TreeNode node) {
		this.children.remove(node);
	}
	public Enumeration<TreeNode> getChildren() {
		return this.children.elements();
	}
}
class Tree {
	TreeNode root = null;
	public Tree(String name) {
		this.root = new TreeNode(name);
	}
}