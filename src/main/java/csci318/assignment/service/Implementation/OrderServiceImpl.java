package csci318.assignment.service.Implementation;

import csci318.assignment.model.Order;
import csci318.assignment.repository.OrderRepository;
import csci318.assignment.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order newOrder) {
        return orderRepository.save(newOrder);
    }

    @Override
    public Order updateOrder(Long orderId, Order updatedOrder) {
        Order existingOrder = orderRepository.findById(orderId)
                .orElseThrow(RuntimeException::new);

        if (updatedOrder.getSupplier() != null) {
            existingOrder.setSupplier(updatedOrder.getSupplier());
        }

        if (updatedOrder.getProduct() != null) {
            existingOrder.setProduct(updatedOrder.getProduct());
        }

        if (updatedOrder.getQuantity() != null) {
            existingOrder.setQuantity(updatedOrder.getQuantity());
        }
        return orderRepository.save(existingOrder);
    }
}
