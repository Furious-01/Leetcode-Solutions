class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<Integer>row1=new ArrayList<>();
        List<Integer>row2=new ArrayList<>();
        int n=colsum.length;
        for(int i=0;i<n;i++){
            int col=colsum[i];
            if(col==2){
                  if (upper <= 0 || lower <= 0) return new ArrayList<>();
                  row1.add(1);
                  row2.add(1);
                  lower--;
                  upper--;
            }
            else if(col==1){
                if(upper>lower){
                row1.add(1);
                row2.add(0);
                upper--;
            }
            else{
                row1.add(0);
                row2.add(1);
                lower--;
            }
            }
            else{
                row1.add(0);
                row2.add(0);
            }
        }
         if (upper != 0 || lower != 0) return new ArrayList<>();
        
        List<List<Integer>> result = new ArrayList<>();
        result.add(row1);
        result.add(row2);
        return result;
    }
}