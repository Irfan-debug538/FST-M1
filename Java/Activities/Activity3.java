
	public class Activity3 {

	    public static void main(String[] args) {
	        
	        long seconds = 1000000000L;


	        final long earthYearInSeconds = 31557600L;

	  
	        double earthAge = seconds / (double) earthYearInSeconds;

	        
	        double mercuryOrbitalPeriod = 0.2408467;
	        double venusOrbitalPeriod = 0.61519726;
	        double marsOrbitalPeriod = 1.8808158;
	        double jupiterOrbitalPeriod = 11.862615;
	        double saturnOrbitalPeriod = 29.447498;
	        double uranusOrbitalPeriod = 84.016846;
	        double neptuneOrbitalPeriod = 164.79132;


	        double mercuryAge = earthAge / mercuryOrbitalPeriod;
	        double venusAge = earthAge / venusOrbitalPeriod;
	        double marsAge = earthAge / marsOrbitalPeriod;
	        double jupiterAge = earthAge / jupiterOrbitalPeriod;
	        double saturnAge = earthAge / saturnOrbitalPeriod;
	        double uranusAge = earthAge / uranusOrbitalPeriod;
	        double neptuneAge = earthAge / neptuneOrbitalPeriod;

	      
	        System.out.println("Age in seconds: " + seconds);
	        System.out.println("Age on Earth: " + earthAge + " years");
	        System.out.println("Age on Mercury: " + mercuryAge + " years");
	        System.out.println("Age on Venus: " + venusAge + " years");
	        System.out.println("Age on Mars: " + marsAge + " years");
	        System.out.println("Age on Jupiter: " + jupiterAge + " years");
	        System.out.println("Age on Saturn: " + saturnAge + " years");
	        System.out.println("Age on Uranus: " + uranusAge + " years");
	        System.out.println("Age on Neptune: " + neptuneAge + " years");
	    }
	}



