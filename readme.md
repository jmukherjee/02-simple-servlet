#Tutorial - Servlet

##IntelliJ Steps
* File > New > Project
* Java Enterprise > Java EE 7 > Web Application checked & web.xml
* Select src & Add new Servlet with package
* Update web.xml for that Servlet

###Servlet LifeCycle
* Servlet class is _loaded_.
* Servlet instance is _created_.
* `init` method is invoked.
* `service` method is invoked.
* `destroy` method is invoked.

load -> instantiate -> init -> service -> destroy

###Ways to create Servlet
* By implementing Servlet interface
* By inheriting GenericServlet class
* By inheriting HttpServlet class (mostly used)