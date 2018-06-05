package br.com.megaprojects;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Graph {
	private int totVertices;
	private int totEdges;
	Map<String, Activity> vertices;
	ArrayList<String> initVertice;
	Stack<String> inPath;
	
	public Graph(int totVertices) {
		this.totVertices = totVertices;
		vertices = new HashMap<String, Activity>(totVertices);
		initVertice = new ArrayList<String>(totVertices);
		inPath = new Stack<String>();
	}
	
	public int getTotVertices() {
		return totVertices;
	}

	public int getTotEdges() {
		return totEdges;
	}

	public void setTotEdges(int totEdges) {
		this.totEdges = totEdges;
	}
	
	public void addEdge(Activity v1, Activity v2) {
		v1.adj.add(v2);
	}
	
	public void dfs(Activity v) {		
		if(!v.isVisited()) {
			v.setVisited(true);
			//System.out.println("Visita  " + v.getName());
			
			for (int i = 0; i < v.adj.size(); i++) {
				dfs(v.adj.get(i));
				
				//System.out.println("Devolve " + v.adj.get(i).getName() + " (" + v.adj.get(i).getValue() + " * " + v.weight.get(i) + ")");				
				
				//v.incTotValue(v.adj.get(i).getTotValue() * v.weight.get(i));
				v.setAccumulated(new BigInteger(v.adj.get(i).getAccumulated()).multiply(new BigInteger(Integer.toString(v.weight.get(i)))));
				System.out.println(v.adj.get(i).getName() + " => " + v.getName());
				System.out.println(v.getName() + " => " + v.getAccumulated());
				System.out.print("\n");
			}
		}
	}
	
	public void allEdges() {
		for (String act : vertices.keySet()) {
			for (int i = 0; i < vertices.get(act).adj.size(); i++) {
				System.out.println(act + " " + vertices.get(act).adj.get(i).getName() + " " + vertices.get(act).weight.get(i));
			}
		}
	}
	
	public void removeInitVertice(String name) {
		for (int i = 0; i < initVertice.size(); i++) {
			if(initVertice.get(i).equals(name)) {
				initVertice.remove(i);
			}
		}
	}
	
	public String getInitVertice() {
		return initVertice.get(0);
	}
}
