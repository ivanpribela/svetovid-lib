/*
 * Copyright 2015 Ivan Pribela
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.svetovid.run;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Start {

    public static void main(String[] arguments) {

        // No class to run
        if (arguments.length == 0) {
            return;
        }

        // Find the class
        String className = arguments[0];
        Class<?> type;
        try {
            type = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // Find a method
        Method[] methods = type.getDeclaredMethods();
        String methodName = null;
        if (arguments.length > 1) {
            methodName = arguments[1];
        }
        methods = filterMethods(methods, methodName);

        // Prepare the instance
        Object instance = null;

        // Invoke all matching methods
        for (Method method : methods) {

            // Prepare the instance
            if ((instance == null) && !Modifier.isStatic(method.getModifiers())) {
                try {
                    instance = type.newInstance();
                } catch (InstantiationException e) {
                    // Leave at null
                } catch (IllegalAccessException e) {
                    // Leave at null
                }
            }

            // Prepare parameters
            int argumentCount = arguments.length - 1;
            if (method.getName().equals(methodName)) {
                argumentCount--;
            }
            int actualArgumentCount = method.getParameterTypes().length;
            String[] stringArguments = new String[actualArgumentCount];
            System.arraycopy(arguments, arguments.length - argumentCount, stringArguments, 0, actualArgumentCount < argumentCount ? actualArgumentCount : argumentCount);
            Object[] methodArguments = new Object[actualArgumentCount];
            Class<?>[] argumentTypes = method.getParameterTypes();
            for (int i = 0; i < actualArgumentCount; i++) {
                methodArguments[i] = convertArgument(argumentTypes[i], stringArguments[i]);
            }

            // Invoke the method
            Object result = null;
            try {
                method.setAccessible(true);
                result = method.invoke(instance, methodArguments);
            } catch (IllegalAccessException e) {
                // Will not happen
            } catch (IllegalArgumentException e) {
                result = e;
            } catch (InvocationTargetException e) {
                result = e.getCause();
            }

            // Output the result
            StringBuilder output = new StringBuilder();
            output.append(method.getName());
            output.append("(");
            boolean placeDelimiter = false;
            for (Object argument : methodArguments) {
                if (placeDelimiter) {
                    output.append(", ");
                }
                output.append(argument);
                placeDelimiter = true;
            }
            output.append(") = ");
            output.append(result);
            System.out.println(output.toString());
            if (result instanceof Throwable) {
                ((Throwable) result).printStackTrace();
            }

        }
    }

    private static Method[] filterMethods(Method[] methods, String name) {
        if (methods.length == 0) {
            return new Method[0];
        }
        if (methods.length == 1) {
            return methods;
        }
        List<Method> result = new ArrayList<>();
        for (Method method : methods) {
            if (method.getName().equals(name)) {
                result.add(method);
            }
        }
        if (result.size() > 0) {
            methods = result.toArray(new Method[result.size()]);
        }
        return methods;
    }

    private static Object convertArgument(Class<?> type, String string) {
        if (String.class.equals(type)) {
            return string;
        }
        if (type.isPrimitive()) {
            type = primitiveToWrapperMap.get(type);
        }
        try {
            return type.getMethod("valueOf", String.class).invoke(null, string);
        } catch (NoSuchMethodException|SecurityException|IllegalAccessException|IllegalArgumentException|InvocationTargetException e) {
            // Do nothing
        }
        try {
            return type.getConstructor(String.class).newInstance();
       } catch (InstantiationException|IllegalAccessException|IllegalArgumentException|InvocationTargetException|NoSuchMethodException|SecurityException e) {
            // Do nothing
        }
        return null;
    }

    private static Map<Class<?>, Class<?>> primitiveToWrapperMap = new HashMap<>();
    static {
        primitiveToWrapperMap.put(boolean.class, Boolean.class);
        primitiveToWrapperMap.put(byte.class, Byte.class);
        primitiveToWrapperMap.put(char.class, Character.class);
        primitiveToWrapperMap.put(short.class, Short.class);
        primitiveToWrapperMap.put(int.class, Integer.class);
        primitiveToWrapperMap.put(long.class, Long.class);
        primitiveToWrapperMap.put(float.class, Float.class);
        primitiveToWrapperMap.put(double.class, Double.class);
        primitiveToWrapperMap.put(void.class, Void.class);
    }
}
