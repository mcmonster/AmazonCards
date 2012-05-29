package amazon.cards;

import java.util.*;

// @author R. Matt McCann
//! Class representing a deck of card
public class Deck {
	//! Constructs a full deck of 52 playing cards
	//! The card are arranged by suits in ascending face value order
	public Deck() {
		Contents = new LinkedList<Card>();
		
		for(Card.SuitType suit : Card.SuitType.values())
			for(Card.FaceValueType faceValue : Card.FaceValueType.values())
				Contents.add(new Card(faceValue, suit));
	}

	//! Removes the card on top of the deck and returns it.
	//! If the deck is empty, null is returned.
	public Card deal_one_card() {
		if(Contents.isEmpty()) return null;
		else return Contents.remove();
	}
	
	//! Puts the cards in the deck in random order
	public void shuffle() {
		LinkedList<Card> newContents = new LinkedList<Card>();
		Random randomizer = new Random();
		
		// Remove cards randomly until there are none remaining
		while(Contents.size() > 0) {
			int position = randomizer.nextInt(Contents.size());
			Card card    = Contents.remove(position);
			if(!newContents.offer(card))
				// This error should not ever occur as linkedlist is not a 
				// capacity limited queue
				System.err.println("Failed to reinsert card during shuffle."); 
		}
		
		// Update the deck's contents
		Contents = newContents;
	}
	
	LinkedList<Card> Contents; //!< Cards in the deck
}
