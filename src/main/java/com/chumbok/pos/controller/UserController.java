package com.chumbok.pos.controller;

import com.chumbok.pos.dto.PersistedObjId;
import com.chumbok.pos.dto.UserDTO;
import com.chumbok.pos.entity.User;
import com.chumbok.pos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public ModelAndView showAddStockForm(@RequestParam(required = false) Long userId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        if (userId != null) {

            User temp = userService.getUser(userId);
            //TODO add the rest of this mf code
           // modelAndView.addObject("userDTO", UserDTO);
        } else {
            modelAndView.addObject("userDTO", new UserDTO());
        }

        modelAndView.setViewName("getUsers");

        return modelAndView;
    }
   /* @Autowired
    private UserService userService;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<User> getUsers() {
        List<User> list = userService.getAllUsers();
        return list;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public PersistedObjId createUser(@RequestBody @Valid User user) {
        userService.createUser(user);
        return new PersistedObjId(user.getId());
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Integer id) {
        User user = userService.getUser(id);
        return user;
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable("id") Long id, @RequestBody @Valid User user) {
        user.setId(id);
        userService.updateUser(user);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }*/
}




