package br.com.megaprojects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class App {
	
	public static void main(String[] args) {
		try {
			FileReader flr = new FileReader("caso1000.txt");
			BufferedReader bfr = new BufferedReader(flr);
			Graph g = new Graph(Integer.parseInt(bfr.readLine()));
			
			for(int i = 0; i < g.getTotVertices(); i++) {
				StringTokenizer tknzr = new StringTokenizer(bfr.readLine());
				String actName = tknzr.nextToken();
				int actValue = Integer.parseInt(tknzr.nextToken());

				g.vertices.put(actName, new Activity(actName, actValue));
				g.initVertice.add(actName);
			}
			
			/*for (int i = 0; i < g.vertices.size(); i++) {
				System.out.println((i + 1) + " => " + g.vertices.get(i));
			}*/
			
			g.setTotEdges(Integer.parseInt(bfr.readLine()));
			
			for (int i = 0; i < g.getTotEdges(); i++) {
				StringTokenizer tknzr = new StringTokenizer(bfr.readLine());
				String v1 = tknzr.nextToken();
				String v2 = tknzr.nextToken();
				
				g.addEdge(g.vertices.get(v1), g.vertices.get(v2));
				g.vertices.get(v1).weight.add(Integer.parseInt(tknzr.nextToken()));
				g.removeInitVertice(v2);
			}
			
			/*for (String activity : g.vertices.keySet()) {
				System.out.println(activity + ":");
				
				for (int i = 0; i < g.vertices.get(activity).adj.size(); i++) {
					System.out.println(g.vertices.get(activity).adj.get(i));
				}
				
				System.out.print("\n");
			}*/
			
			//g.dfs(g.vertices.get(g.getInitVertice()));
			
			//g.allEdges();
			
			/*System.out.println(g.vertices.get("GMZ").getAccumulated());
			g.vertices.get("GMZ").setAccumulated(new BigInteger("10"));
			System.out.println(g.vertices.get("GMZ").getAccumulated());
			g.vertices.get("GMZ").setAccumulated(new BigInteger("25").multiply(new BigInteger("2")));
			System.out.println(g.vertices.get("GMZ").getAccumulated());*/
			
			bfr.close();
			flr.close();
		} catch(IOException e) {
			System.err.print("Erro ao ler o arquivo " + "casoxxxx.txt" + "\n");
			e.getMessage();
		}
	}
	
	/*public static boolean isInt(String s) {
		boolean valInt = false;
		
		try {
			Integer.parseInt(s);
			valInt = true;
		} catch(NumberFormatException e) {

		}
		
		return valInt;
	}*/
}
