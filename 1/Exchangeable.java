public interface Exchangeable{

public static final double EarthtoMars = 1.3;
public static final double EarthtoSaturn = .87; // Exchange rates can ONLY be changed here
public static final double EarthtoNeptune = 2.0;

public void exchange(Exchangeable other, double amount);

}
