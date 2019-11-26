package org.finn.demo.controller.coding;

import org.finn.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Finn Zhao
 * @version 2019-11-19
 */
@Controller
@RequestMapping("/coding")
public class CodingIndexController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/index"})
    public String index() {
        return "coding";
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public String save() {
        return "coding";
    }

}
