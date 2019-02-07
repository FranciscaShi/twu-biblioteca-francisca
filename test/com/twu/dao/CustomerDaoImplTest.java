package com.twu.dao;

import com.twu.dto.BookDto;
import com.twu.dto.CustomerDto;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerDaoImplTest {


    @Test
    @Ignore
    public void shouldAddABookWhenCheckOut() {
        //Arrannge
        //crear cliente de deveras
        //crear libro de mentira

        BookDto bookDto = mock(BookDto.class);
        CustomerDto customerDto = mock(CustomerDto.class);
        when(bookDto.getBookName()).thenReturn("Iliada");

        //Action
        //ejecutar la accion check out book
        //CustomerDaoImpl.bookCheckout(bookDto.getBookName());

        //Assert
        //probar que el cliente tiene un libro
        //assertEquals();

    }

}