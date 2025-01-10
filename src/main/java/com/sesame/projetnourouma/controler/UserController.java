package com.sesame.projetnourouma.controler;

import com.sesame.projetnourouma.Dto.AuthenticationRequest;
import com.sesame.projetnourouma.Dto.UserDto;
import com.sesame.projetnourouma.Exception.AlreadyExistsException;
import com.sesame.projetnourouma.Exception.BadCredentialExecption;
import com.sesame.projetnourouma.Exception.UserNotFoundException;
import com.sesame.projetnourouma.Mapper.UserMapper;
import com.sesame.projetnourouma.entities.User;
import com.sesame.projetnourouma.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
@AllArgsConstructor

public class UserController {

    private final UserRepository userRepo;
    private final UserMapper userMapper;

    @PostMapping("authenticate")
    public UserDto authenticate(@RequestBody AuthenticationRequest request) {
        Optional<User> o=userRepo.findByLogin(request.getLogin());
        if(o.isEmpty())
        {
            throw new UserNotFoundException("there is no user with this login ");
        }
        else if(Objects.equals(o.get().getPassword(), request.getPassword()))
        {
            return userMapper.toUserDto(o.get());
        }
        else
        {
            throw new BadCredentialExecption("Bad Credentials");
        }


    }
    @GetMapping("/all")
    public List<UserDto> getAllUsers() {

        return  userRepo.findAll().stream().map(user -> userMapper.toUserDto(user)).toList();
    }
    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        Optional<User> existingUser = userRepo.findById(user.getId());
        if (existingUser.isPresent()) {
            throw new AlreadyExistsException("user Already Exists");
        }
        userRepo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User added successfully");
    }
   /* @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody User userDetails) {
        Optional<User >o= userRepo.findById(id);
        if(o.isEmpty())
            throw new UserNotFoundException("User not found");
        User user=o.get();
        userRepo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User updated successfully");

*/



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }
        userRepo.deleteById(id);
        return ResponseEntity.ok("User deleted successfully");
    }

}
