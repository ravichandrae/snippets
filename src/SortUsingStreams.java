class SortUsingStreams {  
  public static void main(String[] args) {
        List<Integer> integers = List.of(2,1,3);
        List<Integer> sortedIntegers = integers.stream().sorted().collect(Collectors.toList());
        for(int v: integers) {
            System.out.print(v);
        }
        for(int v: sortedIntegers) {
            System.out.print(v);
        }
  }
}
