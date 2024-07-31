package Exercise11;

class Customer {
    private int customerId;
    private String customerName;

    public Customer(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public int getId() {
        return customerId;
    }

    public String getName() {
        return customerName;
    }
}

interface CustomerRepository {
    Customer findCustomerById(int id);
}

class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(int id) {
        return new Customer(id, "Alex Johnson");
    }
}

class CustomerService {
    private final CustomerRepository customerRepo;

    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer getCustomerById(int id) {
        return customerRepo.findCustomerById(id);
    }
}

public class DependencyInjectionExample {
    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);
        Customer customer = service.getCustomerById(99);
        System.out.printf("Customer [ID: %d, Name: %s]%n", customer.getId(), customer.getName());
    }
}

