package com.xiaomo.timeMachine.core.dao.base;

import com.xiaomo.timeMachine.core.entity.base.BaseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CommonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public <T extends BaseEntity> T get(Class<T> type, long id) {
        return entityManager.find(type, id);
    }

    public <T extends BaseEntity> T update(T entity) {
        return entityManager.merge(entity);
    }

    public <T extends BaseEntity> void save(T entity) {
        entityManager.persist(entity);
    }

    public <T extends BaseEntity> void delete(T entity) {
        entityManager.remove(entity);
    }

    public <T extends BaseEntity> List<T> getAll(Class<? extends BaseEntity> tableClass) {
        Query query = entityManager.createQuery("from " + tableClass.getSimpleName());
        return query.getResultList();
    }
}
