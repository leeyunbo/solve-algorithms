class Main {
  
  public long solution(long num) {
      long answer = 0;
			num = num + 1;
			String str_num = String.valueOf(num);
			
			str_num = str_num.replaceAll("0", "1");
			
			answer = Long.valueOf(str_num);
			
      return answer;
    }

  public static void main(String[] args) {
        Main sol = new Main();
        long num = 9949999;
        long ret = sol.solution(num);

        System.out.println(ret);
    }
}
