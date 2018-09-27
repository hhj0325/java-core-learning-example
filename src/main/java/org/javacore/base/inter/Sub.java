package org.javacore.base.inter;

/**
 * Created by huhaojian on 2018/9/11 0011.
 */
public class Sub extends Supper {

    private boolean man;

    public Sub() {
    }

    public boolean isMan() {
        return man;
    }

    public void setMan(boolean man) {
        this.man = man;
    }

    private class SubInner{

        boolean retRMan(){
            return !man;
        }

    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.nullRetAge();
        sub.protectedRetAge();
        sub.publicRetAge();

        Supper supper = new Supper();
        supper.nullRetAge();
        supper.protectedRetAge();
        supper.publicRetAge();

    }
}
