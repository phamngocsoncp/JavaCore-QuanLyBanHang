package projects.javacore.orders;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import projects.javacore.orders.models.Order;
import projects.javacore.orders.models.Product;
import projects.javacore.orders.services.OrderService;
import projects.javacore.orders.services.ProductService;

/**
 * Hello world!
 *
 */
public class App {
	
	public static List<Product> PRODUCTS = new ArrayList<Product>();
	public static List<Order> ORDERS = new ArrayList<Order>();

	public static void menu() {
		System.out.println("------------------Danh sách chức năng----------------------------");
		System.out.println("1. Thêm mới sản phẩm");
		System.out.println("2. Hiển thị sản phẩm");
		System.out.println("3. Sửa sản phẩm");
		System.out.println("4. Xóa sản phẩm");
		System.out.println("5. Mua hàng");
		System.out.println("6. Hiện thị danh sách đơn hàng");
		System.out.println("7. Thoát.");
	}

	public static void main(String[] args) {
		
		for (int i = 0; i < 4; i++) {
			Float price = (float) (i + 4);
			Product p = new Product(i + 1, "SP " + (i + 1), 1,
					"Description"  + (i + 1), price);
			
			App.PRODUCTS.add(p);
		}
		
		int function = 0;
		
		do {
			menu();
			Scanner inputs = new Scanner(System.in);
			try {
				System.out.print("Chọn chức năng: ");
				function = inputs.nextInt();
				ProductService productService = new ProductService();
				OrderService orderService = new OrderService();
				
				switch (function) {
				case 1:
					productService.insert();
					break;
				case 2:
					productService.show();
					break;
				case 3:
					productService.update();
					break;
				case 4:
					
					break;
				case 5:
					orderService.order();
					break;
				case 6:
					orderService.show();
					break;

				default:
					break;
				}
			} catch (InputMismatchException ei) {
				System.out.println("Bạn đã nhập sai giá trị, xin vui lòng nhập lại!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} while (function != 7);

		System.out.println("Cám ơn bạn đã sử dụng phần mềm!");

	}
}
