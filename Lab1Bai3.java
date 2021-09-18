package Lab1;
import java.util.Scanner;
public class Lab1Bai3 {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Nhap canh khoi lap phuong: ");
		int canh = input.nextInt();
		//cach 1
		int TheTich = canh*canh*canh;
		System.out.println("The tich khoi lap phuong la: "+TheTich);
		//cach2
		/*
		 * double TheTich = Math.pow(canh.3)
		 * Sytem.out.println("The tich khoi lap phuong la: "+TheTich);
		 */
	}
}
