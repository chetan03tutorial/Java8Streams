import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Shipment {

    private double height;
    private double width;
    private double length;


    public Shipment(double height, double width, double length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public Double calculateVolume(){
        return height*width*length;
    }

    public Double calculateVolumeWithPf(double pf){
        return height*width*length*pf;
    }

    public static List<Double> calculateVolumes(List<Shipment> shipments, Function<Shipment,Double> f){
        List<Double> result = new ArrayList<>();
        for(Shipment s : shipments){
            result.add(f.apply(s));
        }
        return result;
    }

    public static List<Double> calculateVolumesWithPf(List<Shipment> shipments, BiFunction<Shipment,Double,Double> f){
        List<Double> result = new ArrayList<>();
        Double pf = Double.valueOf(0.8);
        for(Shipment s : shipments){
            result.add(f.apply(s,pf));
        }
        return result;
    }

    public static void main(String[] args) {
        Shipment[] shipments = {
                new Shipment(1.2,2.4,6.4),
                new Shipment(1,2,6)
        };

        calculateVolumes(Arrays.asList(shipments),(s)-> s.calculateVolume());

        calculateVolumes(Arrays.asList(shipments),Shipment::calculateVolume);

    }

}
