package com.johnny.sars.rule.java.simpleCompilerApi;

import com.johnny.sars.rule.java.fileObject.StringSourceJavaFileObject;

import javax.tools.*;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileManager.Location;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

/**
 * Description: mainTest for fileManager
 * <p>
 * Author: yang_tao
 * Date  : 2017-08-11 10:00
 */
public class MainTest {

    private static String OBJECT_EXECUTOR_CODE = "package com.johnny.sars.rule.java.simpleCompilerApi.testcase;\n" +
            "\n" +
            "/**\n" +
            " * Description:\n" +
            " * <p>\n" +
            " * Author: yang_tao\n" +
            " * Date  : 2017-08-11 10:42\n" +
            " */\n" +
            "public class ObjectExecutor<M extends Object> implements Executor {\n" +
            "\n" +
            "    private M object;\n" +
            "\n" +
            "    public ObjectExecutor(M mObject) {\n" +
            "        object = mObject;\n" +
            "    }\n" +
            "\n" +
            "    @Override\n" +
            "    public void execute() {\n" +
            "        execute(object);\n" +
            "    }\n" +
            "\n" +
            "    private void execute(M object) {\n" +
            "        System.out.println(object);\n" +
            "    }\n" +
            "}\n";


    public static void main(String[] args) throws Exception {
        compiler();
//        execute();
    }

    public static void compiler() throws Exception {
        //get Compiler
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        //define the diagnostic object, which will be used to save the diagnostic information
        DiagnosticCollector<? super JavaFileObject> diagnosticCollector = new DiagnosticCollector<>();
        //get standard JavaFileManager with DiagnosticCollector
        StandardJavaFileManager standardJavaFileManager = compiler.getStandardFileManager(diagnosticCollector, null, null);

        Location location = StandardLocation.CLASS_OUTPUT;
        try {
            standardJavaFileManager.setLocation(location, null);
            JavaFileObject javaFileObject = new StringSourceJavaFileObject("com.johnny.sars.rule.java.simpleCompilerApi.testcase.ObjectExecutor", OBJECT_EXECUTOR_CODE);

            Iterable<String> options = Arrays.asList("-classpath", getClassBasePath(), "-XDuseUnsharedTable");
            CompilationTask task = compiler.getTask(null, standardJavaFileManager, diagnosticCollector,
                    options, null, Arrays.asList(javaFileObject));
            boolean executed = task.call();

            //prints the Diagnostic's information
            for (Diagnostic diagnostic : diagnosticCollector.getDiagnostics()) {
                System.out.println(diagnostic.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("error");
        }
    }

    public static String getClassBasePath() {
        ClassLoader classLoader = MainTest.class.getClassLoader();
        URL[] urls = ((URLClassLoader) classLoader).getURLs();
        String cp = ClassLoaderUtils.buildClassPath(urls);
        return cp;
    }
}
