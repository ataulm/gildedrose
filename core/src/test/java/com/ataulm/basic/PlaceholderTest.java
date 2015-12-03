package com.ataulm.basic;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class PlaceholderTest {

    ObjectToStringWrapper wrapper;

    @Mock
    Object mockObject;

    @Before
    public void setUp() {
        initMocks(this);
        wrapper = new ObjectToStringWrapper(mockObject);
    }

    @Test
    public void wrapperPrintsObjectToString() {
        when(mockObject.toString()).thenReturn("test");

        String actual = wrapper.toString();

        assertThat(actual).isEqualTo("test");
    }

    private static class ObjectToStringWrapper {

        private final Object object;

        ObjectToStringWrapper(Object object) {
            this.object = object;
        }

        @Override
        public String toString() {
            return object.toString();
        }

    }

}
