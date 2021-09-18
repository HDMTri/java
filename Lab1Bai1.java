package Lab1;
import java.util.Scanner;
public class Lab1Bai1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print ("Ho va ten: ");
		String hovaten = sc.nextLine();
		System.out.print ("Diem: ");
		Double diem = sc.nextDouble();
		System.out.println(" ");
		System.out.printf("%s: %.1f diem", hovaten, diem);
	}
}
