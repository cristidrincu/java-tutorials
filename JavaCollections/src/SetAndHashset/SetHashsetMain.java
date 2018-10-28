package SetAndHashset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author cristiandrincu
 */
public class SetHashsetMain {
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HeavenlyBody temp = new HeavenlyBody("Mercury", 80);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);
                
        temp = new HeavenlyBody("Venus", 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);
        
        temp = new HeavenlyBody("Earth", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);
        
        temp = new HeavenlyBody("Pluto", 248);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);
        
        HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);
        
        System.out.println("Planets");
        
        planets.forEach(planet -> {
            System.out.println("\t" + planet.getName());
        });
        
        HeavenlyBody earth = solarSystem.get("Earth");
        System.out.println("Moons of " + earth.getName());
        
        earth.getSattelites().forEach(sattelite -> {
            System.out.println("\t" + sattelite.getName());
        });
        
        Set<HeavenlyBody> moons = new HashSet<>();
        planets.forEach(planet -> {
           //addAll creates a set union
           //in set theory, a union of sets contains all the elements of the sets
           //because sets do not contain duplicates, each element in a union will only appear once,
           //even if it was present in more than one set
           moons.addAll(planet.getSattelites());
        });
        
        System.out.println("All Moons");
        moons.forEach(moon -> {
            System.out.println(moon.getName());
        });
        
        //duplicate will not be added if equals and hashcode are implemented in HeavenlyBody
        HeavenlyBody pluto = new HeavenlyBody("Pluto", 842);
        planets.add(pluto);
        
        planets.forEach(planet -> {
            System.out.println(planet.getName() + ": " + planet.getOrbitalPeriod());
        });
        
        Object o = new Object();
        o.equals(o);
        "pluto".equals("");
    }
    
}
