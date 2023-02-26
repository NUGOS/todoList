package ua.goit.todolist.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.goit.todolist.dto.UserDto;
import ua.goit.todolist.model.Role;
import ua.goit.todolist.model.User;
import ua.goit.todolist.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void save(UserDto userDto) {
        if (userRepository.findByUsername(userDto.getUsername()).isEmpty()) {
            User user = new User();
            user.setUsername(userDto.getUsername());
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            user.setEnabled(true);
            user.setRole(Role.USER);
            userRepository.save(user);
        } else {
            System.out.println(userRepository.findByUsername(userDto.getUsername()) + "User in DB");
        }
    }
}
