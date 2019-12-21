
package org.launchcode.hellospringworld.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //Handles request at path /hello
/*    @GetMapping("hello")
    @ResponseBody
    public String hello(){

        return "Hello, Spring!";
    }*/
    // lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye(){

        return "Goodbye, Spring!";
    }

    // Handles request of form /hello?name=LaunchCode
    //this requestmapping is general version of postmapping.  Put them in annotation parameters.
    //lives at /hello/hello
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST},value = "hello")
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //handles requests of the form /hello/LaunchCode
    //uses data that is part of the path itself to return as variable
    @GetMapping("{name}")
    public String hellowWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    //form if not specified otherwise will be submitted via get request
    // lives at hello/form
    @GetMapping("form")
    public String helloform(){
        String html = "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submits a request to /hello
                "<input type='text' name='name'>" + //above the handler accepts the variable name so it works here
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
        return html;
    }

}
