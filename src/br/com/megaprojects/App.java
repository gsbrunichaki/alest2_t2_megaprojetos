package br.com.megaprojects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class App {
	
	public static void calcProject(String file) {
		long initTime = System.currentTimeMillis();
		
		try {
			FileReader flr = new FileReader(file);
			BufferedReader bfr = new BufferedReader(flr);
			Graph g = new Graph(Integer.parseInt(bfr.readLine()));
			
			for(int i = 0; i < g.getTotVertices(); i++) {
				StringTokenizer tknzr = new StringTokenizer(bfr.readLine());
				String actName = tknzr.nextToken();
				int actValue = Integer.parseInt(tknzr.nextToken());

				g.vertices.put(actName, new Activity(actName, actValue));
				g.initVertice.add(actName);
			}
			
			g.setTotEdges(Integer.parseInt(bfr.readLine()));
			
			for (int i = 0; i < g.getTotEdges(); i++) {
				StringTokenizer tknzr = new StringTokenizer(bfr.readLine());
				String v1 = tknzr.nextToken();
				String v2 = tknzr.nextToken();
				
				g.addEdge(g.vertices.get(v1), g.vertices.get(v2));
				g.vertices.get(v1).weight.add(Integer.parseInt(tknzr.nextToken()));
				g.removeInitVertice(v2);
			}
			
			g.dfs(g.vertices.get(g.getInitVertice()));
			
			bfr.close();
			flr.close();
			
			double finTime = System.currentTimeMillis() - initTime;
			
			System.out.printf("Arquivo:\t\t" + file);
			
			if(g.isCyclical()) {
				System.out.println("\nNão foi possível concluir o cálculo do projeto, pois um ciclo foi detectado!");
			} else {
				System.out.printf("\nCusto total:\t\t" + g.vertices.get(g.getInitVertice()).getAccumulated());
				System.out.printf("\nTempo de execucao:\t" + finTime/1000 + "\n");
			}
			System.out.print("\n");
		} catch(IOException e) {
			System.err.print("Erro ao ler o arquivo " + file + "\n");
			e.getMessage();
		}
	}
	
	public static void main(String[] args) {
		calcProject("caso0010.txt");
		calcProject("caso0100.txt");
		calcProject("caso0200.txt");
		calcProject("caso0400.txt");
		calcProject("caso0600.txt");
		calcProject("caso0800.txt");
		calcProject("caso1000.txt");
	}

}
