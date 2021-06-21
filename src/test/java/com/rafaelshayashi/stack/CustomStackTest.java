package com.rafaelshayashi.stack;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class CustomStackTest {

    @Test
    void should_create_stack_with_default_size() throws NoSuchFieldException, IllegalAccessException {
        CustomStack<Integer> stack = new CustomStack<>();

        Field field = CustomStack.class.getDeclaredField("elements");
        field.setAccessible(true);

        Object[] elements = (Object[]) field.get(stack);

        assertEquals(10, elements.length);
    }

    @Test
    void should_push_element_to_stack() throws NoSuchFieldException, IllegalAccessException {
        CustomStack<Integer> stack = new CustomStack<>();
        stack.push(5);

        Field field = CustomStack.class.getDeclaredField("elements");
        field.setAccessible(true);

        Object[] elements = (Object[]) field.get(stack);

        assertEquals(10, elements.length);
        assertEquals(5, elements[0]);
    }

    @Test
    void should_increase_size_automatically() throws NoSuchFieldException, IllegalAccessException {
        CustomStack<Integer> stack = new CustomStack<>();

        IntStream.range(0, CustomStack.DEFAULT_SIZE + 1)
                .boxed()
                .collect(Collectors.toList())
                .forEach(stack::push);

        Field field = CustomStack.class.getDeclaredField("elements");
        field.setAccessible(true);

        Object[] elements = (Object[]) field.get(stack);

        assertEquals(20, elements.length);
    }

    @Test
    void should_pop_element() {
        CustomStack<Integer> stack = new CustomStack<>();

        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
        assertNull(stack.pop());
    }

    @Test
    void should_peek_element() throws NoSuchFieldException, IllegalAccessException {
        CustomStack<Integer> stack = new CustomStack<>();

        stack.push(10);
        stack.push(20);

        Field field = CustomStack.class.getDeclaredField("elements");
        field.setAccessible(true);

        Object[] elements = (Object[]) field.get(stack);

        assertEquals(20, stack.peek());
        assertEquals(10, elements[0]);
        assertEquals(20, elements[1]);
    }

    @Test
    void should_verify_if_a_stack_is_empty() {
        CustomStack<Integer> stack = new CustomStack<>();

        assertTrue(stack.isEmpty());

        stack.push(10);
        stack.push(20);

        assertFalse(stack.isEmpty());
    }

    @Test
    void should_clear_stack() throws NoSuchFieldException, IllegalAccessException {
        CustomStack<Integer> stack = new CustomStack<>();

        stack.push(10);
        stack.push(20);

        assertFalse(stack.isEmpty());
        stack.clear();
        assertTrue(stack.isEmpty());

        Field field = CustomStack.class.getDeclaredField("elements");
        field.setAccessible(true);

        Object[] elements = (Object[]) field.get(stack);

        assertEquals(10, elements.length);
    }

    @Test
    void should_return_size_of_stack() {
        CustomStack<Integer> stack = new CustomStack<>();

        stack.push(10);
        stack.push(20);

        assertEquals(2, stack.size());
    }
}
