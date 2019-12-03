package org.finn.demo.controller.coding;

import org.finn.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Finn Zhao
 * @version 2019-11-19
 */
@Controller
@RequestMapping("/online")
public class CodingIndexController {

    private static final Logger log = LoggerFactory.getLogger(CodingIndexController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = {""})
    public String brief() {
        return "redirect:online/";
    }

    @RequestMapping(value = {"/", "/index"})
    public String index() {
        return "online/coding";
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public String save(@RequestParam("code") String code) {
        log.info(code);
        return "online/coding";
    }

}
