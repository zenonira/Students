import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class Students {
	
	public static void main(String[] args) throws IOException{
		Scanner start = new Scanner(System.in);
		System.out.println("Enter 1 if you want to pick a random student");
		System.out.println("Enter 2 if you want to make groups");
		int i = start.nextInt();
		File file = new File("class.csv");
		Scanner scan = new Scanner(file);
		String[] students = scan.nextLine().split(",");
		String[] called;
		// System.out.println("" + students[0]);
		Random r = new Random();
		int person = r.nextInt(students.length);
		if (i == 1) {
			System.out.println(students[person]);
		} else if (i == 2) {
			System.out.println("How big of groups?");
			int x = start.nextInt();
			for (int b=0; b<students.length-1; b++) {
				for (int a=0; a<x; a++) {
					person = r.nextInt(students.length);
					System.out.print(students[person] + " ");
					called[b] = students[person];
					b++;
				}
				b--;
				System.out.println();
			}
			
		} else {
			System.out.println("Not a number");
		}
		
	}


}