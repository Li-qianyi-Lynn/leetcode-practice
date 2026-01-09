return IntStream.of(arr)
                .boxed()
                .sorted(Comparator.comparingInt(a -> Math.abs(a - x)))
                .collect(Collectors.toList())
                .subList(0, k)
                .stream()
                .sorted()
                .collect(Collectors.toList());