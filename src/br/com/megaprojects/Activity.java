package br.com.megaprojects;

import java.math.BigInteger;
import java.util.ArrayList;

public class Activity {
	private String name;
	private int value;
	private boolean visited;
	private boolean endAdj;
	private BigInteger accumulated;
	ArrayList<Integer> weight;
	ArrayList<Activity> adj;

	public Activity(String name, int value) {
		this.name = name;
		this.value = value;
		visited = false;
		accumulated = BigInteger.valueOf(value);
		adj = new ArrayList<Activity>();
		weight = new ArrayList<Integer>();
	}

	public void addEdge(Activity vertice) {
		adj.add(vertice);
	}

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public boolean isEndAdj() {
		return endAdj;
	}

	public void setEndAdj(boolean endAdj) {
		this.endAdj = endAdj;
	}

	public String getAccumulated() {
		return accumulated.toString();
	}

	public void setAccumulated(BigInteger value) {
		this.accumulated = this.accumulated.add(value);
	}

	@Override
	public String toString() {
		return "Activity [name=" + name + ", value=" + value + "]";
	}
}