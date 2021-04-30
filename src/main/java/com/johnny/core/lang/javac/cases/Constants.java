package com.johnny.core.lang.javac.cases;

public class Constants {
    public static final String CASE_SOURCE_CODE = "package com.johnny.core.lang.javac.cases;\n" +
            "\n" +
            "public class PrintExecuter implements Executer{\n" +
            "    @Override\n" +
            "    public void execute() {\n" +
            "        System.out.println(\"print execute\");\n" +
            "    }\n" +
            "}\n";
    public static final String CASE_CLASS_NAME = "com.johnny.core.lang.javac.cases.PrintExecuter";
}
