package Map.Swiggy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Managment {
    Map<Integer, Customer> customers = new HashMap<>();
    ArrayList<Order> orders = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.putIfAbsent(customer.getId(), customer);
        System.out.println("Customer added successfully");
    }

    public void placeOrder(Order order) {
        if (customers.containsKey(order.getCustomerId())) {
            orders.add(order);
            System.out.println("Order placed successfully");
        } else {
            System.out.println("Customer not found. ");
        }
    }

    public void displayCustomers() {
        for (Map.Entry<Integer, Customer> entry : customers.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public void displayCustomerbyFor() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            for (Customer customer : customers.values()) {
                System.out.println(customer);
            }
        }
    }

    public void displayOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }

    public void displayOrdersByCustomer(int customerId) {
        if (customers.containsKey(customerId)) {
            System.out.println("Orders for customer: " + customers.get(customerId).getName());
            for (Order order : orders) {
                if (order.getCustomerId() == customerId) {
                    System.out.println(order);
                }
            }
        } else {
            System.out.println("Customer not found. ");
        }
    }

    public void displayTotalRevenue() {
        double totalRevenue = 0;
        for (Order order : orders) {
            totalRevenue += order.getPrice();
        }
        System.out.println("Total Revenue: " + totalRevenue);
    }

    public void calRevenuebyCustomer(int customerId) {
        if (customers.containsKey(customerId)) {
            double revenue = 0;
            for (Order order : orders) {
                if (order.getCustomerId() == customerId) {
                    revenue += order.getPrice();
                }
            }
            System.out.println("Revenue from customer " + customers.get(customerId).getName() + ": " + revenue);
        } else {
            System.out.println("Customer not found. ");
        }
    }

    public void displayHighestSpendigCustomers() {
        Customer highestSpendingCustomer = null;
        double highestSpending = 0;

        for (Customer customer : customers.values()) {
            double totalSpending = 0;
            for (Order order : orders) {
                if (order.getCustomerId() == customer.getId()) {
                    totalSpending += order.getPrice();
                }
            }
            if (totalSpending > highestSpending) {
                highestSpending = totalSpending;
                highestSpendingCustomer = customer;
            }
        }
        if (highestSpendingCustomer != null) {
            System.out.println("Highest Spending Customer: " + highestSpendingCustomer.getName() + ", Amount: " + highestSpending);
        } else {
            System.out.println("No customers found.");
        }
    }

    public void countOrdersPerCustomer() {
        for (Customer customer : customers.values()) {
            int orderCount = 0;
            for (Order order : orders) {
                if (order.getCustomerId() == customer.getId()) {
                    orderCount++;
                }
            }
            System.out.println("Customer: " + customer.getName() + ", Orders Count: " + orderCount);
        }
    }

    public void removeCustomer(int customerId) {
        if (customers.containsKey(customerId)) {
            customers.remove(customerId);
            orders.removeIf(order -> order.getCustomerId() == customerId);
        } else {
            System.out.println("Customer not found. ");
        }
    }
}
