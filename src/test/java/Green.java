public enum Green {
    APPLE(1), OPOP(2);

    private int value = 0;

     Green(int value) {
        this.value = value;
    }

    public static int valueOf(Green a) {
        switch (a) {
            case APPLE:
                return 1;
            case OPOP:
                return 2;
            default:
                return 0;
        }
    }
    public int value(){
        return this.value;
    }

}
