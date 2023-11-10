package backend.REST;

import backend.ressources.Customer;
import backend.ressources.Employee;
import backend.ressources.Person;
import backend.ressources.Restaurant;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

public class SparkRESTAPI {



     public static void main(String[] args) {

         Gson gson = new Gson();

        after((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET, POST");
        });

        post("/add-employee",(req,res)->{
            System.out.println(req.body());

            Employee e = gson.fromJson(req.body(), Employee.class);
            System.out.println("E: "+e.toString());

            //calls userhandling to add person to database

            return "";
        });
         post("/add-customer",(req,res)->{
             System.out.println(req.body());

             Customer c = gson.fromJson(req.body(), Customer.class);
             System.out.println("C: "+c.toString());

             return "";
         });
         post("/restaurant/whatsforlunchmum",(req,res)->{
             System.out.println(req.body());
             Restaurant restaurant = new Restaurant("name", "adresse");
             return gson.toJson(restaurant);
         });

         get("/restaurant",(req,res)->{
             //transfer list of available persons to frontend
            // UserHandling hd = new UserHandling();
             List<Person> personList = new ArrayList<>();
             ArrayList<String> allergies = new ArrayList<>();
             allergies.add("A");
             ArrayList<String> preferences = new ArrayList<>();
             preferences.add("italian");
             Employee testEmployee = new Employee("Employee",allergies,preferences,true,false);
             Customer testCustomer = new Customer("Customer",allergies,preferences,false,false,true);

             //calls userhandling to get available person-list

             personList.add(testEmployee);
             personList.add(testCustomer);

             //creates lunch and calls getrandomrestaurant

             return gson.toJson(personList);
         });


    }
}
