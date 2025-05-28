package br.ufsm.politecnico.csi.pp;

public class Main {

    public static void main(String[] args) {
        String s1 = "1";
        String s2 = "2";
        String s3 = s1;
        s1 += "2";
        //System.out.println(s3);
        //System.out.println(s1);
        long n1 = 1l;
        long n2 = 2l;
        long n3 = n1;
        n1 = n2 + n3;
        System.out.println(n1);
        System.out.println(n3);
        String nome1 = "fulano";
        String nome2 = "fulano";
        System.out.println(nome1.equals(nome2));
    }

}
