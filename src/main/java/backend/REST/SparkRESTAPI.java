package backend.REST;

import backend.businesslogic.Lunch;
import backend.businesslogic.database.UserHandling;
import backend.ressources.Customer;
import backend.ressources.Employee;
import backend.ressources.Restaurant;
import com.google.gson.Gson;

import static java.util.stream.Collectors.joining;
import static spark.Spark.*;

public class SparkRESTAPI {


     public static void main(String[] args) {

        after((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET, POST");
        });

        Gson gson = new Gson();
        UserHandling userhandler = new UserHandling();

        post("/add-employee",(req,res)->{
            System.out.println(req.body());

            Employee e = gson.fromJson(req.body(), Employee.class);
            System.out.println("E: "+e.toString());

            //make data readable for database
            String preferences = e.getPreferences().stream().map(Object::toString)
                    .collect(joining(", "));
            String allergies = e.getAllergies().stream().map(Object::toString)
                    .collect(joining(", "));

            //calls userhandling to add person to database
            return userhandler.createNewUser(e.getName(),allergies,preferences,e.isVegan(),e.isVeggy(),false,false);
        });
        post("/add-customer",(req,res)->{
             System.out.println(req.body());

             Customer c = gson.fromJson(req.body(), Customer.class);
             System.out.println("C: "+c.toString());

             String preferences = c.getPreferences().stream().map(Object::toString)
                     .collect(joining(", "));
             String allergies = c.getAllergies().stream().map(Object::toString)
                     .collect(joining(", "));

             //calls userhandling to add person to database
             return userhandler.createNewUser(c.getName(),allergies,preferences,c.isVegan(),c.isVeggy(),true,c.isPaying());
         });

        post("/restaurant/whatsforlunchmum",(req,res)->{
             System.out.println(req.body());

             //create lunch from response and get random restaurantc

            try {
                Lunch lunch = gson.fromJson(req.body(), Lunch.class);
                lunch.readRestaurants();
                lunch.readAllergiesAndPreferences();
                lunch.defineAvailableRestaurants();
                System.out.println(lunch.toString());
                Restaurant restaurant = lunch.randomRestaurant();
                System.out.println("sending restaurant to frontend: "+restaurant.getName());
                return gson.toJson(restaurant);
            }catch(Exception e){
                System.err.println(e.toString());
            }

            return null;

        });

         //transfer list of available persons to frontend
         get("/restaurant",(req,res)->{
             //calls userhandling to get available person-list
             return gson.toJson(userhandler.getPersonList());
         });


    }
}
