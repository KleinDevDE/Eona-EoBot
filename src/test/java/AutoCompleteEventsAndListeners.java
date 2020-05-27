import org.javacord.api.DiscordApiBuilder;
import org.reflections.Reflections;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

public class AutoCompleteEventsAndListeners {
    public static void insertEvents(String path) throws IOException {
        Class builder = DiscordApiBuilder.class;
        List<String> done = new ArrayList<>();
        for(Method m : builder.getMethods()){
            if (m.getName().startsWith("add") && !done.contains(m.getName())){
                String c = (m.getName().replace("add", ""));
                File file = new File(path+File.separator+"A"+c+".java");
                file.createNewFile();
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write("package de.eonadev.discord.eobot.api.listeners.discord;\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "public class A"+c+" implements "+c+" {\n" +
                        "}\n");
                fileWriter.flush();
                fileWriter.close();
                done.add(m.getName());
            }
        }

        done.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);
            }
        });
    }

    public static void insertListeners(String path) throws IOException, ClassNotFoundException, URISyntaxException {
        Class builder = DiscordApiBuilder.class;
        List<String> done = new ArrayList<>();
        HashMap<String, String> mappingsListener = new HashMap<>();
        HashMap<String, String> mappingsEvents = new HashMap<>();

        Reflections reflections = new Reflections("org.javacord.api.listener");
        Set<Class<? extends Object>> allClasses =
                reflections.getSubTypesOf(Object.class);

        for(Class c : getClassesForPackage("org.javacord.api.listener"))
            mappingsListener.put(c.getSimpleName(), c.getName());
        for(Class c : getClassesForPackage("org.javacord.api.event"))
            mappingsEvents.put(c.getSimpleName(), c.getName());



        for(Method m : builder.getMethods()){
            if (m.getName().startsWith("add") && !m.getName().equals("addListener") && !done.contains(m.getName())) {
                String realClassName = (m.getName().replace("add", ""));
                File file = new File(path+"/A"+realClassName+".java");
                FileWriter fw = new FileWriter(file);
                fw.write("package de.eonadev.discord.eobot.api.listeners.discord;\n"+
                        "\n"+
                        "\n"+
                        "import "+mappingsEvents.get(realClassName.replace("Listener", "Event"))+";\n"+
                        "import "+mappingsListener.get(realClassName)+";\n"+
                        "\n"+
                        "public class A"+realClassName+" implements "+realClassName+" {\n"+
                        "    @Override\n"+
                        "    public void on"+(realClassName.substring(0, 1).toUpperCase() + realClassName.substring(1)).replace("Listener", "")+"("+realClassName.replace("Listener", "Event")+" e) {\n"+
                        "        \n"+
                        "    }\n"+
                        "}");
                fw.close();
                done.add(m.getName());
            }
        }
    }

    public static void GenerateGetterAndSetter(String pathToPackage) throws IOException, URISyntaxException {
        String getter = "public A getB(){" +
                "   return C;" +
                "}";
        String setter = "public void setA(B C){" +
                "   D = C;" +
                "}";
        HashMap<String, String> mappingsEvents = new HashMap<>();
        for(Class c : getClassesForPackage("org.javacord.api.event"))
            mappingsEvents.put(c.getSimpleName(), c.getName());

        for(File f : new File(pathToPackage).listFiles()){
            String content = new String ( Files.readAllBytes(f.toPath()));

        }
    }

    public static void generateBuilderAddListenerCode(){
        List<String> done = new ArrayList<>();
        Class builder = DiscordApiBuilder.class;
        for(Method m : builder.getMethods()) {
            String realClassName = (m.getName().replace("add", ""));
            if (m.getName().startsWith("add") && !m.getName().equals("addListener") && !done.contains(m.getName())) {
                System.out.println("builder."+m.getName()+"(new A"+realClassName+"());");
                done.add(m.getName());
            }
        }
    }

    public static List<Class<?>> getClassesForPackage(final String pkgName) throws IOException, URISyntaxException {
        final String pkgPath = pkgName.replace('.', '/');
        final URI pkg = Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource(pkgPath)).toURI();
        final ArrayList<Class<?>> allClasses = new ArrayList<Class<?>>();

        Path root;
        if (pkg.toString().startsWith("jar:")) {
            try {
                root = FileSystems.getFileSystem(pkg).getPath(pkgPath);
            } catch (final FileSystemNotFoundException e) {
                root = FileSystems.newFileSystem(pkg, Collections.emptyMap()).getPath(pkgPath);
            }
        } else {
            root = Paths.get(pkg);
        }

        final String extension = ".class";
        try (final Stream<Path> allPaths = Files.walk(root)) {
            allPaths.filter(Files::isRegularFile).forEach(file -> {
                try {
                    final String path = file.toString().replace('/', '.');
                    final String name = path.substring(path.indexOf(pkgName), path.length() - extension.length());
                    allClasses.add(Class.forName(name));
                } catch (final ClassNotFoundException | StringIndexOutOfBoundsException ignored) {
                }
            });
        }
        return allClasses;
    }
}
