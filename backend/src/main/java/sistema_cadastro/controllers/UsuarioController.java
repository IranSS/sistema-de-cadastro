package sistema_cadastro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sistema_cadastro.model.UsuarioDTO;
import sistema_cadastro.model.UsuarioModel;
import sistema_cadastro.repository.UsuarioRepository;

@CrossOrigin(origins = "http://localhost:9090", allowCredentials = "true")
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
        }catch(Exception e){
            System.out.println("Error ao salvar usuario: " + e);
        }
        usuarioRepository.save(usuarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioModel);
    }
}
