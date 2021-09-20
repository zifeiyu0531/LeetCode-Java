package DesignPattern.BuilderPattern;

public class Student {
    private int id; // 必选
    private String name; // 必选
    private String sex; // 可选
    private int age; // 可选
    private String address; // 可选
    private String hobby; // 可选

    private Student(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.sex = builder.sex;
        this.age = builder.age;
        this.address = builder.address;
        this.hobby = builder.hobby;
    }

    public static class Builder {
        private int id; // 必选
        private String name; // 必选
        private String sex; // 可选
        private int age; // 可选
        private String address; // 可选
        private String hobby; // 可选

        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setHobby(String hobby) {
            this.hobby = hobby;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    @Override
    public String toString() {
        return "id:\t" + this.id +
                "\nname:\t" + this.name + 
                "\nsex:\t" + this.sex + 
                "\nage:\t" + this.age + 
                "\naddress:\t"+ this.address + 
                "\nhobby:\t" + this.hobby;
    }
}

class Test{
    public static void main(String[] args) {
        Student student = new Student.Builder(123, "zhangsan")
                            .setSex("nan")
                            .setAge(12)
                            .setAddress("address")
                            .setHobby("hobby")
                            .build();
        System.out.println(student.toString());
    }
}
