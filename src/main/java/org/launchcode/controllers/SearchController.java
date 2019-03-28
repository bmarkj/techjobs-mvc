package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results
    @RequestMapping(value="results")
    public String search(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
        ArrayList<HashMap<String, String>> jobs = JobData.findByColumnAndValue(searchType, searchTerm);
        model.addAttribute("jobCount", jobs.size() + " Result(s)");
        //model.addAttribute("columns", ListController.columnChoices);
        model.addAttribute("jobs", jobs); //place search results in model so views can retrieve it

        return "search"; //this is an HTML file, you just don't add teh extension to it

    }

}
