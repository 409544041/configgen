package config.equip;

public class Jewelrysuit {
    private int suitID;
    private String name = "";
    private int ability1;
    private int ability1Value;
    private int ability2;
    private int ability2Value;
    private int ability3;
    private int ability3Value;
    private java.util.List<Integer> suitList = new java.util.ArrayList<>();

    private Jewelrysuit() {
    }

    public static Jewelrysuit _create(ConfigInput input) {
        Jewelrysuit self = new Jewelrysuit();
        self.suitID = input.readInt();
        self.name = input.readStr();
        self.ability1 = input.readInt();
        self.ability1Value = input.readInt();
        self.ability2 = input.readInt();
        self.ability2Value = input.readInt();
        self.ability3 = input.readInt();
        self.ability3Value = input.readInt();
        for (int c = input.readInt(); c > 0; c--) {
            self.suitList.add(input.readInt());
        }
        return self;
    }

    /**
     * 饰品套装ID
     */
    public int getSuitID() {
        return suitID;
    }

    /**
     * 策划用名字
     */
    public String getName() {
        return name;
    }

    /**
     * 套装属性类型1（装备套装中的两件时增加的属性）
     */
    public int getAbility1() {
        return ability1;
    }

    /**
     * 套装属性1
     */
    public int getAbility1Value() {
        return ability1Value;
    }

    /**
     * 套装属性类型2（装备套装中的三件时增加的属性）
     */
    public int getAbility2() {
        return ability2;
    }

    /**
     * 套装属性2
     */
    public int getAbility2Value() {
        return ability2Value;
    }

    /**
     * 套装属性类型3（装备套装中的四件时增加的属性）
     */
    public int getAbility3() {
        return ability3;
    }

    /**
     * 套装属性3
     */
    public int getAbility3Value() {
        return ability3Value;
    }

    /**
     * 部件1
     */
    public java.util.List<Integer> getSuitList() {
        return suitList;
    }

    @Override
    public String toString() {
        return "(" + suitID + "," + name + "," + ability1 + "," + ability1Value + "," + ability2 + "," + ability2Value + "," + ability3 + "," + ability3Value + "," + suitList + ")";
    }

    public static Jewelrysuit get(int suitID) {
        ConfigMgr mgr = ConfigMgr.getMgr();
        return mgr.equip_jewelrysuit_All.get(suitID);
    }

    public static java.util.Collection<Jewelrysuit> all() {
        ConfigMgr mgr = ConfigMgr.getMgr();
        return mgr.equip_jewelrysuit_All.values();
    }

    static void initialize(java.util.List<java.util.List<String>> dataList) {
        java.util.List<Integer> indexes = java.util.Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        for (java.util.List<String> row : dataList) {
            java.util.List<String> data = indexes.stream().map(row::get).collect(java.util.stream.Collectors.toList());
            Jewelrysuit self = new Jewelrysuit()._parse(data);
            All.put(self.suitID, self);
        }
    }

}
