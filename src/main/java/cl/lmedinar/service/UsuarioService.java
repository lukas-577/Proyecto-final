package cl.lmedinar.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cl.lmedinar.service.UsuarioService;
import cl.lmedinar.service.utils.UtileriaDeArchivos;
import cl.lmedinar.model.dao.UsuarioDao;
import cl.lmedinar.model.dto.UsuarioDto;
import cl.lmedinar.model.entity.Usuario;

@Service
public class UsuarioService {
    
    private Logger logger = LoggerFactory.getLogger(UsuarioService.class);
    
    @Autowired
    private UsuarioDao dao;

    public UsuarioDto registrarUsuario(Usuario usuario) {
        UsuarioDto usuarioDto = new UsuarioDto();
        
        Usuario usuarioEnBase = dao.findByEmail(usuario.getEmail()).orElse(null);
        
        if(usuarioEnBase != null) {
            usuarioDto.setUsuario(usuarioEnBase);
            logger.warn("El usuario que desea ingresar ya existe");
        }else {
            usuarioDto.setUsuario(dao.save(usuario));
        }
        
        return usuarioDto;
    }
    
    public UsuarioDto llenarUsuarios() {
        UsuarioDto usuarioDto = new UsuarioDto(new Usuario(), dao.findAll());

        return usuarioDto;
    }
    //funcinalidad de subir fotos
    
    
    @Autowired
    private UtileriaDeArchivos archivos;
    
    public List<Usuario> obtenerTodos(){
        return dao.findAll();
    }
    
    public Usuario ingresar(Usuario usuario, MultipartFile archivo) {
        logger.info("Ingresando al usuario: " + usuario.toString());
        String nombreArchivo = archivos.subirArchivo(archivo);
        usuario.setUrlImagen(nombreArchivo);
        usuario.setId(null);
        return dao.save(usuario);
    }
    
    public Usuario buscar(Integer id) {
        return dao.findById(id).orElse(null);    
    }
    
    public Usuario eliminar(Usuario usuario) {
        String nombreArchivo = usuario.getUrlImagen();
        boolean Archivoeliminado = archivos.eliminarArchivoPorNombre(nombreArchivo);

        if(!Archivoeliminado) {
            logger.error("El archivo: " + nombreArchivo + " no pudo ser eliminado.");
        }
        
        dao.delete(usuario);
        
        return usuario;
    }

    public Usuario actualizar(Usuario usuario) {
        return dao.save(usuario);
    }

    public Usuario actualizar(Usuario usuario, MultipartFile archivo) {
        Usuario usuarioAnterior = dao.findById(usuario.getId()).orElse(null);
        // eliminamos la imagen anterior
        archivos.eliminarArchivoPorNombre(usuarioAnterior.getUrlImagen());
        // subimos la nueva
        String nombreArchivo = archivos.subirArchivo(archivo);
        // actualizamos el registro en la base de datos
        usuario.setUrlImagen(nombreArchivo);

        return dao.save(usuario);
    }
    
    
}




















