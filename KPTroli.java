import java.util.Scanner;

public class KPTroli{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int i,n,m;

        System.out.print("jumlah Buah : ");
        n = input.nextInt();
        System.out.print("Kapasitas Troli : ");
        m = input.nextInt();

        String [] namaBuah = new String[n];
        float [] profit = new float[n];
        float [] weight = new float[n];
        float[] PW = new float[n];
        float[] x = new float[n];

        System.out.println("\nInput Buah");
        for(i=0; i<profit.length; i++){
            System.out.print(" -Buah "+(i+1)+" : ");
            namaBuah[i] = input.next();
        }

        System.out.println("\nInput Profit");
        for(i=0; i<profit.length; i++){
            System.out.print(" -profit "+namaBuah[i]+" : ");
            profit[i]= input.nextInt();
        }

        System.out.println("\nInput Bobot Buah (Kg)");
        for(i=0; i<weight.length; i++){
            System.out.print(" -Buah "+namaBuah[i]+" : ");
            weight[i]= input.nextInt();
        }
        System.out.println("\n");

        for(i=0; i<PW.length; i++){
            PW[i] = (profit[i] / weight[i]);
        }
        
        float bobot=0, sisa;
        float XiPi = 0;
        
        boolean cekloop = true;

        do{
            //menentukan nilai terbesar
            float max = 0;
            int xi = 0;
            float cek = 0; 
            for(i=0; i<PW.length; i++){
                if(PW[i]>max){
                    max = PW[i];
                    xi = i; 
                }
                cek = cek+PW[i];
            }

            if(cek == 0){
                cekloop = false;
                profit[xi] = 0;
                weight[xi] = 0;
            }

            PW[xi] = 0;

            if((weight[xi] + bobot) <= m){
                x[xi] = 1;
                XiPi = XiPi + (x[xi] * profit[xi]);
                bobot = bobot + weight[xi];
            }
            
            else{
                sisa = m - bobot;
                x[xi] = sisa / weight[xi];
                XiPi = XiPi + (x[xi] * profit[xi]);
                bobot = bobot + (x[xi] * weight[xi]);
            }
            
            if(cek!= 0){
                System.out.println("Buah "+namaBuah[xi] +" "+ (x[xi] * weight[xi])+" Kg masuk");
            }
            

        }while(bobot < m && cekloop);

        Float persentase = (((m - bobot)/m)*100);
        System.out.println("\n\nMax profit adalah : " + XiPi);
        System.out.println("kapasitas sisa : "+(m - bobot) +" ("+persentase+"%)");
        System.out.println("\n\n\n");
    }
}