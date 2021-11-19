package com.hotel.registration;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.hotel.registration.dao.BookingDao;
import com.hotel.registration.model.BookedRooms;
import com.hotel.registration.repository.RoomsRepository;

@SpringBootTest
class DaoTest 
{
	
	@Mock
	RoomsRepository roomsRepository;
	@InjectMocks
	BookingDao dao;
	
	@Test
	@DisplayName("there room available to book")
	void testRoomsRepository() 
	{
		List<BookedRooms> rooms = roomsRepository.findAll();
		when(roomsRepository.findAll()).thenReturn(rooms);
		 Assertions.assertThat(dao.getAllrooms()).isEmpty();
		 verify(roomsRepository,times(2)).findAll();
	}

}
