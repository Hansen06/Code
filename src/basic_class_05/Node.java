package basic_class_05;

import java.util.ArrayList;

public class Node {
	public int value;   //权重
	public int in;      //入度
	public int out;     //出度
	public ArrayList<Node> nexts;
	public ArrayList<Edge> edges;

	public Node(int value) {
		this.value = value;
		in = 0;
		out = 0;
		nexts = new ArrayList<>();
		edges = new ArrayList<>();
	}
}
