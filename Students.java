import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class Students {
	
	public static void main(String[] args) throws IOException{
		String[] students;
		Scanner start = new Scanner(System.in);
		Scanner other = new Scanner(System.in);
		Scanner load = new Scanner(System.in);
		System.out.println("Enter the file: ");
		String file = other.nextLine();
		System.out.println("Enter 1 if you want to pick a random student");
		System.out.println("Enter 2 if you want to make groups");
		int i = start.nextInt();
		System.out.print("Enter your student file: ");
		String path = load.nextLine();
		students = loadFile(path, students);
		//File file = new File("class.csv");
		Scanner scan = new Scanner(file);
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
					if (person == students.length) {
						System.out.println("Small Group ");
						System.exit(1);
					}
					System.out.print(students[person] + " ");
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

	public static String[] loadFile(String path, String[] students) {
		File file = new File(path);
		Scanner scan;
		try {
			scan = new Scanner(file);
			students = scan.nextLine().split(",");
			
		} catch {
			System.out.println("Error");
			System.exit(1);
		}
	}


}
