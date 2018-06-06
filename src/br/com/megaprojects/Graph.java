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
	private boolean cyclical;
	Map<String, Activity> vertices;
	ArrayList<String> initVertice;
	Stack<String> inPath;
	
	public Graph(int totVertices) {
		this.totVertices = totVertices;
		cyclical = false;
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
	
	public boolean isCyclical() {
		return this.cyclical;
	}

	public void setTotEdges(int totEdges) {
		this.totEdges = totEdges;
	}
	
	public String getInitVertice() {
		return initVertice.get(0);
	}
	
	public void addEdge(Activity v1, Activity v2) {
		v1.adj.add(v2);
	}
	
	public void dfs(Activity v) {
		if(!cyclical) {
			if(!v.isVisited()) {
				v.setVisited(true);
				
				for (int i = 0; i < v.adj.size(); i++) {
					if(!v.isEndAdj()) {
						dfs(v.adj.get(i));
						
						v.setAccumulated(
							new BigInteger(v.adj.get(i).getAccumulated()).multiply(new BigInteger(Integer.toString(v.weight.get(i))))
						);
					}
				}
				
				v.setEndAdj(true);
			} else {
				if(!v.isEndAdj()) {
					cyclical = true;
				}
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

}
