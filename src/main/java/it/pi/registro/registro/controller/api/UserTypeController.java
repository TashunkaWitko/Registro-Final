package it.pi.registro.registro.controller.api;

import it.pi.registro.registro.entity.UserType;
import it.pi.registro.registro.service.UserTypeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/userTypes")
public class UserTypeController {

    private UserTypeService userTypeService;

    @GetMapping
    public ResponseEntity<List<UserType>> getAllUsers(){
        List<UserType> users = userTypeService.getAllUserTypes();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

//    @GetMapping("{id}")
//    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
//        User user = userService.getUserById(userId);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//    @GetMapping("/findByMail")
//    public ResponseEntity<User> getUserByEmail(@RequestBody String email){
//        User user = userService.getUserByEmail(email);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
    @PostMapping
    public ResponseEntity<UserType> createUser(@Valid @RequestBody UserType user){
        UserType savedUser = userTypeService.createUserType(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
//
//    @PutMapping("{id}")
//    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId ,@RequestBody User user){
//        User updatedUser = userService.getUserById(userId);
//        updatedUser.setFirstName(user.getFirstName());
//        updatedUser.setLastName(user.getLastName());
//        updatedUser.setEmail(user.getEmail());
//        userService.updateUser(updatedUser);
//        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
//    }
}
