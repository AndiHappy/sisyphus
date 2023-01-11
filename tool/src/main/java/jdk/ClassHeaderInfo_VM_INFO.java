package jdk;

import org.openjdk.jol.vm.VM;

public class ClassHeaderInfo_VM_INFO {
    public static void main(String[] args) {
        System.out.println(VM.current().details());
    }
}
