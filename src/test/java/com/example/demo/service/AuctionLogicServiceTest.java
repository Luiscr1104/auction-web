package com.example.demo.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Bid;
import com.example.demo.entity.Bidder;
import com.example.demo.entity.Item;
import com.example.demo.services.AuctionLogicService;

@SpringBootTest
public class AuctionLogicServiceTest {

	@Mock
	AuctionLogicService auctionLogicService;

	@Before
	public void init() {
		this.auctionLogicService = Mockito.mock(AuctionLogicService.class);
	}
	
	@Test
	public void getWinnersTest() {
		// Given
		
		// Apostadores
		Bidder bidder1 = new Bidder("Alice");
		Bidder bidder2 = new Bidder("Aaron");
		Bidder bidder3 = new Bidder("Amanda");
		
		// Artículos
		Item item1 = new Item("Bicycle", 50, null);
		Item item2 = new Item("Scooter", 599, null);
		Item item3 = new Item("Boat", 2500, null);

		Bid bid1 = new Bid(bidder1, item1, 50, 80, 3);
		Bid bid2 = new Bid(bidder2, item2, 50, 80, 3);
		Bid bid3 = new Bid(bidder3, item3, 50, 80, 3);
		
		List<Bid> result = new ArrayList<>();
		result.add(bid1);
		result.add(bid2);
		result.add(bid3);
		when(auctionLogicService.runWinnerProcess()).thenReturn(result);
		
		// When
		auctionLogicService.runWinnerProcess();
		
		// Then
		assertEquals(3, result.size());
		verify(auctionLogicService, times(1)).runWinnerProcess();
	}

	@Test
	public void getZeroWinnersTest() {
		// Given
		List<Bid> result = new ArrayList<>();
		when(auctionLogicService.runWinnerProcess()).thenReturn(result);
		
		// When
		auctionLogicService.runWinnerProcess();
		
		// Then
		assertEquals(0, result.size());
		verify(auctionLogicService, times(1)).runWinnerProcess();
	}
}
