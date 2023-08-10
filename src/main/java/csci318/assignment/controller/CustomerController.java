package csci318.assignment.controller;

import csci318.assignment.model.Contact;
import csci318.assignment.model.Customer;
import csci318.assignment.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer newCustomer) {
        return customerService.createCustomer(newCustomer);
    }

    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.updateCustomerById(id, customer);
    }

    @PutMapping("/customer/{customerId}/contact/{contactId}")
    public Customer updateCustomerContact(@PathVariable Long customerId, @PathVariable Long contactId) {
        return customerService.updateCustomerContact(customerId, contactId);
    }

    @GetMapping("/customer/{id}")
    Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/customer")
    List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/customer/contact")
    public Contact createContact(@RequestBody Contact newContact) {
        return customerService.createContact(newContact);
    }

    @PutMapping("/customer/contact/{id}")
    public Contact updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        return customerService.updateContact(id, contact);
    }

    @GetMapping("/customer/contact/{id}")
    Contact getContact(@PathVariable Long id) {
        return customerService.getContactById(id);
    }

    @GetMapping("/customer/contact")
    List<Contact> getAllContacts() {
        return customerService.getAllContacts();
    }
}
