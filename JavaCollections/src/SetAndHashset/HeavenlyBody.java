package SetAndHashset;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author cristiandrincu
 */
//A class that is declared final cannot be subclassed
public final class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> sattelites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.sattelites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }
    
    public boolean addMoon(HeavenlyBody moon) {
        return this.sattelites.add(moon);
    }

    public Set<HeavenlyBody> getSattelites() {
        return new HashSet<>(this.sattelites);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        
        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);               
    }
    
    @Override
    public int hashCode() {
        System.out.println("hashcode called");
        return this.name.hashCode() + 57;
    }
        
}
