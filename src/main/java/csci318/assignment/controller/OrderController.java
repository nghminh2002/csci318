package csci318.assignment.controller;

import csci318.assignment.model.Order;
import csci318.assignment.repository.OrderRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping("/order")
    public Order createOrder(@RequestBody Order newOrder) {
        return orderRepository.save(newOrder);
    }

    @PutMapping("/order/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        if (order.getSupplier() != null) {
            existingOrder.setSupplier(order.getSupplier());
        }

        if (order.getProduct() != null) {
            existingOrder.setProduct(order.getProduct());
        }

        if (order.getQuantity() != null) {
            existingOrder.setQuantity(order.getQuantity());
        }
        return orderRepository.save(existingOrder);
    }
}
