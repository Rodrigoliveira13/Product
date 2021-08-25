package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;


public class Program {

	public static void main(String[] args) throws ParseException {
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner (System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	List <Product> list = new ArrayList<>();
	
	//Lendo a quantidade de produtos que o usuário deseja inserir 
	System.out.print("Enter the number of products: ");
	int n = sc.nextInt();
	
	//Será comparada a variável N com I para ser criado N produtos
	for (int i = 1; i <= n; i++) {
		System.out.println("Product #" + i + " data: ");
		System.out.print("Common, used or imported (c/u/i)? ");
		char ch = sc.next().charAt(0);
		sc.nextLine();
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Price: ");
		double price = sc.nextDouble();
		
		//Verificando se o produto é comum, usado ou importado
		if (ch == 'i') {
		System.out.print("Customs fee: ");
		double fee = sc.nextDouble();
		
		list.add(new ImportedProduct(name, price, fee));
		}
		else if (ch == 'u') {
			System.out.print("Manufacture date (DD/MM/YYYY): ");
			Date data = sdf.parse(sc.next());
			list.add(new UsedProduct(name, price, data));
		}
		else if (ch == 'c') {
			list.add(new Product(name, price));
		}
	
	
	}
	//Exibindo os produtos
	System.out.println();
	System.out.println("PRICE TAGS");
	for (Product p: list) {
		System.out.println(p.priceTag());
	}
	sc.close();
	}
}