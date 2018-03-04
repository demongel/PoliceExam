package com.shakespace.base;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Police {

	public static void main(String[] args) {
		long ms = System.currentTimeMillis();
		int[] answers = new int[10];
		for (int i = 0; i < answers.length; i++) {
			answers[i] = 1;
		}

		for (int a = 1; a < 5; a++) {
			answers[0] = a;
			for (int b = 1; b < 5; b++) {
				answers[1] = b;
				for (int c = 1; c < 5; c++) {
					answers[2] = c;
					for (int d = 1; d < 5; d++) {
						answers[3] = d;
						// 根据第2题，
						if (answers[1] == 1) {
							answers[4] = 3;
						} else if (answers[1] == 2) {
							answers[4] = 4;
						} else if (answers[1] == 3) {
							answers[4] = 1;
						} else if (answers[1] == 4) {
							answers[4] = 2;
						}
						for (int f = 1; f < 5; f++) {
							answers[5] = f;
							// 根据第3题，234、236、246或者346的答案应该是一样的
							if (!((answers[1] == answers[2] && answers[2] == answers[3] && answers[2] == 2)
									|| (answers[1] == answers[2] && answers[2] == answers[5] && answers[2] == 4)
									|| (answers[1] == answers[3] && answers[3] == answers[5] && answers[2] == 1)
									|| (answers[2] == answers[3] && answers[3] == answers[5] && answers[2] == 3))) {
								continue;
							}
							for (int g = 1; g < 5; g++) {
								answers[6] = g;
								for (int h = 1; h < 5; h++) {
									answers[7] = h;
									for (int i = 1; i < 5; i++) {
										answers[8] = i;
										for (int j = 1; j < 5; j++) {
											answers[9] = j;
											// 根据第4题 设置条件
											if (!((answers[0] == answers[4] && answers[3] == 1)
													|| (answers[1] == answers[6] && answers[3] == 2)
													|| (answers[0] == answers[8] && answers[3] == 3)
													|| (answers[5] == answers[9] && answers[3] == 4))) {
												continue;
											}
											// 根据第5题 设置条件
											if (!((answers[4] == answers[7] && answers[4] == 1)
													|| (answers[4] == answers[3] && answers[4] == 2)
													|| (answers[4] == answers[8] && answers[4] == 3)
													|| (answers[4] == answers[6] && answers[4] == 4))) {
												continue;
											}
											// // 根据第6题，248 168 3810 589 有一个是一样的
											if (!((answers[1] == answers[7] && answers[7] == answers[3])
													|| (answers[0] == answers[7] && answers[7] == answers[5])
													|| (answers[2] == answers[7] && answers[7] == answers[9])
													|| (answers[4] == answers[7] && answers[7] == answers[8]))) {
												continue;
											}
											// 根据第7题
											Map<Integer, Integer> m = getAnswerCountMap(answers);
											Object[] results = m.values().toArray();
											Arrays.sort(results);
											Set<Integer> set = m.keySet();
											Iterator<Integer> it = set.iterator();
											int minKey = -1;
											while (it.hasNext()) {
												Integer key = it.next();
												if (m.get(key) == results[0]) {
													minKey = key;
													break;
												}
											}
											if (!((answers[6] == 1 && minKey == 3) || (answers[6] == 2 && minKey == 2)
													|| (answers[6] == 3 && minKey == 1)
													|| (answers[6] == 4 && minKey == 4))) {
												continue;
											}

											// 根据第9题 设置条件
											if (!((answers[8] == 1&& ((answers[0] == answers[5]) != (answers[4] == answers[5])))
													|| (answers[8] == 2&& ((answers[0] == answers[5]) != (answers[4] == answers[9])))
													|| (answers[8] == 3&& ((answers[0] == answers[5]) != (answers[4] == answers[1])))
													|| (answers[8] == 4&& ((answers[0] == answers[5]) != (answers[4] == answers[8]))))) {
												continue;
											}
											// 根据第10题
											int dif = (int) results[results.length - 1] - (int) results[0];
											if (!((dif == 3) && answers[9] == 1) 
													|| ((dif == 2) && answers[9] == 2)
													|| ((dif == 4) && answers[9] == 3)
													|| ((dif == 1) && answers[9] == 4)) {
												continue;
											}
											printArr(answers);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println("耗时 ：" + (System.currentTimeMillis() - ms));
	}

	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print((char)(arr[i]+64));
		}
		System.out.println();
	}

	public static Map<Integer, Integer> getAnswerCountMap(int[] arr) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (hm.containsKey(arr[i])) {
				int count = hm.get(arr[i]);
				hm.put(arr[i], ++count);
			} else {
				hm.put(arr[i], 1);
			}
		}
		return hm;
	}
}
