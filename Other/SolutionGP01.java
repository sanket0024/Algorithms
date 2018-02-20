class SolutionGP01 {
	public int solution (int[] A, int[] E) {
		Map<Integer,ArrayList<Integer>> nodeMap = new HashMap<Integer, ArrayList<Integer>>();
		nodeMap.put(A[0], );
		int count=0;
		for(int j=0; j<E.length-1; j++) {
			List<Integer> temp = nodeMap.get(A[E[j]-1]);
			nodeMap.put(A[E[j]-1],temp.add(E[j]));
			if(A[E[j]-1] == A[E[j++]-1] && nodeMap.get()) {
				if(nodeMap)
			}

		}
	}
}