package model.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.entidad.Usuario;

@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "PUDocVG")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario iniciarSesion(Usuario usu){
        Usuario usuario = null;
        String sql;
        try {
            sql ="SELECT u FROM Usuario u WHERE u.nomusu = ?1 and u.pwdusu=?2";
            Query query = em.createQuery(sql);
            query.setParameter(1, usu.getNomusu());
            query.setParameter(2,usu.getPwdusu());
            List<Usuario> lista = query.getResultList();
            if(!lista.isEmpty()){
                usuario = lista.get(0);
                System.out.println("Este es el usuario obtenido:" + usuario.getNomusu());
            }
        } catch (Exception e) {
            throw e;
        }
        // Sólo se usa en un EntityManagerFactory
        // it using dependency injection EJB y PersistentContext not
//        finally{
//            em.close();
//        }
        return usuario;
    }
}
