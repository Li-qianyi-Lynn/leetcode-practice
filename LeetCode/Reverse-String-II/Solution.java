char * reverseStr(char * s, int k){
    int sSize = strlen(s);
    if(sSize<=2||k<=1||sSize<k) return s;
    for(int i,j,x,y; i<sSize-k+1, j=i+k+1, x =i, y=j; i+=2*k){
        while(x<y){
            char temp=s[x];
            s[x]=s[y];
            s[y]=temp;
            x++; y--;
        }
    }
    return s;
}