package br.com.casadocodigo.configuracao.validacao.annotation.unico;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UnicoValidator implements ConstraintValidator<UnicoValid, Object> {

    private String atributo;
    private Class<?> classe;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(UnicoValid unicoValid) {
        atributo = unicoValid.atributo();
        classe = unicoValid.classe();
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery("select 1 from " + classe.getName() + " where " + atributo + "=:value");
        query.setParameter("value", obj);
        List<?> list = query.getResultList();
        return list.isEmpty();
    }

}
