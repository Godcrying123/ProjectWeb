package com.project.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class MatchSchedule {
	private int table[][];
	private int roundNum;
	private int roundMatchNum;
	private int teamCount;

	public MatchSchedule() {
	}

	public boolean generate(int teamCount) {
		if (0 != (teamCount % 2)) {
			return false;
		}

		this.teamCount = teamCount;
		roundNum = teamCount - 1;
		roundMatchNum = teamCount / 2;

		table = new int[teamCount][teamCount];

		for (int i = 0; i < teamCount; i++) {
			for (int j = 0; j < teamCount; j++) {
				table[i][j] = -1;
			}
		}

		return genRound(1);
	}

	public String[] printSchedule() {
		String[] sequence = new String[38];
		String result = "";
		for (int i = 1; i <= roundNum; i++) {
			for (int m = 0; m < teamCount - 1; m++) {
				for (int n = m + 1; n < teamCount; n++) {
					if (table[m][n] == i) {
						result = result + " " + "*" + String.valueOf(m + 1) + " " + "*" + String.valueOf(n + 1) + " ";
					}
				}
			}
			sequence[i - 1] = result;
			result = "";
		}
		for (int i = 1; i <= roundNum; i++) {
			for (int m = 0; m < teamCount; m++) {
				for (int n = m + 1; n < teamCount; n++) {
					if (table[m][n] == i) {
						result = result + " " + "*" + String.valueOf(n + 1) + " " + "*" + String.valueOf(m + 1) + " ";
					}
				}
			}
			sequence[i + teamCount - 2] = result;
			result = "";
		}
		return sequence;
	}

	private boolean genRound(int round) {
		List<Integer> occupies = new ArrayList<Integer>();
		if (genMatch(round, 1, occupies)) {
			return true;
		}

		return false;
	}

	private boolean genMatch(int round, int match, List<Integer> occupies) {
		for (int i = 0; i < teamCount; i++) {
			if (find(occupies, i)) {
				continue;
			}

			for (int j = i + 1; j < teamCount; j++) {
				if (find(occupies, j)) {
					continue;
				}

				if (-1 != table[i][j]) {
					continue;
				}

				table[i][j] = round;

				if ((match == roundMatchNum) && (round == roundNum)) {
					return true;
				}

				occupies.add(i);
				occupies.add(j);
				boolean nextStepRst;
				if (match == roundMatchNum) {
					nextStepRst = genRound(round + 1);
				} else {
					nextStepRst = genMatch(round, match + 1, occupies);
				}

				if (true == nextStepRst) {
					return true;
				} else {
					occupies.remove(occupies.size() - 1);
					occupies.remove(occupies.size() - 1);
					table[i][j] = -1;
				}
			}
		}

		return false;
	}

	private boolean find(List<Integer> occupies, int v) {
		for (int i = 0; i < occupies.size(); i++) {
			if (occupies.get(i) == v) {
				return true;
			}
		}

		return false;
	}

	public int[][] Schedule() {

		String[] resultSeq;
		int[][] finalResult = new int[38][20];
		MatchSchedule schedule = new MatchSchedule();
		if (false == schedule.generate(20)) {
		} else {
			resultSeq = schedule.printSchedule();

			for (int i = 0; i < resultSeq.length; i++) {
				String raw1[] = resultSeq[i].split(" ");
				String integrate = "";
				for (String string2 : raw1) {
					integrate += string2;
				}

				String raw0 = integrate.substring(1);
				String raw2[] = raw0.split("[*]");
				for (int j = 0; j < raw2.length; j++) {
					finalResult[i][j] = Integer.valueOf(raw2[j]);
				}
			}

			for (int i = 0; i < 38; i++) {
				for (int j = 0; j < 20; j++) {
				}

			}
		}
		return finalResult;

	}
}