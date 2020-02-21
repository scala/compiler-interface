/**
 * This code is generated using [[http://www.scala-sbt.org/contraband/ sbt-contraband]].
 */

// DO NOT EDIT MANUALLY
package scala.tools.sci.api;
public final class Structure extends scala.tools.sci.api.Type {
    
    public static Structure create(scala.tools.sci.api.Lazy<Type[]> _parents, scala.tools.sci.api.Lazy<ClassDefinition[]> _declared, scala.tools.sci.api.Lazy<ClassDefinition[]> _inherited) {
        return new Structure(_parents, _declared, _inherited);
    }
    public static Structure of(scala.tools.sci.api.Lazy<Type[]> _parents, scala.tools.sci.api.Lazy<ClassDefinition[]> _declared, scala.tools.sci.api.Lazy<ClassDefinition[]> _inherited) {
        return new Structure(_parents, _declared, _inherited);
    }
    private scala.tools.sci.api.Lazy<Type[]> parents;
    private scala.tools.sci.api.Lazy<ClassDefinition[]> declared;
    private scala.tools.sci.api.Lazy<ClassDefinition[]> inherited;
    protected Structure(scala.tools.sci.api.Lazy<Type[]> _parents, scala.tools.sci.api.Lazy<ClassDefinition[]> _declared, scala.tools.sci.api.Lazy<ClassDefinition[]> _inherited) {
        super();
        parents = _parents;
        declared = _declared;
        inherited = _inherited;
    }
    
    public Type[] parents() {
        return this.parents.get();
    }
    public ClassDefinition[] declared() {
        return this.declared.get();
    }
    public ClassDefinition[] inherited() {
        return this.inherited.get();
    }
    public Structure withParents(scala.tools.sci.api.Lazy<Type[]> parents) {
        return new Structure(parents, declared, inherited);
    }
    public Structure withDeclared(scala.tools.sci.api.Lazy<ClassDefinition[]> declared) {
        return new Structure(parents, declared, inherited);
    }
    public Structure withInherited(scala.tools.sci.api.Lazy<ClassDefinition[]> inherited) {
        return new Structure(parents, declared, inherited);
    }
    public boolean equals(Object obj) {
        return this == obj; // We have lazy members, so use object identity to avoid circularity.
    }
    public int hashCode() {
        return super.hashCode(); // Avoid evaluating lazy members in hashCode to avoid circularity.
    }
    public String toString() {
        return super.toString(); // Avoid evaluating lazy members in toString to avoid circularity.
    }
}
