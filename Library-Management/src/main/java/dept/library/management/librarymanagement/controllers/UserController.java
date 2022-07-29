package dept.library.management.librarymanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dept.library.management.librarymanagement.entities.User;
import dept.library.management.librarymanagement.objects.StatusCode;
import dept.library.management.librarymanagement.repositories.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserRepository userRepository;
    
    @PutMapping("/register")
    StatusCode register(@RequestBody User user) {
        try{
            if (userRepository.findByEmail(user.getEmail()) == null) {
                userRepository.save(user);
                return new StatusCode(200, "Student registered successfully");
            }
            else
                throw new Exception();
        }
        catch(Exception e){
            return new StatusCode(400, "Student already exists");
        }
    }

    @PostMapping("/login")
    StatusCode login(@RequestBody User user) {
        try{
            User data = userRepository.findByEmail(user.getEmail());
            if (data != null && data.getPassword().equals(user.getPassword())) {
                return new StatusCode(200, "Login successful");
            }
            else{
                throw new Exception();
            }
        }
        catch(Exception e){
            return new StatusCode(400, "Login unsuccessful");
        }
    }

    @PostMapping("/fetch")
    Object fetch(@RequestBody User user) {
        try{
            User data = userRepository.findByEmail(user.getEmail());
            if ( data == null )
                throw new Exception();
            return data;
        }
        catch(Exception e){
            return new StatusCode(400, "Cannot be fetched");
        }
    }

    @GetMapping("/fetchall")
    List<User> fetchAll(){
        return userRepository.findAll();
    }

    @PutMapping("/update")
    StatusCode update(@RequestBody User user){
        try{
            if (userRepository.findByEmail(user.getEmail()).getUsertype() == 'A')
                throw new Exception();
            user.setUser_id(userRepository.findByEmail(user.getEmail()).getUser_id());
            userRepository.save(user);
            return new StatusCode(200, "Updation successful");
        }
        catch (Exception e){
            return new StatusCode(400, "Updation unsuccessful");
        }
    }
}
