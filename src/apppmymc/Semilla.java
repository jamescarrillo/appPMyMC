/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apppmymc;

/**
 *
 * @author JhanxD
 */
public class Semilla {
    
    private int x0;
    private int x1;
    private float r;

    public Semilla() {
    }

    public Semilla(int x0, int x1, float r) {
        this.x0 = x0;
        this.x1 = x1;
        this.r=r;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }
    
    public int getX0() {
        return x0;
    }

    public void setX0(int x0) {
        this.x0 = x0;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }
    
}
