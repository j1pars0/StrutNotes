/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.co.jamesrparsons.strutnotes.repository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author james
 */
public class StrutNotesDB {
    private final Logger LOG = LogManager.getLogger(StrutNotesDB.class);
    private static final String DB_PU = "StrutNotesDB";

    private static final StrutNotesDB singleton = new StrutNotesDB();

    private EntityManagerFactory emf;

    private StrutNotesDB() {}

    public static StrutNotesDB getInstance() {
        return singleton;
    }


    public EntityManagerFactory getEntityManagerFactory() {
        if(emf == null) {
            emf = Persistence.createEntityManagerFactory(DB_PU);
            LOG.debug("factory created on: " + new Date());
        }
        LOG.debug("factory obtained: " + new Date());
        return emf;
    }

    public void closeEmf() {
        if(emf.isOpen() || emf != null) {
            emf.close();
        }
        emf = null;
        LOG.debug("EMF closed at: " + new Date());
    }    
}
