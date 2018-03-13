package org.spring.web.web5.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.spring.web.web5.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class AbstractHibernateDAO<T extends Serializable> {
    private Class< T > clazz;

    @PersistenceContext
    EntityManager entityManager;

    public final void setClazz( Class< T > clazzToSet ){
        this.clazz = clazzToSet;
    }

    public T findOne( long id ){
        return entityManager.find( clazz, id );
    }

    public T findOneiD(int id){
        return entityManager.find( clazz, id );
    }
    public List< T > findAll(){
        return entityManager.createQuery( "from " + clazz.getName() )
                .getResultList();
    }

    public void create( T entity ){
        //entityManager.persist( entity );
        entityManager.merge( entity );
        //entityManager.flush();

    }

    @Transactional
    public T update( T entity ){
        entity =  entityManager.merge( entity );
        entityManager.flush();
        return entity;

    }

    public void updateUs (User user){
        entityManager.createQuery("UPDATE User u SET u.name=:name, u.login=:login, u.password=:password WHERE u.id=:id")
                .setParameter("name", user.getName())
                .setParameter("login", user.getLogin())
                .setParameter("password", user.getPassword())
                .setParameter("id", user.getId())
                .executeUpdate();
    }

    public void delete( User user ){
        //entityManager.remove(entity);
        //entityManager.
        //entityManager.flush();
        entityManager.createQuery("DELETE User u WHERE u.id=:id")
                .setParameter("id", user.getId())
                .executeUpdate();



    }
    public void deleteById( long entityId ){
        User user = (User) findOne( entityId );
        delete( user );
    }

    public T findOneAnother (User entity){
        return (T)entityManager.createQuery("from " + clazz.getName() + "where " + entity ).getSingleResult();
    }
}
