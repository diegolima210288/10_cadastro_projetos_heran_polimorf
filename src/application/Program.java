package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entitites.ImportedProduct;
import entitites.Product;
import entitites.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Product #"+i+" data: ");
			System.out.println("Common, used or imported (c/u/i)?");
			char type = sc.next().charAt(0);
			System.out.println("Name: ");
			String name = sc.nextLine();
			sc.nextLine();
			System.out.println("Price: ");
			double price = sc.nextDouble();
			
			if (type == 'c') {
				
				list.add(new Product(name, price));
				
			} else if (type == 'u'){
				
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, manufactureDate));
				
			} else if (type == 'i') {
				
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
				
			}
		}
		
		
		
		
		
		
		sc.close();

	}

}
