int[] computeLPS(String str){
        int n = str.length();
        int[] LPS = new int[n];
        LPS[0] = 0;
        for(int i=1; i<n; i++){
            int x = LPS[i-1]; // previous LPS
            while(str.charAt(i)!=str.charAt(x)){
                if(x==0){
                    x = -1; //set x = -1 to generically handle LPS[i] = x+1;
                    break;
                }
                x = LPS[x-1]; // to find atleast one match from previous LPS
            }
            LPS[i] = x+1; //at max we can only increment current by 1
        }
        return LPS;
    }
