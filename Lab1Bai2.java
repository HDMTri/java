package Lab1;
import java.util.Scanner;
public class Lab1Bai2 {
	public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap chieu dai cua hcn: ");
        double length = scanner.nextDouble();
        System.out.println("Nhap chieu rong cua hcn: ");
        double width = scanner.nextDouble();
        
        double CV = (length+width)*2;
        System.out.println("chu vi hcn la:"+CV);
        
        double DT = length*width;
        System.out.println("dien tich hcn la:"+DT);
        
        double CNN = Math.min(length, width);
        System.out.println("canh nho nhat cua hcn la: "+CNN);
        System.out.println("");
    }
}
