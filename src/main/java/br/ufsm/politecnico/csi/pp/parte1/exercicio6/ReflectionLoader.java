package br.ufsm.politecnico.csi.pp.parte1.exercicio6;

import lombok.SneakyThrows;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ReflectionLoader {
    @SneakyThrows
    public static void main(String[] args) {
        JFileChooser jfc = new JFileChooser(new File(System.getProperty("user.dir")));
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfc.setMultiSelectionEnabled(false);
        jfc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".jar");
            }

            @Override
            public String getDescription() {
                return "JAR File";
            }
        });
        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();
            JarFile jarFile = new JarFile(file);
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                if (entry.getName().toLowerCase().endsWith(".class")) {
                    String className = entry.getName().replace("/", ".").substring(0, entry.getName().length() - 6);
                    if (className.contains("exercicio2")) {
                        Class classe = Class.forName(className);
                        System.out.println(classe);
                        for (Method m : classe.getMethods()) {
                            System.out.println("\tMetodo -> " + m);
                        }
                        for (Field f : classe.getFields()) {
                            System.out.println("\tField -> " + f);
                        }
                        if (className.endsWith("Banco")) {
                            Object o = classe.newInstance();
                            for (Method m : classe.getMethods()) {
                                try {
                                    m.invoke(o);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
