package basicAuth.config;

import basicAuth.entity.RoleEntity;
import basicAuth.entity.UserEntity;
import basicAuth.repository.RoleRepository;
import basicAuth.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        return args -> {
            RoleEntity userRole = new RoleEntity();
            userRole.setName("USER");
            RoleEntity adminRole = new RoleEntity();
            adminRole.setName("ADMIN");

            roleRepository.save(userRole);
            roleRepository.save(adminRole);

            UserEntity user = new UserEntity();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("1234"));
            user.setRoles(new HashSet<>(List.of(userRole)));

            UserEntity admin = new UserEntity();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("1234"));
            admin.setRoles(new HashSet<>(List.of(adminRole, userRole)));

            userRepository.save(user);
            userRepository.save(admin);
        };
    }
}
