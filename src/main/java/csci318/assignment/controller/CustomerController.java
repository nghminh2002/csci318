package csci318.assignment.controller;

import csci318.assignment.model.Contact;
import csci318.assignment.model.Customer;
import csci318.assignment.repository.ContactRepository;
import csci318.assignment.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerRepository customerRepository;
    private final ContactRepository contactRepository;

    public CustomerController(CustomerRepository customerRepository, ContactRepository contactRepository) {
        this.customerRepository = customerRepository;
        this.contactRepository = contactRepository;
    }

    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer newCustomer) {
        return customerRepository.save(newCustomer);
    }

    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        if (customer.getCompanyName() != null) {
            existingCustomer.setCompanyName(customer.getCompanyName());
        }

        if (customer.getAddress() != null) {
            existingCustomer.setAddress(customer.getAddress());
        }

        if (customer.getCountry() != null) {
            existingCustomer.setCountry(customer.getCountry());
        }
        return customerRepository.save(existingCustomer);
    }

    @PutMapping("/customer/{id}/contact/{contactId}")
    public Customer updateCustomerContact(@PathVariable Long id, @PathVariable Long contactId) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        Contact existingContact = contactRepository.findById(contactId)
                .orElseThrow(RuntimeException::new);
        existingCustomer.setContact(existingContact);
        return customerRepository.save(existingCustomer);
    }

    @GetMapping("/customer/{id}")
    Customer getCustomer(@PathVariable Long id) {
        return customerRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @GetMapping("/customer")
    List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping("/customer/contact")
    public Contact createContact(@RequestBody Contact newContact) {
        return contactRepository.save(newContact);
    }

    @PutMapping("/customer/contact/{id}")
    public Contact updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        Contact existingContact = contactRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        if (contact.getName() != null) {
            existingContact.setName(contact.getName());
        }

        if (contact.getPhone() != null) {
            existingContact.setPhone(contact.getPhone());
        }

        if (contact.getEmail() != null) {
            existingContact.setEmail(contact.getEmail());
        }

        if (contact.getPosition() != null) {
            existingContact.setPosition(contact.getPosition());
        }
        return contactRepository.save(existingContact);
    }

    @GetMapping("/customer/contact/{id}")
    Contact getContact(@PathVariable Long id) {
        return contactRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @GetMapping("/customer/contact")
    List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
}
