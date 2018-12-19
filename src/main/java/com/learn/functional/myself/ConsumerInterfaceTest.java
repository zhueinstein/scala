package com.learn.functional.myself;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author: WeFon
 * @date: 2018-11-20 16:41
 * @Copyright: 2018
 */
public class ConsumerInterfaceTest {

		public static void main(String[] args) {
				ConsumerInterface<String > consumerInterface = str -> System.out.println(str);
				consumerInterface.accept("2112");
				System.out.println(consumerInterface.ss());
				MySteam<String> mySteam = new MySteam<>();
				mySteam.setList(Arrays.asList("123", "456", "567","998"));
				mySteam.show(consumerInterface);

				String content = new String("a,s,c,c");
				SplitInterface<String> splitInterface = contents -> contents.split(",");
				for (String s : splitInterface.split(content)) {
						System.out.println(s);
				}

				Stream<String> stream = Stream.of("I", "love", "you", "too");
				// (1)
				List<String> list = stream.collect(Collectors.toCollection(ArrayList::new));
				// (2)
//				Set<String> set = stream.collect(Collectors.toSet());
				list.forEach(ds -> System.out.println(ds));
		}
}
