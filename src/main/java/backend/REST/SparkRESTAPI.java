package backend.REST;

import backend.businesslogic.Lunch;
import backend.businesslogic.database.UserHandling;
import backend.logging.Logging;
import backend.ressources.Customer;
import backend.ressources.Employee;
import backend.ressources.Restaurant;
import com.google.gson.Gson;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

import static java.util.stream.Collectors.joining;
import static spark.Spark.*;

/**
 * Custom REST API for handling requests between front and backend
 */
public class SparkRESTAPI {

    static Logger logger = Logger.getLogger(Logging.class.getName());
     public static void main(String[] args) {

         try {
             // Create a new timestamp so the logging files can be sorted by date
             String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
             // Create a new fileHandler so the infos stay persistent in a file
             FileHandler fileHandler = new FileHandler("src/main/java/backend/logging/logger" + timeStamp + ".log",2000, 1);
             // Create a formatter so the file is actually readable
             Formatter formatter = new Formatter() {
                 @Override
                 public String format(LogRecord record) {
                     return record.getThreadID()+" : "+record.getSourceClassName()+" : "
                             +new Date(record.getMillis())+" : "
                             +record.getMessage()+"\n";
                 }
             };
             fileHandler.setFormatter(formatter);
             logger.addHandler(fileHandler);
             // Log the first line to proof it works
             logger.log(Level.INFO, "Das sollte die erste Zeile im Log sein");
         } catch (IOException e) {
             logger.log(Level.SEVERE,e.toString());
             throw new RuntimeException(e);
         }

         logger.log(Level.INFO, "API gestartet");

         /**
          * Enable CORs (cross-origin requests) for our REST API
          */
        after((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET, POST");
        });

        Gson gson = new Gson();
        UserHandling userhandler = new UserHandling();

         /**
          * Handles post request when an Employee shall be added to the database.
          * Uses gson library to convert JSON Response to Employee object
          * Calls Userhandler to create a new User with the given attributes of the response
          * Returns the return-value of createNewUser to frontend
          */
        post("/add-employee",(req,res)->{
            Employee e = gson.fromJson(req.body(), Employee.class);
            //make data readable for database
            String preferences = e.getPreferences().stream().map(Object::toString)
                    .collect(joining(", "));
            String allergies = e.getAllergies().stream().map(Object::toString)
                    .collect(joining(", "));
            logger.log(Level.INFO, "Ein neuer Employee wurde hinzugefügt");
            //calls userhandling to add person to database
            return gson.toJson(userhandler.createNewUser(e.getName(),allergies,preferences,e.isVegan(),e.isVeggy(),false,false));
        });
         /**
          * Handles post request when an Customer shall be added to the database.
          * Uses gson library to convert JSON Response to Customer object
          * Calls Userhandler to create a new User with the given attributes of the response
          * Returns the return-value of createNewUser to frontend
          */
        post("/add-customer",(req,res)->{
             Customer c = gson.fromJson(req.body(), Customer.class);
             //make data readable for db
             String preferences = c.getPreferences().stream().map(Object::toString)
                     .collect(joining(", "));
             String allergies = c.getAllergies().stream().map(Object::toString)
                     .collect(joining(", "));
            logger.log(Level.INFO, "Ein neuer Kunde wurde hinzugefügt");
             //calls userhandling to add person to database
             return gson.toJson(userhandler.createNewUser(c.getName(),allergies,preferences,c.isVegan(),c.isVeggy(),true,c.isPaying()));
         });

         /**
          * Handles post request when a Person shall be deleted to the database.
          * Calls Userhandler to delete the Person with the given name. Since the req comes as a JSON, we split
          * the req String at every " and return the forth entry of the resulting array which is the name
          * Returns the return-value of deleteUser to frontend
          */
        post("/delete-person",(req, res)->{
            return gson.toJson(userhandler.deleteUser(req.body().split("\"")[3]));
         });

         /**
          * returns a list containing every person in the db to frontend when /restaurant is called
          */
         get("/restaurant",(req,res)->{
             logger.log(Level.INFO, "Die Personen wurden abgefragt und zurückgegeben");
             //calls userhandling to get available person-list
             return gson.toJson(userhandler.getPersonList());
         });

         /**
          * Handles post request when the button "what's for lunch mum" is clicked on the frontend
          * Using gson library to convert JSON Response to Lunch object with given attribtues
          * Calls setup methods of lunch and returns the random restaurant generated by Lunch to the frontend
          * using gson library to covnert the restaurant into json format
          */
        post("/restaurant/whatsforlunchmum",(req,res)->{
             System.out.println(req.body());
             //create lunch from response and get random restaurantc
            try {
                Lunch lunch = gson.fromJson(req.body(), Lunch.class);
                lunch.readRestaurants();
                lunch.readAllergiesAndPreferences();
                lunch.defineAvailableRestaurants();
                Restaurant restaurant = lunch.randomRestaurant();
                logger.log(Level.INFO, "Die Restaurants wurden abgefragt und zurückgegeben");
                return gson.toJson(restaurant);
            }catch(Exception e){
                logger.log(Level.SEVERE, e.getMessage());
                System.err.println(e.toString());
            }

            return null;
        });




    }
}
