//package oop.FINAL;
//final class Love {
//    private static final int POWER_OF_LOVE = Integer.MAX_VALUE;
//    final String fiance;
//
//    Love(String fiance) {
//        this.fiance = fiance;   // 한 번 할당 가능.
//    }
//
//    final int powerOfLove() {   // 재정의 불가능
//        return Love.POWER_OF_LOVE;
//    }
//
//    void transfer(final String newFiance) { // 매개변수 선언에도 사용.
//        this.fiance = newFiance;    // 재할당 불가능
//        POWER_OF_LOVE = 0;          // 재할당 불가능
//    }
//}
//
//class Jealousy extends Love {
//    Jealousy(String fiance) {
//        super(fiance);
//    }   // 상속 불가능
//
//    @Override
//    int po
//}