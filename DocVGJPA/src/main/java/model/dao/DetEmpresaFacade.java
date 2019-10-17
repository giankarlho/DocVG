/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entidad.DetEmpresa;

/**
 *
 * @author Giancarlo
 */
@Stateless
public class DetEmpresaFacade extends AbstractFacade<DetEmpresa> {

    @PersistenceContext(unitName = "PUDocVG")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetEmpresaFacade() {
        super(DetEmpresa.class);
    }
    
}
