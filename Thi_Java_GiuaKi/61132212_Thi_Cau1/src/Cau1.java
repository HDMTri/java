import java.util.Scanner;

public class Cau1 {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap chi so can nang:");
		double weight = sc.nextDouble();
		System.out.print("\nNhap chi so chieu cao:");
		double height = sc.nextDouble();
		double BMI = weight/(height*height);
		
		System.out.print("\nChi so BMI cua ban la:"+BMI);
	}
}