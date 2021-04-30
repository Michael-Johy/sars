package com.johnny.core.lang.javac.classpathOutputCompile;

import com.johnny.core.lang.javac.cases.Constants;
import com.johnny.core.lang.javac.common.StringSourceJavaFileObject;

import javax.tools.*;
import javax.tools.JavaCompiler.CompilationTask;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Collections;

/**
 * Description: mainTest for fileManager
 * <p>
 * Author: yang_tao
 * Date  : 2017-08-11 10:00
 */
public class ClassPathOutCompile {

    public ClassPathOutCompile() {

    }

    public void compiler() throws Exception {
        //get Compiler
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        //define the diagnostic object, which will be used to save the diagnostic information
        DiagnosticCollector<? super JavaFileObject> diagnosticCollector = new DiagnosticCollector<>();
        //get standard JavaFileManager with DiagnosticCollector
        StandardJavaFileManager standardJavaFileManager = compiler.getStandardFileManager(diagnosticCollector, null, null);
        standardJavaFileManager.setLocation(StandardLocation.CLASS_OUTPUT, Collections.singletonList(new File("/Users/johnny/codes/github/sars-utils/bytes/")));

        try {
            JavaFileObject javaFileObject = new StringSourceJavaFileObject(Constants.CASE_CLASS_NAME, Constants.CASE_SOURCE_CODE);

            Iterable<String> options = Arrays.asList("-classpath", getClassBasePath(), "-XDuseUnsharedTable");

            Writer log = new PrintWriter(new FileOutputStream("/Users/johnny/codes/github/sars-utils/bytes/compile_log"), true);

            CompilationTask task = compiler.getTask(log, standardJavaFileManager, diagnosticCollector,
                    options, null, Arrays.asList(javaFileObject));
            Boolean result = task.call();

            //编译的二进制文件保存在location位置

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
        ClassLoader classLoader = ClassPathOutCompile.class.getClassLoader();
        URL[] urls = ((URLClassLoader) classLoader).getURLs();
        String cp = buildClassPath(urls);
        return cp;
    }

    public static String buildClassPath(URL[] urls) {
        StringBuffer buffer = new StringBuffer();
        for (URL url : urls) {
            buffer.append(new File(url.getPath()));
            buffer.append(System.getProperty("path.separator"));
        }
        String cp = buffer.toString();

        int toIndex = cp
                .lastIndexOf(System.getProperty("path.separator"));
        cp = cp.substring(0, toIndex);
        return cp;
    }
}
