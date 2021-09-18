package Lab1;
import java.util.Scanner;
public class Lab1Bai4 {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		//Nhap
		System.out.print("Nhap he so 1: ");
		int a = input.nextInt();
		System.out.print("Nhap he so 2: ");
		int b = input.nextInt();
		System.out.print("Nhap he so 3: ");
		int c = input.nextInt();
		//Tinh delta va can delta
		double delta = Math.pow(b, 2) - 4*a*c;
		double sqrtdelta = Math.sqrt(delta);
		//Xuat ra man hinh
		System.out.println("Delta cua he phuong trinh la: "+delta);
		System.out.println("Can Delta cua he phuong trinh la: "+sqrtdelta);
	}
}
