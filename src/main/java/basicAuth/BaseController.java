package basicAuth;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BaseController {

    @PreAuthorize("permitAll()")
    @GetMapping("free")
    public String freeRoute() {
        return "Rota com acesso para todos";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("user")
    public String userRoute() {
        return "Rota com acesso para usuarios";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("admin")
    public String adminRoute() {
        return "Rota com acesso para administradores";
    }
}
