
package org.launchcode.hellospringworld.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    //Handles request at path /hello
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hello(@RequestParam String name){

        return "Hello, " + name + "!";
    }
/*    // lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye(){

        return "Goodbye, Spring!";
    }

    // Handles request of form /hello?name=LaunchCode
    //this requestmapping is general version of postmapping.  Put them in annotation parameters.
    //lives at /hello/hello
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }*/

    //handles requests of the form /hello/LaunchCode
    //uses data that is part of the path itself to return as variable
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloAgain(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    //form if not specified otherwise will be submitted via get request
    // lives at hello/form
    @GetMapping("form")
    public String helloform(){
        return "form";
    }

}
