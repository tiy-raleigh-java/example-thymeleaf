package com.theironyard.exampleproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class ExampleController {

    //@RequestMapping(path = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String sayHello(Model model, @RequestParam(defaultValue = "Phil") String identifier){

        List<Integer> luckyNumbers = new ArrayList<>();
        for (int x = 0 ; x < 5 ; x++){
            luckyNumbers.add(new Random().nextInt(1000));
        }

        model.addAttribute("name", identifier);
        model.addAttribute("luckyNumbers", luckyNumbers);

        return "index";
    }

    @GetMapping("/goodbye")
    public String sayGoodbye(Model model){
        //System.out.println(LocalTime.now());

        model.addAttribute("time", LocalTime.now());

        return "goodbye";
    }

}
