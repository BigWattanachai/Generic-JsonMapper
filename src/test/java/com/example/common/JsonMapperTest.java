package com.example.common;


import com.example.jacksonjson.common.JsonMapper;
import com.example.jacksonjson.dto.Student;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class JsonMapperTest {
    @Test
    public void shouldReturnValidJSONWhenParseStudentToJSON() throws Exception {
        String expected = "{\n" +
                "   \"first_name\":\"Cherprang\",\n" +
                "   \"last_name\":\"Areekul\",\n" +
                "   \"gpa\":4.00\n" +
                "}";
        Student student = new Student();
        student.setFirstName("Cherprang");
        student.setLastName("Areekul");
        student.setGpa(4.00);
        String actual = JsonMapper.toJson(student);
        JSONAssert.assertEquals(expected, actual, false);
    }

    @Test
    public void shouldReturnStudentWhenParseJSONToStudentWithValidJSON() throws Exception {
        String json = "{\n" +
                "   \"first_name\":\"Cherprang\",\n" +
                "   \"last_name\":\"Areekul\",\n" +
                "   \"gpa\":4.00\n" +
                "}";

        Student student = JsonMapper.fromJson(json, Student.class);
        assertEquals(student.getFirstName(), "Cherprang");
        assertEquals(student.getLastName(), "Areekul");
        assertThat(student.getGpa(), is(4.00));
    }
}
