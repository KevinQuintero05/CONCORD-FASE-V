package com.concord.Controller;

import com.concord.Entity.Rol;
import com.concord.Entity.Usuario;
import com.concord.Repository.IRolRepository;
import com.concord.Repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @Autowired
    private IRolRepository iRolRepository;

    //Listar
    @GetMapping("/usuarios")
    public String GetUsuarios(Model model){
        try{
            List<Usuario> usuarios = iUsuarioRepository.findAll();
            model.addAttribute("usuarios",usuarios);
            return "Usuarios/Usuarios";
        } catch (Exception ex){
            return "Error";
        }
    }

    //CREAR
    @GetMapping("/usuarios/New")
    public String GetShowCreateUser(Model model){
        List<Rol> roles = iRolRepository.findAll();
        model.addAttribute("roles",roles);
        model.addAttribute("usuario",new Usuario());
        return  "Usuarios/Create";
    }

    //GUARDAR
    @PostMapping("/usuarios/save")
    public String saveUser(Usuario usuario){
        iUsuarioRepository.save(usuario);
        return "redirect:/Usuarios";
    }

    @GetMapping("usuarios/edit/{id}")
    public String showUpdateUsuarios(Model model, @PathVariable long id){
        Usuario usuariodb = iUsuarioRepository.findById(id).get();
        model.addAttribute("roles", iRolRepository.findAll());
        model.addAttribute("usuario",usuariodb);
        return "usuarios/edit";
    }

    @PostMapping("/usuarios/Update/{id}")
    public String updateUsuario(@PathVariable("id") long id,Usuario usuario,Model model){
        usuario.setIdusuario(id);
        iUsuarioRepository.save(usuario);
        return "redirect:/Usuarios";
    }

    @GetMapping("/usuarios/delete/{id}")
    public String deleteUsuario(Model model,@PathVariable long id){
        iUsuarioRepository.deleteById(id);
        return "redirect:/Usuarios";
    }
}
