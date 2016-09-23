package basic1;

public class Practice {
	public static void main(String[] args) {
//		boolean a = 98>99;
//		boolean b = 100<99;
//		if(a) System.out.println("true");
//		return;
//		if(b) System.out.println("false");
		
		
		
//		int a = 40;
//		int x = 100;
//		int y = 8;
//		int z = 7;
//		System.out.println(a^x);
//		System.out.println(a>>2);
//		System.out.println();
//
//		System.out.println(5>>3);//结果是0  
//        System.out.println(-5>>3);//结果是-1  
//        System.out.println(-5>>>3);//结果是536870911  ／／http://blog.csdn.net/xiaochunyong/article/details/7748713
//   --------------------------------------------------------     
//		System.out.println("rainie" +"\n" + "I love u");
//		int i,j;//i represent row, j represent j
//		for(i=1;i<10;i++) {
//			for(j=1;j<10;j++) {
//				if (j>i) {
//					System.out.print("        ");
//				}else
//				System.out.print(i+"*"+j+"="+(i*j)+"\t");
//			}
//			System.out.println("\n");
//		}
		
		//================================

		//		int days=0;
//		sc = new Scanner (System.in);
//		System.out.print("input year");
//		int year = sc.nextInt();
//		
//		  switch(year){
//			case 1:
//			case 3:
//			case 11:
//				days=31;
//			break;
//			case 2:
//			case 4:
//				days=30;
//			break;
//			
//		  }
//		  System.out.println(days);
			
		
		//=====================
//		
//		int demoArray[] = new int[5];
//		int total = 0;
//		System.out.println("input number:");
//		Scanner sc = new Scanner(System.in);
//		for(int i=0;i<demoArray.length;i++) {
//			demoArray[i] = sc.nextInt();
//			total= total+demoArray[i];
//		}			
//		System.out.println(total
//				+ "");
		
		//=======================
//		int demoArray[] = {1,9,8,9,5,3};
//		for(int x : demoArray) {
//			System.out.print(x);
//			
//		}
		//===============
//		StringBuffer str1 = new StringBuffer("hello");
//		
//		str1.append("word");
//		str1.deleteCharAt(2);
//		str1.delete(4, 8);
//		str1.insert(0, "rainie");
//		str1.setCharAt(5, 'y');
//		System.out.println(str1);
		
		//===================current time efficiency
//		String fragment = "Rainie is cute";
//		
//		int times = 10000;
//		long timeStart1 = System.currentTimeMillis();
//		String str1 = "";
//		
//		for(int i=0; i<times; i++) {
//			str1+=fragment;//一直循环10000次加上cute这句话
//		}
//		
//		
//		long timeEnd1 = System.currentTimeMillis();
//		
//		System.out.println("String:"+(timeEnd1-timeStart1)+"ms");
//		
//		
//		
//		//StringBuffer
//		long timeStart2 = System.currentTimeMillis();
//		StringBuffer str2 = new StringBuffer();
//		
//		for(int i=0; i<times; i++) {
//			str2.append(fragment);//一直循环10000次加上cute这句话
//		}
//		
//		long timeEnd2 = System.currentTimeMillis();
//		System.out.println("StringBuffer:"+(timeEnd2-timeStart2)+"ms");
		
		
		//=======================
		//StringBuilder类跟StringBuffer类功能相似，方法差不多，区别在于StringBuilder类的方法是多线程安全，StringBuilder不是线程安全。所以Builder会快点儿
		//CharSequence 是一个定义字符串操作的接口，String直接实现CharSequence接口；StringBuilder and StringBuffer 都是可变的字符序列，继承于AbstractStringBuilder,实现CharSequence接口
		//StringBuffer:线程安全
		//StringBuilder:线程不安全
		
		
		
		
		
		
		

		
	}
}

