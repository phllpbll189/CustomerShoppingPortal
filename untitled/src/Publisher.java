
public interface Publisher {
    Boolean Purchase(Post item);
    void newSale(Post item);
    public void registerObserver(Poster sub);
    public void deleteSubs(Poster sub);
    public void updateSubs();
}
