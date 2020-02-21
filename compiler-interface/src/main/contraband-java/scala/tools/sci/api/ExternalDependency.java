/**
 * This code is generated using [[http://www.scala-sbt.org/contraband/ sbt-contraband]].
 */

// DO NOT EDIT MANUALLY
package scala.tools.sci.api;
public final class ExternalDependency implements java.io.Serializable {
    
    public static ExternalDependency create(String _sourceClassName, String _targetProductClassName, scala.tools.sci.api.AnalyzedClass _targetClass, scala.tools.sci.api.DependencyContext _context) {
        return new ExternalDependency(_sourceClassName, _targetProductClassName, _targetClass, _context);
    }
    public static ExternalDependency of(String _sourceClassName, String _targetProductClassName, scala.tools.sci.api.AnalyzedClass _targetClass, scala.tools.sci.api.DependencyContext _context) {
        return new ExternalDependency(_sourceClassName, _targetProductClassName, _targetClass, _context);
    }
    private String sourceClassName;
    private String targetProductClassName;
    private scala.tools.sci.api.AnalyzedClass targetClass;
    private scala.tools.sci.api.DependencyContext context;
    protected ExternalDependency(String _sourceClassName, String _targetProductClassName, scala.tools.sci.api.AnalyzedClass _targetClass, scala.tools.sci.api.DependencyContext _context) {
        super();
        sourceClassName = _sourceClassName;
        targetProductClassName = _targetProductClassName;
        targetClass = _targetClass;
        context = _context;
    }
    
    public String sourceClassName() {
        return this.sourceClassName;
    }
    public String targetProductClassName() {
        return this.targetProductClassName;
    }
    public scala.tools.sci.api.AnalyzedClass targetClass() {
        return this.targetClass;
    }
    public scala.tools.sci.api.DependencyContext context() {
        return this.context;
    }
    public ExternalDependency withSourceClassName(String sourceClassName) {
        return new ExternalDependency(sourceClassName, targetProductClassName, targetClass, context);
    }
    public ExternalDependency withTargetProductClassName(String targetProductClassName) {
        return new ExternalDependency(sourceClassName, targetProductClassName, targetClass, context);
    }
    public ExternalDependency withTargetClass(scala.tools.sci.api.AnalyzedClass targetClass) {
        return new ExternalDependency(sourceClassName, targetProductClassName, targetClass, context);
    }
    public ExternalDependency withContext(scala.tools.sci.api.DependencyContext context) {
        return new ExternalDependency(sourceClassName, targetProductClassName, targetClass, context);
    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof ExternalDependency)) {
            return false;
        } else {
            ExternalDependency o = (ExternalDependency)obj;
            return this.sourceClassName().equals(o.sourceClassName()) && this.targetProductClassName().equals(o.targetProductClassName()) && this.targetClass().equals(o.targetClass()) && this.context().equals(o.context());
        }
    }
    public int hashCode() {
        return 37 * (37 * (37 * (37 * (37 * (17 + "scala.tools.sci.api.ExternalDependency".hashCode()) + sourceClassName().hashCode()) + targetProductClassName().hashCode()) + targetClass().hashCode()) + context().hashCode());
    }
    public String toString() {
        return "ExternalDependency("  + "sourceClassName: " + sourceClassName() + ", " + "targetProductClassName: " + targetProductClassName() + ", " + "targetClass: " + targetClass() + ", " + "context: " + context() + ")";
    }
}
