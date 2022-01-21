import java.util.*;

class GasStation{
	
	public int canCompleteCircuit(int[] gas, int[] cost){
		int totalGas = Instream.of(gas).sum();
		int totalCost = Instream.of(cost).sum();
		if (totalGas < totalCost){
			return -1;
		}
		
	}
}
