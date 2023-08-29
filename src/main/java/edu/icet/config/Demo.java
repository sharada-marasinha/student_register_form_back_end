package edu.icet.config;
import java.util.*;
class Customer implements Comparable<Customer>{
    int code;
    String name;
    Customer(int code, String name){
        this.code=code;
        this.name=name;
    }
    public String toString(){
        return code+"-"+name;
    }
    public int hashCode(){
        System.out.println("hashCode..: "+code);
        return code;
    }
    public boolean equals(Object obj){
        System.out.println("equals..: "+code);
        return obj instanceof Customer ? ((Customer)obj).code==this.code: false;
    }

    @Override
    public int compareTo(Customer o) {
        return 0;
    }
}
class Demo {
    public static void main(String[] args) {
        TreeSet <Customer>customerSet=new TreeSet<>();
        customerSet.add(new Customer(1001,"Danapala"));
        customerSet.add(new Customer(1002,"Gunapala"));
        customerSet.add(new Customer(1003,"Somapala"));
        customerSet.add(new Customer(1004,"Siripala"));
        customerSet.add(new Customer(1005,"Amarapala"));
        System.out.println(customerSet);
    }
}