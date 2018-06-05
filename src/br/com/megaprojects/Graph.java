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
	
	public void addEdge(Activity v1, Activity v2) {
		v1.adj.add(v2);
	}
	
	public void dfs(Activity v) {
		if(!cyclical) {
			if(!v.isVisited()) {
				v.setVisited(true);
				//System.out.println("Visita  " + v.getName());
				
				for (int i = 0; i < v.adj.size(); i++) {
					if(!v.isEndAdj()) {
						//System.out.println("endAdj: " + v.adj.get(i).getName() + " " + v.adj.get(i).isEndAdj());
						dfs(v.adj.get(i));
					
						//System.out.println("Devolve " + v.adj.get(i).getName());				
						
						//v.incTotValue(v.adj.get(i).getTotValue() * v.weight.get(i));
						v.setAccumulated(new BigInteger(v.adj.get(i).getAccumulated()).multiply(new BigInteger(Integer.toString(v.weight.get(i)))));
						//System.out.println(v.adj.get(i).getName() + " => " + v.getName());
						//System.out.println(v.getName() + " => " + v.getAccumulated());
						//System.out.print("\n");
					}
				}
				
				//System.out.println("Acabou filhos aqui " + v.getName());
				v.setEndAdj(true);
				//System.out.println("endAdj: " + v.getName() + " " + v.isEndAdj());
			} else {
				if(!v.isEndAdj()) {
					//System.out.println("Ciclo!");
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
	
	public String getInitVertice() {
		return initVertice.get(0);
	}
}
