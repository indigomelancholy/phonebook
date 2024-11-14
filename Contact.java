class Contact {
    String name;
    String num;

    public Contact(String name, String num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String phoneNumber) {
        this.num = phoneNumber;
    }

    public String toString() {
        return "Name: " + name + ", Number: " + num;
    }
}