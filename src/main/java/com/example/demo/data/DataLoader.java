package com.example.demo.data;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Customer;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class DataLoader {
    private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);
    @Autowired
    CustomerRepository customerRepository;

    @PostConstruct
    public void loadData() {
        long customerCount = customerRepository.count();
        logger.info("Customer count in database: " + customerCount);
        if(customerCount == 0) {
            try {
                loadCustomers();
            } catch (Exception e) {
                logger.error("Error loading data", e);
            }
        } else {
            logger.info("Data already loaded");
        }
    }

    private void loadCustomers() {
            // Customer 1
            Customer customer1 = new Customer();
            customer1.setFirstName("John");
            customer1.setLastName("Doe");
            customer1.setAddress("123 Main St");
            customer1.setPostal_code("10001");
            customer1.setPhone("212-555-1234");
            customer1.setCreate_date(new Date());
            customer1.setLast_update(new Date());
            customerRepository.save(customer1);

            // Customer 2
            Customer customer2 = new Customer();
            customer2.setFirstName("Emily");
            customer2.setLastName("Johnson");
            customer2.setAddress("456 Elm Street");
            customer2.setPostal_code("90001");
            customer2.setPhone("213-555-6789");
            customer2.setCreate_date(new Date());
            customer2.setLast_update(new Date());
            customerRepository.save(customer2);

            // Customer 3
            Customer customer3 = new Customer();
            customer3.setFirstName("Michael");
            customer3.setLastName("Smith");
            customer3.setAddress("789 Oak Ave");
            customer3.setPostal_code("60601");
            customer3.setPhone("312-555-9876");
            customer3.setCreate_date(new Date());
            customer3.setLast_update(new Date());
            customerRepository.save(customer3);

            // Customer 4
            Customer customer4 = new Customer();
            customer4.setFirstName("Linda");
            customer4.setLastName("Brown");
            customer4.setAddress("101 Pine Lane");
            customer4.setPostal_code("77001");
            customer4.setPhone("713-555-4321");
            customer4.setCreate_date(new Date());
            customer4.setLast_update(new Date());
            customerRepository.save(customer4);

            // Customer 5
            Customer customer5 = new Customer();
            customer5.setFirstName("David");
            customer5.setLastName("Wilson");
            customer5.setAddress("202 Maple Road");
            customer5.setPostal_code("85001");
            customer5.setPhone("602-555-5678");
            customer5.setCreate_date(new Date());
            customer5.setLast_update(new Date());
            customerRepository.save(customer5);
    }
}
