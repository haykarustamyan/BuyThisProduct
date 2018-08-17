package am.highapps.buythisproduct.data;

public interface ResultListener<T> {

    void onLoad(T obj);

    void onFail(String e);

}
