package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AnimalTest {
    @Test
    public void testGetFoodHerbivore() throws Exception {
        Animal animal = new Animal();
        List<String> actual = animal.getFood("Травоядное");
        List<String> expected = List.of("Трава", "Различные растения");
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFoodPredator() throws Exception {
        Animal animal = new Animal();
        List<String> actual = animal.getFood("Хищник");
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFoodSomeCreature() {
        String expected = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        try {
            Animal animal = new Animal();
            List<String> actual = animal.getFood("foo");
        } catch (Exception e) {
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    public void testGetFamily() {
        Animal animal = new Animal();
        String actual = animal.getFamily();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, actual);

    }
}