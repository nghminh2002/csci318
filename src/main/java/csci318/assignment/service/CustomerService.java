package csci318.assignment.service;

import csci318.assignment.model.Contact;
import csci318.assignment.model.Customer;

import java.util.List;

public interface CustomerService {
    //customer
    Customer createCustomer(Customer newCustomer);
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long customerId);
    Customer updateCustomerById(Long customerId, Customer updateCustomer);
    Customer updateCustomerContact(Long customerId, Long contactId);

    //contact
    Contact createContact(Contact newContact);
    Contact updateContact(Long contactId, Contact updatedContact);
    Contact getContactById(Long contactId);
    List<Contact> getAllContacts();
}
