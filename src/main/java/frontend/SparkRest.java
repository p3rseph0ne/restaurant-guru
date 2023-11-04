package frontend;

import static spark.Spark.*;
public class SparkRest {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello, Baeldung");

        get("/hello/:name", (req, res) -> {
            return "Hello: " + req.params(":name");
        });

        //implement get /adduser
        //implement get /findrestaurant
        //implement post /finderestaurant/result
        //implement post /addperson
        //implement post /deleteperson
    }

}
