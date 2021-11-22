public class LLNode {
    Cardd data;
    LLNode link;

    public LLNode(Cardd data,LLNode link) {
        this.data = data;
        this.link = link;
    }

    public Cardd getData() {
        return data;
    }

    public void setData(Cardd data) {
        this.data = data;
    }

    public LLNode getLink() {
        return link;
    }

    public void setLink(LLNode link) {
        this.link = link;
    }

    public boolean isSmallerValue(Cardd card){
        return Integer.parseInt(card.getValue())<Integer.parseInt(this.getData().getValue());
    }
}
