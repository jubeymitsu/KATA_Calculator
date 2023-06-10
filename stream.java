    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        String line;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String regex = "[^\\p{Alnum}\\p{IsCyrillic}]+";

        String[] words = builder.toString().toLowerCase().split(regex);

        Map<String, Long> map = Arrays.stream(words).collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        map.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()
                        .thenComparing(Map.Entry::getKey))
                .map(Map.Entry::getKey).limit(10).forEach(System.out::println);
    }

https://stackoverflow.com/questions/40690803/hashmap-lexicographic-sort-java-if-value-is-same
