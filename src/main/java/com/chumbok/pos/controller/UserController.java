package com.chumbok.pos.controller;

import com.chumbok.pos.dto.PersistedObjId;
import com.chumbok.pos.dto.UserDTO;
import com.chumbok.pos.entity.Role;
import com.chumbok.pos.entity.User;
import com.chumbok.pos.repository.RoleRepository;
import com.chumbok.pos.service.UserService;
import com.chumbok.pos.service.UserServiceLive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public ModelAndView showAddStockForm(@RequestParam(required = false) Long userId, @Valid User user) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        if (userId != null) {
            //TODO add the rest of this mf code | wait, i think it IS all the code needed
            // somebody please check if we need something else
            modelAndView.addObject("user", userService.getUser(userId));
        } else {
            modelAndView.addObject("user", new User());
            userService.updateUser(user);
            modelAndView.addObject("userDTO", new UserDTO());
        }

        modelAndView.setViewName("user");
        return modelAndView;
    }

    @RequestMapping(path = "/users", method = RequestMethod.POST)
    public ModelAndView createUpdateUser(@RequestParam(value = "id", required = false) Long id, @Valid UserDTO userDTO) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        if (id == null) {
            if (userDTO.getPassword().equals(userDTO.getConfirmPassword())) { //first of all, both passwords must match
                userService.makeUser(userDTO); //saves the user as a real user
            }
            modelAndView.addObject("successMessage", "El usuario se ha registrado exitosamente.");
            modelAndView.addObject("user", new UserDTO());
            modelAndView.setViewName("user");
        } else if (id != null) {
            userService.updateUser(userDTO, id); //sends userDTO for validation and id
            modelAndView.addObject("successMessage", "Usuario modificado correctamente.");
            modelAndView.addObject("user", userDTO);
            modelAndView.setViewName("user");
        }
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




