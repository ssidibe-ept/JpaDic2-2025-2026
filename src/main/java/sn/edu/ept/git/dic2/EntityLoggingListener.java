package sn.edu.ept.git.dic2;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;

import java.lang.reflect.Field;
import java.util.logging.Logger;

public class EntityLoggingListener {

    @PrePersist
    public void onCreate(Object object) throws NoSuchFieldException {
        if(object!=null) {
            Logger logger = Logger.getLogger(object.getClass().getName());
            logger.info("enregistrement de " + object);
        }
    }

    @PreUpdate
    public void onUpdate(Object object){
        if(object!=null) {
            Logger logger = Logger.getLogger(object.getClass().getName());
            logger.warning("update" + object);
        }
    }

    @PreRemove
    public void onDelete(Object object){
        if(object!=null) {
            Logger logger = Logger.getLogger(object.getClass().getName());
            logger.warning("suppression" + object);
        }
    }


}
