package com.retodos;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.retodos.model.User;
import com.retodos.repository.crud.InterfaceChocolate;
import com.retodos.repository.crud.InterfaceOrder;
import com.retodos.repository.crud.InterfaceUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

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
        //interfaceChocolate.deleteAll();
        //interfaceUser.deleteAll();
        //interfaceOrder.deleteAll();
        interfaceUser.saveAll(List.of(			
			new User(1, "123456", "alan brito",ft.parse("1987-02-12"),"Febrero", "CR 34-45", "311222222", "alanbrito@gmail.com", "Demo123.", "ZONA 1","ADM")			
		));
    }
    
}