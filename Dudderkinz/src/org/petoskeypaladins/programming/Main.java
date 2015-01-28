package org.petoskeypaladins.programming;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Are you a snail, or what? (Yes or no)");
		
		Scanner scanner = new Scanner(System.in);
		String response = scanner.nextLine();
		
		if(response.equalsIgnoreCase("yes")) {
			try {
				FileReader reader = new FileReader(Main.class.getClassLoader().getResource("text.txt").getPath());
				BufferedReader br = new BufferedReader(reader);
				String line;
								
				while((line = br.readLine()) != null) {
					System.out.println(line);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("Oh :(");
		}
		
	}
	
}
