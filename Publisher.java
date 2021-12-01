
public interface Publisher {
    Boolean Purchase(Post item);
    void newSale(Post item);
    public void registerObserver(Customer sub);
    public void deleteSubs(Customer sub);
    public void updateSubs();
}
