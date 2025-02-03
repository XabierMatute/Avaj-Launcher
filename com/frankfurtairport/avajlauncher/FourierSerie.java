package com.frankfurtairport.avajlauncher;

// class FourierSerie wich will be used to get the value of a Fourier Serie with coefficients set in the constructor
class FourierSerie
{
    private double[] a;
    private double[] b;

    public FourierSerie(double[] p_a, double[] p_b)// TODO: checkear si los arreglos son del mismo tamaño o rellenar con 0
    {
        if (p_a.length == p_b.length)
        {
            this.a = p_a;
            this.b = p_b;
            return;
        }
        else if (p_a.length > p_b.length)
        {
            this.a = p_a;
            this.b = new double[p_a.length];
            for (int i = 0; i < p_b.length; i++)
            {
                this.b[i] = p_b[i];
            }
            for (int i = p_b.length; i < p_a.length; i++)
            {
                this.b[i] = 0;
            }
            return;
        }
        else
        {
            this.b = p_b;
            this.a = new double[p_b.length];
            for (int i = 0; i < p_a.length; i++)
            {
                this.a[i] = p_a[i];
            }
            for (int i = p_a.length; i < p_b.length; i++)
            {
                this.a[i] = 0;
            }
            return;
        }
    }

    public double getValue(double x)
    {
        double result = 0;
        for (int i = 0; i < this.a.length; i++)
        {
            int n = i + 1;
            // System.out.println("a[" + i + "] = " + this.a[i]);
            // System.out.println("b[" + i + "] = " + this.b[i]);
            // System.out.println("R[" + i + "] = " + (this.a[i] * Math.cos(i * x) + this.b[i] * Math.sin(i * x)) + " = " + this.a[i] + " * cos(" + i + " * " + x + ") + " + this.b[i] + " * sin(" + i + " * " + x + ")");
            result += this.a[i] * Math.cos(n * x * 2 * Math.PI) + this.b[i] * Math.sin(n * x * 2 * Math.PI);
        }
        return result;
    }
}