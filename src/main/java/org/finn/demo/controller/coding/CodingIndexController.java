package org.finn.demo.controller.coding;

import org.finn.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
