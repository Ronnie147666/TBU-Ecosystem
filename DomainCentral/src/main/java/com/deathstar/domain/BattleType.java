package com.deathstar.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum BattleType {
    SINGLE_FIVE(5), SINGLE_TEN(10), SINGLE_FIFTEEN(15),
    MULTI_FIVE(5), MULTI_TEN(10), MULTI_FIFTEEN(15);

    private int number;

    BattleType(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private static final Random RANDOM = new Random();

    private static final List<BattleType> SINGLE_VALUES =
            Collections.unmodifiableList(Arrays.asList(SINGLE_FIVE, SINGLE_TEN, SINGLE_FIFTEEN));
    private static final int SINGLE_SIZE = SINGLE_VALUES.size();

    public static BattleType getRandomSingleBattleType()  {
        return SINGLE_VALUES.get(RANDOM.nextInt(SINGLE_SIZE));
    }

    private static final List<BattleType> MULTI_VALUES =
            Collections.unmodifiableList(Arrays.asList(MULTI_FIVE, MULTI_TEN, MULTI_FIFTEEN));
    private static final int MULTI_SIZE = MULTI_VALUES.size();

    public static BattleType getRandomMultiBattleType()  {
        return MULTI_VALUES.get(RANDOM.nextInt(MULTI_SIZE));
    }
}
