package com.mirego.interop.java.test.interfaces;

import commonMain.kotlin.test.interfaces.KotlinInterfaceWithStringProperty;
import org.jetbrains.annotations.NotNull;

public class WithStringProperty {

    public static class WithStringPropertyImplementation implements JavaInterfaceThatExtendsAKotlinInterfaceWithAProperty {
        @NotNull
        @Override
        public String getKey() {
            return "this is the value of my key";
        }

        @Override
        public String getValue() {
            return "This is the value";
        }
    }

    public interface JavaInterfaceThatExtendsAKotlinInterfaceWithAProperty extends KotlinInterfaceWithStringProperty {
        String getValue();
    }

    public static String main(String[] args) {
        WithStringPropertyImplementation withStringPropertyImplementation = new WithStringPropertyImplementation();
        return withStringPropertyImplementation.getKey();
    }
}
