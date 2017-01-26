public class CourseSchedule{


	public boolean canFinish(int numCourses, int[][] prerequisites){
		// graph edges 
		// this is how to declare list of lists
		List[] edges = new ArrayList[numCourses];
		
		// outdegree
		int[] degree = new int[numCourses];

		for(int i = 0; i < numCourses; i++){
			edges[i] = new ArrayList<Integer>();
		}	

		for(int i = 0; i < prerequisites.length; i++){
			degree[prerequisites[i][1]]++;
			edges[prerequisites[i][0]].add(prerequisites[i][1]);
		}


		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < numCourses; i++){
			if(degree[i] == 0){
				queue.offer(i);
			}
		}

		int count = 0;
		while(!queue.isEmpty()){
			int course = (int) queue.poll();
			count++;
			int size = edges[course].size();0
			for(int i = 0; i < size; i++){
				int ptr = (int) edges[course].get(i);
				degree[ptr]--;	

				if(degree[ptr] == 0){
					queue.add(ptr);
				}
			}

		}

		return count == numCourses;

	}


}

























