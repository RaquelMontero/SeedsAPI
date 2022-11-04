package com.semillas.SemillasApi.Controllers;

import com.semillas.SemillasApi.Entities.JwtRequest;
import com.semillas.SemillasApi.Entities.JwtResponse;
import com.semillas.SemillasApi.Entities.Volunter;
import com.semillas.SemillasApi.Security.jwt.JwtUtil;
import com.semillas.SemillasApi.Service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/oauth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OauthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping(path = {"/generate-token"})
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        System.out.println("hkjhk"+ jwtRequest);
        try {
            authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
        }catch (Exception exception) {
            exception.printStackTrace();
            throw new Exception("usuario no encontrado");
        }
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException disabledException){
            throw new Exception("USUARIO DESHABILITADO" + disabledException.getMessage());
        }catch (BadCredentialsException badCredentialsException){
            throw new Exception("credenciales invalidas" + badCredentialsException.getMessage());
        }
    }
    @GetMapping("/actual-usuario")
    public Volunter getCurrentVolunter(Principal principal){
        return (Volunter) this.userDetailsService.loadUserByUsername(principal.getName());
    }
}
