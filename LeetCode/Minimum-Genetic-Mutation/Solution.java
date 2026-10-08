    if(start.equals(end)){
        minMutation=Math.min(minMutation,count);
        return;
    }
    for(int i=0;i<bank.length;i++){
        if(diff(start,bank[i])==1 && !set.contains(bank[i])){ 
            set.add(bank[i]);
            helper(bank[i],end,bank,count+1,set);
            set.remove(bank[i]);   
        }
    } 
}
private int diff(String a,String b){
    int count=0;
    for(int i=0;i<8;i++){
        if(a.charAt(i)!=b.charAt(i)) count++;
    }
    return count;
}