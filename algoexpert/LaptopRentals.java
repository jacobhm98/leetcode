class LaptopRentals{

	MinHeap<Integer> endDate;
	int counter = 1;

	public int findSmallestValidLatops(List<List<Integer>> scheduledRentals){
		sortListOnFirstElement(scheduledRentals);
		List<Integer> firstRental = scheduledRentals.get(0);
		Integer endDate = firstRental.get(1);
		endDates.insert(endDate);

		//Iterate over the sorted list of scheduled rentals
		for (int i = 1; i < scheduledRentals.size(); ++i){
			List<Integer> currRental = scheduledRentals.get(i);
			int currentSmallestEndDate = endDate.pop();
			if (currRental.get(0) < currentSmallestEndDate){
				counter++;
				endDate.insert(currentSmallestEndDate);
			}
			endDate.insert(currRental.get(1);
		}
		return counter;
		
	}

	private void sortListOnFirstElement(List<List<Integer>> listToSort){
		//sorts the entries of the list in ascending order based off of the first
		//value of each sublist
	}
}
