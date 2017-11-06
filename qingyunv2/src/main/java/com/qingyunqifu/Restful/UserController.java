package com.qingyunqifu.Restful;


import com.qingyunqifu.domain.Users;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @RequestMapping(value = "/u/{id}",method = RequestMethod.GET)
    public Users query(@PathVariable  String id) {
        Users users = new Users();
        users.setUsername("tom");
        return users;
    }
}
