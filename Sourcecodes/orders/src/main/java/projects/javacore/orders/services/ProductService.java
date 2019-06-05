package projects.javacore.orders.services;

import java.util.InputMismatchException;
import java.util.Scanner;

import projects.javacore.orders.App;
import projects.javacore.orders.models.Product;

public class ProductService {
	public void insert() {
		Scanner inputs = new Scanner(System.in);
		System.out.println("Nhập thông tin sản phẩm:");

		try {
			System.out.print("Mã: ");
			int id = inputs.nextInt();

			inputs.nextLine();

			System.out.println("Tên: ");
			String name = inputs.nextLine();

			System.out.println("Số lượng: ");
			int quantity = inputs.nextInt();

			inputs.nextLine();

			System.out.println("Ghi chú:");
			String description = inputs.nextLine();

			System.out.println("Giá:");
			Float price = inputs.nextFloat();

			Product p = new Product(id, name, quantity, description, price);
			App.PRODUCTS.add(p);

		} catch (InputMismatchException ei) {
			System.out.println("Bạn đã nhập sai giá trị, xin vui lòng nhập lại!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void show() {
		System.out.println("Danh sách sản phẩm");
		String header = String.format("%s%15s%30s%15s%15s", "Mã", "Tên", "Số lượng", "Giá", "Ghi chú");
		System.out.println(header);
		for (Product p : App.PRODUCTS) {
			String row = String.format("%d%15s%30d%15f%15s", p.getId(), p.getName(), p.getQuantity(), p.getPrice(),
					p.getDescription());
			System.out.println(row);
		}

	}

	public void update() {
		Scanner inputs = new Scanner(System.in);

		try {
			System.out.println("Nhập mã: ");
			Integer id = inputs.nextInt();
			Product product = null;

			for (Product p : App.PRODUCTS) {
				if (p.getId().equals(id)) {
					product = p;
					break;
				}
			}

			if (product == null) {
				System.out.println("Mã sản phẩm không tồn tại. Xin vui long nhập lại!");
			}

			System.out.println("thông tin sản phẩm");
			String row = String.format("%d%15s%30d%15f%15s", product.getId(), product.getName(), product.getQuantity(),
					product.getPrice(), product.getDescription());
			System.out.println(row);

			for (int i = 0; i < App.PRODUCTS.size(); i++) {
				if (id.equals(App.PRODUCTS.get(i).getId())) {

					inputs.nextLine();

					System.out.println("Tên: ");
					String name = inputs.nextLine();

					System.out.println("Số lượng: ");
					int quantity = inputs.nextInt();

					inputs.nextLine();

					System.out.println("Ghi chú:");
					String description = inputs.nextLine();

					System.out.println("Giá:");
					Float price = inputs.nextFloat();

					App.PRODUCTS.get(i).setName(name);
					App.PRODUCTS.get(i).setQuantity(quantity);
					App.PRODUCTS.get(i).setDescription(description);
					App.PRODUCTS.get(i).setPrice(price);

				}
			}

		} catch (InputMismatchException ei) {
			System.out.println("Bạn đã nhập sai giá trị, xin vui lòng nhập lại!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Product getById(int id) {
		Product product = new Product();
		
		for (Product p : App.PRODUCTS) {
			if (p.getId().equals(id)) {
				product = p;
				break;
			}
		}
		return product;
	}
}
