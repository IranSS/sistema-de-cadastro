package sistema_cadastro.controllers;

import sistema_cadastro.model.UsuarioDTO;
import sistema_cadastro.model.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sistema_cadastro.repository.UsuarioRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
@RestController
@RequestMapping(value = "/user")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping(value = "/get")
    public ResponseEntity<?> getUser(){
        List<UsuarioModel> listUSer = usuarioRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listUSer);
    }

    @PostMapping(value = "/post")
    public ResponseEntity<?> postUser(@RequestBody UsuarioDTO usuarioDTO){
        UsuarioModel usuarioModel = new UsuarioModel();
        try{
            usuarioModel.setNome(usuarioDTO.nome());
            usuarioModel.setEmail(usuarioDTO.email());
            usuarioModel.setSenha(usuarioDTO.senha());
        }catch(Exception e){
            System.out.println("Error ao salvar usuario: " + e);
        }
        usuarioRepository.save(usuarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioModel);
    }
}
