package projects.javacore.orders.services;

import java.util.InputMismatchException;
import java.util.Scanner;

import projects.javacore.orders.App;
import projects.javacore.orders.models.Order;
import projects.javacore.orders.models.OrderDetail;
import projects.javacore.orders.models.Product;

public class OrderService {
	public void order() {
		
		Scanner inputs = new Scanner(System.in);
		System.out.println("-------------------Mua sản phẩm:----------------");
		
		
		try {
			System.out.print("Mã đặt hàng: ");
			int id = inputs.nextInt();
			
			inputs.nextLine();
			
			System.out.println("Nhập tên khách hàng: ");
			String customerName = inputs.nextLine();
			
			System.out.println("Nhập số điện thoại: ");
			String phone = inputs.nextLine();
						
			System.out.println("Nhập số email: ");
			String email = inputs.nextLine();
			
			Order order = new Order(id, customerName, phone, email);
			
			Integer productId = -1;
			
			while (true) {
				inputs = new Scanner(System.in);
				
				System.out.println("Nhập mã sản phẩm: ");
				productId = inputs.nextInt();
				
				if (productId.equals(-1)) {
					break;
				}
				
				System.out.println("Nhập số lượng: ");
				int quantity = inputs.nextInt();
				
				Product product = null;
				
				for (Product p : App.PRODUCTS) {
					if (p.getId().equals(productId)) {
						product = p;
						break;
					}
				}
				
				if (product == null) {
					System.out.println("Mã sản phẩm không tồn tại");
				}
				
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setId(1);
				orderDetail.setOrderId(order.getId());
				orderDetail.setPrice(product.getPrice());
				orderDetail.setProductId(productId);
				orderDetail.setQuantity(quantity);
				
				order.getOrderDetails().add(orderDetail);
				
			}
			
			App.ORDERS.add(order);
			
			
		} catch (InputMismatchException ei) {
			System.out.println("Bạn đã nhập sai giá trị, xin vui lòng nhập lại!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public void show() {
		System.out.println("Danh sách đặt hàng");
		String header = String.format("%s%15s%30s%30s", "Mã", "Tên khách hàng",
				"Số điện thoại", "Email");
		System.out.println(header);
		ProductService productService = new ProductService();
		
		for (Order order : App.ORDERS) {
			String row = String.format("%d%15s%30s%30s", order.getId(), order.getCustomerName(),
					order.getPhone(), order.getEmail());
			System.out.println(row);
			
			String orderDetailHeader = String.format("%30s%10s%30s%30s",
					"STT", "Tên Sản Phẩm", "Giá", "Số Lượng");
			System.out.println(orderDetailHeader);
			
			int i = 1;
			for (OrderDetail od : order.getOrderDetails()) {
				
				Product p = productService.getById(od.getProductId());
				
				String orderDetailRow = String.format("%30s%10s%30s%30s",
						i, p.getName(), od.getPrice(), od.getQuantity());
				System.out.println(orderDetailRow);
				i++;
			}
		}
	
	}
}
