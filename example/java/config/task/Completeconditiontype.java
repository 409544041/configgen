package config.task;

public enum Completeconditiontype {
    KILLMONSTER,
    TALKNPC,
    COLLECTITEM;

    private int id;
    private String name = "";

    private void assign(Completeconditiontype other) {
        id = other.id;
        name = other.name;
    }

    /**
     * ��������������ͣ�id�ķ�ΧΪ1-100��
     */
    public int getId() {
        return id;
    }

    /**
     * ����������
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "(" + id + "," + name + ")";
    }

    Completeconditiontype _parse(java.util.List<String> data) {
        id = config.CSV.parseInt(data.get(0));
        name = data.get(1);
        return this;
    }

    private static final java.util.Map<Integer, Completeconditiontype> All = new java.util.LinkedHashMap<>();

    public static Completeconditiontype get(int id) {
        return All.get(id);
    }

    public static java.util.Collection<Completeconditiontype> all() {
        return All.values();
    }

    static void initialize(java.util.List<java.util.List<String>> dataList) {
        java.util.List<Integer> indexes = java.util.Arrays.asList(0, 1);
        for (java.util.List<String> row : dataList) {
            java.util.List<String> data = indexes.stream().map(row::get).collect(java.util.stream.Collectors.toList());
            Completeconditiontype self = valueOf(row.get(1).trim().toUpperCase())._parse(data);
            All.put(self.id, self);
        }
        if (values().length != all().size()) 
            throw new RuntimeException("Enum Uncompleted: Completeconditiontype");
    }

    static void reload(java.util.List<java.util.List<String>> dataList) {
        java.util.Map<Integer, Completeconditiontype> old = new java.util.LinkedHashMap<>(All);
        All.clear();
        initialize(dataList);
        All.forEach((k, v) -> {
            Completeconditiontype ov = old.get(k);
            if (ov != null)
                ov.assign(v);
        });
    }

}
