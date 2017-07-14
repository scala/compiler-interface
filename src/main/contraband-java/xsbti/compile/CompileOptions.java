/**
 * This code is generated using [[http://www.scala-sbt.org/contraband/ sbt-contraband]].
 */

// DO NOT EDIT MANUALLY
package xsbti.compile;
/** Compilation options */
public final class CompileOptions implements java.io.Serializable {
    
    /**
     * The classpath to use for compilation.
     * This will be modified according to the ClasspathOptions used to configure the ScalaCompiler.
     */
    private java.io.File[] classpath;
    /**
     * All sources that should be recompiled.
     * This should include Scala and Java sources, which are identified by their extension.
     */
    private java.io.File[] sources;
    private java.io.File classesDirectory;
    /** The options to pass to the Scala compiler other than the sources and classpath to use. */
    private String[] scalacOptions;
    /** The options to pass to the Java compiler other than the sources and classpath to use. */
    private String[] javacOptions;
    private int maxErrors;
    private xsbti.F1<xsbti.Position, xsbti.Position> sourcePositionMapper;
    /** Controls the order in which Java and Scala sources are compiled. */
    private xsbti.compile.CompileOrder order;
    public CompileOptions() {
        super();
        classpath = new java.io.File[0];
        sources = new java.io.File[0];
        classesDirectory = new java.io.File("classes");
        scalacOptions = new String[0];
        javacOptions = new String[0];
        maxErrors = 100;
        sourcePositionMapper = new xsbti.F1<xsbti.Position, xsbti.Position>() { public xsbti.Position apply(xsbti.Position a) { return a; } };
        order = xsbti.compile.CompileOrder.Mixed;
    }
    public CompileOptions(java.io.File[] _classpath, java.io.File[] _sources, java.io.File _classesDirectory, String[] _scalacOptions, String[] _javacOptions, int _maxErrors, xsbti.F1<xsbti.Position, xsbti.Position> _sourcePositionMapper, xsbti.compile.CompileOrder _order) {
        super();
        classpath = _classpath;
        sources = _sources;
        classesDirectory = _classesDirectory;
        scalacOptions = _scalacOptions;
        javacOptions = _javacOptions;
        maxErrors = _maxErrors;
        sourcePositionMapper = _sourcePositionMapper;
        order = _order;
    }
    public java.io.File[] classpath() {
        return this.classpath;
    }
    public java.io.File[] sources() {
        return this.sources;
    }
    public java.io.File classesDirectory() {
        return this.classesDirectory;
    }
    public String[] scalacOptions() {
        return this.scalacOptions;
    }
    public String[] javacOptions() {
        return this.javacOptions;
    }
    public int maxErrors() {
        return this.maxErrors;
    }
    public xsbti.F1<xsbti.Position, xsbti.Position> sourcePositionMapper() {
        return this.sourcePositionMapper;
    }
    public xsbti.compile.CompileOrder order() {
        return this.order;
    }
    public CompileOptions withClasspath(java.io.File[] classpath) {
        return new CompileOptions(classpath, sources, classesDirectory, scalacOptions, javacOptions, maxErrors, sourcePositionMapper, order);
    }
    public CompileOptions withSources(java.io.File[] sources) {
        return new CompileOptions(classpath, sources, classesDirectory, scalacOptions, javacOptions, maxErrors, sourcePositionMapper, order);
    }
    public CompileOptions withClassesDirectory(java.io.File classesDirectory) {
        return new CompileOptions(classpath, sources, classesDirectory, scalacOptions, javacOptions, maxErrors, sourcePositionMapper, order);
    }
    public CompileOptions withScalacOptions(String[] scalacOptions) {
        return new CompileOptions(classpath, sources, classesDirectory, scalacOptions, javacOptions, maxErrors, sourcePositionMapper, order);
    }
    public CompileOptions withJavacOptions(String[] javacOptions) {
        return new CompileOptions(classpath, sources, classesDirectory, scalacOptions, javacOptions, maxErrors, sourcePositionMapper, order);
    }
    public CompileOptions withMaxErrors(int maxErrors) {
        return new CompileOptions(classpath, sources, classesDirectory, scalacOptions, javacOptions, maxErrors, sourcePositionMapper, order);
    }
    public CompileOptions withSourcePositionMapper(xsbti.F1<xsbti.Position, xsbti.Position> sourcePositionMapper) {
        return new CompileOptions(classpath, sources, classesDirectory, scalacOptions, javacOptions, maxErrors, sourcePositionMapper, order);
    }
    public CompileOptions withOrder(xsbti.compile.CompileOrder order) {
        return new CompileOptions(classpath, sources, classesDirectory, scalacOptions, javacOptions, maxErrors, sourcePositionMapper, order);
    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof CompileOptions)) {
            return false;
        } else {
            CompileOptions o = (CompileOptions)obj;
            return java.util.Arrays.deepEquals(classpath(), o.classpath()) && java.util.Arrays.deepEquals(sources(), o.sources()) && classesDirectory().equals(o.classesDirectory()) && java.util.Arrays.deepEquals(scalacOptions(), o.scalacOptions()) && java.util.Arrays.deepEquals(javacOptions(), o.javacOptions()) && (maxErrors() == o.maxErrors()) && sourcePositionMapper().equals(o.sourcePositionMapper()) && order().equals(o.order());
        }
    }
    public int hashCode() {
        return 37 * (37 * (37 * (37 * (37 * (37 * (37 * (37 * (37 * (17 + "CompileOptions".hashCode()) + classpath().hashCode()) + sources().hashCode()) + classesDirectory().hashCode()) + scalacOptions().hashCode()) + javacOptions().hashCode()) + (new Integer(maxErrors())).hashCode()) + sourcePositionMapper().hashCode()) + order().hashCode());
    }
    public String toString() {
        return "CompileOptions("  + "classpath: " + classpath() + ", " + "sources: " + sources() + ", " + "classesDirectory: " + classesDirectory() + ", " + "scalacOptions: " + scalacOptions() + ", " + "javacOptions: " + javacOptions() + ", " + "maxErrors: " + maxErrors() + ", " + "sourcePositionMapper: " + sourcePositionMapper() + ", " + "order: " + order() + ")";
    }
}
