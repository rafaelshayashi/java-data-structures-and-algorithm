package com.rafaelshayashi.stack;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackTest {

    @Test
    public void should_create_stack_with_default_size() throws NoSuchFieldException, IllegalAccessException {
        Stack<Integer> stack = new Stack<>();

        Field field = Stack.class.getDeclaredField("elements");
        field.setAccessible(true);

        Object[] elements = (Object[]) field.get(stack);

        assertEquals(10, elements.length);
    }

    @Test
    public void should_push_element_to_stack() throws NoSuchFieldException, IllegalAccessException {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);

        Field field = Stack.class.getDeclaredField("elements");
        field.setAccessible(true);

        Object[] elements = (Object[]) field.get(stack);

        assertEquals(10, elements.length);
        assertEquals(5, elements[0]);
    }

    @Test
    public void should_increase_size_automatically() throws NoSuchFieldException, IllegalAccessException {
        Stack<Integer> stack = new Stack<>();

        IntStream.range(0, Stack.DEFAULT_SIZE + 1)
                .boxed()
                .collect(Collectors.toList())
                .forEach(stack::push);

        Field field = Stack.class.getDeclaredField("elements");
        field.setAccessible(true);

        Object[] elements = (Object[]) field.get(stack);

        assertEquals(20, elements.length);
    }
}
