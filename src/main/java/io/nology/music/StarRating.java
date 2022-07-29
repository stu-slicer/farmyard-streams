package io.nology.music;

public enum StarRating {

    zero(0),
    one(1),
    two(2),
    three(3),
    four(4),
    five(5);

    private int count = 0;

    StarRating(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
