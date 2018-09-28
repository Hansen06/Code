package x2018;


import java.util.*;

public class sougou01 {

    public static class Graph {
        public HashMap<Integer, Node> nodes;
        public HashSet<Edge> edges;

        public Graph() {
            nodes = new HashMap<>();
            edges = new HashSet<>();
        }
    }

    public static class Edge {
        public int weight;
        public Node from;
        public Node to;

        public Edge(int weight, Node from, Node to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }

    }

    public static class Node {
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

    public static Graph createGraph(Integer[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            Integer from = matrix[i][0];
            Integer to = matrix[i][1];
            Integer weight = matrix[i][2];

            //添加node
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }

            //建立边
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);

            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }


    public static HashMap<Node, Integer> dijkstra(Node head) {
        HashMap<Node, Integer> distanceMap = new HashMap<>();//head到node的距离
        distanceMap.put(head, 0);
        HashSet<Node> selectedNodes = new HashSet<>();

        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;//通过边找下一个相连的节点
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge.weight);
                }
                distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
            }
            selectedNodes.add(minNode);
            //取下一个节点
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    //
    public static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> touchedNodes) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!touchedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int v_rab = in.nextInt();
        int v_tor = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();

        int num = 0;
        Integer[][] matrix2 = new Integer[m][4];
        for (int i = 0; i < m; i++) {
            int from = in.nextInt();
            int to = in.nextInt();
            int weight = in.nextInt();
            int flag = in.nextInt();
            matrix2[i][0] = from;
            matrix2[i][1] = to;
            matrix2[i][2] = weight;
            matrix2[i][3] = flag;
            if (flag != 1) {
               num++;
            }
        }

        Integer[][] matrix1 = new Integer[num][3];//只有陆路
        for (int i = 0; i < matrix2.length; i++) {
            if (matrix2[i][3] != 1) {
                matrix1[i][0] = matrix2[i][0];
                matrix1[i][1] = matrix2[i][1];
                matrix1[i][2] = matrix2[i][2];
            }
        }

//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(matrix2[i][j] + " ");
//            }
//            System.out.println();
//        }
        Graph graph1 = createGraph(matrix1);
        Graph graph2 = createGraph(matrix2);

        HashMap<Node, Integer> res1 = new HashMap<>();
        HashMap<Node, Integer> res2 = new HashMap<>();
        res1 = dijkstra(graph1.nodes.get(1));
        res2 = dijkstra(graph2.nodes.get(1));
        int time1 = res1.get(n) / v_rab;
        int time2 = res2.get(n) / v_tor;
        if (time1 == time2){
            System.out.println("0");
        }else if (time1 > time2){
            System.out.println("-1");
        }else{
            System.out.println("1");
        }
    }
}
