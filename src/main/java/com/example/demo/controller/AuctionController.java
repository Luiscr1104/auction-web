package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Bid;
import com.example.demo.services.AuctionLogicService;

@RestController
@RequestMapping("/auctionApi")
public class AuctionController {

	@Autowired
	private AuctionLogicService auctionLogicService;
	
	@GetMapping("/runWinnerProcess")
	public void runWinnerProcess() {
		List<Bid> winners = auctionLogicService.runWinnerProcess();
		
		// Para testing
		auctionLogicService.printWinners(winners);
	}
}
