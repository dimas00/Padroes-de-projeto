package br.ufsm.politecnico.csi.pp.parte1.exercicio7;

import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JSONGenerator {

    public String getJSON(Object obj) {
        return getJSON(obj, "\t");
    }

    @SneakyThrows
    private String getJSON(Object obj, String tab) {
        if (obj == null) {
            return "null";
        }
        StringBuffer sb = new StringBuffer();
        sb.append("{\n");
        Class classe = obj.getClass();
        for (Method method : classe.getMethods()) {
            if ((method.getName().startsWith("get") ||
                    method.getName().startsWith("is")) &&
                    method.getAnnotation(JSON.class) != null &&
                    method.getParameterCount() == 0)
            {
                String name = method.getName().substring(3);
                name = name.substring(0, 1).toLowerCase() + name.substring(1);
                sb.append(tab + "\"").append(name).append("\": ");
                String value = getJSONValue(method.invoke(obj), tab);
                sb.append(value).append(",\n");
            }
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.append(tab + "}");
        return sb.toString();
    }

    private String getJSONValue(Object obj, String tab) {
        String strValue = "";
        if (obj instanceof String) {
            strValue = "\"" + obj + "\"";
        } else if (obj instanceof Number) {
            strValue = obj.toString();
        } else if (obj instanceof Collection) {
            strValue = "[";
            for (Object o : (Collection) obj) {
                strValue += getJSONValue(o, tab) + ", ";
            }
            strValue = strValue.substring(0, strValue.length() - 2);
            strValue += "]";
        } else {
            tab += "\t";
            strValue = getJSON(obj, tab);
        }
        return strValue;
    }

    public static void main(String[] args) {
        JSONGenerator json = new JSONGenerator();
        ClasseExemplo exemplo = new ClasseExemplo();
        exemplo.setCpf("123.456.789");
        exemplo.setId(1);
        exemplo.setNome("Nome");
        exemplo.setSaldo(0.0);
        exemplo.setChaves(new ArrayList<>());
        List<String> s1 = new ArrayList<>();
        s1.add("s1");
        List<String> s2 = new ArrayList<>();
        s2.add("s2");
        List<String> s3 = new ArrayList<>();
        s3.add("s3");
        List<String> s4 = new ArrayList<>();
        s4.add("s4");
        exemplo.getChaves().add(s1);
        exemplo.getChaves().add(s2);
        exemplo.getChaves().add(s3);
        exemplo.getChaves().add(s4);
        OutraClasse outraClasse = new OutraClasse();
        outraClasse.setChave("chave");
        outraClasse.setDescricao("descricao");
        outraClasse.setCodigo(3);
        exemplo.setOutraClasse(outraClasse);
        System.out.println(json.getJSON(exemplo));
        // {
        //  "id": 1,
        //  "cpf": "123.456.789",
        //  "nome": "Nome",
    //      "saldo": 0.0
        // }
    }

}
