package project1;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("resources")
public class GenericApplication extends Application {
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();

        // Register root resources.
        classes.add(GenericResource.class21);
		//Adding new class1

        // Register provider classes.

        return classes;
    }
	
	public Set<Class<?>> getClasses1() {
        Set<Class<?>> classes = new HashSet<Class<?>>();

        // Register root resources.
        classes.add(GenericResource.class);

        // Register provider classes.

        return classes;
    }
}
