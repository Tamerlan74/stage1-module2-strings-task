package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     * 1. access modifier - optional, followed by space: ' '
     * 2. return type - followed by space: ' '
     * 3. method name
     * 4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     * accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     * private void log(String value)
     * Vector3 distort(int x, int y, int z, float magnitude)
     * public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        StringTokenizer st = new StringTokenizer(signatureString, "(");
        List<String> tokens = new ArrayList<>();
        List<String> methodNames = new ArrayList<>();
        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }
        String returnType = null;
        String am = null;



        StringTokenizer st2 = new StringTokenizer(tokens.get(0));

        while (st2.hasMoreTokens()) {
            methodNames.add(st2.nextToken());
        }

        if (methodNames.size() == 2){
            returnType = methodNames.get(0);
        }

        if (methodNames.size() == 3){
            am = methodNames.get(0);
            returnType = methodNames.get(1);
        }

        List<String> arguments = new ArrayList<>();
        StringTokenizer st3 = new StringTokenizer(tokens.get(1), ",");
        while (st3.hasMoreTokens()) {
            arguments.add(st3.nextToken());
        }
        List<MethodSignature.Argument> argumentList = new ArrayList<>();
        if (arguments.size()>1){
            for (int i = 0; i < arguments.size(); i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(arguments.get(i));
                if (i != arguments.size() - 1) {
                    argumentList.add(new MethodSignature.Argument(stringTokenizer.nextToken(), stringTokenizer.nextToken()));
                } else {
                    argumentList.add(new MethodSignature.Argument(stringTokenizer.nextToken(), stringTokenizer.nextToken(") ")));
                }
            }
        }
        MethodSignature methodSignature = new MethodSignature(methodNames.get(methodNames.size() - 1), argumentList);
        methodSignature.setReturnType(returnType);
        methodSignature.setAccessModifier(am);
        return methodSignature;
    }
}
