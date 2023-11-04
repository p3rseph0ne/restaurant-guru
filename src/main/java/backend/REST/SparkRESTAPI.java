package backend.REST;

import backend.ressources.Restaurant;
import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.post;

public class SparkRESTAPI {
     public static void main(String[] args) {
        /*final RestaurantService restaurantService = new RestaurantService();

        after((Filter) (request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET");
        });

        get("/restaurant",(req,res)->{
            Restaurant restaurant = new Restaurant("test restaurant");
            return restaurant.getName();
        });

        post("/add-restaurant",(req,res)->{
            //Restaurant restaurant = new Restaurant(req.params(":name"));
            System.out.println(req.body());
            //restaurantService.addRestaurant(restaurant);
            //return restaurant.toString();
            return "";
        });*/

        
    }
}
