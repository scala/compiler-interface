/**
 * This code is generated using [[http://www.scala-sbt.org/contraband/ sbt-contraband]].
 */

// DO NOT EDIT MANUALLY
package scala.tools.sci.api;
public abstract class Qualifier implements java.io.Serializable {
    
    
    protected Qualifier() {
        super();
        
    }
    
    
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof Qualifier)) {
            return false;
        } else {
            Qualifier o = (Qualifier)obj;
            return true;
        }
    }
    public int hashCode() {
        return 37 * (17 + "scala.tools.sci.api.Qualifier".hashCode());
    }
    public String toString() {
        return "Qualifier("  + ")";
    }
}
