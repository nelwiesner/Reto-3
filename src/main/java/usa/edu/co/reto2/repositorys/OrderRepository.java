/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usa.edu.co.reto2.repositorys;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.edu.co.reto2.model.Order;
import usa.edu.co.reto2.repository.crud.InterfaceOrder;

/**
 *
 * @author karen
 */
@Repository
public class OrderRepository {
    @Autowired
    private InterfaceOrder orderCrudRepository;
    
    //@Autowired
    //private MongoTemplate mongoTemplate;

    public List<Order> getAll() {
        return (List<Order>) orderCrudRepository.findAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderCrudRepository.findById(id);
    }

    public Order create(Order order) {
        return orderCrudRepository.save(order);
    }

    public void update(Order order) {
        orderCrudRepository.save(order);
    }

    public void delete(Order order) {
        orderCrudRepository.delete(order);
    }
    
    public List<Order> findByZone(String zona){
       return orderCrudRepository.findByZone(zona);
    }
    
    //public List<Order> orderSalesManByDate(String dateStr, Integer id) {
      //  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        //Query query= new Query();
        //Criteria dateCriteria =Criteria.where("registerDay")
          //      .get(LocalDate.parse(dataStr, dtf).minusDays(1).atStartOfDay())
            //    .lt(LocalDate.parse(dataStr, dtf).plusDays(2).atStartOfDay())
              //  .and("salesMan.id"). is (id);
        
        //query.addCriteria(dateCriteria);
        //List<Order> orders =mongoTemplate.find(query, Order.class);
        //return orders;
    //}
     //public List<Order> orderSalesManByState(String dateStr, Integer id){
       //  Query query =new Query();
         //Criteria dateCriteria =Criteria.where("salesMan.id").is(id)
         //        .and("status").is(state);
         //query.addCriteria(dateCriteria);
         //List<Order> orders =mongoTemplate.find(query, Order.class);
        //return orders;
         
     //}
    
    public Optional<Order> lastUserId(){
        return orderCrudRepository.findTopByOrderByIdDesc();
    }
}
