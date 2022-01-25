import java.util.stream.IntStream;

class GasStation{
	
	public int canCompleteCircuit(int[] gas, int[] cost){
		int totalGas = IntStream.of(gas).sum();
		int totalCost = IntStream.of(cost).sum();
		if (totalGas < totalCost){
			return -1;
		}
		return 0;
		
	}
}
