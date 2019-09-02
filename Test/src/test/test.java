package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class test {
	public static int total;
public static int N;
public static int area[][];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T= Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			
			N=Integer.parseInt(br.readLine());
			area=new int [N][N];
			for(int i=0; i<N; i++) {
				st= new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					area[i][j]=Integer.parseInt(st.nextToken());
					if(area[i][j]!=0)total+=area[i][j];
				}
			}
			total=total/4;
			//System.out.println(total);
			int ans=0;
			int temp1=0;
			int temp2=0;
			int temp3=0;
			int temp4=0;
			int Temp1=0;
			int Temp2=0;
			int Temp3=0;
			int Temp4=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					for(int one=0;one<=i;one++) {
						for(int one1=0;one1<=j;one1++) {
							temp1+=area[one][one1];
						}
					}//System.out.println(temp1);
					Temp1=temp1;
					temp1=0;
					for(int one=0;one<=i;one++) {
						for(int one1=j+1;one1<N;one1++) {
							temp2+=area[one][one1];
						}
					}//System.out.println(temp2);
					Temp2=temp2;
					temp2=0;
					//System.out.println();
					for(int one=i+1;one<N;one++) {
						for(int one1=0;one1<=j;one1++) {
							temp3+=area[one][one1];
						}
					}//System.out.println(temp3);
					Temp3=temp3;
					temp3=0;
					for(int one=i+1;one<N;one++) {
						for(int one1=j+1;one1<N;one1++) {
							temp4+=area[one][one1];
						}
					}//System.out.println(temp4);
					Temp4=temp4;
					temp4=0;
//					System.out.println(Temp1);
//					System.out.println(Temp2);
//					System.out.println(Temp3);
//					System.out.println(Temp4);
//					System.out.println();
					if(Temp1==Temp2&&Temp2==Temp3&&Temp3==Temp4) {ans=1;break;}
				}if(ans==1)break;
			}System.out.println("#"+tc+" "+ans);
			
		}
		
	}

}
