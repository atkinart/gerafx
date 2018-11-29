package ru.gera.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Procedure {
    
    private Set<ProcedureChangeListener> changeListeners = new HashSet<>();
    
    private String id;
    private String number;
    private List<Integer> params = new ArrayList<>(12);
    
    public String getId() {
        return id;
    }
    
    public void addChangeListener(ProcedureChangeListener listener) {
        changeListeners.add(listener);
    }
    
    private void changeNotify() {
        changeListeners.forEach(p -> p.procedureChanged(this));
    }
}
