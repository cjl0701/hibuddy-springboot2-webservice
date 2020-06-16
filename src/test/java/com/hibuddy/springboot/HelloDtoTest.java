package com.hibuddy.springboot;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class HelloDtoTest {
    @Test
    public void testdto(){
        String name="test";
        int amount=1000;
        HelloDto dto = new HelloDto(name, amount);
        assertThat(dto.getName()).isEqualTo(name);
    }

}