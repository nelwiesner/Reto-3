package usa.edu.co.reto2;


import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import usa.edu.co.reto2.repository.crud.InterfaceChocolate;
import usa.edu.co.reto2.repository.crud.InterfaceOrder;
import usa.edu.co.reto2.repository.crud.InterfaceUser;

@Component
@SpringBootApplication
public class Reto2Application implements CommandLineRunner {
   @Autowired
    private InterfaceChocolate interfaceChocolate;
    @Autowired
    private InterfaceUser interfaceUser;
    @Autowired
    private InterfaceOrder interfaceOrder;
	public static void main(String[] args) {
		SpringApplication.run(Reto2Application.class, args);
	}
          @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        interfaceChocolate.deleteAll();
        interfaceUser.deleteAll();
        interfaceOrder.deleteAll();
    }
    
}