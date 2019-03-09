package ua.training.model.entity;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Optional;

public abstract class TaxFabric {

    private HashMap<String, Class> taxes = new HashMap<>();
    private String locale;
    public TaxFabric(String locale){
        setLocale(locale);
    }

    private void setLocale(String locale) {
        this.locale = locale;
    }
    private String getLocale() {
        return locale;
    }

    protected HashMap<String, Class> getTaxes() {
        return taxes;
    }

    public final Tax getTax(String[] name){
        StringBuilder buff = new StringBuilder();
        for (int i = 0; i < name.length - 1; i++){
            buff.append(name[i]);
            Optional<Class> tax = Optional.ofNullable(taxes.get(buff.toString()));
            if (tax.isPresent()){
                try {
                    return (Tax)tax.get().getConstructor(String.class).newInstance(getLocale());
                } catch (InstantiationException | IllegalAccessException
                        | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                    throw new IllegalArgumentException("creating a Tax object failed for " + buff);
                }
            }
            buff.append("_");
        }
        throw new IllegalArgumentException("there is no Tax that matches" + name.toString());//buff.toString());
    }
}
