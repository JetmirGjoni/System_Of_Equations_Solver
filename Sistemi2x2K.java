import javax.swing.*;

public class Sistemi2x2K {

    public  String sistemi = "ax + by = e \n   cx + dy = f";
    //Metoda qe e merr numrin e shifrave te saktesis
    public int saktesia(){
        Sistemi2x2K zgj = new Sistemi2x2K();
        int b = 0;
        try {
            b = Integer.parseInt(JOptionPane.showInputDialog("Shifrat e saktesise ;\nNumer i plote pozitiv :"));
            if(b<=0){
                zgj.saktesia();
            }
        }   catch (NumberFormatException | NullPointerException e){
            System.out.println("Vlere e gabuar e hyrjes ; " + e);
            System.exit(0);
        }
        return b;
    }

    //Metoda per cungimin e numrit
    public Double cungo(double x,int saktesia)
    {
        double r = 0;
        String vleraCunguar;
        String vlera = x+"";
        try {
            if (vlera.length() < saktesia)
                saktesia = vlera.length();
            vleraCunguar = vlera.substring(0, saktesia);
            r=Double.parseDouble(vleraCunguar);
        } catch (NumberFormatException e) {
            System.out.println("Sistemi i ekuacioneve nuk ka zgjidhje .");
            System.exit(0);
        }
        return r;
    }
    //Metoda per gjetjen e x
    public double x(double a,double b,double e,double y,int saktesia){
        double x = (e-b*y)/a ;
        return this.cungo(x,saktesia);
    }
    //Metoda per gjetjen e y
    public double y(double f1 , double d1,int saktesia){
        double y =  f1/d1;
        return this.cungo(y,saktesia);
    }

    //Input x=a,b,e,c,d,f
    public double Input(String x,int saktesia){
        Sistemi2x2K zgj = new Sistemi2x2K();
        double a= 0;
        try {
            a = Double.parseDouble(JOptionPane.showInputDialog("Vlera e '"+x+"' (a ≠ 0)   \n   " + sistemi));
            if (a == 0) {
                zgj.Input(x,saktesia);
            }
        } catch (NumberFormatException  | NullPointerException e) {
            System.out.println("Vlere e gabuar e hyrjes ; " + e);
            System.exit(0);
        }

        return this.cungo(a,saktesia-1);
    }

    public double m(double a, double c, int saktesia){
        double m =  c/a ;
        return this.cungo(m,saktesia);
    }

    public double d1(double b , double d , double m, int saktesia){
        double d1 =  d-(m*b);
        return this.cungo(d1,saktesia);
    }

    public double f1(double f , double e ,double m, int saktesia){
        double f1 =f-(m*e);
        return this.cungo(f1,saktesia);
    }


    public double calc_det(double a, double b, double c, double d){
        return a*d-b*c;
    }


    public static void main(String[] args) {

        Sistemi2x2K zgj = new Sistemi2x2K();

        int saktesia = (zgj.saktesia()+1);
        double a =  zgj.Input("a",saktesia);
        double b =  zgj.Input("b",saktesia);
        double e =  zgj.Input("e",saktesia);
        double c =  zgj.Input("c",saktesia);
        double d =  zgj.Input("d",saktesia);
        double f =  zgj.Input("f",saktesia);
        String sistemiFresh = a+"x + "+b+"y = "+ e +"\n" + c+"x + "+d+"y = "+f;

        System.out.println(sistemiFresh);
        double m = zgj.m(a,c,saktesia);
        double f1= zgj.f1(f,e,m,saktesia);
        double d1 = zgj.d1(b,d,m,saktesia);
        double y = zgj.y(f1,d1,saktesia);
        double x = zgj.x(a,b,e,y,saktesia);

        double D=zgj.calc_det(a,b,c,d);
        double D_x=zgj.calc_det(e,b,f,d);
        double D_y=zgj.calc_det(a,e,c,f);

        if (D!=0)
        {
            System.out.println("Sistemi i ekuacioneve ka nje zgjidhje te vetme : x = " + x + "  ∧  y = "+ y + " . Me saktesi " + (saktesia-1) + ".");
        }
        else
        {
            if (D_x==0&&D_y==0)
            {
                System.out.println("Sistemi i ekuacioneve ka pafund zgjidhje : ∀x,y∈R");
            }

        }
    }
}