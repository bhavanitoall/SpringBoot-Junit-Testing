package com.hotel.registration;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.hotel.registration.model.BookedRooms;
import com.hotel.registration.repository.RoomsRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class Repositorytest 
{
	@Mock
	RoomsRepository roomsRepository;

	@Test
	void roomBooking() 
	{
		List<BookedRooms>rooms=roomsRepository.findAll();
		when(roomsRepository.findAll()).thenReturn(rooms);
		assertNotNull(rooms,"No room Available to book");
		verify(roomsRepository,times(1)).findAll();
		
		
	}

}
