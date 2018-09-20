package tera.prog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	// Program entry point
	public static void main(String[] args) {
		run();
	}
	
	// Main run function
	private static void run() {
		System.out.print("Enter file path: ");
		String filePath = getUserInput();
		
		String[] fileContent = parseFile(filePath);
		
		List<Integer> integerFileContent = new ArrayList<Integer>();
		for (String string : fileContent)
			integerFileContent.add(Integer.parseInt(string.trim()));
		
		Collections.sort(integerFileContent);
		
		System.out.print("Enter nth digit: ");
		String nthDigitStr = getUserInput();
		int nthDigit = Integer.parseInt(nthDigitStr.trim());
		
		if (nthDigit >= integerFileContent.size())
			System.out.println("No such nth digit exits.");
		else
			System.out.println(integerFileContent.get(nthDigit - 1));
	}
	
	// Gets the user's input
	private static String getUserInput() {
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();
		if (userInput != null)
			return userInput;
		else
			return null;
	}
	
	// Collects content of file and returns it as an array
	private static String[] parseFile(String path) {
		String[] content = null;
		try (BufferedReader reader = new BufferedReader(new FileReader(new File("./src/" + path)))) {
			StringBuilder builder = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null)
				builder.append(line).append("\n");
			content = builder.toString().split(" ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}
	
}
