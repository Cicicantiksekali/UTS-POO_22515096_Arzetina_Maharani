public class StackServis {
    private Servis[] data;
    private int top;
    private int kapasitas;

    public StackServis(int kapasitas) {
        if (kapasitas <= 0) {
            throw new IllegalArgumentException("Kapasitas harus lebih dari 0");
        }
        this.kapasitas = kapasitas;
        this.data = new Servis[kapasitas];
        this.top = -1;
    }

    public boolean push(Servis servis) {
        if (servis == null || isFull()) {
            return false;
        }
        top = top + 1;
        data[top] = servis;
        return true;
    }

    public Servis pop() {
        if (isEmpty()) {
            return null;
        }
        Servis teratas = data[top];
        data[top] = null;
        top = top - 1;
        return teratas;
    }

    public Servis peek() {
        if (isEmpty()) {
            return null;
        }
        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == kapasitas - 1;
    }

    public int size() {
        return top + 1;
    }
}
