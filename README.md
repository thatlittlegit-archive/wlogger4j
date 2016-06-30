# wLogger4j
### Because Apache Log4j never seems to work... :-1:
wLogger4j is a simplistic version of Log4j. It's not extremely customizable
(yet), but it's just what's necessary for a simple program.
## Usage
This program will log with every level available.
```java
import wlogga4j.Logger;

public class Example {
    /*
     Create a logger instance.
     Will output "Hello, World!", with level INFO on September 22nd 2013 at
     8:00:01, as:
     [22/09/2013][8:00:01][ExampleProgram/INFO] Hello, World!
    */
    static final LOGGER = new Logger("ExampleProgram");

    public static void main(String args[]) {
        LOGGER.log(Level.INFO, "Hello, World!"); // Level INFO
        LOGGER.trace("Hello, World!"); // Level TRACE
        LOGGER.debug("Hello, World!"); // Level DEBUG
        LOGGER.finer("Hello, World!"); // Level FINER
        LOGGER.fine("Hello, World!"); // Level FINE
        LOGGER.info("Hello, World!"); // Level INFO
        LOGGER.warn("Hello, World!"); // Level WARN
        LOGGER.error("Hello, World!"); // Level ERROR
        LOGGER.fatal("Hello, World!"); // Level FATAL D:
    }
}
```