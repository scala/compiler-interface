/**
 * This code is generated using [[http://www.scala-sbt.org/contraband/ sbt-contraband]].
 */

// DO NOT EDIT MANUALLY
package scala.tools.sci.api;
public final class Public extends scala.tools.sci.api.Access {
    
    public static Public create() {
        return new Public();
    }
    public static Public of() {
        return new Public();
    }
    
    protected Public() {
        super();
        
    }
    
    
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof Public)) {
            return false;
        } else {
            Public o = (Public)obj;
            return true;
        }
    }
    public int hashCode() {
        return 37 * (17 + "scala.tools.sci.api.Public".hashCode());
    }
    public String toString() {
        return "Public("  + ")";
    }
}
