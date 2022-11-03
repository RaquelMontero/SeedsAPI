package com.semillas.SemillasApi.Controllers;

import com.semillas.SemillasApi.Security.jwt.JwtProvider;
import com.semillas.SemillasApi.Service.RolService;
import com.semillas.SemillasApi.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oauth")
@CrossOrigin
public class OauthController {

    @Value("${google.clientId}")
    String googleClientId;

    @Value("${secretPsw}")
    String secretPsw;

/*    @Autowired
    PasswordEncoder passwordEncoder;
*/
    /*@Autowired
    AuthenticationManager authenticationManager;*/

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;


 /*
    @PostMapping("/google")
    public ResponseEntity<TokenDto> google(@RequestBody TokenDto tokenDto) throws IOException {
       System.out.println("token" + tokenDto.getValue());
        final NetHttpTransport transport = new NetHttpTransport();
        final JacksonFactory jacksonFactory = JacksonFactory.getDefaultInstance();
        GoogleIdTokenVerifier.Builder verifier =
                new GoogleIdTokenVerifier.Builder(transport, jacksonFactory)
                        .setAudience(Collections.singletonList(googleClientId));
        final GoogleIdToken googleIdToken = GoogleIdToken.parse(verifier.getJsonFactory(), tokenDto.getValue());
        final GoogleIdToken.Payload payload = googleIdToken.getPayload();
        System.out.println("este es el payload " + payload.getEmail());
        Usuario usuario = new Usuario();
        if(usuarioService.existsEmail(payload.getEmail()))
            usuario = usuarioService.getByEmail(payload.getEmail()).get();
        else
            usuario = saveUsuario(payload.getEmail());
        TokenDto tokenRes = login(usuario);
        return new ResponseEntity(tokenRes, HttpStatus.OK);
    }
*/
/*
    private TokenDto login(Usuario usuario){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuario.getEmail(), secretPsw)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        TokenDto tokenDto = new TokenDto();
        tokenDto.setValue(jwt);
        return tokenDto;
    }
*/
    /*@Bean
    private Usuario saveUsuario(String email){
        Usuario usuario = new Usuario(email, passwordEncoder.encode(secretPsw));
        Rol rolUser = rolService.getByRolNombre(RolNombre.ROLE_USER).get();
        Set<Rol> roles = new HashSet<>();
        roles.add(rolUser);
        usuario.setRoles(roles);
        return usuarioService.save(usuario);
    }
*/
}
