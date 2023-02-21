package ibf2022.ssf.day16.controller;

import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;

@RestController
// application/json
@RequestMapping(path="/time", produces = MediaType.APPLICATION_JSON_VALUE)
public class TimeController {

    // Request
    // > GET /time
    // > ACCEPT: application/json
    // Response
    // < 200 OK
    // < Content-Type: application/json
    // 
    // < {"time" : "the time"}

    //This method returns time as json (in client)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getTimeAsJson() {
        String time = (new Date()).toString();
        JsonObject payload = Json.createObjectBuilder()
            .add("time", time)
            .build();
        return ResponseEntity.ok(payload.toString());
    }

    //Method that returns time as text/plain (in client)
    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getTimeAsText() {
        String time = (new Date()).toString();
        return ResponseEntity.ok("The current time/date is %s".formatted(time));
    }
    
    // Method that returns time as HTML (in browser)
    // @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    // public ResponseEntity<String> getTimeAsHTML() {
    //     String time = (new Date()).toString();
    //     return ResponseEntity.ok(
    //         "<h1>The current time/date is %s</h>".formatted(time)
    //         );
    // }

    // Method that returns time as HTML (in browser), more elaborate than the above method
    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> getTimeAsHTMLdetailed() {
        String time = (new Date()).toString();
        return ResponseEntity.status(200)
            .header("X-Generated-By", "Spring-Boot") 
            .body(
                "<h1>The current time/date is %s</h>".formatted(time)
            );
    }

    /*The above is an example of content negotiation. Value of time remains the same, result can be
    presented in different formats. Can even use other libraries to generate other file types like pdf*/


}
