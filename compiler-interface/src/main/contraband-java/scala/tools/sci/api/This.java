/**
 * This code is generated using [[http://www.scala-sbt.org/contraband/ sbt-contraband]].
 */

// DO NOT EDIT MANUALLY
package scala.tools.sci.api;
public final class This extends scala.tools.sci.api.PathComponent {
    
    public static This create() {
        return new This();
    }
    public static This of() {
        return new This();
    }
    
    protected This() {
        super();
        
    }
    
    
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof This)) {
            return false;
        } else {
            This o = (This)obj;
            return true;
        }
    }
    public int hashCode() {
        return 37 * (17 + "scala.tools.sci.api.This".hashCode());
    }
    public String toString() {
        return "This("  + ")";
    }
}
