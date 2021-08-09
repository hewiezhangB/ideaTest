package com.hewie.test;

public enum TestEnum {
    TEST1("test1", "测试1"),
    TEST2("test2", "测试2"),
    TEST3("test3", "测试3");

    private String englishName;
    private String chineseName;

    private TestEnum(String englishName, String chineseName) {
        this.englishName = englishName;
        this.chineseName = chineseName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public String getChineseName() {
        return chineseName;
    }

    private static final TestEnum[] testArray = new TestEnum[]{TEST1, TEST2, TEST3};

    private static String getDes(String name) {
        for (TestEnum testEnum : testArray) {
            if (name.equals(testEnum.getEnglishName())) {
                return testEnum.getChineseName();
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.err.println(TestEnum.getDes("test1"));
        System.err.println(TestEnum.getDes("test2"));
        System.err.println(TestEnum.getDes("test3"));
    }
}


