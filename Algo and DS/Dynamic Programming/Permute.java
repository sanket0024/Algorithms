import java.util.*;
class Permute {
   public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> list = new ArrayList<>();
      // Arrays.sort(nums); // not necessary
      backtrack(list, new ArrayList<>(), nums);
      return list;
   }

   private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
      if(tempList.size() == nums.length){
         list.add(new ArrayList<>(tempList));
      } else{
         for(int i = 0; i < nums.length; i++){ 
            if(tempList.contains(nums[i])) continue; // element already exists, skip
            tempList.add(nums[i]);
            backtrack(list, tempList, nums);
            tempList.remove(tempList.size() - 1);
         }
      }
   }

   private static void print(List<List<Integer>> ls) {
      for(int i=0; i<ls.size(); i++) {
         List<Integer> temp = ls.get(i);
         System.out.println(temp.toString());
         // for(int j=0; j<temp.size(); j++) {
         //    System.out.print(temp.get(j) + "  ");
         // }
      }
   }

   public static void main(String[] args) {
      Permute p = new Permute();
      int[] arr = {1,2,3};
      print(p.permute(arr));
   }
}