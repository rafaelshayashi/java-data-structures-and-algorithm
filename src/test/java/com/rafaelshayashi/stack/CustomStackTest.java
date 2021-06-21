package com.rafaelshayashi.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class CustomStackTest {

    @Test
    @DisplayName("Should create a stack with a default size")
    void should_create_stack_with_default_size() throws NoSuchFieldException, IllegalAccessException {
        CustomStack<Integer> stack = new CustomStack<>();

        Object[] elements = getElements(stack);

        assertEquals(10, elements.length);
    }

    @Test
    @DisplayName("Should push a element to a stack")
    void should_push_element_to_stack() throws NoSuchFieldException, IllegalAccessException {
        CustomStack<Integer> stack = new CustomStack<>();
        stack.push(5);

        Object[] elements = getElements(stack);

        assertEquals(10, elements.length);
        assertEquals(5, elements[0]);
    }

    @Test
    @DisplayName("Should increase size o based array automatically")
    void should_increase_size_automatically() throws NoSuchFieldException, IllegalAccessException {
        CustomStack<Integer> stack = new CustomStack<>();

        IntStream.range(0, CustomStack.DEFAULT_SIZE + 1)
                .boxed()
                .collect(Collectors.toList())
                .forEach(stack::push);

        Object[] elements = getElements(stack);

        assertEquals(20, elements.length);
    }

    @Test
    @DisplayName("Should pop a element")
    void should_pop_element() {
        CustomStack<Integer> stack = new CustomStack<>();

        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
        assertNull(stack.pop());
    }

    @Test
    @DisplayName("Should only peek a element")
    void should_peek_element() throws NoSuchFieldException, IllegalAccessException {
        CustomStack<Integer> stack = new CustomStack<>();

        stack.push(10);
        stack.push(20);

        Object[] elements = getElements(stack);

        assertEquals(20, stack.peek());
        assertEquals(10, elements[0]);
        assertEquals(20, elements[1]);
    }

    @Test
    @DisplayName("Should verify if a stack is empty")
    void should_verify_if_a_stack_is_empty() {
        CustomStack<Integer> stack = new CustomStack<>();

        assertTrue(stack.isEmpty());

        stack.push(10);
        stack.push(20);

        assertFalse(stack.isEmpty());
    }

    @Test
    @DisplayName("Should create a stack - Success")
    void should_clear_stack() throws NoSuchFieldException, IllegalAccessException {
        CustomStack<Integer> stack = new CustomStack<>();

        stack.push(10);
        stack.push(20);

        assertFalse(stack.isEmpty());
        stack.clear();
        assertTrue(stack.isEmpty());

        Object[] elements = getElements(stack);

        assertEquals(10, elements.length);
    }

    @Test
    @DisplayName("Should return the size of a stack - Success")
    void should_return_size_of_stack() {
        CustomStack<Integer> stack = new CustomStack<>();

        stack.push(10);
        stack.push(20);

        assertEquals(2, stack.size());
    }

    private Object[] getElements(CustomStack<Integer> stack) throws NoSuchFieldException, IllegalAccessException {
        Field field = CustomStack.class.getSuperclass().getDeclaredField("elements");
        field.setAccessible(true);

        return (Object[]) field.get(stack);
    }
}
