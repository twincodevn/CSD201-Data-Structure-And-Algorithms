/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adj_list;
// Java Program to Implement the Unidirectional Graph
// Using Linked List

// Importing required classes from packages
import java.io.*;
import java.util.*;

// Main class
public class Adj_List {

	// Method 1
	// To make pair of nodes
	static void
	addEdge(LinkedList<LinkedList<Integer> > Adj, int u,
			int v)
	{
		// Creating bi-directional vertex
		Adj.get(u).add(v);
		Adj.get(v).add(u);
	}
        

	// Method 2
	// To print the adjacency list
	static void
	printadjacencylist(LinkedList<LinkedList<Integer> > adj)
	{
		for (int i = 0; i < adj.size(); ++i) {

			// Printing the head
			System.out.print(i + "->");

			for (int v : adj.get(i)) {
				// Printing the nodes
				System.out.print(v + " ");
			}

			// Now a new line is needed
			System.out.println();
		}
	}

	// Method 3
	// Main driver method
	public static void main(String[] args)
	{

		// Creating vertex
		int V = 5;

		LinkedList<LinkedList<Integer> > adj
			= new LinkedList<LinkedList<Integer> >();
		for (int i = 0; i < V; ++i) {
			adj.add(new LinkedList<Integer>());
		}

		// Inserting nodes
		// Custom input node elements
		addEdge(adj, 0, 1);
		addEdge(adj, 0, 4);
		addEdge(adj, 1, 2);
		addEdge(adj, 1, 3);
		addEdge(adj, 1, 4);
		addEdge(adj, 2, 3);
		addEdge(adj, 3, 4);

		// Printing adjacency list
		printadjacencylist(adj);
	}
}

