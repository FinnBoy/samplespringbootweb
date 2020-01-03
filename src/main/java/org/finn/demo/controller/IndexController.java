package org.finn.demo.controller;

import org.finn.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Finn Zhao
 * @version 2019-11-19
 */
@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/index"})
    public String index() {
        return "module/index";
    }

}
