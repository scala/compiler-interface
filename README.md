Compiler Interface
==================

Compiler Interface is an internal implementation of Zinc,
used as a binary contract (written in Java) between Zinc and Scala Compilers.
All details are subject to change.

### about compiler bridges

An implementation of a compiler interface specific to a Scala version is called a compiler bridge.
A build tool is responsible for locating a compiler bridge to use Zinc.

### License

Copyright 2011 - 2019, Lightbend, Inc.
Copyright 2008 - 2010, Mark Harrah
Licensed under Apache v2 license (see LICENSE)
