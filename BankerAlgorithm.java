class BankerAlgorithm {

    static class Banker {

        int n = 5, m = 3; 
        int needMatrix[][] = new int[n][m];
        int maxMatrix[][] , allocationMatrix[][], availableMatrix[];
        int trackingSequence[] = new int[n];
            
        void actualInsectionofValues(){
        allocationMatrix = new int[][] {{ 0, 1, 0 },{ 2, 0, 0 },{ 3, 0, 2 },{ 2, 1, 1 },{ 0, 0, 2 } }; 
        maxMatrix        = new int[][] {{ 7, 5, 3 },{ 3, 2, 2 },{ 9, 0, 2 },{ 2, 2, 2 },{ 4, 3, 3 }};
		availableMatrix  = new int[] { 3, 3, 2 };	
    }

        void NeedMatrix() {
            for (int i = 0;i < n; i++) {
		        for (int j = 0;j < m; j++) {
		            needMatrix[i][j] = maxMatrix[i][j]-allocationMatrix[i][j];
                }
	        }	
        }

        void mainWorking(){
            int count=0;
	
        	boolean visitedProcesses[] = new boolean[n];
	        for (int i = 0;i < n; i++)
		        visitedProcesses[i] = false;
		
	        int workMatrix[] = new int[m];	
	        for (int i = 0;i < m; i++)
                workMatrix[i] = availableMatrix[i];
	
            while (count<n) {
                boolean flag = false;
                for (int i = 0;i < n; i++) {
                    if (visitedProcesses[i] != true) {
                    int j;
                    for (j = 0;j < m; j++){		
                        if (needMatrix[i][j] > workMatrix[j])
                        break;
                    }
                    if (j == m) {
                        trackingSequence[count++]=i;
                        visitedProcesses[i]=true;
                        flag=true;

                        for (j = 0;j < m; j++){
                            workMatrix[j] = workMatrix[j]+allocationMatrix[i][j];
                            }
                        }
                    }
                }
                if (flag == false){
                    break;
                }
            }
        }

        void printOut(){
            System.out.println(" Tracking Sequence");
				for (int i = 0;i < n; i++){
			    System.out.print("P" + trackingSequence[i]);
                if (i != n-1)
			        System.out.print(" -> ");
		    }
        }

    }
    public static void main(String[] args){

        Banker BK =  new Banker();
        BK.actualInsectionofValues();
        BK.NeedMatrix();
        BK.mainWorking();
        BK.printOut();
    }
}