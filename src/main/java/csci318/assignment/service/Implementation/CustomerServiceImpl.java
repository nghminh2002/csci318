package csci318.assignment.service.Implementation;

import csci318.assignment.model.Contact;
import csci318.assignment.model.Customer;
import csci318.assignment.repository.ContactRepository;
import csci318.assignment.repository.CustomerRepository;
import csci318.assignment.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ContactRepository contactRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, ContactRepository contactRepository) {
        this.customerRepository = customerRepository;
        this.contactRepository = contactRepository;
    }

    @Override
    public Customer createCustomer(Customer newCustomer) {
        return customerRepository.save(newCustomer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Customer updateCustomerById(Long customerId, Customer updateCustomer) {
        Customer existingCustomer = customerRepository.findById(customerId)
                .orElseThrow(RuntimeException::new);
        if (updateCustomer.getCompanyName() != null) {
            existingCustomer.setCompanyName(updateCustomer.getCompanyName());
        }

        if (updateCustomer.getAddress() != null) {
            existingCustomer.setAddress(updateCustomer.getAddress());
        }

        if (updateCustomer.getCountry() != null) {
            existingCustomer.setCountry(updateCustomer.getCountry());
        }
        return customerRepository.save(existingCustomer);
    }

    @Override
    public Customer updateCustomerContact(Long customerId, Long contactId) {
        Customer existingCustomer = customerRepository.findById(customerId)
                .orElseThrow(RuntimeException::new);
        Contact existingContact = contactRepository.findById(contactId)
                .orElseThrow(RuntimeException::new);
        existingCustomer.setContact(existingContact);
        return customerRepository.save(existingCustomer);
    }

    @Override
    public Contact createContact(Contact newContact) {
        return contactRepository.save(newContact);
    }

    @Override
    public Contact updateContact(Long contactId, Contact updatedContact) {
        Contact existingContact = contactRepository.findById(contactId)
                .orElseThrow(RuntimeException::new);
        if (updatedContact.getName() != null) {
            existingContact.setName(updatedContact.getName());
        }

        if (updatedContact.getPhone() != null) {
            existingContact.setPhone(updatedContact.getPhone());
        }

        if (updatedContact.getEmail() != null) {
            existingContact.setEmail(updatedContact.getEmail());
        }

        if (updatedContact.getPosition() != null) {
            existingContact.setPosition(updatedContact.getPosition());
        }
        return contactRepository.save(existingContact);
    }

    @Override
    public Contact getContactById(Long contactId) {
        return contactRepository.findById(contactId)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
}
