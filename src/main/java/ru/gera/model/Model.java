package ru.gera.model;

import java.util.List;

public interface Model {
    void addProcedure(Procedure procedure);
    
    void removeProcedure(String id);
    
    List<Procedure> getProcedures();
}
