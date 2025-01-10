package com.epam.aicode.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player();
    }

    @Test
    public void testDefaultConstructor() {
        assertNull(player.getAge());
        assertNull(player.getEmail());
        assertNull(player.getPhone());
        assertNull(player.getName());
        assertNull(player.getSurname());
    }

    @Test
    public void testParameterizedConstructor() {
        Player player = new Player(25, "john.doe@example.com", "123-456-7890", "John", "Doe");

        assertEquals(25, player.getAge());
        assertEquals("john.doe@example.com", player.getEmail());
        assertEquals("123-456-7890", player.getPhone());
        assertEquals("John", player.getName());
        assertEquals("Doe", player.getSurname());
    }

    @Test
    public void testSetAge() {
        player.setAge(30);
        assertEquals(30, player.getAge());
    }

    @Test
    public void testSetEmail() {
        player.setEmail("jane.doe@example.com");
        assertEquals("jane.doe@example.com", player.getEmail());
    }

    @Test
    public void testSetPhone() {
        player.setPhone("098-765-4321");
        assertEquals("098-765-4321", player.getPhone());
    }

    @Test
    public void testSetName() {
        player.setName("Jane");
        assertEquals("Jane", player.getName());
    }

    @Test
    public void testSetSurname() {
        player.setSurname("Smith");
        assertEquals("Smith", player.getSurname());
    }
}