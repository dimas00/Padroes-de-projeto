package br.ufsm.politecnico.csi.pp.parte1.exercicio8;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ValidatorFramework {

    public List<String> validate(Object object) {
        List<String> erros = new ArrayList<>();
        if (object.getClass().getAnnotation(Validate.class) == null) {
            return erros;
        }
        //façam!
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            //field.getA
        }
        return erros;
    }
}
