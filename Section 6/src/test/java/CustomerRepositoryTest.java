import com.demo.Customer;
import com.demo.CustomerRepository;
import com.demo.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Main.class)
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    public void testRepository() {
        Customer customer = new Customer();
        customer.setName("Tom");
        customer.setAge(40);

        repository.save(customer);
        assertEquals(1, repository.findAll().size()); // confirm save

        Customer loadedCustomer = repository.findById(customer.getId()).get(); // load / read by id
        assertEquals("Tom", loadedCustomer.getName());
        assertEquals(40, loadedCustomer.getAge());

        customer.setName("Peter"); // change name
        repository.save(customer); // update

        Customer updatedCustomer = repository.findById(customer.getId()).get(); // reload by id
        assertEquals("Peter", updatedCustomer.getName()); // check name updated correctly
        assertEquals(40, updatedCustomer.getAge()); // check age unchanged

        repository.delete(customer);
        assertEquals(0, repository.findAll().size()); // confirm deletion
    }
}
