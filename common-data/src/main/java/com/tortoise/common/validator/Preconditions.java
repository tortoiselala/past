package com.tortoise.common.validator;

import com.tortoise.common.exception.ServiceException;

import java.lang.reflect.Constructor;
import java.util.Collection;

/**
 * @author wuyangmin
 * @date 2020/1/15
 */
public class Preconditions {
    public static <T> void checkNotEmpty(Collection<T> collection, Object message){
        if(collection==null||collection.isEmpty()){
            throw new IllegalArgumentException(String.valueOf(message));
        }
    }

    public static <T> void checkNotEmpty(Collection<T> collection,StateCode stateCode){
        if(collection==null||collection.isEmpty()){
            throw new IllegalArgumentException(stateCode.getDesc());
        }
    }

    public static void checkNotBlank(String string,Object message){
        if(string==null||string.isEmpty()){
            throw new IllegalArgumentException(String.valueOf(message));
        }
    }

    public static void checkNotBlank(String string,StateCode stateCode){
        if(string==null||string.isEmpty()){
            throw new IllegalArgumentException(stateCode.getDesc());
        }
    }

    public static void checkArgument(boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkArgument(boolean expression, Object errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
    }

    public static void checkArgument(boolean expression, StateCode stateCode) {
        if (!expression) {
            throw new IllegalArgumentException(stateCode.getDesc());
        }
    }

    public static void checkArgument(boolean expression,
                                     String errorMessageTemplate,
                                     Object... errorMessageArgs) {
        if (!expression) {
            throw new IllegalArgumentException(format(errorMessageTemplate, errorMessageArgs));
        }
    }

    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }

    public static <T> T checkNotNull(T reference, Object errorMessage) {
        if (reference == null) {
            throw new NullPointerException(String.valueOf(errorMessage));
        }
        return reference;
    }

    public static <T> T checkNotNull(T reference, StateCode stateCode) {
        if (reference == null) {
            throw new NullPointerException(stateCode.getDesc());
        }
        return reference;
    }


    public static <T> T checkNotNull(T reference,
                                     String errorMessageTemplate,
                                     Object... errorMessageArgs) {
        if (reference == null) {
            // If either of these parameters is null, the right thing happens anyway
            throw new NullPointerException(format(errorMessageTemplate, errorMessageArgs));
        }
        return reference;
    }

    public static void checkState(boolean expression) {
        if (!expression) {
            throw new IllegalStateException();
        }
    }

    public static void checkState(boolean expression,  Object errorMessage) {
        if (!expression) {
            throw new IllegalStateException(String.valueOf(errorMessage));
        }
    }

    public static void checkState(boolean expression,
                                  String errorMessageTemplate,
                                  Object... errorMessageArgs) {
        if (!expression) {
            throw new IllegalStateException(format(errorMessageTemplate, errorMessageArgs));
        }
    }

    public static <T, E extends RuntimeException> void checkArgument(boolean expression, String errorMessage, Class<E> clazz) {
        if (!expression) {
            checkNotNull(null, errorMessage, clazz);
        }
    }

    public static <T, E extends RuntimeException> T checkNotNull (T reference, Object errorMessage, Class<E> clazz) {
        if (reference == null) {
            try {
                Constructor<?> messageConstructor = clazz.getConstructor(String.class);
                throw (RuntimeException) messageConstructor.newInstance(String.valueOf(errorMessage));
            } catch (Exception ex) {
                if (ex instanceof RuntimeException) {
                    throw (RuntimeException)ex;
                } else {
                    ex.printStackTrace();
                    throw new ServiceException();
                }
            }
        }
        return reference;
    }



    static String format(String template, Object... args) {
        template = String.valueOf(template); // null -> "null"

        // start substituting the arguments into the '%s' placeholders
        StringBuilder builder = new StringBuilder(template.length() + 16 * args.length);
        int templateStart = 0;
        int i = 0;
        while (i < args.length) {
            int placeholderStart = template.indexOf("%s", templateStart);
            if (placeholderStart == -1) {
                break;
            }
            builder.append(template.substring(templateStart, placeholderStart));
            builder.append(args[i++]);
            templateStart = placeholderStart + 2;
        }
        builder.append(template.substring(templateStart));

        // if we run out of placeholders, append the extra args in square braces
        if (i < args.length) {
            builder.append(" [");
            builder.append(args[i++]);
            while (i < args.length) {
                builder.append(", ");
                builder.append(args[i++]);
            }
            builder.append(']');
        }

        return builder.toString();
    }
}
