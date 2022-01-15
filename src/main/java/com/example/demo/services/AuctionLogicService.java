package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Bid;
import com.example.demo.entity.Bidder;
import com.example.demo.entity.Item;
import com.example.demo.entity.Seller;

@Service
public class AuctionLogicService {

	public List<Bid> bets = new ArrayList<Bid>();
	public List<Item> products = new ArrayList<Item>();

	public AuctionLogicService() {
		// Vendedores
		Seller seller1 = new Seller("Masiel");
		Seller seller2 = new Seller("Dilana");
		Seller seller3 = new Seller("Oli");

		// Apostadores
		Bidder bidder1 = new Bidder("Alice");
		Bidder bidder2 = new Bidder("Aaron");
		Bidder bidder3 = new Bidder("Amanda");

		// Artículos
		Item item1 = new Item("Bicycle", 50, seller1);
		products.add(item1);
		Item item2 = new Item("Scooter", 599, seller2);
		products.add(item2);
		Item item3 = new Item("Boat", 2500, seller3);
		products.add(item3);

		// Apuestas Bicicleta
		Bid bid1 = new Bid(bidder1, item1, 50, 80, 3);
		bets.add(bid1);
		Bid bid2 = new Bid(bidder2, item1, 60, 82, 2);
		bets.add(bid2);
		Bid bid3 = new Bid(bidder3, item1, 55, 85, 5);
		bets.add(bid3);

		// Apuestas Scooter
		Bid bid4 = new Bid(bidder1, item2, 700, 725, 2);
		bets.add(bid4);
		Bid bid5 = new Bid(bidder2, item2, 599, 725, 15);
		bets.add(bid5);
		Bid bid6 = new Bid(bidder3, item2, 625, 725, 8);
		bets.add(bid6);

		// Apuestas Bote
		Bid bid7 = new Bid(bidder1, item3, 2500, 3000, 500);
		bets.add(bid7);
		Bid bid8 = new Bid(bidder2, item3, 2800, 3100, 201);
		bets.add(bid8);
		Bid bid9 = new Bid(bidder3, item3, 2501, 3200, 247);
		bets.add(bid9);
	}

	/**
	 * Este metodo utiliza un ciclo para recorrer la lista de productos y acceder a
	 * la data usando filter. Luego con un map y un compare tenemos máximo de
	 * apuesta requerido para obtener el ganador
	 * 
	 * @return retornando una lista de ganadores
	 */
	public List<Bid> runWinnerProcess() {
		List<Bid> bidders = new ArrayList<Bid>();
		Integer maxBid;

		for (Item item : products) {
			List<Bid> resultSubList = bets.stream().filter(r -> item.getName().equals(r.getItem().getName()))
					.collect(Collectors.toList());

			maxBid = resultSubList.stream().map(bid -> bid.getMaxBid()).max(Integer::compare).orElse(0);

			bidders.add(getWinner(maxBid, resultSubList));
		}

		return bidders;
	}

	/**
	 * Este metodo usa un ciclo para recorer la
	 * 
	 * @param maxBid        que sacamos del runWinnerProcess
	 * @param resultSubList esta sublista es para recorerla con for each y tener la
	 *                      apuesta ganadora
	 * @return retornamos la apuesta ganadora bid
	 */
	private Bid getWinner(Integer maxBid, List<Bid> resultSubList) {
		int price;

		while (true) {
			for (Bid bid : resultSubList) {
				price = bid.getItem().getPrice();
				if ((price <= maxBid) && (price <= bid.getMaxBid()
						&& (bid.getItem().getPrice() + bid.getAutoIncrementAmount() <= maxBid))) {
					bid.getItem().setPrice(price + bid.getAutoIncrementAmount());
				} else {
					return bid;
				}
			}

		}
	}

	/**
	 * Este metodo me ayuda a imprimir los ganadores concatenando el producto y
	 * precio
	 * 
	 * @param winners
	 */
	public void printWinners(List<Bid> winners) {
		for (Bid bid : winners) {
			System.out.println("EL ganador del producto " + bid.getItem().getName() + ", con precio $"
					+ bid.getItem().getPrice() + ", es: " + bid.getBidder().getName());
		}
	}
}
