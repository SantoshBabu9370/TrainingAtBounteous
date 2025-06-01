import java.util.*;

public class MyCar {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] brands = {"Mahindra","Tata","Maruti"};
        System.out.println("Select Manufacturer:\n1.Mahindra\n2.Tata\n3.Maruti");
        int b = s.nextInt();
        if(b<1||b>3){System.out.println("Invalid");return;}
        String make = brands[b-1], model=null;

        if(make.equals("Mahindra")){
            String[] models = {"Scorpio","Thar","Scorpio N","XUV 700"};
            System.out.println("Choose Model:\n1.Scorpio\n2.Thar\n3.Scorpio N\n4.XUV 700");
            int m = s.nextInt();
            if(m<1||m>4){System.out.println("Invalid");return;}
            model = models[m-1];
        }

        String[] trans = {"Manual","Automatic"};
        System.out.println("Transmission:\n1.Manual\n2.Automatic");
        int t = s.nextInt();
        if(t<1||t>2){System.out.println("Invalid");return;}
        String tr = trans[t-1];

        String[] fuels = {"Diesel","Petrol","CNG"};
        System.out.println("Fuel Type:\n1.Diesel\n2.Petrol\n3.CNG");
        int f = s.nextInt();
        if(f<1||f>3){System.out.println("Invalid");return;}
        String fuel = fuels[f-1];

        String[] colors = {"Silver","Blue","Yellow"};
        System.out.println("Color:\n1.Silver\n2.Blue\n3.Yellow");
        int c = s.nextInt();
        if(c<1||c>3){System.out.println("Invalid");return;}
        String color = colors[c-1];

        String[] places = {"Delhi","Bangalore","Hyderabad","Chennai"};
        System.out.println("Location:\n1.Delhi\n2.Bangalore\n3.Hyderabad\n4.Chennai");
        int l = s.nextInt();
        if(l<1||l>4){System.out.println("Invalid");return;}
        String loc = places[l-1];

        System.out.println("\nYour Selection:");
        System.out.println("Brand:"+make);
        if(model!=null)System.out.println("Model:"+model);
        System.out.println("Transmission:"+tr);
        System.out.println("Fuel:"+fuel);
        System.out.println("Color:"+color);
        System.out.println("Location:"+loc);
    }
}
