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
		int person = 0;
		// System.out.println("" + students[0]);
		if (i == 1) {
			Random r = new Random();
			person = r.nextInt(students.length);
			System.out.println(students[person]);
		} else if (i == 2) {
			System.out.println("How big of groups?");
			int x = start.nextInt();
			shuffle(students);
			for (int b=0; b<students.length-1; b++) {
				for (int a=0; a<x; a++) {
					System.out.print(students[person] + " ");
					//called[b] = students[person];
					b++;
					person++;
				}
				b--;
				System.out.println();	
			}
			if (students.length % x > 0) {
				for (int j = students.length; j % x >= 1; j--) {
					System.out.println("Left over " + students[j-1]);
				}
			}
			
		} else {
			System.out.println("Not a number");
		}
		
	}

	public static void shuffle(String[] students) {
		Random r = new Random();
		for (int f = (students.length - 1); f > 0; f--) {
		    String name = students[f];
		    int temp = r.nextInt(f);
		    students[f] = students[temp];
		    students[temp] = name;
		}
	}


}
