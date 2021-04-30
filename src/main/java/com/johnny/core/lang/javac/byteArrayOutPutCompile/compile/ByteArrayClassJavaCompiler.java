package com.johnny.core.lang.javac.byteArrayOutPutCompile.compile;

import com.google.common.collect.Lists;
import com.johnny.core.lang.javac.byteArrayOutPutCompile.ByteArrayClassFileManager;
import com.johnny.core.lang.javac.common.StringSourceJavaFileObject;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

/**
 * Description:JavaCompiler java String-Format source
 * <p>
 * Author: johnny
 * Date  : 2017-11-13 11:05
 */
public class ByteArrayClassJavaCompiler {

    private final javax.tools.JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

    private final DiagnosticCollector<? super JavaFileObject> diagnosticCollector = new DiagnosticCollector();

    private final ByteArrayClassFileManager javaFileManager;

    private final List<String> options;

    public ByteArrayClassJavaCompiler() {
        options = Lists.newArrayList();
        options.add("-source");
        options.add("1.7");
        options.add("-target");
        options.add("1.7");
        options.add("-XDuseUnsharedTable");
        StandardJavaFileManager manager = compiler.getStandardFileManager(diagnosticCollector, null, null);
        javaFileManager = new ByteArrayClassFileManager(manager);

        //        ClassLoader currentClassLoader = Thread.currentThread().getContextClassLoader();
//        if (currentClassLoader instanceof URLClassLoader
//                && (!currentClassLoader.getClass().getName().equals("sun.misc.Launcher$AppClassLoader"))) {
//            try {
//                URLClassLoader urlClassLoader = (URLClassLoader) currentClassLoader;
//                List<File> files = new ArrayList<>();
//                for (URL url : urlClassLoader.getURLs()) {
//                    files.add(new File(url.getFile()));
//                }
//                manager.setLocation(StandardLocation.CLASS_PATH, files);
//            } catch (IOException e) {
//                throw new IllegalStateException(e.getMessage(), e);
//            }
//        }
    }

    public byte[] compiler(String qualifiedName, String sourceCode) {
        int i = qualifiedName.lastIndexOf('.');
        String className = i < 0 ? qualifiedName : qualifiedName.substring(i + 1);
        JavaFileObject javaFileObject = new StringSourceJavaFileObject(className, sourceCode);
        PrintWriter writer = new PrintWriter(new StringWriter());
        Boolean result = compiler.getTask(writer, javaFileManager, diagnosticCollector, options, null,
                Lists.newArrayList(javaFileObject)
        ).call();
        if (null == result || !result) {
            throw new IllegalStateException("Compilation failed. class:" + qualifiedName + ", diagnostics:" + diagnosticCollector.getDiagnostics());
        }
        return javaFileManager.getBytes(qualifiedName);
    }

    public ByteArrayClassFileManager getJavaFileManager() {
        return javaFileManager;
    }
}
