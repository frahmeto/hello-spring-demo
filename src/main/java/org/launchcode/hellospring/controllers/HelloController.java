package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chris Bay
 */
@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //    // Handle request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

//    // Handles requests of the form /hello?name=LaunchCode
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";
//    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public static String createMessage(@RequestParam String name, @RequestParam String language){

        String greeting = "";
        if(name == null){
            return name = "World";
        }

        if(language.equals("english")){
            greeting ="Hello";
        }else if(language.equals("french")){
                greeting ="Bonjour";
        }else if(language.equals("italian")) {
            greeting = "Buongiorno";
        }else if(language.equals("german")) {
            greeting = "Guten Tag";
        }else if(language.equals("amharic")) {
            greeting = "Selam new";
        }
        return greeting + " " + name;
    }
    // /hello/form<
    //@GetMapping("form")
    @RequestMapping(value = "form", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = '/hello' method = 'post'>" + // submit a request to /hello
                "<input type = 'text' name = 'name' />" +
                "<select name = 'language'>" +
                "<option value = 'english'>English</option>" +
                "<option value = 'french'>French</option>" +
                "<option value = 'italian'>Italian</option>" +
                "<option value = 'german'>German</option>" +
                "<option value = 'amharic'>Amharic</option>" +
                "</select>"+
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
