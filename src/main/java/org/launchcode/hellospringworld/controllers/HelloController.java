
package org.launchcode.hellospringworld.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    //Handles request at path /hello
/*    @GetMapping("hello")
    @ResponseBody
    public String hello(){

        return "Hello, Spring!";
    }*/

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){

        return "Goodbye, Spring!";
    }

    // Handles request of form /hello?name=LaunchCode
    //this requestmapping is general version of postmapping.  Put them in annotation parameters.
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //handles requests of the form /hello/LaunchCode
    //uses data that is part of the path itself to return as variable
    @GetMapping("hello/{name}")
    @ResponseBody
    public String hellowWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    //form if not specified otherwise will be submitted via get request
    @GetMapping("form")
    @ResponseBody
    public String helloform(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submits a request to /hello
                "<input type='text' name='name'>" + //above the handler accepts the variable name so it works here
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
