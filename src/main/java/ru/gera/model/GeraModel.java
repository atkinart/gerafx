package ru.gera.model;

import java.util.ArrayList;
import java.util.List;

public class GeraModel implements Model, Transformer, ProcedureChangeListener {
    private List<Procedure> procedures = new ArrayList<>();
    
    @Override
    public void addProcedure(Procedure procedure) {
        procedure.addChangeListener(this);
        this.procedures.add(procedure);
    }
    
    @Override
    public void removeProcedure(String id) {
        this.procedures.removeIf(p -> p.getId().equals(id));
    }
    
    @Override
    public List<Procedure> getProcedures() {
        return this.procedures;
    }
    
    @Override
    public void moveUp(String id) {
        int index = findIndex(id);
        if (index > 0)
            move(index, index - 1);
    }
    
    @Override
    public void moveDown(String id) {
        int index = findIndex(id);
        if (index < procedures.size() - 1)
            move(index, index + 1);
    }
    
    private void move(int index, int indexReplaced) {
        Procedure replaced = procedures.get(indexReplaced);
        
        procedures.set(indexReplaced, procedures.get(index));
        procedures.set(index, replaced);
    }
    
    private int findIndex(String id) {
        for (int i = 0; i < this.procedures.size(); i++) {
            if (this.procedures.get(i).getId().equals(id))
                return i;
        }
        return 0;
    }
    
    private Procedure find(String id) {
        return procedures.stream().filter(p -> p.getId().equals(id)).findFirst().get();
    }
    
    @Override
    public void procedureChanged(Procedure procedure) {
        //TODO Stub
        System.out.println(procedure);
    }
}
