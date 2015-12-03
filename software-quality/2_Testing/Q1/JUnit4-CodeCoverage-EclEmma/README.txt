EclEmma Java Code Coverage for Eclipse 
============================================
http://www.eclemma.org/

Eclipse update site: http://update.eclemma.org/

EclEmma is a free Java code coverage tool for Eclipse, available under the 
Eclipse Public License. Internally it is based on the great EMMA  Java code 
coverage tool, trying to adopt EMMA's philosophy for the Eclipse workbench.

How to use it
--------------------------------------------------------------------------
Run the Test classes with:
 CoverageAs -> JUnit Test

FAQs
--------------------------------------------------------------------------
Why can't I select source folders separately for instrumentation?
EMMA works on Java class files. If source folders have the same output 
location, only all or none of them can be selected for instrumentation. 
If you want to select them individually please specify a different 
output location for each source folder. 
This can be done in the Java Build Path settings in the project properties. 
Check Allow output folders on the Source tab and specify different output 
folders for your source folders (for example bin-src/, bin-test/ etc.).  
