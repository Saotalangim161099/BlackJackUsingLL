public class ArrayClass {
    String[] names = null;
    int pointer = 0;

    public ArrayClass(int size) {
        names = new String[size];
    }

    public void displayArray() {
        for (String name : names) {
            System.out.println(name);
        }
    }

    public void add(String element) {
        if (pointer < names.length) {
            names[pointer] = element;
            pointer++;
        } else {
            String[] newList = new String[names.length * 2];
            System.arraycopy(names, 0, newList, 0, names.length);
            names = newList;
        }
    }

    public int size() {
        int size = 0;
        for (int i = 0; i < names.length; i++) {
            if (names[i] == null) {
                break;
            } else {
                size++;
            }
        }
        return size;
    }

    public String get(int index) {
        return names[index];
    }

    public void remove(String element) {
        if (contains(element)) {
            int index = getIndex(element);
            int pointer1 = index;
            int pointer2 = index + 1;
            for (int i = index; i < names.length; i++) {
                if (pointer2 < names.length) {
                    names[pointer1] = names[pointer2];
                    pointer1++;
                    pointer2++;
                }
            }
            --pointer;
        }
    }

    public boolean contains(String element) {
        for (int i = 0; i < names.length; i++) {
            if (element.equalsIgnoreCase(names[i])) {
                return true;
            }
        }
        return false;
    }

    public int getIndex(String element) {
        for (int i = 0; i < names.length; i++) {
            if (element.equalsIgnoreCase(names[i])) {
                return i;
            }
        }
        return -1;
    }


}
