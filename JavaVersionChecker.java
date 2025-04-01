/**
 * A simple Java script to print the Java version information.
 * This helps verify which JDK version is being used.
 */
public class JavaVersionChecker {
    public static void main(String[] args) {
        // Get Java version
        String version = System.getProperty("java.version");
        String runtimeName = System.getProperty("java.runtime.name");
        String vmName = System.getProperty("java.vm.name");
        String vmVersion = System.getProperty("java.vm.version");
        String vendor = System.getProperty("java.vendor");
        String home = System.getProperty("java.home");

        // Print detailed Java information
        System.out.println("=== Java Version Information ===");
        System.out.println("Java Version: " + version);
        System.out.println("Runtime Name: " + runtimeName);
        System.out.println("VM Name: " + vmName);
        System.out.println("VM Version: " + vmVersion);
        System.out.println("Vendor: " + vendor);
        System.out.println("Java Home: " + home);

        // Print Java version as typically displayed by java -version
        System.out.println("\n=== Java Version String ===");
        System.out.println(System.getProperty("java.version") + " from " + System.getProperty("java.vendor"));

        // Print Java major version
        String[] versionElements = version.split("\\.");
        String majorVersion = versionElements[0];
        // For Java 9+ the major version is the first element
        // For Java 1.8 and below, the major version is the second element
        if (majorVersion.equals("1")) {
            majorVersion = versionElements.length > 1 ? versionElements[1] : "0";
        }
        System.out.println("\nJava Major Version: " + majorVersion);
    }
}